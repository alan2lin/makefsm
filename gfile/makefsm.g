grammar makefsm;

//check rule :  only one transfer between two status , no indivied node.  must have a start node ,must have more than one end node

options{
superClass=FSMParser;
}

@header
{
package  makefsm.parser;
import makefsm.util.Constant.FSMType;
import makefsm.util.Constant.StatusAttr;
import makefsm.util.Constant.SymbolType;
import makefsm.entity.SymbolBean;

}


@lexer::header
{
package  makefsm.parser;
}


@members {
 }




prog
@after{
//check if had set the start and end status;
if(!startFlag) throw new FailedPredicateException(input,"prog" ,"you haven't define the start status ,please check");
if(!endFlag) throw new FailedPredicateException(input,"prog" , "you haven't define the end status  list,please check");

//System.out.println(alSymbol.toString());

MidleCode mc = genMidleCode();


}
  : ('MOORE'{fsmType = FSMType.MOORE;}|'MEALY'{fsmType = FSMType.MEALY;})? fsm_name status_list statment+  EOF;

statment:	 start_status| end_status_list | transfer;

fsm_name
	:	FSM  a=ID{fsmName=$a.text;} (DESC? b=STRING {fsmDesc=$b.text;})? SEMI;

status_list
  :
  STATUS  COLON def_status (COMMA  def_status )* SEMI;

def_status
	:	 a=ID
	       {
	         symbolRedefined = mc.isSymbolExists($a.text,SymbolType.STATUS) ;
	         if(symbolRedefined) throw new FailedPredicateException(input,"def_stauts", "stauts ["+$a.text+"]defined again,please check");

	         SymbolBean sb = new SymbolBean();
           sb.setIndex(mc.getCount());
           sb.setType(SymbolType.STATUS);
           sb.setStatus(StatusAttr.NONTERMINAL);
           sb.setName($a.text);
	        }

	   (DESC? b=STRING {sb.setDesc($b.text);})?

	       {
	         mc.addSymbol(sb);
	       }
	   ;

start_status
	:
	 START  EQUAL  a=ID SEMI
	 {
	   if(startFlag) throw new FailedPredicateException(input,"start_status", "you had defined the start status ,please check");

	   SymbolBean start = mc.getSymbol($a.text,SymbolType.STATUS);

	   if(null == start) throw new FailedPredicateException(input,"start_status", "status ["+$a.text+"] that you want to start is not defined yet");

	   start.setStatus(StatusAttr.START); //denfine this status to start status;

	   startFlag = true;
	 }
	 ;

end_status_list:
{
  if(endFlag) throw new FailedPredicateException(input,"end_status_list", "you had defined the end status list ,please check");
}
END EQUAL
end_status 	(COMMA end_status )* SEMI
  {
   endFlag = true;
  };


end_status
	:
	a=ID
	{
	   SymbolBean end = mc.getSymbol($a.text,SymbolType.STATUS);

     if(null == end) throw new FailedPredicateException(input,"end_status", "status ["+$a.text+"] that you want to start is not defined yet");
     if(end.getStatus()==StatusAttr.START) throw new FailedPredicateException(input,"end_status", "status ["+$a.text+"] have been defined as start status");

     end.setStatus(StatusAttr.TERMINAL); //denfine this status to end status;
	}
	;


transfer:
{
  SymbolBean s1 = new SymbolBean();
}
a=ID '->' b=ID LSB c=ID (DESC? e=STRING {s1.setDesc($e.text);})? RSB SEMI
{
//check for whether the status undefined and whether inputEvent redefined;

     symbolRedefined = mc.isSymbolExists($c.text,SymbolType.EVENT) ;
     if(symbolRedefined) throw new FailedPredicateException(input,"transfer", "inputEvent ["+$c.text+"] redefined!!! please check");


     if(!mc.isSymbolExists($a.text,SymbolType.STATUS)) throw new FailedPredicateException(input,"transfer", "status ["+$a.text+"] that transfer from is not  defined yet");
     if(!mc.isSymbolExists($b.text,SymbolType.STATUS)) throw new FailedPredicateException(input,"transfer", "status ["+$b.text+"] that transfer to is not  defined yet");



     s1.setIndex(mc.getCount());
     s1.setName($c.text);
     s1.setType(SymbolType.EVENT);
     s1.setPstart(mc.getSymbol($a.text,SymbolType.STATUS));
     s1.setPend(mc.getSymbol($b.text,SymbolType.STATUS));

     mc.addSymbol(s1);




     }

;


FSM	:	'FSM';
DESC	:	'DESC';
STATUS	:	'STATUS';
START	:	'START';
END	:	'END';
COLON	:	':';
SEMI	:	';';
DIRECT	:	'->';
LSB	:	'[';
RSB	:	']';
EQUAL	:	'=';

COMMA	:	',';


ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
    ;


COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |'#' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
