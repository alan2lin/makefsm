
package com.alan2lin.runtime;

import com.alan2lin.runtime.impl.DefaultExceptionHandle;
import com.alan2lin.runtime.impl.DefaultInputHandle;
import com.alan2lin.runtime.impl.DefaultOutputHandle;
import com.alan2lin.runtime.intf.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.HashSet;
import java.util.concurrent.*;

/**
 * @Description: 状态机的运行时框架 构建输入事件队列， 输出队列，异常队列 以及 相关的守护线程。
 * @Author: alan2lin
 * @Date: 2020/3/18 12:34
 * @Version V1.0
 */
@Slf4j
public class DefaultFsmFramework implements FsmFramework {

    private static FsmFramework fsmFramework = null;

    //输入队列
    private static LinkedBlockingQueue<InputEvent> __inputInputEvents = new LinkedBlockingQueue<>();
    private static QueueGuardian<InputEvent,DefaultInputHandle> inputGuardian = null;

    //输出队列
    private static LinkedBlockingQueue<OutputEvent> __outputEvents = new LinkedBlockingQueue<>();
    private static QueueGuardian<OutputEvent,DefaultOutputHandle> outputGuardian = null;

    //ERROR队列
    private static LinkedBlockingQueue<ExceptionEvent> __exceptionEvents = new LinkedBlockingQueue<>();
    private static QueueGuardian<ExceptionEvent,DefaultExceptionHandle> exceptionGuardian = null;

    //延迟注销的集合
    HashSet<Fsm> delayUnregisterFsms = new HashSet<>();
    ExecutorService executorService;



    //状态机实例的存储
    private static ConcurrentHashMap<String,Fsm> fsmInstances = new ConcurrentHashMap<>() ;

    private void delayDetectAndUnregisterFsm(){
       delayUnregisterFsms.stream().forEach( x -> {
           if(x.isClearToUnregister()){
               fsmInstances.remove(x.getInstanceId());
               delayUnregisterFsms.remove(x);
               log.debug("fsm[{}] unregistered in delay region",x.getInstanceId());
           }
       });
    }

    private DefaultFsmFramework(){
        //启动延迟注销检测单元
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate( ()-> delayDetectAndUnregisterFsm() ,2,2,TimeUnit.SECONDS);

        synchronized (DefaultFsmFramework.class){
            if(executorHolder == null){
                log.info("executorHolder have not been set,buiding default thread pool");
                int corePoolSize = 5;
                int maxPoolSize = 30;
                int queueCpacity = 500;
                int keepAliveSeconds = 60;
                String namePrefix = "fsmframework";
                ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
                //核心线程数15：线程池创建时候初始化的线程数
                executor.setCorePoolSize(corePoolSize);
                //最大线程数5：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
                executor.setMaxPoolSize(maxPoolSize);
                //缓冲队列500：用来缓冲执行任务的队列
                executor.setQueueCapacity(queueCpacity);
                //允许线程的空闲时间60秒：当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
                executor.setKeepAliveSeconds(keepAliveSeconds);
                //线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
                executor.setThreadNamePrefix(namePrefix);
                executor.initialize();
                executorHolder = executor;
                log.info("thread pool built corePoolSize[{}] maxPoolSize[{}] queueCpacity[{}],keepAliveSeconds[{}]",corePoolSize,maxPoolSize,queueCpacity,keepAliveSeconds);
            }
        }
    }

    // 执行的线程池
    private static  Executor executorHolder = null;

    public static void setExecutorHolder(Executor executorHolder) {

        synchronized (DefaultFsmFramework.class){
            if(DefaultFsmFramework.executorHolder == null){
                DefaultFsmFramework.executorHolder = executorHolder;
            }else{
               log.info("thread pools already exists!");
            }
        }
    }

