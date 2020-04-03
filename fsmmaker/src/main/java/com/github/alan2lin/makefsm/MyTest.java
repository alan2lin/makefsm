

package com.github.alan2lin.makefsm;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * @Description: TODO
 * @Author: alan2lin
 * @Date: 2020/3/18 16:36
 * @Version V1.0
 */
public class MyTest {

    public static void main(String[] args) {

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

        try {

        System.out.println("main start ");

        String s = null;


        Entity entity = new Entity("myname","mysex");
        Entity entity2 = new Entity("myname222","mysex222");

        CompletableFuture<CompletableFuture> cf =  CompletableFuture.completedFuture(null);
        CompletableFuture<Entity> e1 =  CompletableFuture.completedFuture(entity);

        //CompletableFuture.supplyAsync()
        System.out.println("main completefuture");

        CompletableFuture aa = e1.thenApplyAsync(new Fn2<Entity, CompletableFuture>(), executor);


        System.out.println("main commit a mission");
        System.out.println("main sleep 5s");
        Thread.sleep(5000);
        System.out.println("main wake up 5s");
        cf.thenApplyAsync(new Fn(),executor);
        cf.thenAccept( x -> { System.out.println("accept"+x); });


            System.out.println("main take a break...");
            Thread.sleep(100000);
            System.out.println("main end...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static int v = 0;

//    static public Boolean fun(){
//
//        try {
//            v++;
//            System.out.println(v + "fun start ..."+Thread.currentThread().getId());
//            Thread.sleep(1000);
//            System.out.println(v+"fun start ..."+Thread.currentThread().getId());
//            return true;
//        } catch (InterruptedException e) {
//        }
//        return false;
//    }

    static class Fn implements  Function{

        @Override
        public Object apply(Object o) {
            try {
                v++;
                System.out.println(v + "fun start ..."+Thread.currentThread().getId());
                Thread.sleep(1000);
                System.out.println(v+"fun end ..."+Thread.currentThread().getId());
                return true;
            } catch (InterruptedException e) {
            }
            return false;
        }
    }

    static class Fn2<T,R> implements  Function {

        @Override
        public Object apply(Object o) {
            try {
                v++;
                System.out.println(v + "fun2 start ..."+Thread.currentThread().getId());
                if(o instanceof  Entity){
                    System.out.println( "entity "+((Entity)o).name);
                }
                Thread.sleep(1000);
                System.out.println(v+"fun2 end ..."+Thread.currentThread().getId());
                return true;
            } catch (InterruptedException e) {
            }
            return false;
        }
    }

    public static class Entity{
       String name;
       String sex;
       public Entity(String name,String sex){
          this.name = name;
          this.sex = sex;
       }
    }


}
