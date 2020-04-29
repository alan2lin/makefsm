
package com.github.alan2lin.runtime;

import com.github.alan2lin.runtime.DefaultFsmFramework;
import com.github.alan2lin.runtime.impl.BaseFsm;
import com.github.alan2lin.runtime.impl.DefaultExceptionEvent;
import com.github.alan2lin.runtime.impl.DefaultOutputEvent;
import com.github.alan2lin.runtime.intf.EnumInterface;
import com.github.alan2lin.runtime.intf.ExceptionEvent;
import com.github.alan2lin.runtime.intf.FsmFramework;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.UUID;
import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class ProcessorFSM extends BaseFsm {

   //状态机的名字
   String fsmName = "ProcessorFSM";

   // 状态机实例 uuid
   String fsmInstanceId = "ProcessorFSM".trim()+"_"+UUID.randomUUID().toString();

   //状态机类型
   String fsmType = "MOORE";

   //当前状态
   private States __current = States.start;



    //状态和事件的枚举变量
   public enum States {
       start,
       ready,
       running,
       pause_locked,
       pause,
       pause_unlocked,
       stop_locked,
       stop
       } ;
       public enum EVENT implements EnumInterface<EVENT > {
          start__init("start__init","init") ,
          ready__start("ready__start","start") ,
          running__pause("running__pause","pause") ,
          pause_locked__pauseWaiting("pause_locked__pauseWaiting","pauseWaiting") ,
          pause__resume("pause__resume","resume") ,
          pause_unlocked__resumeWaiting("pause_unlocked__resumeWaiting","resumeWaiting") ,
          running__stop("running__stop","stop") ,
          stop_locked__stopWating("stop_locked__stopWating","stopWating") ;
          String name;
          String value;

          private EVENT(String name,String value){
               this.name = name;
                 this.value = value;
          }
          @Override
          public String getName() {
             return this.name;
          }
          @Override
          public String getValue(){
             return this.value;
          }
       }

        public HashMap< String,String >  outputTable = new HashMap<String,String>(){
            {
              put("start","开始");
              put("ready","就绪");
              put("running","running");
              put("pause_locked","pause_locked");
              put("pause","pause");
              put("pause_unlocked","pause_unlocked");
              put("stop_locked","stop_locked");
              put("stop","stop");
            }
        };

     @Override
     public String getInstanceId() {
         return fsmInstanceId;
     }

   protected  States __currentState;

   //输入列表,状态机的输入，体现为事件。
   //输出列表,是状态机的一个响应输出，如果是moore状态机 则和 当前状态有关。 如果是mealy 状态机 则和当前输入和当前状态有关。 在这里实现为， moore 是事件触发，状态迁移完成时触发。 mealy 状态机 则是在事件触发后， 状态为迁移前触发。
   //每一个状态机还维护一个最后的输出状态，该状态包含了时间,输入，和迁移前状态。
   //迁移函数，直接体现在事件响应中。
   //状态迁移过程:
   //   1. 判断输入是否是当前状态允许接受的输入。 如果不是，则触发 未预期警告
   //   2. 迁移前状态检查。
   //   3. 迁移时动作响应内容，不成功则执行回滚函数。
   //   4. 迁移前状态检查。
   //   5. 发射输出

   // 关于错误处理, 对于未受控的行为将都会发布到 异常队列里面， 由应用具体去判断，
   //  包括
   //   1. 当前状态下的非法输入序列。
   //   2. 状态迁移前检查异常，无法迁移
   //   3. 状态迁移中动作异常，无法迁移 TODO
   //   4. 状态迁移后检查异常，已经迁移
   //   5. 其他异常


     public boolean checkBeforeStart__init(EVENT event){
        return true;
     }

     public boolean onStart__init(EVENT event){
         return true;
     }

     public boolean recoverStart__init(EVENT event){
         return true;
     }
     public boolean checkAfterStart__init(EVENT event){
         return true;
     }


      public void enterStart__init(EVENT event,States target){
           CheckFunctionPointer prefixCheck = this::checkBeforeStart__init;
           CheckFunctionPointer postfixCheck = this::checkAfterStart__init;
           ExecFunctionPointer  onTransition = this::onStart__init;
           ExecFunctionPointer  recoverTransition = this::recoverStart__init;

           standProcedure(prefixCheck,postfixCheck,onTransition,recoverTransition,event, target);
      }

     public boolean checkBeforeReady__start(EVENT event){
        return true;
     }

     public boolean onReady__start(EVENT event){
         return true;
     }

     public boolean recoverReady__start(EVENT event){
         return true;
     }
     public boolean checkAfterReady__start(EVENT event){
         return true;
     }


      public void enterReady__start(EVENT event,States target){
           CheckFunctionPointer prefixCheck = this::checkBeforeReady__start;
           CheckFunctionPointer postfixCheck = this::checkAfterReady__start;
           ExecFunctionPointer  onTransition = this::onReady__start;
           ExecFunctionPointer  recoverTransition = this::recoverReady__start;

           standProcedure(prefixCheck,postfixCheck,onTransition,recoverTransition,event, target);
      }

     public boolean checkBeforeRunning__pause(EVENT event){
        return true;
     }

     public boolean onRunning__pause(EVENT event){
         return true;
     }

     public boolean recoverRunning__pause(EVENT event){
         return true;
     }
     public boolean checkAfterRunning__pause(EVENT event){
         return true;
     }


      public void enterRunning__pause(EVENT event,States target){
           CheckFunctionPointer prefixCheck = this::checkBeforeRunning__pause;
           CheckFunctionPointer postfixCheck = this::checkAfterRunning__pause;
           ExecFunctionPointer  onTransition = this::onRunning__pause;
           ExecFunctionPointer  recoverTransition = this::recoverRunning__pause;

           standProcedure(prefixCheck,postfixCheck,onTransition,recoverTransition,event, target);
      }

     public boolean checkBeforePause_locked__pauseWaiting(EVENT event){
        return true;
     }

     public boolean onPause_locked__pauseWaiting(EVENT event){
         return true;
     }

     public boolean recoverPause_locked__pauseWaiting(EVENT event){
         return true;
     }
     public boolean checkAfterPause_locked__pauseWaiting(EVENT event){
         return true;
     }


      public void enterPause_locked__pauseWaiting(EVENT event,States target){
           CheckFunctionPointer prefixCheck = this::checkBeforePause_locked__pauseWaiting;
           CheckFunctionPointer postfixCheck = this::checkAfterPause_locked__pauseWaiting;
           ExecFunctionPointer  onTransition = this::onPause_locked__pauseWaiting;
           ExecFunctionPointer  recoverTransition = this::recoverPause_locked__pauseWaiting;

           standProcedure(prefixCheck,postfixCheck,onTransition,recoverTransition,event, target);
      }

     public boolean checkBeforePause__resume(EVENT event){
        return true;
     }

     public boolean onPause__resume(EVENT event){
         return true;
     }

     public boolean recoverPause__resume(EVENT event){
         return true;
     }
     public boolean checkAfterPause__resume(EVENT event){
         return true;
     }


      public void enterPause__resume(EVENT event,States target){
           CheckFunctionPointer prefixCheck = this::checkBeforePause__resume;
           CheckFunctionPointer postfixCheck = this::checkAfterPause__resume;
           ExecFunctionPointer  onTransition = this::onPause__resume;
           ExecFunctionPointer  recoverTransition = this::recoverPause__resume;

           standProcedure(prefixCheck,postfixCheck,onTransition,recoverTransition,event, target);
      }

     public boolean checkBeforePause_unlocked__resumeWaiting(EVENT event){
        return true;
     }

     public boolean onPause_unlocked__resumeWaiting(EVENT event){
         return true;
     }

     public boolean recoverPause_unlocked__resumeWaiting(EVENT event){
         return true;
     }
     public boolean checkAfterPause_unlocked__resumeWaiting(EVENT event){
         return true;
     }


      public void enterPause_unlocked__resumeWaiting(EVENT event,States target){
           CheckFunctionPointer prefixCheck = this::checkBeforePause_unlocked__resumeWaiting;
           CheckFunctionPointer postfixCheck = this::checkAfterPause_unlocked__resumeWaiting;
           ExecFunctionPointer  onTransition = this::onPause_unlocked__resumeWaiting;
           ExecFunctionPointer  recoverTransition = this::recoverPause_unlocked__resumeWaiting;

           standProcedure(prefixCheck,postfixCheck,onTransition,recoverTransition,event, target);
      }

     public boolean checkBeforeRunning__stop(EVENT event){
        return true;
     }

     public boolean onRunning__stop(EVENT event){
         return true;
     }

     public boolean recoverRunning__stop(EVENT event){
         return true;
     }
     public boolean checkAfterRunning__stop(EVENT event){
         return true;
     }


      public void enterRunning__stop(EVENT event,States target){
           CheckFunctionPointer prefixCheck = this::checkBeforeRunning__stop;
           CheckFunctionPointer postfixCheck = this::checkAfterRunning__stop;
           ExecFunctionPointer  onTransition = this::onRunning__stop;
           ExecFunctionPointer  recoverTransition = this::recoverRunning__stop;

           standProcedure(prefixCheck,postfixCheck,onTransition,recoverTransition,event, target);
      }

     public boolean checkBeforeStop_locked__stopWating(EVENT event){
        return true;
     }

     public boolean onStop_locked__stopWating(EVENT event){
         return true;
     }

     public boolean recoverStop_locked__stopWating(EVENT event){
         return true;
     }
     public boolean checkAfterStop_locked__stopWating(EVENT event){
         return true;
     }


      public void enterStop_locked__stopWating(EVENT event,States target){
           CheckFunctionPointer prefixCheck = this::checkBeforeStop_locked__stopWating;
           CheckFunctionPointer postfixCheck = this::checkAfterStop_locked__stopWating;
           ExecFunctionPointer  onTransition = this::onStop_locked__stopWating;
           ExecFunctionPointer  recoverTransition = this::recoverStop_locked__stopWating;

           standProcedure(prefixCheck,postfixCheck,onTransition,recoverTransition,event, target);
      }


       /**
         * 激发某一个事件
         *
         * @param eventName
         * @return
         */
        @Override
        public void fireEvent(String eventName) {
           //利用反射 从事件类型名称 调用相关的响应函数
          EVENT event =   EnumInterface.getFromTypeName(eventName,EVENT.class);
          __processEvent(event);
        }

    // 检查函数指针
    @FunctionalInterface
    interface CheckFunctionPointer{
        public boolean check(EVENT event);
    }

    // 执行函数指针
    @FunctionalInterface
    interface ExecFunctionPointer{
        public boolean exec(EVENT event);
    }




    void standProcedure(CheckFunctionPointer prefixCheck, CheckFunctionPointer postfixCheck,ExecFunctionPointer onTransition,ExecFunctionPointer recoverTransition,EVENT event,States target){

        log.debug("fsm[{}] 事件[{}]响应中....",getInstanceId(),event.name);
        FsmFramework fsmFramework = DefaultFsmFramework.getInstance();
        //检查迁移前状态
        if(!prefixCheck.check(event)){
            log.debug("无法通过检查，迁移中止，触发一个警告"); //
            fsmFramework.exception(new DefaultExceptionEvent(this, ExceptionEvent.EXCETPION_TYPE.PREFIX_CHECK_FAILED,null));
            return ;
        }

        //如果是mealy 则进行输出

        if(fsmType.equals("MEALY")){
            log.debug("fsm[{}] 事件[{}] 进行输出....",getInstanceId(),event.name);

            fsmFramework.output(new DefaultOutputEvent(this,outputTable.get(event.getName())));
        }

        //状态迁移
        try{
            onTransition.exec(event);
        }catch (Throwable t){
            log.error("状态迁移出错，无法迁移状态，将会执行恢复补偿函数",t);
            fsmFramework.exception(new DefaultExceptionEvent(this, ExceptionEvent.EXCETPION_TYPE.TRANSITION_FAILED,null));

            try{
                recoverTransition.exec(event);
            }catch (Throwable t2){
            fsmFramework.exception(new DefaultExceptionEvent(this, ExceptionEvent.EXCETPION_TYPE.TRANSITION_RECOVER_FAILED,null));
                log.error("状态迁移恢复出错",t2);
            }
            return;
        }
        transition(target);

        //如果是moore ，则进行输出
        if(fsmType.equals("MOORE")){
            fsmFramework.output(new DefaultOutputEvent(this,outputTable.get(__currentState.name())));
        }

        if(!postfixCheck.check(event)){
            log.debug("迁移后无法通过检查，已经无法终止，将触发一个警告"); //
            fsmFramework.exception(new DefaultExceptionEvent(this, ExceptionEvent.EXCETPION_TYPE.POSTFIX_CHECK_FAILED,null));
        }
    }



   //主要实现的函数
        void __processEvent( EVENT event ){
            switch(__currentState) {
               case running:
                 if (event == EVENT.running__stop){
                     enterRunning__stop(event,States.stop_locked);
                 }
                 if (event == EVENT.running__pause){
                     enterRunning__pause(event,States.pause_locked);
                 }

                 break;
               case ready:
                 if (event == EVENT.ready__start){
                     enterReady__start(event,States.running);
                 }

                 break;
               case pause_locked:
                 if (event == EVENT.pause_locked__pauseWaiting){
                     enterPause_locked__pauseWaiting(event,States.pause);
                 }

                 break;
               case start:
                 if (event == EVENT.start__init){
                     enterStart__init(event,States.ready);
                 }

                 break;
               case pause_unlocked:
                 if (event == EVENT.pause_unlocked__resumeWaiting){
                     enterPause_unlocked__resumeWaiting(event,States.running);
                 }

                 break;
               case stop_locked:
                 if (event == EVENT.stop_locked__stopWating){
                     enterStop_locked__stopWating(event,States.stop);
                 }

                 break;
               case pause:
                 if (event == EVENT.pause__resume){
                     enterPause__resume(event,States.pause_unlocked);
                 }

                 break;

                default:
                    fsmFramework.exception(new DefaultExceptionEvent(this, ExceptionEvent.EXCETPION_TYPE.TRANSITION_NOT_DEFINED,null));
                    break;
            }
        }

       public boolean transition(States target){
            __currentState = target;
            return true;
       }

       @Override
       public <T> T getCurrentState() {
          return (T)__currentState;
       }

}