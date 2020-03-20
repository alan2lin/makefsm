
package com.alan2lin.runtime;

import com.alan2lin.runtime.intf.Event;
import com.alan2lin.runtime.intf.Handle;
import com.alan2lin.runtime.intf.InputEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.function.Function;

/**
 * @Description:  队列守护线程 主要的工作是 读取守护的队列，不做队列写入操作
 * @Author: alan2lin
 * @Date: 2020/3/18 14:23
 * @Version V1.0
 */
@Slf4j
public class  QueueGuardian<T extends Handle> extends  Thread {
    private String name;
    private CountDownLatch latch;
    private LinkedBlockingQueue<InputEvent> queue;
    //是否还活着，如果设置为false 则推出
    volatile boolean liveFlag = true;
    //是否就绪,只在初始化过程中进行判断
    volatile boolean ready = false;
    //是否在运行的状态 ，这个状态可以反复设置
    volatile boolean runFlag = false;
    private Class<T> handleClazz;
    private T handle;


    private HashMap<String, CompletableFuture> asyncQueueMap = new HashMap<>();

    //检测时间
    int detectTimeMin = 6000;         // 6s
    int detectTimeMax = 60000;        // 60s
    int detectTime = detectTimeMin;   //
    int intervalForChecking = 10000;  // 10s 暂停时线程检测恢复标记的间隔
    int pollTimeout = 2000;           // 2s 线程拉取元素的超时时间

    /**
     * 队列守护者构造器
     * @param name
     * @param queue 守护队列
     * @param latch  信号灯 用来决定就绪后的运行的
     * @param handleClazz 用来创建特定的处理类实例
     */
    public QueueGuardian(String name, LinkedBlockingQueue<InputEvent> queue, CountDownLatch latch,Class<T> handleClazz){
        this.name = name;
        this.queue = queue;
        this.latch = latch;
        this.handleClazz = handleClazz;

        try {
            handle = this.handleClazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public boolean isReady(){
        return ready;
    }

    @Override
    public synchronized void start() {
        super.start();
    }

    private boolean  check(){
       //目前只检查 handle 是否正确被创建
      return  handle!=null;
    }

    @Override
    public void run() {
        if(!ready){
            log.info("[{}] check ready...",this.name);


            log.info("thread[{}] is ready latch will countdown from [{}] to [{}]",this.name,this.latch.getCount(),this.latch.getCount()-1);
            ready=true;
            latch.countDown();

            try {
               //等大家一起跑
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //超过检测时间的时候才判断标志， 如果外部程序关闭了程序则推出， 如果是暂停，则定时检测恢复
        long lastTimeTicket = System.currentTimeMillis() ;
        long currentTimeTicket = 0 ;
        while (true){
          currentTimeTicket = System.currentTimeMillis() ;
          if(currentTimeTicket - lastTimeTicket > detectTime){
             if(!liveFlag){
                 break;
             }

             if(!runFlag){
                 try {
                     Thread.sleep(intervalForChecking);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 continue;
             }
              //超过检测标记的时间 ，检测标记并重置事件 ，这一行一定要放在两个判断后，否则 可能会出现  检测
              lastTimeTicket = currentTimeTicket ;
          }

          //线程体处理过程 从队列里面获取元素，并进行处理
            Optional<InputEvent> event = null;
            try {
                 event = Optional.ofNullable( queue.poll(pollTimeout, TimeUnit.MILLISECONDS) );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!event.isPresent()){
                continue;
            }

          //生成这个事件的处理任务，并提交到线程池运行， 要确保
           String key =  event.get().getOwner().getInstanceId();
           CompletableFuture<Handle> cf = asyncQueueMap.get(key) ;
           if(null == cf){
               //创建一个任务处理器并放入这个处理链条中

               cf = CompletableFuture.completedFuture(handle);
               asyncQueueMap.put(key,cf);
           }

           final Event fEvent = event.get();
            cf.thenApplyAsync(new Function<Handle, Handle >() {
                @Override
                public Handle apply(Handle handle) {
                    handle.processEvent(fEvent);
                    return handle;
                }
            });
        }
    }
}