    /**
     *  创建一个运行时框架的实例 ,采用默认的参数的
     *
     * @return
     */
    public static FsmFramework getInstance(){
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder {
        private static final FsmFramework sInstance = new DefaultFsmFramework();
        static {
            sInstance.start();
        }
    }

    /**
     * 运行时框架的启动流程
     * @return
     */
    @Override
    public boolean start() {
       // 创建各个队列 线程并等待线程就绪

        log.info("create inputqueue guardian....");
        CountDownLatch latch = new CountDownLatch(2);

        inputGuardian = new QueueGuardian("inputGuardian", __inputInputEvents,latch,DefaultInputHandle.class);
        inputGuardian.start();
        log.info("inputQueue guardian created") ;

        log.info("create outputqueue guardian....");
        outputGuardian = new QueueGuardian("outputGuardian", __outputEvents,latch,DefaultOutputHandle.class);
        outputGuardian.start();
        log.info("outputQueue guardian created") ;

        log.info("create exceptionqueue guardian....");
        exceptionGuardian = new QueueGuardian("exceptionGuardian", __exceptionEvents,latch,DefaultExceptionHandle.class);
        log.info("exceptionQueue guardian created") ;

        try {
            log.info("waiting all guardian is ready.....") ;
            latch.await();
            log.info("all guardian is  ready..... go!") ;
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
        String key = fsm.getInstanceId();
        boolean contained = fsmInstances.containsKey(key);
        boolean debugFlag = log.isDebugEnabled();
        if(contained){
            if(debugFlag){
                log.debug("fsm[{}]  already exists,do not need register...",key);
            }
            return false;
        }else{
            fsmInstances.put(key,fsm);
            if(debugFlag){
                log.debug("fsm[{}] registered",key);
            }
        }
        return true;
    }

    @Override
    public boolean unregister(Fsm fsm) {
        //需要考虑fsm没有输入事件，输出事件 才能清除， 这个需要在fsm上写入计数器

        String key = fsm.getInstanceId();
        boolean contained = fsmInstances.containsKey(key);
        boolean debugFlag = log.isDebugEnabled();

        if(!contained){
            if(debugFlag){
               log.debug("fsm[{}] does not exists,do not need register",key);
            }
            return false;
        }
        if(!fsm.isClearToUnregister()){
           //移动入 延迟注销区
            delayUnregisterFsms.add(fsm);
            if(debugFlag){
                log.debug("fsm[{}]移动至延迟注销区",fsm.getInstanceId());
            }
            return false;
        }

        fsmInstances.remove(key);
        if(debugFlag){
            log.debug("fsm[{}] unregisterd",key);
        }
        return true;
    }

    @Override
    public int setOutputHandle(Fsm fsm, OutputHandle handle) {
        //默认在头部插入
        return setOutputHandle(fsm,handle,HANDLE_APPEND.HEAD);
    }

    @Override
    public int setOutputHandle(Fsm fsm, OutputHandle handle, HANDLE_APPEND method) {
        Handle headTail = outputGuardian.getHandleHeadTail(fsm.getInstanceId());
        addHandleToQueue(headTail,handle, method);
        return 0;
    }

    /**
     * 追加处理到处理链中，可以在头部或者尾部追加
     * @param headTail
     * @param handle
     * @param method
     */
    private void addHandleToQueue(Handle headTail,Handle handle, HANDLE_APPEND method) {
        if(method.equals(HANDLE_APPEND.HEAD)){
            Handle head = headTail.getNext();
            handle.setPrev(headTail);
            if(head.equals(headTail)){
               handle.setNext(null);
               headTail.setPrev(handle);
            }else{
               handle.setNext(head);
               head.setPrev(handle);
            }
            headTail.setNext(handle);
        }

        if(method.equals(HANDLE_APPEND.TAIL)){
            Handle tail = headTail.getPrev();
            tail.setNext(handle);
            handle.setPrev(tail);
            headTail.setPrev(handle);
        }
    }

    @Override
    public int setExcepitonHandle(Fsm fsm, ExceptionHandle handle) {
        setExcepitonHandle(fsm,handle,HANDLE_APPEND.TAIL);
        return 0;
    }

    @Override
    public int setExcepitonHandle(Fsm fsm, ExceptionHandle handle, HANDLE_APPEND method) {
        Handle headTail = exceptionGuardian.getHandleHeadTail(fsm.getInstanceId());
        addHandleToQueue(headTail,handle, method);
        return 0;
    }


    @Override
    public boolean emit(InputEvent event) {
        try {
            if(event.isEmited()){
                log.debug("消息已经被消费过了,如果需要消费请reset");
                return false;
            }
            //增加引用计数
            Fsm fsm = event.getOwner();
            int inputCount = fsm.increaseInputCount();
            log.debug("fsm[{}] 输入事件[{}]等待队列原长度[{}],入队后[{}]",fsm.getInstanceId(),event.getInputEventType(),inputCount,inputCount+1);
            __inputInputEvents.put(event);
            event.emited();
            log.debug("emit event[{}] 入队完成",event.toString());
        } catch (InterruptedException e) {
            log.error("入队被中断",e);
            return false;
        }
        return true;
    }

    /**
     * fsm 在运行过程中遇到的一些标准或者自定义 警告，错误，和异常信息 可以通过这个接口送到 exception 队列
     *
     * @param exceptionEvent
     * @return
     */
    @Override
    public boolean exception(ExceptionEvent exceptionEvent) {

        try {
            __exceptionEvents.put(exceptionEvent);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * fsm 在运行过程中的输出
     * @param outputEvent
     * @return
     */
    @Override
    public boolean output(OutputEvent outputEvent) {
        try {
            Fsm fsm = outputEvent.getOwner();
            fsm.increaseOutputCount();

            __outputEvents.put(outputEvent);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
