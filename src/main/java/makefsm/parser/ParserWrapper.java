package makefsm.parser;

import makefsm.parser.autogen.makefsmLexer;
import makefsm.parser.autogen.makefsmParser;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;

import java.io.IOException;

public class ParserWrapper {
	String srcFileName ;
	String absoluteSrcFileName;

	public ParserWrapper(String xsrcFileName){
		this.srcFileName = xsrcFileName;
        //TODO: 比较友好的方式是  判断绝对路径和相对路径 如果是相对路径 则优先在当前下进行判断，如果文件不存在，则到jar包资源文件目录下去判断
		//Resource resource = new ClassPathResource(xsrcFileName);
		//try {
		//	this.srcFileName =resource.getFile().getAbsolutePath();
		//} catch (IOException e) {
		//	e.printStackTrace();
		//}
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
