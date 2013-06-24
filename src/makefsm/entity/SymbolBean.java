/**
 * 
 */
package makefsm.entity;

import makefsm.util.Constant.StatusAttr;
import makefsm.util.Constant.SymbolType;


/**
 * @author "linc"
 * date   :2012-4-21 
 * time   :下午07:29:54
 *
 */
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
	SymbolType type ;

	/**
	 *  状态的属性  0 非终结状态   1开始状态 2 结束状态
	 */
	StatusAttr status;
	
	/**
	 *  事件的开始端
	 */
	SymbolBean pstart;
	
	/**
	 *  事件的结束端
	 */
	SymbolBean pend;

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	

	/**
	 * @return the status
	 */
	public StatusAttr getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusAttr status) {
		this.status = status;
	}

	/**
	 * @return the pstart
	 */
	public SymbolBean getPstart() {
		return pstart;
	}

	/**
	 * @param pstart the pstart to set
	 */
	public void setPstart(SymbolBean pstart) {
		this.pstart = pstart;
	}

	/**
	 * @return the pend
	 */
	public SymbolBean getPend() {
		return pend;
	}

	/**
	 * @param pend the pend to set
	 */
	public void setPend(SymbolBean pend) {
		this.pend = pend;
	}
	
	public String toString(){		
		return "["+index+"|"+ name+"|"+ desc+"|"+ type +"|"+ status+"|"+ pstart+"|"+ pend+"]\n";
		
	}

	public SymbolType getType() {
		return type;
	}

	public void setType(SymbolType type) {
		this.type = type;
	}



}
