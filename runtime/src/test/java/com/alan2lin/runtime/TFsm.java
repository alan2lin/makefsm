package com.alan2lin.runtime;

import com.alan2lin.runtime.impl.BaseFsm;
import com.alan2lin.runtime.impl.DefaultExceptionEvent;
import com.alan2lin.runtime.impl.DefaultOutputEvent;
import com.alan2lin.runtime.intf.EnumInterface;
import com.alan2lin.runtime.intf.ExceptionEvent;
import com.alan2lin.runtime.intf.FsmFramework;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public abstract class TFsm extends BaseFsm {

     String instanceId ="justtest";

     String fsmType = "MEALY";

     @Override
     public String getInstanceId() {
         return instanceId;
     }

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

     //构造输出表  TODO: 最好的做法是  符号映射成数组，再通过数组进行映射. 后续统一规划这个
     public HashMap<String,String>  outputTable = new HashMap<>(){
         {
             put("start__init","aa");
             put("ready__start","bb");
         }
     };

        public enum EVENT implements EnumInterface<EVENT> {start__init("start__init","init"),ready__start("ready__start","start");

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


    protected  States __currentState = States.start;

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

    public boolean checkBeforeStart__init(EVENT event){
        return true;
    }

    public boolean transition(States target){
        __currentState = target;
        return true;
    }
    public boolean onStart__init(EVENT event){
        return true;
    }

    public boolean checkAfterStart__init(EVENT event){
        return true;
    }


    /**
     *  标准处理流程， 以模板模式处理每一个事件 减少代码生成量
     * @param prefixCheck
     * @param postfixCheck
     * @param onTransition
     * @param event
     * @param target
     */
    void standProcedure(CheckFunctionPointer prefixCheck, CheckFunctionPointer postfixCheck,ExecFunctionPointer onTransition,EVENT event,States target){

        log.debug("fsm[{}] 事件[{}]响应中....",instanceId,event.name);
        FsmFramework fsmFramework = DefaultFsmFramework.getInstance();
        //检查迁移前状态
        if(!prefixCheck.check(event)){
            log.debug("无法通过检查，迁移中止，触发一个警告"); //
            fsmFramework.exception(new DefaultExceptionEvent(this, ExceptionEvent.EXCETPION_TYPE.PREFIX_CHECK_FAILED,null));
            return ;
        }

        //如果是mealy 则进行输出

        if(fsmType.equals("MEALY")){
            log.debug("fsm[{}] 事件[{}] 进行输出....",instanceId,event.name);

            fsmFramework.output(new DefaultOutputEvent(this,outputTable.get(event.getName())));
        }

        //状态迁移
        transition(target);
        onTransition.exec(event);
        //触发相应动作,TODO:未来考虑 事务完整型，如果迁移失败，应当可以回滚

        //如果是moore ，则进行输出
        if(fsmType.equals("MOORE")){
            fsmFramework.output(new DefaultOutputEvent(this,outputTable.get(__currentState.name())));
        }



        if(!postfixCheck.check(event)){
            log.debug("迁移后无法通过检查，已经无法终止，将触发一个警告"); //
            fsmFramework.exception(new DefaultExceptionEvent(this, ExceptionEvent.EXCETPION_TYPE.POSTFIX_CHECK_FAILED,null));
        }
    }

    protected void enterStart__init(EVENT event,States target){
        CheckFunctionPointer prefixCheck = this::checkBeforeStart__init;
        CheckFunctionPointer postfixCheck = this::checkAfterStart__init;
        ExecFunctionPointer  onTransition = this::onStart__init;

        standProcedure(prefixCheck,postfixCheck,onTransition,event, target);

    };
    protected  void enterReady__start(EVENT event,States target){


    };


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



     void __processEvent( EVENT event ){

         switch(__currentState) {
             case start:
                 if( event == EVENT.start__init) {
                     enterStart__init(event,States.ready);
                 }
                 break;
             case ready:
                 if( event == EVENT.ready__start) {

                     enterReady__start(event,States.running);
                 }
                 break;

             case stop:
                 break;
             default:
                 fsmFramework.exception(new DefaultExceptionEvent(this, ExceptionEvent.EXCETPION_TYPE.TRANSITION_NOT_DEFINED,null));
                 break;
         }

     }

 }


