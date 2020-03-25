package com.alan2lin.makefsm.generate;

import com.alan2lin.makefsm.MyEdge;
import com.alan2lin.makefsm.entity.SymbolBean;
import com.alan2lin.makefsm.parser.MidleCode;
import com.alan2lin.makefsm.util.Constant.FSMType;
import com.alan2lin.makefsm.util.Constant.StatusAttr;
import org.jgrapht.graph.DirectedMultigraph;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.util.*;

public class GenerateJavaCode implements IGenerateCode{

	String abstractClassTemplate = "./template/java/java_abs.stg";
	String implementClassTemplate = "./template/java/java_impl.stg";
	String testClassTemplate =  "./template/java/java_test.stg";

	String errorMsg = "";
	String abstractClassContent ;
	String implementClassContent;
	String testClassContent;


	@Override
	public boolean generateCode(MidleCode mc){
		boolean bRet = false;

		DirectedMultigraph<SymbolBean, MyEdge> g = mc.getGraph();

		STGroup absTpl = new STGroupFile(abstractClassTemplate);
		STGroup implTpl = new STGroupFile(implementClassTemplate);
		STGroup testTpl = new STGroupFile(testClassTemplate);



		ST absST = absTpl.getInstanceOf("class");
		absST.add("name", mc.getFsmName());
		absST.add("type", mc.getFsmType());

		ST implST = implTpl.getInstanceOf("class");
		implST.add("name", mc.getFsmName());



		//生成常量  Status  和 Event
		SymbolBean[] statusSymbols = mc.getStatusSymbols();
		String[] statusNames = new String[statusSymbols.length];
		for (int i = 0; i < statusSymbols.length; i++) {
			statusNames[i] = statusSymbols[i].getName();
		}

		SymbolBean[] eventSymbols = mc.getEventSymbols();
		String[] eventNames = new String[eventSymbols.length];

		ArrayList<HashMap<String,String>> fixedEvents = new ArrayList<>() ;
		for (int i = 0; i < eventSymbols.length; i++) {
			HashMap<String, String> fixedEvent = new HashMap<String, String>();
			fixedEvent.put("state_name", eventSymbols[i].getPstart().getName());
			fixedEvent.put("event_name", eventSymbols[i].getName());
			fixedEvents.add(fixedEvent);

			eventNames[i] = eventSymbols[i].getName();
		}

		ST[] constats = new ST[2];
		constats[0] = absTpl.getInstanceOf("state_constants");
		constats[0].add("typename", "States");
		constats[0].add("names", statusNames);


		constats[1] = absTpl.getInstanceOf("events_constants");
		constats[1].add("typename", "EVENT");
		//constats[1].add("names", eventNames);
		constats[1].add("events",fixedEvents );

		absST.add("members", constats);

		//生成接口
		ST[] interfaces = null;
		ST[] interfaceImpls = null;

		if(mc.getFsmType().equals(FSMType.MOORE))
		{
			interfaces= new ST[statusSymbols.length];
			interfaceImpls= new ST[statusSymbols.length];

			for (int i = 0; i < statusSymbols.length; i++) {
				String tmp = statusSymbols[i].getName();
				tmp = tmp.substring(0,1).toUpperCase() + tmp.substring(1);
				interfaces[i] = absTpl.getInstanceOf("enteractions");
				interfaces[i].add("name", tmp);

				interfaceImpls[i] = implTpl.getInstanceOf("mooreImpl");
				interfaceImpls[i].add("name", tmp);

			}
		}else
		{
			interfaces= new ST[eventSymbols.length];
			interfaceImpls= new ST[eventSymbols.length];
			for (int i = 0; i < eventSymbols.length; i++) {
				String tmp = eventSymbols[i].getName();
				tmp = tmp.substring(0,1).toUpperCase() + tmp.substring(1);
				interfaces[i] = absTpl.getInstanceOf("onevent");
				interfaces[i].add("name", tmp);

				interfaceImpls[i] = implTpl.getInstanceOf("mealyImpl");
				interfaceImpls[i].add("name", tmp);
			}
		}

		absST.add("interfaces", interfaces);
		implST.add("implFunctions", interfaceImpls);


		//生成实现函数体
		//第一个是processevent

		   ST beginfun = absTpl.getInstanceOf("begin");
		//对每一个状态，都产生一个case模块,顺便如果是开始状态，也产生begin模块

		ST[] caseblock = new ST[statusSymbols.length];
		for (int i = 0; i < statusSymbols.length; i++) {
			caseblock[i] = absTpl.getInstanceOf("case");
			caseblock[i].add("statusName", statusSymbols[i].getName());
			//根据配置的出度产生if的语句模块
			if(statusSymbols[i].getStatus()==StatusAttr.TERMINAL)
			{
				//如果是终结状态，则不能产生任何东西，如果有跳入的，则错了
			}else
			{
				Set<MyEdge> tmpEdges = g.outgoingEdgesOf(statusSymbols[i]);
				ST[] ifblock = new ST[tmpEdges.size()];
				int i_ifblock =0;
				for (Iterator it = tmpEdges.iterator(); it
						.hasNext();) {
					MyEdge e = (MyEdge) it.next();
					ifblock[i_ifblock] = absTpl.getInstanceOf("event_if");

					ifblock[i_ifblock].add("eventName", e.getBindEvent().getName());

					String tmp = e.getTarget().getName();
					ifblock[i_ifblock].add("newStatusName", tmp);

					if(e.getTarget().getStatus()==StatusAttr.TERMINAL) {
						ifblock[i_ifblock].add("isEndState", "endState");
					}


					if(mc.getFsmType().equals( FSMType.MOORE))
					{
						ifblock[i_ifblock].add("isMooreType", "moore");

						tmp = tmp.substring(0,1).toUpperCase() + tmp.substring(1);
						ifblock[i_ifblock].add("funName", tmp);

					}else
					{
						String tmp2 = e.getBindEvent().getName();
						tmp2 = tmp2.substring(0,1).toUpperCase() + tmp2.substring(1);
						ifblock[i_ifblock].add("funName", tmp2);
					}

					i_ifblock++;

				}
				caseblock[i].add("ifblock", ifblock);
			}
			if(statusSymbols[i].getStatus()==StatusAttr.START)
			{
				beginfun.add("beginState", statusSymbols[i].getName());
			}
		}



	   ST processevent = absTpl.getInstanceOf("processevent");
	   processevent.add("caseblock", caseblock);

	   absST.add("functions", new ST[]{ beginfun, processevent});


	   abstractClassContent = absST.render();
	   implementClassContent = implST.render();




	    getAllTestPath(mc);
	   //生成测试类的内容
		ST testST = testTpl.getInstanceOf("class");
		testST.add("name", mc.getFsmName());



		if(!paths.isEmpty())
		{
			ST[] stpath = new ST[paths.size()];
 			for (int i = 0; i < paths.size(); i++) {
				ArrayList<SymbolBean> path = paths.get(i);
				stpath[i] = testTpl.getInstanceOf("pathtest");
				stpath[i].add("order", i);
				stpath[i].add("name",mc.getFsmName());

				ST[] emitEvents = new ST[path.size()-1];

				SymbolBean preV = null;
				int count=0;
				String strPath = "";
				for (Iterator it = path.iterator(); it.hasNext();) {
					SymbolBean sb = (SymbolBean) it.next();


					if(preV!=null){
						strPath = strPath + "->" +sb.getName();
						String eventName=g.getEdge(preV,sb ).getBindEvent().getName();
						emitEvents[count]=testTpl.getInstanceOf("emitEvent");
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
 			testST.add("pathtests", stpath);
		}


		testClassContent = testST.render();



	   bRet = true;

	   return bRet;
	}

	/**
	 * 存储开始节点到终结点的每一条路径的容器。
	 */
	ArrayList<ArrayList<SymbolBean>> paths = new ArrayList<ArrayList<SymbolBean>>();

	/**
	 * 当前遍历的节点的堆栈
	 */
	Stack<SymbolBean> stCurr = new Stack<SymbolBean>();

	Hashtable<SymbolBean,Stack<MyEdge>> hshest = new Hashtable<SymbolBean,Stack<MyEdge>>();

	public void getAllTestPath(MidleCode mc)
	{
		SymbolBean[] statusSymbols = mc.getStatusSymbols();
		SymbolBean startSymbol = mc.getStartSymbol();
		SymbolBean[] endStatusSymbols = mc.getEndStatusSymbols();



		//对每一个结束节点，都从开始节点做一个全路径遍历



		DirectedMultigraph<SymbolBean, MyEdge> g = mc.getGraph();
		for (int i = 0; i < endStatusSymbols.length; i++) {
			//从拷贝的图中删除无关的结束节点
			DirectedMultigraph<SymbolBean, MyEdge>  g_tmp = (DirectedMultigraph<SymbolBean, MyEdge>) g.clone();

			for (int j = 0; j < endStatusSymbols.length; j++) {
				if (i!=j) {
					g_tmp.removeVertex(endStatusSymbols[j]);
				}
			}

			//构造辅助信息 每一个顶点配置一个堆栈
			Set<SymbolBean> sV = g_tmp.vertexSet();
			hshest.clear();

			for (Iterator it = sV.iterator(); it.hasNext();) {
				SymbolBean sb = (SymbolBean) it.next();
				//est[sb.getId()]= new Stack<MyEdge>() ;
				hshest.put(sb,new Stack<MyEdge>());
			}


			//if(!st.isEmpty()) System.out.println("sth wrong...");

			//清空堆栈
			stCurr.clear();

			stCurr.push(startSymbol);

			dfs4paths(g_tmp,endStatusSymbols[i]);

		}


	}


	//已经明确，但单纯的遍历节点是无法生成所有的路径组合
	//问题转换成，遍历所有的入度与出度的组合
	void dfs4paths(DirectedMultigraph<SymbolBean, MyEdge>  xg,SymbolBean endsb)
	{

		if(stCurr.isEmpty())
		{
			//终结了，查找完所有的路径。
			return ;
		}

		SymbolBean sbcur = stCurr.peek();

		//出口一 找到路径
		if (sbcur.equals(endsb)){
			System.out.println(" find a path");
			//逐一地遍历堆栈节点，带上环路信息

			ArrayList<SymbolBean> path = new ArrayList<SymbolBean>();

			for (int i = 0; i < stCurr.size(); i++) {
				path.add(stCurr.get(i));
				System.out.print(stCurr.get(i).getName() +"->");
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
					if (!( est.contains(myEdge) ) ){
						tmpE.add(myEdge);
					}
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

			stCurr.push(myEdge.getTarget());
			est.push(myEdge);
			dfs4paths(xg,endsb);
			stCurr.pop();
			est.pop();

		}


	}

	public String generateTestCode(){
		String strRet = "";

		return strRet;

	}


	@Override
	public void setAbstractClassTemplate(String fileName) {
		if (fileName!=null && ! "".equals(fileName.trim())) {
			abstractClassTemplate = fileName;
		}
	}


	@Override
	public void setImplementClassTemplate(String fileName) {
		if (fileName!=null && ! "".equals(fileName.trim())) {
			implementClassTemplate = fileName;
		}
	}


	@Override
	public void setTestClassTemplate(String fileName) {
		if (fileName!=null && ! "".equals(fileName.trim())) {
			testClassTemplate = fileName;
		}

	}


	@Override
	public void setResource(String name, String value) {
		//nothing to do in this case ...
		return ;

	}


	@Override
	public String getErrorMsg() {
		return errorMsg;
	}


	@Override
	public String getAbstractClassContent() {
		return abstractClassContent;
	}


	@Override
	public String getImplementClassContent() {
		return implementClassContent;
	}


	@Override
	public String getTestClassContent() {
		return testClassContent;
	}

}
