

package com.github.alan2lin.runtime.intf;

/**
 * @Description: TODO
 * @Author: alan2lin
 * @Date: 2020/3/18 10:39
 * @Version V1.0
 */
public interface  FsmFramework {

  // 框架启动 初始化动作都在这里做
  boolean start();
  // 框架终止退出， 清理动作都都在这里做， 这对函数的目的是为了让运行时框架能够热插拔
  boolean end();

  /**
   * 注册一个状态机 实例.无论如何这个函数都会存在这个名字的状态机实例，但是如果已经存在了，结果会返回false，以便调用者知晓
   * @param fsm
   * @return  false: 如果该名字的实例已经存在，  true:该名字实例不存在,且已经添加。
   */
  boolean register(Fsm fsm);

  // 注销状态机实例
  boolean unregister(Fsm fsm);

  //对于输出，处理的方式交由 应用来管控， 默认的输出处理是是一个 打印的动作。 应用可以定制自己的 处理函数链条。
  //默认是追加的方式
  int setOutputHandle(Fsm fsm,OutputHandle handle);

  enum HANDLE_APPEND{HEAD,TAIL,REPLACE};

  // 注册状态机实例输出处理回调函数，可选
  //对于输出，处理的方式交由 应用来管控， 默认的输出处理是是一个 打印的动作。 应用可以定制自己的 处理函数链条。
  //TODO: 暂时先关闭 output的handle链条的实现，默认是实现其中某一个
  int setOutputHandle(Fsm fsm,OutputHandle handle,HANDLE_APPEND method);

  //注册状态机实例异常处理回调函数 可选
  int setExcepitonHandle(Fsm fsm,ExceptionHandle handle);

  //注册状态机实例异常处理回调函数 可选
  //TODO: 暂时先关闭 output的handle链条的实现，默认是实现其中某一个
  int setExcepitonHandle(Fsm fsm,ExceptionHandle handle,HANDLE_APPEND method);

  /**
   * app可以对某一个状态机实例进行输入 ,以驱动状态机的状态迁移
   * @param inputEvent 输入事件
   * @return
   */
  boolean emit(InputEvent inputEvent);


  /**
   * fsm 在运行过程中遇到的一些标准或者自定义 警告，错误，和异常信息 可以通过这个接口送到 exception 队列
   * @param exceptionEvent
   * @return
   */
  boolean exception(ExceptionEvent exceptionEvent);


  /**
   * fsm 在运行过程中的输出
   * @param outputEvent
   * @return
   */
  boolean output(OutputEvent outputEvent);


  //可能不建议的接口
  // getLastOutput(Fsm fsm)

  /**
   * 是否可以销毁,判断依据是  状态机实例池和延迟缓冲池 是空的
   * @return
   */
  boolean  canDestory();

}

