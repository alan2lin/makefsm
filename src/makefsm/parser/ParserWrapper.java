package makefsm.parser;

import java.io.IOException;

import makefsm.check.DefaultCheck;
import makefsm.check.ICheck;
import makefsm.generate.GenerateGraphviz;
import makefsm.generate.GenerateJavaCode;
import makefsm.generate.IGenerateCode;
import makefsm.util.FileMaker;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;

public class ParserWrapper {
	String srcFileName ;
	
	public ParserWrapper(String xsrcFileName){
		this.srcFileName = xsrcFileName;
	}
	
	public MidleCode parser4MidleCode()
	{
		 MidleCode mc = null ;
		
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
            mc = g.genMidleCode();              
        } catch (org.antlr.runtime.RecognitionException e) {
			e.printStackTrace();
		}

		return mc;
	}

}
