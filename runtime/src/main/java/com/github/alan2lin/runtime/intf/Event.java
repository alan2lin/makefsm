

package com.github.alan2lin.runtime.intf;

/**
 * @Description: 将事件统一成三类，一类是输入事件  一类是 输出事件 一类是 异常事件 它们被处理的模型都一样的
 * @Author: alan2lin
 * @Date: 2020/3/18 11:40
 * @Version V1.0
 */
public interface Event {

    /**
     * 获取事件所绑定的状态机实例
     * @return
     */
    Fsm getOwner();


}
