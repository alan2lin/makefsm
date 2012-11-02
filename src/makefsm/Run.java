/**
 * 
 */
package makefsm;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;

import antlr.RecognitionException;

/**
 * @author "linc"
 * date   :2012-5-6 
 * time   :上午02:09:42
 *
 */
public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws RecognitionException {
		
		String srcFileName = ".\\testdata\\testfsm.data";  //demo file show.
		if(args.length!=1)
		{
			System.out.println("Usage: java -cp makefsm.jar makefsm.Run <sourcefilename> ");
			return;
		}		
		srcFileName = args[0];
		
		
		
        makefsmLexer lex = null;
		try {			
			lex = new makefsmLexer(new ANTLRFileStream(srcFileName, "UTF8"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        CommonTokenStream tokens = new CommonTokenStream(lex);

        makefsmParser g = new makefsmParser(tokens);
        try {
            g.prog();
        } catch (org.antlr.runtime.RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
