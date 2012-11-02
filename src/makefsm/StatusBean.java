/**
 * 
 */
package makefsm;

import makefsm.Constant.StatusAttr;

/**
 * @author "linc"
 * date   :2012-4-23 
 * time   :下午08:34:20
 *
 */
public class StatusBean {
	
	int id ;
	StatusAttr status =StatusAttr.NONTERMINAL;;
	String name;
	String desc;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
