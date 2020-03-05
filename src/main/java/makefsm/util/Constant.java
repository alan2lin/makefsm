/**
 *
 */
package makefsm.util;

/**
 * @author "linc"
 * date   :2012-4-22
 * time   :下午03:49:37
 *
 */
public class Constant {

	/**状态节点的属性，非终结，开始，终结
	 * @author "linc"
	 * date   :2012-4-22
	 * time   :下午04:05:26
	 *
	 */
	public enum StatusAttr{NONTERMINAL,START,TERMINAL};

	/**符号类型 是状态 还是 事件
	 * @author "linc"
	 * date   :2012-4-22
	 * time   :下午04:05:26
	 */
	public enum SymbolType{STATUS,EVENT};

	/**状态机类型 moore 型 还是mealy型 ,还是混合型
	 * @author "linc"
	 * date   :2012-4-22
	 * time   :下午04:05:26
	 */
	public enum FSMType{MOORE,MEALY};





}
