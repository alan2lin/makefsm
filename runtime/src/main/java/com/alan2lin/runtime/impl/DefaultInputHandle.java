

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
public class DefaultInputHandle implements IntputHandle {

    @Override
    public void processEvent(Event event) {
       InputEvent e = (InputEvent) event;
       //迁移前完整性检查
        Fsm fsm = e.getOwner();


       log.debug("processing event[{}]...",e.getOwner().getInstanceId());
    }


}
