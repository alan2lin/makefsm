

package com.alan2lin.runtime.intf;

/**
 * @Description: 输出事件，所有的状态机都需要实现这个输出事件的接口
 * @Author: alan2lin
 * @Date: 2020/3/18 11:40
 * @Version V1.0
 */
public interface OutputEvent extends Event {

    String getOutputValue();

}
