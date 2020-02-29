/**
 * 
 */
package makefsm;


import makefsm.entity.SymbolBean;

import org.jgrapht.graph.DefaultEdge;

/**
 * @author "linc"
 * date   :2012-4-23 
 * time   :下午09:28:35
 *
 */
public class MyEdge extends DefaultEdge {
	
	
	   //TODO 边同事件的符号关联，以便减少查找，可能这个可以省略
	   public SymbolBean  eb;
	
	   public MyEdge()
	   {
		   super();
	   }

		public SymbolBean getSource()
		{
			return (SymbolBean) super.getSource();
		}
		public SymbolBean getTarget()
		{
			return (SymbolBean) super.getTarget();
		}

		/**
		 * @return the eb
		 */
		public SymbolBean getBindEvent() {
			return eb;
		}

		/**
		 * @param eb the eb to set
		 */
		public void setBindEvent(SymbolBean eb) {
			this.eb = eb;
		}
		
	

}
