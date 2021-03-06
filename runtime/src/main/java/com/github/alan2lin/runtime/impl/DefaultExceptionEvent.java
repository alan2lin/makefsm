package com.github.alan2lin.runtime.impl;

import com.github.alan2lin.runtime.intf.ExceptionEvent;
import com.github.alan2lin.runtime.intf.Fsm;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 这是一个 默认的异常事件的包装器， 所有的状态机都有一个标准的异常事件集合，自定义的异常事件，遵照接口自行扩展
 * @Author: alan2lin
 * @Date: 2020/3/20 15:28
 * @Version V1.0
 */
@Data
public class DefaultExceptionEvent extends DefaultEvent implements ExceptionEvent {

    EXCETPION_TYPE excetpionType;
    String value;

    public DefaultExceptionEvent(Fsm eventOwner, EXCETPION_TYPE excetpionType, String value){
       this.owner = eventOwner;
       this.excetpionType = excetpionType;
       this.value = value;
       this.createTime = new Date();
    }

    /**
     * 获取
     *
     * @return
     */
    @Override
    public EXCETPION_TYPE getExceptionType() {
        return this.excetpionType;
    }

    @Override
    public String getExceptionValue() {
        if(this.value==null){
            return excetpionType.toString();
        }
        return this.value;
    }
}
