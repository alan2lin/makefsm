package com.github.alan2lin.runtime.impl;

import com.github.alan2lin.runtime.intf.Fsm;
import com.github.alan2lin.runtime.intf.InputEvent;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 这是一个 默认的输入事件的包装器， 外界调用的时候会用具体状态机的枚举类型，便于做静态检查，
 *   但在里面 还是使用字符串来进行反射。
 * @Author: alan2lin
 * @Date: 2020/3/20 15:28
 * @Version V1.0
 */
@Data
public class DefaultInputEvent extends DefaultEvent implements InputEvent {
    Date emitTime;

    // 输入事件类型在同一个状态机内是唯一的， 但是不同的输入事件类型可以携带同一个值.
    // 规则: 输入类型的命名是 起始状态+"__"+事件名称 输入值=事件名字
    String inputEventType;   //输入的事件类型名
    String inputEventValue;  //输入的事件值

    boolean emited = false;

    //TODO: 后续需要利用类型 进行输入的强校验，避免被误杀

    /**
     *
     * @param eventOwner
     * @param inputEventType
     */
    public DefaultInputEvent(Fsm eventOwner,String inputEventType){
       this.owner = eventOwner;
       this.inputEventType = inputEventType;
    }


    @Override
    public String getInputEventType() {
       return   this.inputEventType;
    }




    @Override
    public void emited() {
        emitTime = new Date();
        emited=true;
    }

    @Override
    public boolean isEmited() {
        return emited;
    }

    @Override
    public void reset() {
        emited=false;
    }
}
