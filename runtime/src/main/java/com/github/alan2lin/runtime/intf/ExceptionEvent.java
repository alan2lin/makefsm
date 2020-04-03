

package com.github.alan2lin.runtime.intf;

/**
 * @Description: 异常事件，所有的状态机都需要实现这个异常事件的接口
 * @Author: alan2lin
 * @Date: 2020/3/18 11:40
 * @Version V1.0
 */
public interface ExceptionEvent extends  Event {

   enum EXCETPION_TYPE{
      //迁移未定义
      TRANSITION_NOT_DEFINED,
      //迁移前检查失败
      PREFIX_CHECK_FAILED,
      //迁移后检查失败
      POSTFIX_CHECK_FAILED,
      // 自定义
      CUSTOMIZE;
   }

   /**
    *  获取
    * @return
    */
   EXCETPION_TYPE getExceptionType();

   String getExceptionValue();


}
