/**
 *
 */
package com.github.alan2lin.makefsm.parser;

import com.github.alan2lin.makefsm.entity.SymbolBean;
import com.github.alan2lin.makefsm.util.Constant;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * @author "linc"
 * date   :2012-4-21
 * time   :下午08:46:25
 *
 */
public abstract class FSMParser extends Parser {

	/**
	 * 判断定义开始一次的标志
	 */
	public boolean startFlag=false;

	/**
	 * 判断定义结束一次的标志
	 */
	public boolean endFlag = false;

	/**
	 * 是否moore 类型的状态机，如果不是moore 就是 mealy 默认是moore ，暂不支持 mix
	 */
	public Constant.FSMType fsmType = Constant.FSMType.MOORE;

	/**
	 * 状态机的名字
	 */
	public String fsmName ;

	/**
	 * 状态机的描述
	 */
	public String fsmDesc ;

	/**
	 * 事件在哈希表中的key的前缀
	 */
	String eventPrefix="e_";

	/**
	 * 状态在哈希表中的key的前缀
	 */
	String statusPrefix="s_";


	/**
	 * 状态个数
	 */
	int statusCount = 0;

	/**
	 *事件个数
	 */
	int eventCount = 0;
	/**
	 * 符号的个数
	 */
	int count = 0;

	ArrayList<SymbolBean> alSymbol = new   ArrayList<SymbolBean>();
	Hashtable<String,SymbolBean> hshSymbol = new   Hashtable<String,SymbolBean>();


	public boolean symbolRedefined = true;

	boolean checkFlag = true;  //语义检查通过的标志  true 通过，false 不通过



	public MidleCode mc = new MidleCode();


	/** 产生中间结果
	 *
	 */
	public MidleCode genMidleCode() {

		mc.setFsmName(fsmName);
		mc.setFsmDesc(fsmDesc);
		mc.setFsmType(fsmType);




		/*

		//参数检查
		if(count==0||statusCount==0||eventCount==0||null==tmpSymbol||tmpSymbol.size()==0||count!=tmpSymbol.size()||count!=(statusCount+eventCount) )
		{
			return mc;
		}



		StatusBean[] tmpasb = new StatusBean[statusCount];  //维护状态的列表
		EventBean[] tmpaeb= new EventBean[eventCount];      //维护数组的列表

		//将临时符号表的内容分门别类装入各个空间

		int iStatus =0;
		int iCount =0;
		int iEvent =0;

		for (Iterator it = tmpSymbol.iterator(); it.hasNext();) {
			SymbolBean sb = (SymbolBean) it.next();

			if(sb.getType().equals(SymbolType.STATUS))
			{
				tmpasb[iStatus] = new StatusBean();
				tmpasb[iStatus].setId(sb.getIndex());
				tmpasb[iStatus].setDesc(sb.getDesc());
				tmpasb[iStatus].setStatus(sb.getStatus());
				tmpasb[iStatus].setName(sb.getName());

				iStatus++;
			}else
			{
				tmpaeb[iEvent] = new EventBean();
				tmpaeb[iEvent].setEid(sb.getIndex());
				tmpaeb[iEvent].setName(sb.getName());
				tmpaeb[iEvent].setDesc(sb.getDesc());
				//tmpaeb[iEvent].setPend(sb.getPend());
				//tmpaeb[iEvent].setPstart(sb.getPstart());


				iEvent++;
			}

			iCount++;
		}


		mc = new MidleCode();


		mc.setAeb(tmpaeb);
		mc.setAsb(tmpasb);
		*/

		return mc;
	}

	/**
	 * @param input
	 */
	public FSMParser(TokenStream input) {
		super(input);
	}



	public MidleCode getMidleCode()
	{
		return null;
	}
}
