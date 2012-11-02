/**
 * 
 */
package makefsm;

import makefsm.Constant.StatusAttr;

/**
 * @author "linc"
 * date   :2012-4-23 
 * time   :下午08:34:33
 *
 */
public class EventBean {
	
	/**
	 * 事件id
	 */
	int eid ;
	
	/**
	 * 开始状态
	 */
	int pstart;
	
	/**
	 * 结束状态 
	 */
	int pend;
	
	/**
	 * 事件名字
	 */
	String name;
	
	/**
	 * 时间描述
	 */
	String desc;
	
	/**
	 * @return the eid
	 */
	public int getEid() {
		return eid;
	}
	/**
	 * @param eid the eid to set
	 */
	public void setEid(int eid) {
		this.eid = eid;
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


}
