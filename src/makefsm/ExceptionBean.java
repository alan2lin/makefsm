/**
 * 
 */
package makefsm;

/**异常描述bean
 * @author "linc"
 * date   :2012-4-21 
 * time   :下午12:03:10
 *
 */
public class ExceptionBean {
	
	public static int WARNING = 0;
	public static int ERROR =   1;
	
	
	/**
	 *  级别指示: 是warning还是 error, 默认为error 用以漏设置时，在错误中出现，以引起警告。
	 */
	int level = ExceptionBean.ERROR ;
	
	/**
	 * 源文件名字
	 */
	String sourceName;
	
	/**
	 * 行数
	 */
	int line;
	
	/**
	 * 出错的字符位置
	 */
	int charPoint;
	
	
	/**
	 * 出错的信息
	 */
	String message;


	/**获取级别指示: 是warning还是 error, 默认为error 用以漏设置时，在错误中出现，以引起警告。
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}


	/**设置级别指示: 是warning还是 error, 默认为error 用以漏设置时，在错误中出现，以引起警告。
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}


	/**获取源文件名字
	 * @return the sourceName
	 */
	public String getSourceName() {
		return sourceName;
	}


	/**设置源文件名字
	 * @param sourceName the sourceName to set
	 */
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}


	/**获取行数
	 * @return the line
	 */
	public int getLine() {
		return line;
	}


	/**设置行数
	 * @param line the line to set
	 */
	public void setLine(int line) {
		this.line = line;
	}


	/**获取出错的字符位置
	 * @return the charPoint
	 */
	public int getCharPoint() {
		return charPoint;
	}


	/**设置出错的字符位置
	 * @param charPoint the charPoint to set
	 */
	public void setCharPoint(int charPoint) {
		this.charPoint = charPoint;
	}


	/**获取出错的信息
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}


	/**设置出错的信息
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString()
	{
		return " 文件["+sourceName+"] 第["+line+"]行 第["+charPoint+"]列     ["+message+"]";
	}

}
