
package com.github.alan2lin.runtime.impl;

import com.github.alan2lin.runtime.DefaultFsmFramework;
import com.github.alan2lin.runtime.intf.Fsm;
import com.github.alan2lin.runtime.intf.FsmFramework;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 实现状态机的通用行为， 引用计数器
 * @Author: alan2lin
 * @Date: 2020/3/23 16:57
 * @Version V1.0
 */
public abstract class BaseFsm implements Fsm {

    private AtomicInteger inputRefCnt = new AtomicInteger(0);
    private AtomicInteger outputRefCnt = new AtomicInteger(0);

    public FsmFramework fsmFramework = DefaultFsmFramework.getInstance();

    /**
     * 判断是否可以注销，条件是 待处理的输入事件和输出事件计数为零。
     *
     * @return
     */
    @Override
    public boolean isClearToUnregister() {
        return (inputRefCnt.get()==0 && outputRefCnt.get()==0);
    }


    /**
     * 增加输入事件的计数。
     *
     * @return
     */
    @Override
    public int increaseInputCount() {
       return inputRefCnt.getAndIncrement();
    }

    @Override
    public int decreaseInputCount() {
        return inputRefCnt.getAndDecrement();
    }

    @Override
    public int getInputCount() {
        return inputRefCnt.get();
    }

    @Override
    public int increaseOutputCount() {
        return outputRefCnt.getAndIncrement();
    }

    @Override
    public int decreaseOutputCount() {
        return outputRefCnt.getAndDecrement();
    }

    @Override
    public int getOutputCount() {
        return outputRefCnt.get();
    }

}
