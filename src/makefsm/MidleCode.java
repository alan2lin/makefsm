/**
 * 
 */
package makefsm;

import graphviz.GraphViz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import javax.net.ssl.SSLEngineResult.Status;

import org.antlr.gunit.swingui.TestCaseEditController.OutputEditorPane;
import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.BiconnectivityInspector;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.AsUndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedMultigraph;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;


import makefsm.Constant.StatusAttr;



/**
 * @author "linc"
 * date   :2012-4-20 
 * time   :下午08:51:20
 *
 */
public class MidleCode {
	
	/**
	 * 状态机名称
	 */
	private String fsmName;
	
	/**
	 * 状态机的描述 
	 */
	String fsmDesc;
	
	
	/**
	 * 状态机类型  true moore类型    false mealy类型
	 */
	boolean mooreFsm = false;
	
	/**
	 * 状态描述表
	 */
	StatusBean[] asb = null;
	
	/**
	 * 时间描述表 
	 */
	EventBean[] aeb= null;
	
	/**
	 * 生成的目标语言
	 */
	String[] targets = new String[]{"java"};
	
	
	/**
	 *  对事件响应的严格性的限制， false 非严格的，如果当前遇到无法识别的事件，将会忽略。  true 严格的 ，如果当前状态下遇到无法识别的事件，将会抛出异常。
	 */
	boolean strict = true;
	
	
	/**
	 *  是否是自治的。  如果是自治的，则意味着不需要与外部交互
	 */
	boolean autonomy = true;

	
	/**
	 * 进行语义检查后的出错信息
	 */
	public String errorMsg = "";

	/**
	 * @return the fsmName
	 */
	public String getFsmName() {		
		return fsmName;
	}

	/**
	 * @param fsmName the fsmName to set
	 */
	public void setFsmName(String xfsmName) {
		
		//this.fsmName = xfsmName.substring(0,1).toUpperCase() + xfsmName.substring(1);
		this.fsmName = xfsmName;
	}

	/**
	 * @return the fsmDesc
	 */
	public String getFsmDesc() {
		return fsmDesc;
	}

	/**
	 * @param fsmDesc the fsmDesc to set
	 */
	public void setFsmDesc(String fsmDesc) {
		this.fsmDesc = fsmDesc;
	}

