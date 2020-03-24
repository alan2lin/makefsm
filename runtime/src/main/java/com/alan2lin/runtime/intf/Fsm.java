

package com.alan2lin.runtime.intf;

/**
 * @Description: TODO
 * @Author: alan2lin
 * @Date: 2020/3/18 11:03
 * @Version V1.0
 */
public interface Fsm {
   /**
    * 获取状态机的实例
    * @return
    */
   String getInstanceId();

   /**
    *  激发某一个事件
    * @param eventName
    * @return
    */
   void fireEvent(String eventName);

   /**
    * 增加输入事件的计数。
    * @return
    */
   int increaseInputCount();
   int decreaseInputCount();
   int getInputCount();

   int increaseOutputCount();
   int decreaseOutputCount();
   int getOutputCount();


   /**
    * 判断是否可以注销，条件是 待处理的输入事件和输出事件计数为零。
    * @return
    */
   boolean isClearToUnregister();


}
