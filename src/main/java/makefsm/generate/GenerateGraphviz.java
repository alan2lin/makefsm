package makefsm.generate;

import makefsm.entity.SymbolBean;
import makefsm.parser.MidleCode;
import makefsm.util.Constant.StatusAttr;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class GenerateGraphviz {


	public String graphvizTemplateFile = "./template/graphviz.stg";

	/** 产生图形化的graphiv能识别的内容
	 * @param mc
	 * @return
	 */
	public String makeGraphContent(MidleCode mc,String stgFile)
	{
		if(stgFile==null||stgFile.trim().equals("")) stgFile = graphvizTemplateFile;

		STGroup group = new STGroupFile(stgFile);
        //name,desc,status_list,event_list
		ST st = group.getInstanceOf("digraph");
		st.add("name", mc.getFsmName());
		String tmpDesc = mc.getFsmDesc();
		if(null==tmpDesc) {
			tmpDesc="";
		}else
		{
			tmpDesc = tmpDesc.replace('"', ' ');
		}
		st.add("desc", tmpDesc);

		//填充状态节点列表	name,desc,shape

		SymbolBean[] statusSymbols = mc.getStatusSymbols();
		ST[] st_status_list  = new ST[statusSymbols.length];

		for (int i = 0; i < statusSymbols.length; i++) {

			st_status_list[i]=group.getInstanceOf("status_list");

			StatusAttr status  = statusSymbols[i].getStatus();

			String nodeName = statusSymbols[i].getName();
			st_status_list[i].add("name", nodeName);

			String nodeDesc = statusSymbols[i].getDesc();
			if(null!=nodeDesc)
			{
				nodeDesc = nodeDesc.replace('"', ' ');
				st_status_list[i].add("desc", nodeDesc);
			}

			String shape = "";
			switch(status)
			{
			case START:
				shape="ellipse";
				break;
			case NONTERMINAL:
				shape="box";
				break;
			case TERMINAL:
				shape="doublecircle";
				break;
			}
			st_status_list[i].add("shape", shape);
		}


		//填充事件列表  name,from_status,to_status,desc

		SymbolBean[] eventSymbols = mc.getEventSymbols();
		ST[] st_event_list  = new ST[eventSymbols.length];
		for (int i = 0; i < eventSymbols.length; i++) {
			st_event_list[i]= group.getInstanceOf("event_list");

			String eventName = eventSymbols[i].getName();
			st_event_list[i].add("name", eventName);
			String eventDesc =eventSymbols[i].getDesc();
			if(null!=eventDesc) {
				eventDesc = eventDesc.replace('"', ' ');
				st_event_list[i].add("desc", eventDesc);
			}
			st_event_list[i].add("from_status",  eventSymbols[i].getPstart().getName());
			st_event_list[i].add("to_status",  eventSymbols[i].getPend().getName());
		}

		//合并到一起
		st.add("status_list", st_status_list);
		st.add("event_list", st_event_list);

		return st.render();

	}

}