	DirectedMultigraph<StatusBean, MyEdge> g = null;
	
	
	//进行语义检查	
	/**
	 * @return
	 */
	public boolean check()
	{
		
		boolean bRet = false;
		
		errorMsg="";
		
		 g =  new DirectedMultigraph<StatusBean, MyEdge>(MyEdge.class);
		 
			
		for (int i = 0; i < asb.length; i++) {									
			g.addVertex(asb[i]);			
		}
		
		for (int i = 0; i < aeb.length; i++) {
			
			//检查两节点多转移情况。		
			
			MyEdge edge = g.getEdge(asb[aeb[i].getPstart()],asb[aeb[i].getPend()]);
			
			if (null != edge)
			{
				errorMsg = "状态["+asb[aeb[i].getPstart()].getName()+"]到状态["+asb[aeb[i].getPend()].getName()+"]存在多条转移定义，事件["+aeb[i].getName()+"]";
				return bRet;
			}
			MyEdge edge2 = g.addEdge(asb[aeb[i].getPstart()],asb[aeb[i].getPend()]);
			edge2.setEb(aeb[i]);
		}
		
		
		
		//检查出度入度情况
		// 开始节点必须要有一个除了自己外的出度
		// 结束节点必须不能有出度。
		// 非终结节点必须要有出度和入度
		
		boolean tmpFlag = false;
		for (int i = 0; i < asb.length; i++) {
			
			int inEdges = 0;
			int outEdges = 0;
			
			int inEdges_noself = 0;
			int outEdges_noself = 0;			

			Set<MyEdge> outg = g.outgoingEdgesOf(asb[i]);
			outEdges = outg.size();
			outEdges_noself = outEdges ;
			
			if(outEdges>0)
			{			
				for (Iterator it = outg.iterator(); it.hasNext();) {
					MyEdge myEdge = (MyEdge) it.next();
					if (myEdge.getSource().equals(myEdge.getTarget()))   outEdges_noself--;
				}				
			}
			
			Set<MyEdge> ing = g.incomingEdgesOf(asb[i]);
			inEdges = ing.size();
			inEdges_noself = inEdges ;
			
			if(inEdges>0)
			{			
				for (Iterator it = ing.iterator(); it.hasNext();) {
					MyEdge myEdge = (MyEdge) it.next();
					if (myEdge.getSource().equals(myEdge.getTarget()))   inEdges_noself--;
				}				
			}
			
			switch(asb[i].getStatus())
			{
			case START:				
				if(outEdges_noself==0){					
					errorMsg=errorMsg+"开始状态节点["+asb[i].getName()+"] 没有出去的边，请检查  \n";
					tmpFlag=true;
				}
				break;
			case NONTERMINAL:
				if(inEdges_noself==0){
					errorMsg=errorMsg+"中间状态节点["+asb[i].getName()+"] 没有其他节点进来的边，请检查 \n";
					tmpFlag=true;
				}
				if(outEdges_noself==0){
					errorMsg=errorMsg+"中间状态节点["+asb[i].getName()+"] 没有出去其他节点的边，请检查 \n";
					tmpFlag=true;
				}

				break;
			case TERMINAL:
				if(outEdges>0){
					errorMsg=errorMsg+"终结状态节点["+asb[i].getName()+"] 有出度，请检查 \n";
					tmpFlag=true;
				}				
				break;
			}			
		}
		
		if(tmpFlag) return bRet;
		
		
		//检测连通性
		ConnectivityInspector<StatusBean, MyEdge> ci = new ConnectivityInspector(g);
		if (!ci.isGraphConnected())
		{			
			List<Set<StatusBean>> lst = ci.connectedSets();			
			errorMsg = errorMsg + "图并不连通，分成了["+lst.size()+"]个连通分量 请检查 \n";
			
			int iparts = 0;
			for (Iterator it = lst.iterator(); it.hasNext();) {
				Set<StatusBean> set = (Set<StatusBean>) it.next();
				errorMsg = errorMsg + " \n第["+(++iparts)+"] 有["+set.size()+"]个节点:";
				for (Iterator itset = set.iterator(); itset.hasNext();) {
					StatusBean sbp = (StatusBean) itset.next();
					errorMsg = errorMsg + " , " + sbp.getName() ;
				}				
			}
			
			
		}
		
		
		
		AsUndirectedGraph <StatusBean, MyEdge> g2= new AsUndirectedGraph <StatusBean, MyEdge>(g);
		
		BiconnectivityInspector inspector = new BiconnectivityInspector(g2);		
		
		
		//System.out.println( inspector.getCutpoints().size());
		
		Set<StatusBean> a = inspector.getCutpoints();		
		
		boolean tmpFlag2 = false;
		for (Iterator<StatusBean> it = a.iterator(); it.hasNext();) {
			StatusBean o=  it.next();
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
	
	
	/** 根据节点和关系生成graphviz能识别的dot的内容
	 * @return
	 */
	public String makeGraphContent()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(" digraph G { \n node[fontname=\"FangSong\"]; \n edge[fontname=\"FangSong\"]; \n graph[fontname=\"FangSong\"]; \n");
		sb.append(" subgraph cluster_r0 { ");
		
		String tmpDesc = fsmDesc;
		if(null==tmpDesc) {
			tmpDesc="";
		}else
		{
			tmpDesc = tmpDesc.replace('"', ' ');
		}
		
		sb.append(" label=\"").append(fsmName).append("\\n").append(tmpDesc).append("\";");
		
		
		
		//产生节点
		for (int i = 0; i < asb.length; i++) {
			StatusAttr status  = asb[i].getStatus();
			
			String nodeName = asb[i].getName();
			String nodeDesc = asb[i].getDesc();
			if(null==nodeDesc) {
				nodeDesc="";
			}else
			{
				nodeDesc = nodeDesc.replace('"', ' ');
			}
			
			//nodeName="s_"+nodeName;
			
			sb.append("\n   ");
			sb.append(nodeName);
			sb.append("[label=\"\\N\\n");
			sb.append(nodeDesc);
			sb.append(" \"  ");
			
			switch(status)
			{
			case START:
				sb.append(" shape=ellipse ");
				break;
			case NONTERMINAL:
				sb.append(" shape=box ");
				break;
			case TERMINAL:
				sb.append(" shape=doublecircle ");
				break;
			}
			
			sb.append(" ];");
		}
		sb.append("\n\n\n");
		
		//产生边
		for (int i = 0; i < aeb.length; i++) {
			String eventName = aeb[i].getName();
			String eventDesc =aeb[i].getDesc();
			if(null==eventDesc) {
				eventDesc="";
			}else
			{
				eventDesc = eventDesc.replace('"', ' ');
			}
			String s1 = asb[aeb[i].getPstart()].getName();
			String s2 = asb[aeb[i].getPend()].getName();
			//s1="s_"+s1;
			//s2="s_"+s2;
			//String eventName = "e_"+eventName;
			
			sb.append("\n    ").append(s1).append("->").append(s2).append("[label=\"").append(eventName).append("\\n").append(eventDesc).append("\"]; \n");
			
		}
		
		sb.append("     }\n");
		sb.append(" }");
		return sb.toString();
	}
	
	
	public void write2file(String fileDir,String xfileName,String fileContent)
	{
		// System.out.println(path+fileName+".g");
		String fileName = fileDir+"/"+xfileName;
		
		//System.out.println("准备写入的文件是:" + fileName);

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fileName);
			Writer out = new OutputStreamWriter(fos, "UTF-8");
			out.write(fileContent);
			out.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public void testWriteFile()
	{
		
		GraphViz gv = new GraphViz(); 
		//gv.readSource(makeGraphContent());
		
		//System.out.println(gv.getDotSource());
		
		String type = "gif";
		
		File out = new File("./graphs/"+fsmName+"." + type);   // Linux
//	      File out = new File("c:/eclipse.ws/graphviz-java-api/out." + type);    // Windows
		
		//System.out.println(" graph file is "+ out.getName());
		
		//String strGraphContent = makeGraphContent();
		//System.out.println(" graph file content is  "+ strGraphContent);
		
		//byte img[] = gv.getGraph( strGraphContent, type );
			
		
		//System.out.println(" graph img lengh is "+ img.length);	
	
				
	      gv.writeGraphToFile( gv.getGraph(makeGraphContent() , type ), out );
	      
	      
	      
		//gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type), "./graphs/"+fsmName+"."+type);
		//writeGraph("./graphs",fsmName,makeGraphContent());
	      
	      
	      
	      //代码文件
	      write2file("./generatecodes/makefsm",fsmName+".java",generateCode()[0]);
	      write2file("./generatecodes/makefsm",fsmName+"Impl.java",generateCode()[1]);
	      getAllTestPath();
	      write2file("./generatecodes/makefsm",fsmName+"Test.java",generateTestCode());
	      
		
	}

	/**
	 * @return the asb
	 */
	public StatusBean[] getAsb() {
		return asb;
	}

	/**
	 * @param asb the asb to set
	 */
	public void setAsb(StatusBean[] asb) {
		this.asb = asb;
	}

	/**
	 * @return the aeb
	 */
	public EventBean[] getAeb() {
		return aeb;
	}

	/**
	 * @param aeb the aeb to set
	 */
	public void setAeb(EventBean[] aeb) {
		this.aeb = aeb;
	}
	
	
	public String[] generateCode(){
		String[] strRet = new String[2];
		
		STGroup group = new STGroupFile("./template/java.stg");
		STGroup groupImpl = new STGroupFile("./template/javaimpl.stg");



		ST st = group.getInstanceOf("class");
		st.add("name", fsmName);
		
		ST stImpl = groupImpl.getInstanceOf("class");
		stImpl.add("name", fsmName);

		
		
		//生成常量  Status  和 Event
		
		String[] statusNames = new String[asb.length];		
		for (int i = 0; i < asb.length; i++) {
			statusNames[i] = asb[i].getName();			
		}
		
		String[] eventNames = new String[aeb.length];		
		for (int i = 0; i < aeb.length; i++) {
			eventNames[i] = aeb[i].getName();			
		}
		
		ST[] constats = new ST[2];	
		constats[0] = group.getInstanceOf("constants");
		constats[0].add("typename", "States");
		constats[0].add("names", statusNames);
		
		
		constats[1] = group.getInstanceOf("constants");
		constats[1].add("typename", "Event");
		constats[1].add("names", eventNames);
		
		st.add("members", constats);
		
		//生成接口
		ST[] interfaces = null;
		ST[] interfaceImpls = null;
		
		if(isMooreFsm())
		{
			interfaces= new ST[asb.length];			
			interfaceImpls= new ST[asb.length];
			
			for (int i = 0; i < asb.length; i++) {
				String tmp = asb[i].getName();				
				tmp = tmp.substring(0,1).toUpperCase() + tmp.substring(1);
				interfaces[i] = group.getInstanceOf("enteractions");
				interfaces[i].add("name", tmp);	
				
				interfaceImpls[i] = groupImpl.getInstanceOf("mooreImpl");
				interfaceImpls[i].add("name", tmp);	
				
			}			
		}else
		{
			interfaces= new ST[aeb.length];			
			interfaceImpls= new ST[aeb.length];			
			for (int i = 0; i < aeb.length; i++) {
				String tmp = aeb[i].getName();				
				tmp = tmp.substring(0,1).toUpperCase() + tmp.substring(1);
				interfaces[i] = group.getInstanceOf("onevent");
				interfaces[i].add("name", tmp);		
				
				interfaceImpls[i] = groupImpl.getInstanceOf("mealyImpl");
				interfaceImpls[i].add("name", tmp);	
			}
		}
		
		st.add("interfaces", interfaces);
		stImpl.add("implFunctions", interfaceImpls);
		
		
		//生成实现函数体
		//第一个是processevent
		
		   ST beginfun = group.getInstanceOf("begin");		   
		//对每一个状态，都产生一个case模块,顺便如果是开始状态，也产生begin模块
		ST[] caseblock = new ST[asb.length];
		for (int i = 0; i < asb.length; i++) {
			caseblock[i] = group.getInstanceOf("case");
			caseblock[i].add("statusName", asb[i].getName());
			//根据配置的出度产生if的语句模块
			if(asb[i].getStatus()==StatusAttr.TERMINAL)
			{
				//如果是终结状态，则不能产生任何东西，如果有跳入的，则错了
			}else
			{
				Set<MyEdge> tmpEdges = g.outgoingEdgesOf(asb[i]);
				ST[] ifblock = new ST[tmpEdges.size()];
				int i_ifblock =0;
				for (Iterator it = tmpEdges.iterator(); it
						.hasNext();) {
					MyEdge e = (MyEdge) it.next();
					ifblock[i_ifblock] = group.getInstanceOf("event_if");
					
					ifblock[i_ifblock].add("eventName", e.getEb().getName());
					
					String tmp = e.getTarget().getName();
					ifblock[i_ifblock].add("newStatusName", tmp);
					
					tmp = tmp.substring(0,1).toUpperCase() + tmp.substring(1);					
					ifblock[i_ifblock].add("funName", tmp);
					
					if(isMooreFsm()) ifblock[i_ifblock].add("isMooreType", "moore");
					if(e.getTarget().getStatus()==StatusAttr.TERMINAL) ifblock[i_ifblock].add("isEndState", "endState");
					
					i_ifblock++;
					
				}
				caseblock[i].add("ifblock", ifblock);
			}
			if(asb[i].getStatus()==StatusAttr.START)
			{
				beginfun.add("beginState", asb[i].getName());
			}
		}
		

		
	   ST processevent = group.getInstanceOf("processevent");
	   processevent.add("caseblock", caseblock);
	   
	   st.add("functions", new ST[]{ beginfun, processevent});
	   
	   
		
		
		
		strRet[0] = st.render(); 
		strRet[1] = stImpl.render();
		
		
		
		//System.out.println(strRet);
		
		
		Set<MyEdge> tt = g.getAllEdges(asb[0], asb[1]);
		for (Iterator it = tt.iterator(); it.hasNext();) {
			MyEdge myEdge = (MyEdge) it.next();
			//System.out.println("sss"+myEdge.getEb().getName());			
		}	
		
		return strRet;	
	}	
	
	
	//////////////////////////
	ArrayList<ArrayList<StatusBean>> paths = new ArrayList<ArrayList<StatusBean>>();
	
	ArrayList<StatusBean> endList = new ArrayList<StatusBean>();
	StatusBean start = null;
	
	Stack<StatusBean> st = new Stack<StatusBean>();
	
	Hashtable<StatusBean,Stack<MyEdge>> hshest = new Hashtable<StatusBean,Stack<MyEdge>>();
	//Stack<MyEdge>[] est =  null;	

	
	public void getAllTestPath()
	{
		//找到开始节点和结束节点列表
		for (int i = 0; i < asb.length; i++) {
			if(asb[i].getStatus()==StatusAttr.TERMINAL) {
				endList.add(asb[i]);
			}else if(asb[i].getStatus()==StatusAttr.START){
				start = asb[i];
			}else
			{
				;
			}		
		}
		
		//对每一个结束节点，都从开始节点做一个全路径遍历
		
		for (int i = 0; i < endList.size(); i++) {
			//从拷贝的图中删除无关的结束节点
			DirectedMultigraph<StatusBean, MyEdge>  g_tmp = (DirectedMultigraph<StatusBean, MyEdge>) g.clone();
			
			for (int j = 0; j < endList.size(); j++) {
				if (i!=j) g_tmp.removeVertex(endList.get(j));				
			}
			
			//构造辅助信息
			Set<StatusBean> sV = g_tmp.vertexSet();
			hshest.clear();
			
			for (Iterator it = sV.iterator(); it.hasNext();) {
				StatusBean sb = (StatusBean) it.next();			
				//est[sb.getId()]= new Stack<MyEdge>() ;
				hshest.put(sb,new Stack<MyEdge>());
			}
			
			
			//if(!st.isEmpty()) System.out.println("sth wrong...");
			
			//清空堆栈			
			st.clear();			
			
			st.push(start);
			
			dfs4paths(g_tmp,endList.get(i));		
			
		}
		
		
	}
	
	
	//已经明确，但单纯的遍历节点是无法生成所有的路径组合
	//问题转换成，遍历所有的入度与出度的组合
	void dfs4paths(DirectedMultigraph<StatusBean, MyEdge>  xg,StatusBean endsb)
	{
		
		if(st.isEmpty())
		{
			//终结了，查找完所有的路径。
			return ;		
		}
		
		StatusBean sbcur = st.peek();			
		
		//出口一 找到路径
		if (sbcur.equals(endsb)){
			System.out.println(" find a path");
			//逐一地遍历堆栈节点，带上环路信息
			
			ArrayList<StatusBean> path = new ArrayList<StatusBean>();
			
			for (int i = 0; i < st.size(); i++) {
				path.add(st.get(i));
				System.out.print(st.get(i).getName() +"->");				
			}
			paths.add(path);
			System.out.println("");
			
			//st.pop();
			return;
		}
		
		
		Set<MyEdge> set = xg.outgoingEdgesOf(sbcur);
		if(set.size()==0)
		{
			//终结点,死路
			//st.pop();			
			return ;			
		}		
		//判断当前的状态is visited (  estack.isempty)
		Stack<MyEdge> est = hshest.get(sbcur);
		ArrayList<MyEdge> tmpE = new ArrayList<MyEdge>();
		
		
		if(! (est.isEmpty()) )
		{
			for (Iterator it = set.iterator(); it.hasNext();) {
				MyEdge myEdge = (MyEdge) it.next();
					if (!( est.contains(myEdge) ) ) tmpE.add(myEdge);				
			}
		}else
		{
			for (Iterator it = set.iterator(); it.hasNext();) {
				MyEdge myEdge = (MyEdge) it.next();
					tmpE.add(myEdge);				
			}
			
		}
		
		//将 把所有的出度都列举出来   减去 stack中的 出度 ，得到遍历的列表
		
		//对于每一个出度  ，将这个出度压入  stack  ，将这个出度的节点压入stack
		
		//递归
		
		//恢复边的出度
		
		if(tmpE.size()==0)
		{
			//所有的出度都是环路
			//System.out.println(sbcur.getName()+" 出度 都是环路");
			return;
			
		}
		
		for (Iterator it = tmpE.iterator(); it.hasNext();) {
			MyEdge myEdge = (MyEdge) it.next();
			
			st.push(myEdge.getTarget());
			est.push(myEdge);
			dfs4paths(xg,endsb);
			st.pop();
			est.pop();		
			
		}

		
	}
	
	public String generateTestCode(){
		String strRet = "";
		
		STGroup group = new STGroupFile("./template/javatest.stg");
		ST st = group.getInstanceOf("class");
		st.add("name", fsmName);
		

		if(!paths.isEmpty())
		{
			ST[] stpath = new ST[paths.size()];
 			for (int i = 0; i < paths.size(); i++) {
				ArrayList<StatusBean> path = paths.get(i);				
				stpath[i] = group.getInstanceOf("pathtest");
				stpath[i].add("order", i);
				stpath[i].add("name",fsmName);
				
				ST[] emitEvents = new ST[path.size()-1];
				
				StatusBean preV = null;	
				int count=0;
				String strPath = "";
				for (Iterator it = path.iterator(); it.hasNext();) {
					StatusBean sb = (StatusBean) it.next();
					
					
					if(preV!=null){
						strPath = strPath + "->" +sb.getName();
						String eventName=g.getEdge(preV,sb ).getEb().getName();	
						emitEvents[count]=group.getInstanceOf("emitEvent");
						emitEvents[count].add("eventName", eventName);	
						count++;
					}else
					{
						strPath = strPath+ sb.getName();
					}					
					
					preV = sb;					
				}
				stpath[i].add("emitEvents",emitEvents );
				stpath[i].add("path",strPath );
				
			}
 			st.add("pathtests", stpath);
		}
		
		
		strRet = st.render();
		return strRet;
		
	}

	/**
	 * @return the mooreFsm
	 */
	public boolean isMooreFsm() {
		return mooreFsm;
	}

	/**
	 * @param mooreFsm the mooreFsm to set
	 */
	public void setMooreFsm(boolean mooreFsm) {
		this.mooreFsm = mooreFsm;
	}
	
	
}
