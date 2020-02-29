package makefsm.generate;

import makefsm.parser.MidleCode;

public interface IGenerateCode {
	
	/**设置抽象类文件
	 * @param fileName 文件名
	 */
	public void setAbstractClassTemplate(String fileName);
	/**设置实现类文件
	 * @param fileName 文件名
	 */
	public void setImplementClassTemplate(String fileName);
	/**设置测试类文件
	 * @param fileName
	 */
	public void setTestClassTemplate(String fileName);
	
	/**设置其它资源，一般为了保留用
	 * @param name
	 * @param value
	 */
	public void setResource(String name,String value);
	
	/** 产生代码的
	 * @param mc
	 * @return
	 */
	public boolean generateCode(MidleCode mc);
	
	
	/**获取抽象类内容
	 * @return 抽象类内容
	 */
	public String getAbstractClassContent();
	/**获取实现类内容
	 * @return 实现类内容
	 */
	public String getImplementClassContent();
	/**获取测试类内容
	 * @return 测试类内容
	 */
	public String getTestClassContent();
	
	/** 获取具体的失败信息
	 * @return
	 */
	public String getErrorMsg();

}
