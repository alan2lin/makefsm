// $ANTLR 3.3 Nov 30, 2010 12:50:56 F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g 2013-06-25 12:34:36

package  makefsm.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class makefsmLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int FSM=4;
    public static final int ID=5;
    public static final int DESC=6;
    public static final int STRING=7;
    public static final int SEMI=8;
    public static final int STATUS=9;
    public static final int COLON=10;
    public static final int COMMA=11;
    public static final int START=12;
    public static final int EQUAL=13;
    public static final int END=14;
    public static final int LSB=15;
    public static final int RSB=16;
    public static final int DIRECT=17;
    public static final int INT=18;
    public static final int COMMENT=19;
    public static final int WS=20;
    public static final int ESC_SEQ=21;
    public static final int CHAR=22;
    public static final int HEX_DIGIT=23;
    public static final int UNICODE_ESC=24;
    public static final int OCTAL_ESC=25;

    // delegates
    // delegators

    public makefsmLexer() {;} 
    public makefsmLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public makefsmLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g"; }

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:7:7: ( 'MOORE' )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:7:9: 'MOORE'
            {
            match("MOORE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:8:7: ( 'MEALY' )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:8:9: 'MEALY'
            {
            match("MEALY"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "FSM"
    public final void mFSM() throws RecognitionException {
        try {
            int _type = FSM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:149:5: ( 'FSM' )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:149:7: 'FSM'
            {
            match("FSM"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FSM"

    // $ANTLR start "DESC"
    public final void mDESC() throws RecognitionException {
        try {
            int _type = DESC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:150:6: ( 'DESC' )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:150:8: 'DESC'
            {
            match("DESC"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DESC"

    // $ANTLR start "STATUS"
    public final void mSTATUS() throws RecognitionException {
        try {
            int _type = STATUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:151:8: ( 'STATUS' )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:151:10: 'STATUS'
            {
            match("STATUS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STATUS"

    // $ANTLR start "START"
    public final void mSTART() throws RecognitionException {
        try {
            int _type = START;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:152:7: ( 'START' )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:152:9: 'START'
            {
            match("START"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "START"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:153:5: ( 'END' )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:153:7: 'END'
            {
            match("END"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:154:7: ( ':' )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:154:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:155:6: ( ';' )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:155:8: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "DIRECT"
    public final void mDIRECT() throws RecognitionException {
        try {
            int _type = DIRECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:156:8: ( '->' )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:156:10: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIRECT"

    // $ANTLR start "LSB"
    public final void mLSB() throws RecognitionException {
        try {
            int _type = LSB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:157:5: ( '[' )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:157:7: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LSB"

    // $ANTLR start "RSB"
    public final void mRSB() throws RecognitionException {
        try {
            int _type = RSB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:158:5: ( ']' )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:158:7: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RSB"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:159:7: ( '=' )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:159:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:161:7: ( ',' )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:161:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:164:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:164:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:164:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:167:5: ( ( '0' .. '9' )+ )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:167:7: ( '0' .. '9' )+
            {
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:167:7: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:167:7: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:172:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '#' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='/') ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1=='/') ) {
                    alt8=1;
                }
                else if ( (LA8_1=='*') ) {
                    alt8=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA8_0=='#') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:172:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 

                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:172:14: (~ ( '\\n' | '\\r' ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='\uFFFF')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:172:14: ~ ( '\\n' | '\\r' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:172:28: ( '\\r' )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='\r') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:172:28: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 
                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:173:6: '#' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match('#'); 
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:173:10: (~ ( '\\n' | '\\r' ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='\u0000' && LA5_0<='\t')||(LA5_0>='\u000B' && LA5_0<='\f')||(LA5_0>='\u000E' && LA5_0<='\uFFFF')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:173:10: ~ ( '\\n' | '\\r' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:173:24: ( '\\r' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='\r') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:173:24: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 
                    _channel=HIDDEN;

                    }
                    break;
                case 3 :
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:174:9: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 

                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:174:14: ( options {greedy=false; } : . )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='*') ) {
                            int LA7_1 = input.LA(2);

                            if ( (LA7_1=='/') ) {
                                alt7=2;
                            }
                            else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFF')) ) {
                                alt7=1;
                            }


                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFF')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:174:42: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match("*/"); 

                    _channel=HIDDEN;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:177:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:177:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:185:5: ( '\"' ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )* '\"' )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:185:8: '\"' ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:185:12: ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )*
            loop9:
            do {
                int alt9=3;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\\') ) {
                    alt9=1;
                }
                else if ( ((LA9_0>='\u0000' && LA9_0<='!')||(LA9_0>='#' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                    alt9=2;
                }


                switch (alt9) {
            	case 1 :
            	    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:185:14: ESC_SEQ
            	    {
            	    mESC_SEQ(); 

            	    }
            	    break;
            	case 2 :
            	    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:185:24: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:188:5: ( '\\'' ( ESC_SEQ | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:188:8: '\\'' ( ESC_SEQ | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:188:13: ( ESC_SEQ | ~ ( '\\'' | '\\\\' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\\') ) {
                alt10=1;
            }
            else if ( ((LA10_0>='\u0000' && LA10_0<='&')||(LA10_0>='(' && LA10_0<='[')||(LA10_0>=']' && LA10_0<='\uFFFF')) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:188:15: ESC_SEQ
                    {
                    mESC_SEQ(); 

                    }
                    break;
                case 2 :
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:188:25: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:192:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:192:13: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:196:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt11=3;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt11=1;
                    }
                    break;
                case 'u':
                    {
                    alt11=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt11=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:196:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 
                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:197:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 

                    }
                    break;
                case 3 :
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:198:9: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:203:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\\') ) {
                int LA12_1 = input.LA(2);

                if ( ((LA12_1>='0' && LA12_1<='3')) ) {
                    int LA12_2 = input.LA(3);

                    if ( ((LA12_2>='0' && LA12_2<='7')) ) {
                        int LA12_4 = input.LA(4);

                        if ( ((LA12_4>='0' && LA12_4<='7')) ) {
                            alt12=1;
                        }
                        else {
                            alt12=2;}
                    }
                    else {
                        alt12=3;}
                }
                else if ( ((LA12_1>='4' && LA12_1<='7')) ) {
                    int LA12_3 = input.LA(3);

                    if ( ((LA12_3>='0' && LA12_3<='7')) ) {
                        alt12=2;
                    }
                    else {
                        alt12=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:203:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:203:14: ( '0' .. '3' )
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:203:15: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:203:25: ( '0' .. '7' )
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:203:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:203:36: ( '0' .. '7' )
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:203:37: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:204:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:204:14: ( '0' .. '7' )
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:204:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:204:25: ( '0' .. '7' )
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:204:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:205:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:205:14: ( '0' .. '7' )
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:205:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:210:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:210:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 
            match('u'); 
            mHEX_DIGIT(); 
            mHEX_DIGIT(); 
            mHEX_DIGIT(); 
            mHEX_DIGIT(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UNICODE_ESC"

    public void mTokens() throws RecognitionException {
        // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:8: ( T__26 | T__27 | FSM | DESC | STATUS | START | END | COLON | SEMI | DIRECT | LSB | RSB | EQUAL | COMMA | ID | INT | COMMENT | WS | STRING | CHAR )
        int alt13=20;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:10: T__26
                {
                mT__26(); 

                }
                break;
            case 2 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:16: T__27
                {
                mT__27(); 

                }
                break;
            case 3 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:22: FSM
                {
                mFSM(); 

                }
                break;
            case 4 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:26: DESC
                {
                mDESC(); 

                }
                break;
            case 5 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:31: STATUS
                {
                mSTATUS(); 

                }
                break;
            case 6 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:38: START
                {
                mSTART(); 

                }
                break;
            case 7 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:44: END
                {
                mEND(); 

                }
                break;
            case 8 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:48: COLON
                {
                mCOLON(); 

                }
                break;
            case 9 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:54: SEMI
                {
                mSEMI(); 

                }
                break;
            case 10 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:59: DIRECT
                {
                mDIRECT(); 

                }
                break;
            case 11 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:66: LSB
                {
                mLSB(); 

                }
                break;
            case 12 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:70: RSB
                {
                mRSB(); 

                }
                break;
            case 13 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:74: EQUAL
                {
                mEQUAL(); 

                }
                break;
            case 14 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:80: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 15 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:86: ID
                {
                mID(); 

                }
                break;
            case 16 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:89: INT
                {
                mINT(); 

                }
                break;
            case 17 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:93: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 18 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:101: WS
                {
                mWS(); 

                }
                break;
            case 19 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:104: STRING
                {
                mSTRING(); 

                }
                break;
            case 20 :
                // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:1:111: CHAR
                {
                mCHAR(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\uffff\5\15\15\uffff\10\15\1\41\2\15\1\45\2\15\1\uffff\1\50\2"+
        "\15\1\uffff\1\53\1\54\1\uffff\1\15\1\56\2\uffff\1\57\2\uffff";
    static final String DFA13_eofS =
        "\60\uffff";
    static final String DFA13_minS =
        "\1\11\1\105\1\123\1\105\1\124\1\116\15\uffff\1\117\1\101\1\115"+
        "\1\123\1\101\1\104\1\122\1\114\1\60\1\103\1\122\1\60\1\105\1\131"+
        "\1\uffff\1\60\1\125\1\124\1\uffff\2\60\1\uffff\1\123\1\60\2\uffff"+
        "\1\60\2\uffff";
    static final String DFA13_maxS =
        "\1\172\1\117\1\123\1\105\1\124\1\116\15\uffff\1\117\1\101\1\115"+
        "\1\123\1\101\1\104\1\122\1\114\1\172\1\103\1\124\1\172\1\105\1\131"+
        "\1\uffff\1\172\1\125\1\124\1\uffff\2\172\1\uffff\1\123\1\172\2\uffff"+
        "\1\172\2\uffff";
    static final String DFA13_acceptS =
        "\6\uffff\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22"+
        "\1\23\1\24\16\uffff\1\3\3\uffff\1\7\2\uffff\1\4\2\uffff\1\1\1\2"+
        "\1\uffff\1\6\1\5";
    static final String DFA13_specialS =
        "\60\uffff}>";
    static final String[] DFA13_transitionS = {
            "\2\20\2\uffff\1\20\22\uffff\1\20\1\uffff\1\21\1\17\3\uffff"+
            "\1\22\4\uffff\1\14\1\10\1\uffff\1\17\12\16\1\6\1\7\1\uffff\1"+
            "\13\3\uffff\3\15\1\3\1\5\1\2\6\15\1\1\5\15\1\4\7\15\1\11\1\uffff"+
            "\1\12\1\uffff\1\15\1\uffff\32\15",
            "\1\24\11\uffff\1\23",
            "\1\25",
            "\1\26",
            "\1\27",
            "\1\30",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\42",
            "\1\44\1\uffff\1\43",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\46",
            "\1\47",
            "",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\51",
            "\1\52",
            "",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "",
            "\1\55",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "",
            "",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__26 | T__27 | FSM | DESC | STATUS | START | END | COLON | SEMI | DIRECT | LSB | RSB | EQUAL | COMMA | ID | INT | COMMENT | WS | STRING | CHAR );";
        }
    }
 

}