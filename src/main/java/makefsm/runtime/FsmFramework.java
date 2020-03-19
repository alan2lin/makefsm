

package makefsm.runtime;

import java.util.concurrent.Executor;

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

  // 注册一个状态机 实例
  boolean register(Fsm fsm);

  // 注销状态机实例
  boolean unregister(Fsm fsm);

  //对于输出，处理的方式交由 应用来管控， 默认的输出处理是是一个 打印的动作。 应用可以定制自己的 处理函数链条。
  //默认是追加的方式
  int setOutputHandle(Fsm fsm,OutputHandle handle);

  enum HANDLE_APPEND{HEAD,TAIL,REPLACE};

  // 注册状态机实例输出处理回调函数，可选
  //对于输出，处理的方式交由 应用来管控， 默认的输出处理是是一个 打印的动作。 应用可以定制自己的 处理函数链条。
  int setOutputHandle(Fsm fsm,OutputHandle handle,HANDLE_APPEND method);

  //注册状态机实例异常处理回调函数 可选
  int setExcepitonHandle(Fsm fsm,ExceptionHandle handle,HANDLE_APPEND method);

  // app可以对某一个状态机实例进行输入 ,以驱动状态机的状态迁移
  boolean emit(Fsm fsm,Event event);

  //可能不建议的接口
  // getLastOutput(Fsm fsm)

}
