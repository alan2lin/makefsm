package com.github.alan2lin;

import static org.junit.Assert.assertTrue;

import com.github.alan2lin.runtime.DefaultFsmFramework;
import com.github.alan2lin.runtime.TFsm;
import com.github.alan2lin.runtime.TFsmImpl;
import com.github.alan2lin.runtime.impl.DefaultInputEvent;
import com.github.alan2lin.runtime.intf.*;
import com.github.alan2lin.runtime.intf.Fsm;
import com.github.alan2lin.runtime.intf.FsmFramework;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{


    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        FsmFramework fsmfw =  DefaultFsmFramework.getInstance();
        Fsm fsm = new TFsmImpl();

        // 1. 注册一个fsm
        fsmfw.register(fsm);
        // 2. 替换输出处理/输入处理/异常处理
        // 3. 进行输入
        DefaultInputEvent event = new DefaultInputEvent(fsm, TFsm.EVENT.start__init.getName());
        fsmfw.emit(event);
        DefaultInputEvent event2 = new DefaultInputEvent(fsm,TFsm.EVENT.ready__start.getName());
        fsmfw.emit(event2);
        fsmfw.emit(event);


        fsmfw.unregister(fsm);

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
