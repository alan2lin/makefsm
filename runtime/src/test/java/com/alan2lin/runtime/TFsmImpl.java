package com.alan2lin.runtime;

import com.alan2lin.runtime.DefaultFsmFramework;
import com.alan2lin.runtime.impl.DefaultExceptionEvent;
import com.alan2lin.runtime.impl.DefaultOutputEvent;
import com.alan2lin.runtime.intf.ExceptionEvent;
import com.alan2lin.runtime.intf.FsmFramework;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TFsmImpl extends TFsm{

    @Override
    public boolean checkBeforeStart__init(EVENT event){
       return super.checkBeforeStart__init(event);
    }

    @Override
    public boolean onStart__init(EVENT event){
        return super.onStart__init(event);
    }

    @Override
    public boolean checkAfterStart__init(EVENT event){
        return checkAfterStart__init(event);
    }

    @Override
    protected void enterStart__init(EVENT event,States target) {
        super.enterStart__init(event,target);
    }


    @Override
    protected void enterReady__start(EVENT event,States target) {
        super.enterReady__start(event,target);
    }

    private boolean checkAfterReady__start(EVENT event) {
        return true;
    }

    private boolean checkBeforeReady__start(EVENT event) {
        return true;
    }
}


