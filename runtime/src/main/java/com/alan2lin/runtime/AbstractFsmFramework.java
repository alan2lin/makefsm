
package com.alan2lin.runtime;

import com.alan2lin.runtime.intf.*;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description: 状态机的运行时框架 构建输入事件队列， 输出队列，异常队列 以及 相关的守护线程。
 * @Author: alan2lin
 * @Date: 2020/3/18 12:34
 * @Version V1.0
 */
public class AbstractFsmFramework implements FsmFramework {

    private static FsmFramework fsmFramework = null;

    //输入队列
    private static LinkedBlockingQueue<InputEvent> __inputInputEvents;


    //输出队列
    private static LinkedBlockingQueue<InputEvent> __outputInputEvents;

    //ERROR队列
    private static LinkedBlockingQueue<InputEvent> __exceptionInputEvents;

    private AbstractFsmFramework(){
        synchronized (AbstractFsmFramework.class){
            if(executorHolder == null){
                int corePoolSize = 5;
                int maxPoolSize = 30;
                int queueCpacity = 500;
                int keepAliveSecends = 60;
                String namePrefix = "fsmframework";
                ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
                //核心线程数15：线程池创建时候初始化的线程数
                executor.setCorePoolSize(corePoolSize);
                //最大线程数5：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
                executor.setMaxPoolSize(maxPoolSize);
                //缓冲队列500：用来缓冲执行任务的队列
                executor.setQueueCapacity(queueCpacity);
                //允许线程的空闲时间60秒：当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
                executor.setKeepAliveSeconds(keepAliveSecends);
                //线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
                executor.setThreadNamePrefix(namePrefix);
                executor.initialize();
                executorHolder = executor;
            }
        }
    }

    // 执行的线程池
    private static  Executor executorHolder = null;

    public static void setExecutorHolder(Executor executorHolder) {
        synchronized (AbstractFsmFramework.class){
            if(AbstractFsmFramework.executorHolder == null){
                AbstractFsmFramework.executorHolder = executorHolder;
            }else{
               System.out.println("thread pools already exists!");
            }
        }
    }

    /**
     *  创建一个运行时框架的实例 ,采用默认的参数的
     *
     * @return
     */
    static FsmFramework getInstance(){
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder {
        private static final FsmFramework sInstance = new AbstractFsmFramework();
    }

    /**
     * 运行时框架的启动流程
     * @return
     */
    @Override
    public boolean start() {
       // 创建各个队列 线程并等待线程就绪
        CountDownLatch latch = new CountDownLatch(3);
        QueueGuardian inputGuardian = new QueueGuardian("inputGuardian", __inputInputEvents,latch);
        QueueGuardian outputGuardian = new QueueGuardian("outputGuardian", __outputInputEvents,latch);
        QueueGuardian exceptionGuardian = new QueueGuardian("exceptionGuardian", __exceptionInputEvents,latch);

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return true;
    }

    /**
     * 运行时框架的退出流程
     * @return
     */
    @Override
    public boolean end(){
        return true;
    }

    @Override
    public boolean register(Fsm fsm) {
        return false;
    }

    @Override
    public boolean unregister(Fsm fsm) {
        return false;
    }

    @Override
    public int setOutputHandle(Fsm fsm, OutputHandle handle) {
        return 0;
    }

    @Override
    public int setOutputHandle(Fsm fsm, OutputHandle handle, HANDLE_APPEND method) {
        return 0;
    }

    @Override
    public int setExcepitonHandle(Fsm fsm, ExceptionHandle handle, HANDLE_APPEND method) {
        return 0;
    }

    @Override
    public boolean emit(Fsm fsm, InputEvent event) {
        return false;
    }
}
