

package makefsm.parser;

import makefsm.parser.autogen.MakefsmParser;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.Collections;
import java.util.List;

/**
 * @Description: TODO
 * @Author: alan2lin
 * @Date: 2020/3/4 18:45
 * @Version V1.0
 */
public class VerboseErrorListener extends BaseErrorListener {
   ParserWrapper parserWrapper;
    public VerboseErrorListener(ParserWrapper parserWrapper){
       this.parserWrapper = parserWrapper;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg,
                            RecognitionException e)
    {
        List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
        Collections.reverse(stack);
        System.err.println("rule stack: "+stack);
        System.err.println("line "+line+":"+charPositionInLine+" at "+
                offendingSymbol+": "+msg);
        parserWrapper.increaseErrors();
    }


}
