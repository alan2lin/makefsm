package com.alan2lin.runtime.impl;

import com.alan2lin.runtime.intf.Fsm;
import com.alan2lin.runtime.intf.InputEvent;
import lombok.Data;

import java.util.Date;

/**
 * @Description: TODO
 * @Author: alan2lin
 * @Date: 2020/3/20 15:28
 * @Version V1.0
 */
@Data
public class DefaultInputEvent implements InputEvent {
    Fsm owner ;
    Date createTime;
    Date emitTime;
    String inputValue;
    boolean emited = false;


    //TODO: 后续需要利用类型 进行输入的强校验，避免被误杀
    public DefaultInputEvent(Fsm eventOwner,String inputValue){
       this.owner = eventOwner;
       this.inputValue = inputValue;
    }

    /**
     * 获取事件所绑定的状态机实例
     *
     * @return
     */
    @Override
    public Fsm getOwner() {
        return owner;
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
