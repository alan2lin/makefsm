/**
 * 
 */
package makefsm;


import org.stringtemplate.v4.*;


/**
 * @author "linc"
 * date   :2012-4-24 
 * time   :下午01:41:56
 *
 */
public class TestST4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		STGroup group = new STGroupFile("./template/java.stg");
		ST st = group.getInstanceOf("class");
		st.add("name", "fsm");
		ST consts =  group.getInstanceOf("constants");
		
		consts.add("typename", "Event");
		consts.add("names", new String[]{"aaa","bbb"});
		
		//st.add("members", consts);
		
		ST consts2 =  group.getInstanceOf("constants");
		
		consts2.add("typename", "Status");
		consts2.add("names", new String[]{"aaa","bbb"});
		
		st.add("members", new ST[]{consts,consts2});	
		
		
		String result = st.render(); // yields "int x = 0;"
		
		
		
		System.out.println(result);
		
		
		
		


	}

}
