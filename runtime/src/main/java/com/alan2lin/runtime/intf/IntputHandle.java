

package com.alan2lin.runtime.intf;

/**
 * @Description: 输入事件的处理接口，一个输入事件会引发一个状态迁移， 通常具体的处理步骤是:
 * 迁移函数，直接体现在事件响应中。
 * 状态迁移过程:
 *    1. 判断输入是否是当前状态允许接受的输入。 如果不是，则触发 未预期警告
 *    2. 迁移前状态检查。
 *    3. 迁移时动作响应内容，不成功则执行回滚函数。
 *    4. 迁移前状态检查。
 *    5. 发射输出
 * @Author: alan2lin
 * @Date: 2020/3/18 11:27
 * @Version V1.0
 */
public interface IntputHandle extends Handle<InputEvent> {
}
