/**
 * 
 */
package makefsm;

import org.jgrapht.graph.DefaultEdge;

/**
 * @author "linc"
 * date   :2012-4-23 
 * time   :下午09:28:35
 *
 */
public class MyEdge extends DefaultEdge {
	
	
	
	   public EventBean  eb;
	
	   public MyEdge()
	   {
		   super();
	   }

		public StatusBean getSource()
		{
			return (StatusBean) super.getSource();
		}
		public StatusBean getTarget()
		{
			return (StatusBean) super.getTarget();
		}

		/**
		 * @return the eb
		 */
		public EventBean getEb() {
			return eb;
		}

		/**
		 * @param eb the eb to set
		 */
		public void setEb(EventBean eb) {
			this.eb = eb;
		}
		
	

}
