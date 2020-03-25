parser grammar MakefsmParser;

//check rule :  only one transfer between two status , no indivied node.  must have a start node ,must have more than one end node

options{
//superClass=FSMParser;
tokenVocab=MakefsmLexer;
}

@header
{

package  com.alan2lin.makefsm.parser.autogen;

import com.alan2lin.makefsm.parser.FSMParser;
import com.alan2lin.makefsm.util.Constant.FSMType;
import com.alan2lin.makefsm.util.Constant.StatusAttr;
import com.alan2lin.makefsm.util.Constant.SymbolType;
import com.alan2lin.makefsm.entity.SymbolBean;
}


@members {
 }

// 语法文件:
// 类型:可选项，有两种类型的状态机， moore 和mealy  默认是 moore状态机
// 状态机名字: 必须项, 生成物的命名依据
// 状态集合： 必须项， 目前是强制一定要填写状态及其描述, moore类型的状态可以 带输出，,如果没有定义，则默认输出 状态名字 参见(输出项)
// 开始状态: 必须项， 目前一定要定义一个开始项
// 结束状态集合: 必须项， 目前一定要定义一组结束项
// 状态迁移定义: 必须项， 定义两个状态之间的迁移， 两个状态之间有且仅止有一个迁移定义；迁移定义 .mealy类型 可以在迁移后面定义 输出  如果没有定义则默认输出 （状态名字+"__"+输入)   参见(输出项)
// 输出项: 可选项 不同的类型的状态机的 输出不一样  moore fsm 的 输出紧跟在 状态后面描述 形式: 状态/"输出字符串" ， mealy fsm的输出紧跟在 迁移的名字 后面 迁移名字/"输出字符串", 输出项 都以 / 进行 分隔

prog

  : fsm_type? fsm_name status_list statment+  EOF;

fsm_type :
  MOORE | MEALY
  ;

fsm_name
	:	FSM  name=ID (DESC? desc=STRING )? SEMI;

status_list
  :
  STATUS  COLON def_status  (COMMA  def_status )* SEMI;

def_status
	:	 statusName=ID (SLASH output=STRING)?
	   (DESC? statusDesc=STRING)?
	   ;

statment: start_status| end_status_list | transfer;

start_status
	:
	 START  EQUAL starter=ID SEMI
	 ;

end_status_list:
END EQUAL
end_status 	(COMMA end_status )* SEMI
;

end_status
	:
	ender=ID
	;

transfer:
src=ID DIRECT dest=ID LSB eventName=ID(SLASH output=STRING)? (DESC? eventDesc=STRING )? RSB SEMI
;
