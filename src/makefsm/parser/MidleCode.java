/**
 * 
 */
package makefsm.parser;

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
import java.util.HashMap;
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


import makefsm.MyEdge;
import makefsm.entity.SymbolBean;
import makefsm.util.Constant.FSMType;
import makefsm.util.Constant.StatusAttr;
import makefsm.util.Constant.SymbolType;



/**中间代码类，从语法文件构造符号表，由于比较简单，就基本描述+符号表为中间文件
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
	 * 状态机类型   moore类型     mealy类型
	 */
	FSMType fsmType = FSMType.MOORE;
	

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
	 * 符号表
	 */
	public ArrayList<SymbolBean> symbols = new ArrayList<SymbolBean>();
	/**
	 * hash形式的符号表，用以辅助查找
	 */
	public HashMap<String,SymbolBean> hshSymbols = new  HashMap<String,SymbolBean>();
	
	
	//将符号分解归类，减少之后的需要用到的查询开销。
	
	/**
	 * 状态符号
	 */
	public SymbolBean[] statusSymbols ;	
	/**
	 * 事件符号
	 */
	public SymbolBean[] eventSymbols ;	
	/**
	 * 开始状态
	 */
	public SymbolBean   startSymbol;
	/**
	 * 非终结状态
	 */
	public SymbolBean[]  nonterminalSymbols;	
	/**
	 * 终结状态
	 */
	public SymbolBean[] endStatusSymbols ;
	
	
	/**状态计数器
	 * 
	 */
	private int statusCount = 0; 
	
	
	/**事件计数器
	 * 
	 */
	private int eventCount = 0;
	/**
	 * 非终结状态计数器
	 */
	private int nonterminalStatusCount = 0;
	/**
	 * 终结状态技术器
	 */
	private int endStatusCount = 0;
	

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
	
	DirectedMultigraph<SymbolBean, MyEdge> g =  null;
	

	
	public String getErrorMsg()
	{
		return errorMsg;		
	}
	
	public FSMType getFsmType() {
		return fsmType;
	}

	public void setFsmType(FSMType fsmType) {
		this.fsmType = fsmType;
	}

	
	
	
	
	/** 检查该符号是否存在
	 * @param name 符号名称
	 * @param symbolType 符号类型
	 * @return true 存在  false 不存在
	 */
	public boolean isSymbolExists(String name,SymbolType symbolType){
		 
		return hshSymbols.get(symbolType+"_"+name)!=null;		
	}

	
	/** 增加一个符号
	 * @param sb 符号bean
	 */
	public void addSymbol(SymbolBean sb)
	{
		//生成内部编号
		sb.setIndex(symbols.size());
		symbols.add(sb);
		hshSymbols.put(sb.getType()+"_"+sb.getName(), sb);	
		if(sb.getType().equals(SymbolType.EVENT)) eventCount++;
		
		if(sb.getType().equals(SymbolType.STATUS)) {
			statusCount++;			
		}
	}
	
	/** 获取符号的数量。
	 * @return
	 */
	public int getCount()
	{
		return symbols.size();
		
	}
	
	/** 获取状态的个数。
	 * @return
	 */
	public int getStatusCount()
	{
		return statusCount;
	}
	
	/** 获取事件的个数。
	 * @return
	 */
	public int getEventCount()
	{
		return eventCount;
	}
	
	
	/** 按照名字和类型获取符号表的一项
	 * @param name 名字
	 * @param st 类型
	 * @return
	 */
	public SymbolBean getSymbol(String name , SymbolType st)
	{
		return hshSymbols.get(st+"_"+name);				
	}
	
	public  void pickupSymbols()
	{
		//申请空间
		statusSymbols = new SymbolBean[statusCount] ;
		eventSymbols = new SymbolBean[eventCount];
		
		
		int sc =0,ec=0,nsc=0,esc=0;
		for (Iterator iterator = symbols.iterator(); iterator.hasNext();) {
			SymbolBean sb = (SymbolBean) iterator.next();
			
			if(sb.getType().equals(SymbolType.EVENT)) eventSymbols[ec++]=sb;
			if(sb.getType().equals(SymbolType.STATUS)) {
				statusSymbols[sc++]=sb;
				switch (sb.getStatus()) {

					
				case NONTERMINAL:
					nonterminalStatusCount++;							
					break;
				case TERMINAL:
					endStatusCount++;					
					break;	
				}
			}			
		}
		
		nonterminalSymbols = new SymbolBean[nonterminalStatusCount];	
		endStatusSymbols = new SymbolBean[endStatusCount];
		
		//第二次从 状态符号中获取各类型状态。
		for (int i = 0; i < statusSymbols.length; i++) {
			switch (statusSymbols[i].getStatus()) {
			case START:
				startSymbol = statusSymbols[i];
				break;				
			case NONTERMINAL:
				nonterminalSymbols[nsc++]=statusSymbols[i];				
				break;
			case TERMINAL:
				endStatusSymbols[esc++]=statusSymbols[i];
				break;	
			}			
		}
	}
	 
	
	/** 构造网络图
	 * @return 构造是否成功
	 */
	public boolean makeGraph(){
		g =  new DirectedMultigraph<SymbolBean, MyEdge>(MyEdge.class);
		boolean bRet = false;
		//开始构造图
		//增加顶点
		for (int i = 0; i < statusSymbols.length; i++) {
			g.addVertex(statusSymbols[i]);
		}
		
		//添加边，顺便检查两个节点间多边的情况，此处的实现开销比较大，应该考虑连接矩阵的计算方式。TODO
		
	   for (int i = 0; i < eventSymbols.length; i++) {
		   SymbolBean e = eventSymbols[i];
			if(g.getEdge(e.getPstart(), e.getPend())!=null)
			{
				errorMsg = "状态["+e.getPstart().getName()+"]到状态["+e.getPend().getName()+"]存在多条转移定义，事件["+e.getName()+"]";
				return bRet;					
			}
			
			MyEdge edge = g.addEdge(e.getPstart(),e.getPend());
			edge.setBindEvent(e);			
	   }
	   bRet = true;
		return bRet;
	}
	
	
	public DirectedMultigraph<SymbolBean, MyEdge> getGraph(){
		return g;
	}
	
	
	
	
	/**打印所有符号
	 * 
	 */
	public void printSymbols()
	{
		System.out.println("序号\t 名字\t 类型\t 状态 \t 开始状态\t 结束状态\t 描述\t");
		for (Iterator iterator = symbols.iterator(); iterator.hasNext();) {
			SymbolBean e = (SymbolBean) iterator.next();
			System.out.println(e.getIndex()
					+ "\t "
					+ e.getName()
					+ "\t "
					+ e.getType()
					+ "\t "
					+ (e.getStatus() == null ? "null" : e.getStatus())
					+ "\t "
					+ (e.getPstart()== null ? "null" : e.getPstart()
							.getName())
					+ "\t "
					+ (e.getPend()== null ? "null" : e.getPend()
							.getName()) + "\t "
					+ (e.getDesc() == null ? "null" : e.getDesc()) + "\t");
			
		}
	}
	
	

	public ArrayList<SymbolBean> getSymbols() {
		return symbols;
	}

	public SymbolBean[] getStatusSymbols() {
		return statusSymbols;
	}

	public SymbolBean[] getEventSymbols() {
		return eventSymbols;
	}

	public SymbolBean getStartSymbol() {
		return startSymbol;
	}

	public SymbolBean[] getNonterminalSymbols() {
		return nonterminalSymbols;
	}

	public SymbolBean[] getEndStatusSymbols() {
		return endStatusSymbols;
	}

	public int getNonterminalStatusCount() {
		return nonterminalStatusCount;
	}

	public int getEndStatusCount() {
		return endStatusCount;
	}
	
	
}
