parser grammar MakefsmParser;

//check rule :  only one transfer between two status , no indivied node.  must have a start node ,must have more than one end node

options{
superClass=FSMParser;
tokenVocab=MakefsmLexer;
}

@header
{
package  makefsm.parser.autogen;

import makefsm.parser.FSMParser;
import makefsm.util.Constant.FSMType;
import makefsm.util.Constant.StatusAttr;
import makefsm.util.Constant.SymbolType;
import makefsm.entity.SymbolBean;
}


@members {
 }




prog

  : (MOORE | MEALY)? fsm_name status_list statment+  EOF;

statment:	 start_status| end_status_list | transfer;

fsm_name
	:	FSM  a=ID (DESC? b=STRING )? SEMI;

status_list
  :
  STATUS  COLON def_status (COMMA  def_status )* SEMI;

def_status
	:	 a=ID
	   (DESC? b=STRING)?

	   ;

start_status
	:
	 START  EQUAL  a=ID SEMI
	 ;

end_status_list:

END EQUAL
end_status 	(COMMA end_status )* SEMI
;


end_status
	:
	a=ID
	;


transfer:

a=ID DIRECT b=ID LSB c=ID (DESC? e=STRING )? RSB SEMI


;
