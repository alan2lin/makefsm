

package makefsm.runtime;

/**
 * @Description: 错误的一场处理函数
 * @Author: alan2lin
 * @Date: 2020/3/18 11:27
 * @Version V1.0
 */
@FunctionalInterface
public interface ExceptionHandle {

    void apply();
}
