/**
 *
 */
package com.alan2lin.makefsm.entity;

import com.alan2lin.makefsm.util.Constant;
import lombok.Data;


/**
 * @author "linc"
 * date   :2012-4-21
 * time   :下午07:29:54
 *
 */

@Data
public class SymbolBean {

	/**
	 * 在符号表中的索引号
	 */
	int index;
	/**
	 * 符号名称
	 */
	String name;
	/**
	 * 符号描述
	 */
	String desc;
	/**
	 * 符号类型
	 */
	Constant.SymbolType type ;

	/**
	 *  状态的属性  0 非终结状态   1开始状态 2 结束状态
	 */
	Constant.StatusAttr status;

	/**
	 *  事件的开始端
	 */
	SymbolBean pstart;

	/**
	 *  事件的结束端
	 */
	SymbolBean pend;

	/**
	 * 符号的输出， 如果没有指定，如果是摩尔状态机 则默认是状态， 如果是mealy 状态机 则默认是
	 */
	String output ;


	@Override
	public String toString(){
		return "["+index+"|"+ name+"|"+ desc+"|"+ type +"|"+ status+"|"+ pstart+"|"+ pend+"]\n";

	}





}
