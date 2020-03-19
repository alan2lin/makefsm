lexer grammar MakefsmLexer;

@lexer::header
{
package  makefsm.parser.autogen;
}


FSM	:	'FSM';
DESC	:	'DESC';
STATUS	:	'STATUS';
START	:	'START' ;
END	:	'END' ;
COLON	:	':';
SEMI	:	';';
DIRECT	:	'->';
LSB	:	'[';
RSB	:	']';
EQUAL	:	'=';
MOORE   : 'MOORE';
MEALY   : 'MEALY';
SLASH   : '/';

COMMA	:	',';


ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
    ;


LINE_COMMENT
    :   '//' ~[\n\r]* -> skip
    ;

BLOCK_COMMENT
    :   '/*'  .*? '*/' -> skip
    ;

SHELL_COMMENT
    :   '#' ~[\n\r]* -> skip
    ;

WS
    :  [ \t\r\n\u000C]+ -> skip
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'| '"' ) )* '"'
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')
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
