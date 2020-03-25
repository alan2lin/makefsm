/**
 * Copyright (C), 2005-2020, 深圳市珍爱网信息技术有限公司
 */

package com.alan2lin.runtime.impl;

import com.alan2lin.runtime.intf.Event;
import com.alan2lin.runtime.intf.Handle;
import lombok.Data;

/**
 * @Description:  实现链式管理的功能
 * @Author: alan2lin
 * @Date: 2020/3/25 10:01
 * @Version V1.0
 */
public abstract   class DefaultHandle< A extends Event > implements Handle<A> {

    Handle next = null;
    Handle prev = null;



    @Override
    public Handle getNext() {
        return next;
    }

    @Override
    public void setNext(Handle next) {
        this.next = next;
    }

    @Override
    public Handle getPrev() {
        return prev;
    }

    @Override
    public void setPrev(Handle prev) {
        this.prev = prev;
    }

}
