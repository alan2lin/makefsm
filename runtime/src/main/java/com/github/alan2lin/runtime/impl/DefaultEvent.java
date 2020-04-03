
package com.github.alan2lin.runtime.impl;

import com.github.alan2lin.runtime.intf.Event;
import com.github.alan2lin.runtime.intf.Fsm;

import java.util.Date;

/**
 * @Description:
 * @Author: alan2lin
 * @Date: 2020/3/24 13:51
 * @Version V1.0
 */
public abstract  class DefaultEvent implements Event {
    Fsm owner ;
    Date createTime;

    /**
     * 获取事件所绑定的状态机实例
     *
     * @return
     */
    @Override
    public Fsm getOwner() {
        return owner;
    }

}
