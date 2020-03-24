

package com.alan2lin.runtime.impl;

import com.alan2lin.runtime.intf.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: TODO
 * @Author: alan2lin
 * @Date: 2020/3/19 14:59
 * @Version V1.0
 */
@Slf4j
public class DefaultOutputHandle implements OutputHandle {

    @Override
    public void processEvent(OutputEvent event) {
      OutputEvent e =  (OutputEvent)  event;
      Fsm fsm = e.getOwner();
      log.debug("#######fsm[{}] output[{}] ",e.getOwner().getInstanceId(),e.getOutputValue());
    }
}
