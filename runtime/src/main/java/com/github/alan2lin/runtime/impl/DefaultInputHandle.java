

package com.github.alan2lin.runtime.impl;

import com.github.alan2lin.runtime.intf.*;
import com.github.alan2lin.runtime.intf.Fsm;
import com.github.alan2lin.runtime.intf.InputEvent;
import com.github.alan2lin.runtime.intf.IntputHandle;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: TODO
 * @Author: alan2lin
 * @Date: 2020/3/19 14:59
 * @Version V1.0
 */
@Slf4j
public class DefaultInputHandle  extends  DefaultHandle<InputEvent> implements IntputHandle {


    @Override
    public void processEvent(InputEvent event) {
       InputEvent e = (InputEvent) event;
        Fsm fsm = e.getOwner();
        fsm.fireEvent(e.getInputEventType());
       log.debug("**************processing fsm[{}] event type[{}] ",e.getOwner().getInstanceId(),e.getInputEventType());
    }
}
