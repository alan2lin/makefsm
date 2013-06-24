package makefsm.check;

import makefsm.parser.MidleCode;

public interface ICheck {
	
	/**约束检查执行函数
	 * 
	 * @param mc 中间代码对象	 
	 * @return  true 通过了约束检查  false 检查失败 ，具体失败信息  查看 getErrorMsg
	 */
	public boolean check(MidleCode mc);
	
	/** 获取具体的失败信息
	 * @return
	 */
	public String getErrorMsg();

}
