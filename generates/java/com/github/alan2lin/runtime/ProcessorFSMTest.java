
package makefsm;


import com.github.alan2lin.runtime.ProcessorFSM;
import com.github.alan2lin.runtime.ProcessorFSMImpl;
import DefaultInputEvent;
import com.github.alan2lin.runtime.intf.*;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.*;

import java.util.concurrent.CountDownLatch;


@Slf4j
public class ProcessorFSMTest  {

  static FsmFramework fsmfw = null;
  static Thread fortest;

  static CountDownLatch cdl = new CountDownLatch(1);

  @BeforeAll
  public static void init(){

      fortest = new Thread( ()->{
          try {
              log.info("latch[{}] start to waiting",cdl.toString());
              cdl.await();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      });
      fortest.start();;

    fsmfw =  DefaultFsmFramework.getInstance();

  }

  @AfterAll
  public static void destory(){
      log.info("latch[{}] count down",cdl.toString());
      while (!fsmfw.canDestory()){
          try {
              Thread.sleep(200);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          log.info("framework cannot be shut down ,try again after [{}]ms",200);
      }
      log.info("framework shutting down now");
      cdl.countDown();
  }



    @Test
    public void testPath0() {
       log.info("\n  testPath0 start.......");
       log.info("start->ready->running->pause_locked->pause->pause_unlocked->running->stop_locked->stop \n");

       Fsm fsm = new ProcessorFSMImpl();
       fsmfw.register(fsm);

             DefaultInputEvent event0 = new DefaultInputEvent(fsm, ProcessorFSM.EVENT.start__init.getName());
             fsmfw.emit(event0);

             DefaultInputEvent event1 = new DefaultInputEvent(fsm, ProcessorFSM.EVENT.ready__start.getName());
             fsmfw.emit(event1);

             DefaultInputEvent event2 = new DefaultInputEvent(fsm, ProcessorFSM.EVENT.running__pause.getName());
             fsmfw.emit(event2);

             DefaultInputEvent event3 = new DefaultInputEvent(fsm, ProcessorFSM.EVENT.pause_locked__pauseWaiting.getName());
             fsmfw.emit(event3);

             DefaultInputEvent event4 = new DefaultInputEvent(fsm, ProcessorFSM.EVENT.pause__resume.getName());
             fsmfw.emit(event4);

             DefaultInputEvent event5 = new DefaultInputEvent(fsm, ProcessorFSM.EVENT.pause_unlocked__resumeWaiting.getName());
             fsmfw.emit(event5);

             DefaultInputEvent event6 = new DefaultInputEvent(fsm, ProcessorFSM.EVENT.running__stop.getName());
             fsmfw.emit(event6);

             DefaultInputEvent event7 = new DefaultInputEvent(fsm, ProcessorFSM.EVENT.stop_locked__stopWating.getName());
             fsmfw.emit(event7);


       fsmfw.unregister(fsm);
       log.info("\n  testPath0 end.......");
    }


    @Test
    public void testPath1() {
       log.info("\n  testPath1 start.......");
       log.info("start->ready->running->stop_locked->stop \n");

       Fsm fsm = new ProcessorFSMImpl();
       fsmfw.register(fsm);

             DefaultInputEvent event0 = new DefaultInputEvent(fsm, ProcessorFSM.EVENT.start__init.getName());
             fsmfw.emit(event0);

             DefaultInputEvent event1 = new DefaultInputEvent(fsm, ProcessorFSM.EVENT.ready__start.getName());
             fsmfw.emit(event1);

             DefaultInputEvent event2 = new DefaultInputEvent(fsm, ProcessorFSM.EVENT.running__stop.getName());
             fsmfw.emit(event2);

             DefaultInputEvent event3 = new DefaultInputEvent(fsm, ProcessorFSM.EVENT.stop_locked__stopWating.getName());
             fsmfw.emit(event3);


       fsmfw.unregister(fsm);
       log.info("\n  testPath1 end.......");
    }


  }