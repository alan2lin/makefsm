

package com.alan2lin.runtime.intf;

import java.util.function.Function;

/**
 * @Description: 所有处理的基础接口 只是为了能够限制使用范围
 * @Author: alan2lin
 * @Date: 2020/3/18 11:27
 * @Version V1.0
 */
public interface Handle<A extends Event> {

    void processEvent(A event);

}
