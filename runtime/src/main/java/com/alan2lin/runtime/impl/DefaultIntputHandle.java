/**
 * Copyright (C), 2005-2020, 深圳市珍爱网信息技术有限公司
 */

package com.alan2lin.runtime.impl;

import lombok.extern.slf4j.Slf4j;
import com.alan2lin.runtime.intf.InputEvent;
import com.alan2lin.runtime.intf.IntputHandle;

/**
 * @Description: TODO
 * @Author: alan2lin
 * @Date: 2020/3/19 14:59
 * @Version V1.0
 */
@Slf4j
public class DefaultIntputHandle implements IntputHandle {

    @Override
    public void apply(InputEvent event) {

      log.info("input envent is {}" , event.getOwner().getInstanceId());

    }
}
