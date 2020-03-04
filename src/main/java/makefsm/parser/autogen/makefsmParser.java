// $ANTLR 3.3 Nov 30, 2010 12:50:56 F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g 2013-06-25 12:34:35

package makefsm.parser.autogen;
import makefsm.parser.FSMParser;
import makefsm.parser.MidleCode;
import makefsm.util.Constant.FSMType;
import makefsm.util.Constant.StatusAttr;
import makefsm.util.Constant.SymbolType;
import makefsm.entity.SymbolBean;



import org.antlr.runtime.*;

public class makefsmParser extends FSMParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FSM", "ID", "DESC", "STRING", "SEMI", "STATUS", "COLON", "COMMA", "START", "EQUAL", "END", "LSB", "RSB", "DIRECT", "INT", "COMMENT", "WS", "ESC_SEQ", "CHAR", "HEX_DIGIT", "UNICODE_ESC", "OCTAL_ESC", "'MOORE'", "'MEALY'"
    };
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


        public makefsmParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public makefsmParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);

        }


    public String[] getTokenNames() { return makefsmParser.tokenNames; }
    public String getGrammarFileName() { return "F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g"; }





    // $ANTLR start "prog"
    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:32:1: prog : ( 'MOORE' | 'MEALY' )? fsm_name status_list ( statment )+ EOF ;
    public final void prog() throws RecognitionException {
        try {
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:44:3: ( ( 'MOORE' | 'MEALY' )? fsm_name status_list ( statment )+ EOF )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:44:5: ( 'MOORE' | 'MEALY' )? fsm_name status_list ( statment )+ EOF
            {
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:44:5: ( 'MOORE' | 'MEALY' )?
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==26) ) {
                alt1=1;
            }
            else if ( (LA1_0==27) ) {
                alt1=2;
            }
            switch (alt1) {
                case 1 :
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:44:6: 'MOORE'
                    {
                    match(input,26,FOLLOW_26_in_prog56);
                    fsmType = FSMType.MOORE;

                    }
                    break;
                case 2 :
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:44:40: 'MEALY'
                    {
                    match(input,27,FOLLOW_27_in_prog59);
                    fsmType = FSMType.MEALY;

                    }
                    break;

            }

            pushFollow(FOLLOW_fsm_name_in_prog64);
            fsm_name();

            state._fsp--;

            pushFollow(FOLLOW_status_list_in_prog66);
            status_list();

            state._fsp--;

            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:44:97: ( statment )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ID||LA2_0==START||LA2_0==END) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:44:97: statment
            	    {
            	    pushFollow(FOLLOW_statment_in_prog68);
            	    statment();

            	    state._fsp--;


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

            match(input,EOF,FOLLOW_EOF_in_prog72);

            }


            //check if had set the start and end status;
            if(!startFlag) throw new FailedPredicateException(input,"prog" ,"you haven't define the start status ,please check");
            if(!endFlag) throw new FailedPredicateException(input,"prog" , "you haven't define the end status  list,please check");

            //System.out.println(alSymbol.toString());

            MidleCode mc = genMidleCode();



        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "prog"


    // $ANTLR start "statment"
    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:46:1: statment : ( start_status | end_status_list | transfer );
    public final void statment() throws RecognitionException {
        try {
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:46:9: ( start_status | end_status_list | transfer )
            int alt3=3;
            switch ( input.LA(1) ) {
            case START:
                {
                alt3=1;
                }
                break;
            case END:
                {
                alt3=2;
                }
                break;
            case ID:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:46:12: start_status
                    {
                    pushFollow(FOLLOW_start_status_in_statment80);
                    start_status();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:46:26: end_status_list
                    {
                    pushFollow(FOLLOW_end_status_list_in_statment83);
                    end_status_list();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:46:44: transfer
                    {
                    pushFollow(FOLLOW_transfer_in_statment87);
                    transfer();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "statment"


    // $ANTLR start "fsm_name"
    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:48:1: fsm_name : FSM a= ID ( ( DESC )? b= STRING )? SEMI ;
    public final void fsm_name() throws RecognitionException {
        Token a=null;
        Token b=null;

        try {
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:49:2: ( FSM a= ID ( ( DESC )? b= STRING )? SEMI )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:49:4: FSM a= ID ( ( DESC )? b= STRING )? SEMI
            {
            match(input,FSM,FOLLOW_FSM_in_fsm_name97);
            a=(Token)match(input,ID,FOLLOW_ID_in_fsm_name102);
            fsmName=(a!=null?a.getText():null);
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:49:32: ( ( DESC )? b= STRING )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=DESC && LA5_0<=STRING)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:49:33: ( DESC )? b= STRING
                    {
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:49:33: ( DESC )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==DESC) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:49:33: DESC
                            {
                            match(input,DESC,FOLLOW_DESC_in_fsm_name106);

                            }
                            break;

                    }

                    b=(Token)match(input,STRING,FOLLOW_STRING_in_fsm_name111);
                    fsmDesc=(b!=null?b.getText():null);

                    }
                    break;

            }

            match(input,SEMI,FOLLOW_SEMI_in_fsm_name117);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "fsm_name"


    // $ANTLR start "status_list"
    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:51:1: status_list : STATUS COLON def_status ( COMMA def_status )* SEMI ;
    public final void status_list() throws RecognitionException {
        try {
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:52:3: ( STATUS COLON def_status ( COMMA def_status )* SEMI )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:53:3: STATUS COLON def_status ( COMMA def_status )* SEMI
            {
            match(input,STATUS,FOLLOW_STATUS_in_status_list129);
            match(input,COLON,FOLLOW_COLON_in_status_list132);
            pushFollow(FOLLOW_def_status_in_status_list134);
            def_status();

            state._fsp--;

            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:53:28: ( COMMA def_status )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==COMMA) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:53:29: COMMA def_status
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_status_list137);
            	    pushFollow(FOLLOW_def_status_in_status_list140);
            	    def_status();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match(input,SEMI,FOLLOW_SEMI_in_status_list145);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "status_list"


    // $ANTLR start "def_status"
    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:55:1: def_status : a= ID ( ( DESC )? b= STRING )? ;
    public final void def_status() throws RecognitionException {
        Token a=null;
        Token b=null;

        try {
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:56:2: (a= ID ( ( DESC )? b= STRING )? )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:56:5: a= ID ( ( DESC )? b= STRING )?
            {
            a=(Token)match(input,ID,FOLLOW_ID_in_def_status158);

            	         symbolRedefined = mc.isSymbolExists((a!=null?a.getText():null),SymbolType.STATUS) ;
            	         if(symbolRedefined) throw new FailedPredicateException(input,"def_stauts", "stauts ["+(a!=null?a.getText():null)+"]defined again,please check");

            	         SymbolBean sb = new SymbolBean();
                       sb.setIndex(mc.getCount());
                       sb.setType(SymbolType.STATUS);
                       sb.setStatus(StatusAttr.NONTERMINAL);
                       sb.setName((a!=null?a.getText():null));

            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:68:5: ( ( DESC )? b= STRING )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=DESC && LA8_0<=STRING)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:68:6: ( DESC )? b= STRING
                    {
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:68:6: ( DESC )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==DESC) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:68:6: DESC
                            {
                            match(input,DESC,FOLLOW_DESC_in_def_status186);

                            }
                            break;

                    }

                    b=(Token)match(input,STRING,FOLLOW_STRING_in_def_status191);
                    sb.setDesc((b!=null?b.getText():null));

                    }
                    break;

            }


            	         mc.addSymbol(sb);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "def_status"


    // $ANTLR start "start_status"
    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:75:1: start_status : START EQUAL a= ID SEMI ;
    public final void start_status() throws RecognitionException {
        Token a=null;

        try {
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:76:2: ( START EQUAL a= ID SEMI )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:77:3: START EQUAL a= ID SEMI
            {
            match(input,START,FOLLOW_START_in_start_status238);
            match(input,EQUAL,FOLLOW_EQUAL_in_start_status241);
            a=(Token)match(input,ID,FOLLOW_ID_in_start_status246);
            match(input,SEMI,FOLLOW_SEMI_in_start_status248);

            	   if(startFlag) throw new FailedPredicateException(input,"start_status", "you had defined the start status ,please check");

            	   SymbolBean start = mc.getSymbol((a!=null?a.getText():null),SymbolType.STATUS);

            	   if(null == start) throw new FailedPredicateException(input,"start_status", "status ["+(a!=null?a.getText():null)+"] that you want to start is not defined yet");

            	   start.setStatus(StatusAttr.START); //denfine this status to start status;

            	   startFlag = true;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "start_status"


    // $ANTLR start "end_status_list"
    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:91:1: end_status_list : END EQUAL end_status ( COMMA end_status )* SEMI ;
    public final void end_status_list() throws RecognitionException {
        try {
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:91:16: ( END EQUAL end_status ( COMMA end_status )* SEMI )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:92:1: END EQUAL end_status ( COMMA end_status )* SEMI
            {

              if(endFlag) throw new FailedPredicateException(input,"end_status_list", "you had defined the end status list ,please check");

            match(input,END,FOLLOW_END_in_end_status_list265);
            match(input,EQUAL,FOLLOW_EQUAL_in_end_status_list267);
            pushFollow(FOLLOW_end_status_in_end_status_list270);
            end_status();

            state._fsp--;

            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:96:13: ( COMMA end_status )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==COMMA) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:96:14: COMMA end_status
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_end_status_list274);
            	    pushFollow(FOLLOW_end_status_in_end_status_list276);
            	    end_status();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match(input,SEMI,FOLLOW_SEMI_in_end_status_list281);

               endFlag = true;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "end_status_list"


    // $ANTLR start "end_status"
    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:102:1: end_status : a= ID ;
    public final void end_status() throws RecognitionException {
        Token a=null;

        try {
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:103:2: (a= ID )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:104:2: a= ID
            {
            a=(Token)match(input,ID,FOLLOW_ID_in_end_status304);

            	   SymbolBean end = mc.getSymbol((a!=null?a.getText():null),SymbolType.STATUS);

                 if(null == end) throw new FailedPredicateException(input,"end_status", "status ["+(a!=null?a.getText():null)+"] that you want to start is not defined yet");
                 if(end.getStatus()==StatusAttr.START) throw new FailedPredicateException(input,"end_status", "status ["+(a!=null?a.getText():null)+"] have been defined as start status");

                 end.setStatus(StatusAttr.TERMINAL); //denfine this status to end status;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "end_status"


    // $ANTLR start "transfer"
    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:116:1: transfer : a= ID '->' b= ID LSB c= ID ( ( DESC )? e= STRING )? RSB SEMI ;
    public final void transfer() throws RecognitionException {
        Token a=null;
        Token b=null;
        Token c=null;
        Token e=null;

        try {
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:116:9: (a= ID '->' b= ID LSB c= ID ( ( DESC )? e= STRING )? RSB SEMI )
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:117:1: a= ID '->' b= ID LSB c= ID ( ( DESC )? e= STRING )? RSB SEMI
            {

              SymbolBean s1 = new SymbolBean();

            a=(Token)match(input,ID,FOLLOW_ID_in_transfer324);
            match(input,DIRECT,FOLLOW_DIRECT_in_transfer326);
            b=(Token)match(input,ID,FOLLOW_ID_in_transfer330);
            match(input,LSB,FOLLOW_LSB_in_transfer332);
            c=(Token)match(input,ID,FOLLOW_ID_in_transfer336);
            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:120:25: ( ( DESC )? e= STRING )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=DESC && LA11_0<=STRING)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:120:26: ( DESC )? e= STRING
                    {
                    // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:120:26: ( DESC )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==DESC) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // F:\\h\\git_repos\\makefsm\\gfile\\makefsm.g:120:26: DESC
                            {
                            match(input,DESC,FOLLOW_DESC_in_transfer339);

                            }
                            break;

                    }

                    e=(Token)match(input,STRING,FOLLOW_STRING_in_transfer344);
                    s1.setDesc((e!=null?e.getText():null));

                    }
                    break;

            }

            match(input,RSB,FOLLOW_RSB_in_transfer350);
            match(input,SEMI,FOLLOW_SEMI_in_transfer352);

            //check for whether the status undefined and whether event redefined;

                 symbolRedefined = mc.isSymbolExists((c!=null?c.getText():null),SymbolType.EVENT) ;
                 if(symbolRedefined) throw new FailedPredicateException(input,"transfer", "event ["+(c!=null?c.getText():null)+"] redefined!!! please check");


                 if(!mc.isSymbolExists((a!=null?a.getText():null),SymbolType.STATUS)) throw new FailedPredicateException(input,"transfer", "status ["+(a!=null?a.getText():null)+"] that transfer from is not  defined yet");
                 if(!mc.isSymbolExists((b!=null?b.getText():null),SymbolType.STATUS)) throw new FailedPredicateException(input,"transfer", "status ["+(b!=null?b.getText():null)+"] that transfer to is not  defined yet");



                 s1.setIndex(mc.getCount());
                 s1.setName((c!=null?c.getText():null));
                 s1.setType(SymbolType.EVENT);
                 s1.setPstart(mc.getSymbol((a!=null?a.getText():null),SymbolType.STATUS));
                 s1.setPend(mc.getSymbol((b!=null?b.getText():null),SymbolType.STATUS));

                 mc.addSymbol(s1);






            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "transfer"

    // Delegated rules




    public static final BitSet FOLLOW_26_in_prog56 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_27_in_prog59 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_fsm_name_in_prog64 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_status_list_in_prog66 = new BitSet(new long[]{0x0000000000005020L});
    public static final BitSet FOLLOW_statment_in_prog68 = new BitSet(new long[]{0x0000000000005020L});
    public static final BitSet FOLLOW_EOF_in_prog72 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_start_status_in_statment80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_end_status_list_in_statment83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_transfer_in_statment87 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FSM_in_fsm_name97 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_fsm_name102 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_DESC_in_fsm_name106 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_fsm_name111 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_fsm_name117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATUS_in_status_list129 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_status_list132 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_def_status_in_status_list134 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_COMMA_in_status_list137 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_def_status_in_status_list140 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_SEMI_in_status_list145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_def_status158 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_DESC_in_def_status186 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_def_status191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_START_in_start_status238 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUAL_in_start_status241 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_start_status246 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_start_status248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_END_in_end_status_list265 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_EQUAL_in_end_status_list267 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_end_status_in_end_status_list270 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_COMMA_in_end_status_list274 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_end_status_in_end_status_list276 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_SEMI_in_end_status_list281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_end_status304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_transfer324 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_DIRECT_in_transfer326 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_transfer330 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LSB_in_transfer332 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_transfer336 = new BitSet(new long[]{0x00000000000100C0L});
    public static final BitSet FOLLOW_DESC_in_transfer339 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_in_transfer344 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RSB_in_transfer350 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_transfer352 = new BitSet(new long[]{0x0000000000000002L});

}
