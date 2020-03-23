

package com.alan2lin.runtime.intf;

/**
 * @Description: 输入事件，所有的状态机都需要实现这个输入事件的接口
 * @Author: alan2lin
 * @Date: 2020/3/18 11:40
 * @Version V1.0
 */
public interface InputEvent extends Event{

    /**
     * 获取 输入事件的类型
     * @return
     */
    String getInputEventType();

    //如果已经消费过的事件，需要转换一下状态。没有被消费过的事件才可以被消费
    void emited();
    //读取状态读取标志
    boolean isEmited();
    //对已经消费过的事件 进行重置，让其可以重用
    void reset();

}
