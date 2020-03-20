

package com.alan2lin.runtime.impl;

import com.alan2lin.runtime.intf.Event;
import com.alan2lin.runtime.intf.Handle;
import com.alan2lin.runtime.intf.InputEvent;
import com.alan2lin.runtime.intf.IntputHandle;
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
       log.debug("processing event[{}]...",e.getOwner().getInstanceId());
    }


}
