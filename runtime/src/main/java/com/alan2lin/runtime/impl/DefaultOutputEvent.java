package com.alan2lin.runtime.impl;

import com.alan2lin.runtime.intf.Fsm;
import com.alan2lin.runtime.intf.OutputEvent;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 这是一个 默认的输出事件的包装器 输出都是一个字符串的值
 * @Author: alan2lin
 * @Date: 2020/3/20 15:28
 * @Version V1.0
 */
@Data
public class DefaultOutputEvent extends  DefaultEvent implements OutputEvent {
    String value;

    public DefaultOutputEvent(Fsm eventOwner,  String value){
       this.owner = eventOwner;
       this.value = value;
       this.createTime = new Date();
    }

    @Override
    public String getOutputValue() {
        return this.value;
    }

}
