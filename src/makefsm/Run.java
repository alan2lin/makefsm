/**
 * 
 */
package makefsm;

import java.io.IOException;

import makefsm.check.DefaultCheck;
import makefsm.check.ICheck;
import makefsm.generate.GenerateGraphviz;
import makefsm.generate.GenerateJavaCode;
import makefsm.generate.IGenerateCode;
import makefsm.parser.MidleCode;
import makefsm.parser.makefsmLexer;
import makefsm.parser.makefsmParser;
import makefsm.util.FileMaker;

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
			//return;
		}		
		//srcFileName = args[0];
		
		
		
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
            MidleCode mc = g.genMidleCode();  //取得中间格式            
            mc.pickupSymbols();            
            mc.printSymbols();
            mc.makeGraph();
            ICheck icheck = new DefaultCheck();
            if (!icheck.check(mc)) System.out.print(icheck.getErrorMsg());
            
            GenerateGraphviz genGraph = new GenerateGraphviz();
            System.out.println(genGraph.makeGraphContent(mc,null));
            IGenerateCode iGenJava = new GenerateJavaCode();
            iGenJava.generateCode(mc);
            
            FileMaker fm = new FileMaker(mc.getFsmName());
            
            System.out.println(iGenJava.getAbstractClassContent());
            System.out.println(iGenJava.getImplementClassContent());
            System.out.println(iGenJava.getTestClassContent());
            
            fm.makeGraphvizImage(genGraph.makeGraphContent(mc, null));
            fm.makeJavaSourceFile(iGenJava.getAbstractClassContent(), iGenJava.getImplementClassContent(), iGenJava.getTestClassContent());

            
        } catch (org.antlr.runtime.RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
