grammar makefsm;

//check rule :  only one transfer between two status , no indivied node.  must have a start node ,must have more than one end node 

options{
superClass=FSMParser;
}

@header
{
package  makefsm;
import makefsm.Constant.StatusAttr;

}


@lexer::header
{
package  makefsm;
}


@members {     
 }




prog
@after{
//check if had set the start and end status;
if(!startFlag) throw new FailedPredicateException(input, "you haven't define the start status ,please check", eventPrefix);
if(!endFlag) throw new FailedPredicateException(input, "you haven't define the end status  list,please check", eventPrefix);

//System.out.println(alSymbol.toString());

MidleCode mc = genMidleCode(alSymbol);
if(mc==null) throw new FailedPredicateException(input, "unknown error", eventPrefix);
//if(!mc.check()) System.out.println(mc.getErrorMsg());
if(!mc.check()) System.out.println(mc.getErrorMsg());
//mc.check2();
//System.out.println(" \n \n \n" + mc.makeGraphContent() );
mc.testWriteFile();
mc.getAllTestPath();



//if(true) throw new FailedPredicateException(input, "please check", eventPrefix);

}	
  : ('MOORE'|'MEALY'{fsmMooreType=false;})? fsm_name def_status statment+  EOF;

statment:	 start_status| end_status | transfer;

fsm_name 
	:	FSM  a=ID{fsmName=$a.text;} (DESC? b=STRING {fsmDesc=$b.text;})? SEMI;
	
def_status
	:	STATUS  COLON a=ID 
	       {
	         SymbolBean s1 = new SymbolBean(); 
	         s1.setIndex(count);
	         s1.setStatusType(true);
	         s1.setName($a.text);
	         symbolRedefined = (null!=hshSymbol.get(statusPrefix+$a.text) ) ;
	         if(symbolRedefined) throw new FailedPredicateException(input, "stauts ["+$a.text+"]defined again,please check", eventPrefix);
	        }
	        
	   (DESC? b=STRING {s1.setDesc($b.text);})?
	   	   
	       {	         	       
	         alSymbol.add(s1);	         
	         hshSymbol.put(statusPrefix+s1.getName(),s1);
	         
	         statusCount++;
	         count++;
	        }
	        	        
	        
	        	        
	    (COMMA c=ID
         {
           SymbolBean s2 = new SymbolBean(); 
           s2.setIndex(count);
           s2.setStatusType(true);
           s2.setName($c.text);
           symbolRedefined = (null!=hshSymbol.get(statusPrefix+$c.text) ) ;
           
           if(symbolRedefined) throw new FailedPredicateException(input, "stauts ["+$c.text+"]defined again,please check", eventPrefix);
           
          }	     
	       (DESC? d=STRING {s2.setDesc($d.text);})?
	        {                   
           alSymbol.add(s2);           
           hshSymbol.put(statusPrefix+s2.getName(),s2); 
           statusCount++;          
           count++;
          }
	       
	       
	     )*   SEMI;

start_status
	: 
	 START  EQUAL  a=ID SEMI
	 {   
	   if(startFlag) throw new FailedPredicateException(input, "you had defined the start status ,please check", eventPrefix);
	   
	   SymbolBean start = hshSymbol.get(statusPrefix+$a.text);
	   
	   if(null == start) throw new FailedPredicateException(input, "status ["+$a.text+"] that you want to start is not defined yet", eventPrefix);
	   
	   start.setStatus(StatusAttr.START); //denfine this status to start status;   	   	   
	   
	   startFlag = true;
	 }
	 ;	
	
end_status	
	: 
	END EQUAL a=ID
	{
	  if(endFlag) throw new FailedPredicateException(input, "you had defined the end status list ,please check", eventPrefix);
	  
	   SymbolBean end = hshSymbol.get(statusPrefix+$a.text);
     
     if(null == end) throw new FailedPredicateException(input, "status ["+$a.text+"] that you want to start is not defined yet", eventPrefix);
     if(end.getStatus()==StatusAttr.START) throw new FailedPredicateException(input, "status ["+$a.text+"] have been defined as start status", eventPrefix);
     
     end.setStatus(StatusAttr.TERMINAL); //denfine this status to end status;        
	  
	}
	(
	  COMMA b=ID
	   {	  
	     SymbolBean end2 = hshSymbol.get(statusPrefix+$b.text);
	     
	     if(null == end2) throw new FailedPredicateException(input, "status ["+$b.text+"] that you want to start is not defined yet", eventPrefix);
	     if(end2.getStatus()==StatusAttr.START) throw new FailedPredicateException(input, "status ["+$b.text+"] have been defined as start status", eventPrefix);
	     
	     end2.setStatus(StatusAttr.TERMINAL); //denfine this status to end status;
     }        
	  
	  	
	)* SEMI
	
	{
	 endFlag = true;	 
	}
	
	;

	
transfer:
{
  SymbolBean s1 = new SymbolBean();
}	
a=ID '->' b=ID LSB c=ID (DESC? e=STRING {s1.setDesc($e.text);})? RSB SEMI
{
//check for whether the status undefined and whether event redefined;


     SymbolBean ps1 = hshSymbol.get(statusPrefix+$a.text);     
     if(null == ps1) throw new FailedPredicateException(input, "status ["+$a.text+"] that you want to start is not defined yet", eventPrefix);

     SymbolBean ps2 = hshSymbol.get(statusPrefix+$b.text);     
     if(null == ps2) throw new FailedPredicateException(input, "status ["+$b.text+"] that you want to start is not defined yet", eventPrefix);
     
     SymbolBean se = hshSymbol.get(eventPrefix+$c.text);
     if(null!=se)  throw new FailedPredicateException(input, "event ["+$c.text+"] redefined!!! please check", eventPrefix);
     
     s1.setIndex(count);
     s1.setName($c.text);
     s1.setStatusType(false);
     s1.setPstart(ps1.getIndex());
     s1.setPend(ps2.getIndex());
     
     alSymbol.add(s1);           
     hshSymbol.put(eventPrefix+s1.getName(),s1);        
     
     eventCount++;
     count++;
     
     
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
