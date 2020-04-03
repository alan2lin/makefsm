

package com.github.alan2lin.runtime.intf;

/**
 * @Description: 所有处理的基础接口 只是为了能够限制使用范围,使用处理链的方式
 * @Author: alan2lin
 * @Date: 2020/3/18 11:27
 * @Version V1.0
 */
public interface Handle<A extends Event> {

    /**
     *  处理事件
     * @param event
     */
    void processEvent(A event);

    /**
     * 获取下一个
     * @return
     */
    Handle getNext();

    /**
     * 设置下一个指针
     * @param handle
     */
    void setNext(Handle handle);


    /**
     * 获取前驱
     * @return
     */
    Handle getPrev();

    /**
     * 设置前驱
     * @param handle
     */
    void setPrev(Handle handle);

  }
