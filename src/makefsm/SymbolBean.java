/**
 * 
 */
package makefsm;

import makefsm.Constant.StatusAttr;

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
	 * 符号类型   false:事件   true 状态
	 */
	boolean statusType = false;
	/**
	 *  状态的属性  0 非终结状态   1开始状态 2 结束状态
	 */
	StatusAttr status = StatusAttr.NONTERMINAL;
	
	/**
	 *  事件的开始端
	 */
	int pstart;
	
	/**
	 *  事件的结束端
	 */
	int pend;

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
	public int getPstart() {
		return pstart;
	}

	/**
	 * @param pstart the pstart to set
	 */
	public void setPstart(int pstart) {
		this.pstart = pstart;
	}

	/**
	 * @return the pend
	 */
	public int getPend() {
		return pend;
	}

	/**
	 * @param pend the pend to set
	 */
	public void setPend(int pend) {
		this.pend = pend;
	}
	
	public String toString(){		
		return "["+index+"|"+ name+"|"+ desc+"|"+ statusType+"|"+ status+"|"+ pstart+"|"+ pend+"]\n";
		
	}

	/**
	 * @return the statusType
	 */
	public boolean isStatusType() {
		return statusType;
	}

	/**
	 * @param statusType the statusType to set
	 */
	public void setStatusType(boolean statusType) {
		this.statusType = statusType;
	}

}
