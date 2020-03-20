package com.alan2lin;

import static org.junit.Assert.assertTrue;

import com.alan2lin.runtime.DefaultFsmFramework;
import com.alan2lin.runtime.intf.Fsm;
import com.alan2lin.runtime.intf.FsmFramework;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    public class TFsm implements Fsm {
        String instanceId ="justtest";

        @Override
        public String getInstanceId() {
            return instanceId;
        }
    }
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        FsmFramework fsmfw =  DefaultFsmFramework.getInstance();

        Fsm fsm = new TFsm();

        fsmfw.register(fsm);

        fsmfw.unregister(fsm);
    }
}
