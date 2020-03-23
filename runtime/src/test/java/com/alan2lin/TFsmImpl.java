package com.alan2lin;

import com.alan2lin.runtime.DefaultFsmFramework;
import com.alan2lin.runtime.intf.EnumInterface;
import com.alan2lin.runtime.intf.Fsm;
import com.alan2lin.runtime.intf.FsmFramework;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TFsmImpl extends TFsm{

    public boolean checkBeforeStart__init(){
       return true;
    }

    public boolean checkAfterStart__init(){
        return true;
    }
    @Override
    protected void enterStart__init() {
        //检查迁移前状态
        if(!checkBeforeStart__init()){
            log.info("无法通过检查，迁移中止，触发一个警告"); //
            FsmFramework fsmFramework = DefaultFsmFramework.getInstance();

        }

    }

    @Override
    protected void enterReady__start() {

    }
}


