package makefsm.check;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import makefsm.MyEdge;
import makefsm.entity.SymbolBean;
import makefsm.parser.MidleCode;
import makefsm.util.Constant.StatusAttr;
import makefsm.util.Constant.SymbolType;

import org.jgrapht.alg.BiconnectivityInspector;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.AsUndirectedGraph;
import org.jgrapht.graph.DirectedMultigraph;

/** 对状态和事件进行约束性检查
 * @author workstation
 *
 */
public class DefaultCheck implements ICheck{
	
	String errorMsg = "";
	
	/** 对中间代码进行约束检查。
	 * @param mc 中间代码
	 * @return 检查结果  true 检查通过 false 检查不通过,详细情况见 getErrorMsg
	 */
	public boolean check(MidleCode mc)
	{

			
			boolean bRet = false;
			
			errorMsg="";
			
			SymbolBean[] statusSymbols = mc.getStatusSymbols(); 
			SymbolBean[] eventSymbols = mc.getEventSymbols();		

			
			DirectedMultigraph<SymbolBean, MyEdge> g =  mc.getGraph();		
	
		
			//检查出度入度情况
			// 开始节点必须要有一个除了自己外的出度
			// 结束节点必须不能有出度。
			// 非终结节点必须要有出度和入度
			
			boolean tmpFlag = false;
			for (int i = 0; i < statusSymbols.length; i++) {
				
				int inEdges = 0;
				int outEdges = 0;
				
				int inEdges_noself = 0;
				int outEdges_noself = 0;			

				Set<MyEdge> outg = g.outgoingEdgesOf(statusSymbols[i]);
				outEdges = outg.size();
				outEdges_noself = outEdges ;
				
				if(outEdges>0)
				{			
					for (Iterator it = outg.iterator(); it.hasNext();) {
						MyEdge myEdge = (MyEdge) it.next();
						if (myEdge.getSource().equals(myEdge.getTarget()))   outEdges_noself--;						
					}				
				}
				
				Set<MyEdge> ing = g.incomingEdgesOf(statusSymbols[i]);
				inEdges = ing.size();
				inEdges_noself = inEdges ;
				
				if(inEdges>0)
				{			
					for (Iterator it = ing.iterator(); it.hasNext();) {
						MyEdge myEdge = (MyEdge) it.next();
						if (myEdge.getSource().equals(myEdge.getTarget()))   inEdges_noself--;
					}				
				}
				
				switch(statusSymbols[i].getStatus())
				{
				case START:				
					if(outEdges_noself==0){					
						errorMsg=errorMsg+"开始状态节点["+statusSymbols[i].getName()+"] 没有出去的边，请检查  \n";
						tmpFlag=true;
					}
					break;
				case NONTERMINAL:
					if(inEdges_noself==0){
						errorMsg=errorMsg+"中间状态节点["+statusSymbols[i].getName()+"] 没有其他节点进来的边，请检查 \n";
						tmpFlag=true;
					}
					if(outEdges_noself==0){
						errorMsg=errorMsg+"中间状态节点["+statusSymbols[i].getName()+"] 没有出去其他节点的边，请检查 \n";
						tmpFlag=true;
					}

					break;
				case TERMINAL:
					if(outEdges>0){
						errorMsg=errorMsg+"终结状态节点["+statusSymbols[i].getName()+"] 有出度，请检查 \n";
						tmpFlag=true;
					}				
					break;
				default: 
					errorMsg=errorMsg+"存在定义不完整的状态节点 ，不是开始/结束/非终结状态，请检查\n";
					tmpFlag=true; 
				}			
			}
			
			if(tmpFlag) return bRet;
			
			
			//检测连通性
			ConnectivityInspector<SymbolBean, MyEdge> ci = new ConnectivityInspector(g);
			if (!ci.isGraphConnected())
			{			
				List<Set<SymbolBean>> lst = ci.connectedSets();			
				errorMsg = errorMsg + "图并不连通，分成了["+lst.size()+"]个连通分量 请检查 \n";
				
				int iparts = 0;
				for (Iterator it = lst.iterator(); it.hasNext();) {
					Set<SymbolBean> set = (Set<SymbolBean>) it.next();
					errorMsg = errorMsg + " \n第["+(++iparts)+"] 部分 有["+set.size()+"]个节点:";
					for (Iterator itset = set.iterator(); itset.hasNext();) {
						SymbolBean sbp = (SymbolBean) itset.next();
						errorMsg = errorMsg + " , " + sbp.getName() ;
					}
				}
				tmpFlag=true;
			}
			
			if(tmpFlag) return bRet;
			
			
			//检查终结状态是否关节点。已经转化为无向图。 该部分尚存在不能证实的地方 TODO
			AsUndirectedGraph <SymbolBean, MyEdge> g2= new AsUndirectedGraph <SymbolBean, MyEdge>(g);
			
			BiconnectivityInspector inspector = new BiconnectivityInspector(g2);				
						
			Set<SymbolBean> a = inspector.getCutpoints();		
			
			boolean tmpFlag2 = false;
			for (Iterator<SymbolBean> it = a.iterator(); it.hasNext();) {
				SymbolBean o=  it.next();
				if(o.getStatus()==StatusAttr.TERMINAL)
				{
					errorMsg=errorMsg+"终结状态节点["+o.getName()+"] 是关节点，这将导致部分状态无法迁移，请检查 \n";
					tmpFlag2 = true;
				}			
			}
			if(tmpFlag2) return bRet;
			
			bRet = true;	

					
			return bRet;
		
	
	}
	
	public String getErrorMsg()
	{
		return errorMsg;
	}
	
}

