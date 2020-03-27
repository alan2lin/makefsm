package com.alan2lin.runtime;

import com.alan2lin.runtime.DefaultFsmFramework;
import com.alan2lin.runtime.impl.DefaultExceptionEvent;
import com.alan2lin.runtime.impl.DefaultOutputEvent;
import com.alan2lin.runtime.intf.ExceptionEvent;
import com.alan2lin.runtime.intf.FsmFramework;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TFsmImpl extends TFsm{

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
    @Override
    protected void enterStart__init(EVENT event) {
        log.debug("fsm[{}] 事件[{}]响应中....",instanceId,event.name);
        FsmFramework fsmFramework = DefaultFsmFramework.getInstance();
        //检查迁移前状态
        if(!checkBeforeStart__init(event)){
            log.debug("无法通过检查，迁移中止，触发一个警告"); //
            fsmFramework.exception(new DefaultExceptionEvent(this, ExceptionEvent.EXCETPION_TYPE.PREFIX_CHECK_FAILED,null));
            return ;
        }

        //如果是mealy 则进行输出

        if(fsmType.equals("MEALY")){
            log.debug("fsm[{}] 事件[{}] 进行输出....",instanceId,event.name);

            fsmFramework.output(new DefaultOutputEvent(this,outputTable.get("start__init")));
        }

        //状态迁移
        transition(States.ready);
        //触发相应动作,TODO:未来考虑 事务完整型，如果迁移失败，应当可以回滚

        //如果是moore ，则进行输出
        if(fsmType.equals("MOORE")){
            fsmFramework.output(new DefaultOutputEvent(this,outputTable.get(__currentState.name())));
        }



        if(!checkAfterStart__init(event)){
            log.debug("迁移后无法通过检查，已经无法终止，将触发一个警告"); //
            fsmFramework.exception(new DefaultExceptionEvent(this, ExceptionEvent.EXCETPION_TYPE.POSTFIX_CHECK_FAILED,null));
        }
    }


    @Override
    protected void enterReady__start(EVENT event) {
        log.debug("fsm[{}] 事件[{}]响应中....",instanceId,event.name);
        FsmFramework fsmFramework = DefaultFsmFramework.getInstance();
        //检查迁移前状态
        if(!checkBeforeReady__start(event)){
            log.debug("无法通过检查，迁移中止，触发一个警告"); //
            fsmFramework.exception(new DefaultExceptionEvent(this, ExceptionEvent.EXCETPION_TYPE.PREFIX_CHECK_FAILED,null));
            return ;
        }

        //如果是mealy 则进行输出

        if(fsmType.equals("MEALY")){
            log.debug("fsm[{}] 事件[{}] 进行输出....",instanceId,event.name);

            fsmFramework.output(new DefaultOutputEvent(this,outputTable.get("start__init")));
        }

        //状态迁移
        transition(States.running);
        //触发相应动作,TODO:未来考虑 事务完整型，如果迁移失败，应当可以回滚

        //如果是moore ，则进行输出
        if(fsmType.equals("MOORE")){
            fsmFramework.output(new DefaultOutputEvent(this,outputTable.get(__currentState.name())));
        }





        if(!checkAfterReady__start(event)){
            log.debug("迁移后无法通过检查，已经无法终止，将触发一个警告"); //
            fsmFramework.exception(new DefaultExceptionEvent(this, ExceptionEvent.EXCETPION_TYPE.POSTFIX_CHECK_FAILED,null));
        }
    }

    private boolean checkAfterReady__start(EVENT event) {
        return true;
    }

    private boolean checkBeforeReady__start(EVENT event) {
        return true;
    }
}


