package com.github.alan2lin.makefsm.parser;

import com.github.alan2lin.makefsm.parser.autogen.MakefsmLexer;
import com.github.alan2lin.makefsm.parser.autogen.MakefsmParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ParserWrapper {
	String srcFileName ;
	String absoluteSrcFileName;
	private int errors;

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

        MakefsmLexer lex = null;
		try {
			CharStream charStream = CharStreams.fromFileName(srcFileName,UTF_8);
			lex = new MakefsmLexer(charStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        CommonTokenStream tokens = new CommonTokenStream(lex);

        MakefsmParser g = new MakefsmParser(tokens);
        g.removeErrorListeners();
        g.addErrorListener(new VerboseErrorListener(this));

        try {
			ParseTree tree = g.prog();
			MakefsmParserVisitorImpl visitor = new MakefsmParserVisitorImpl(g);

			visitor.visit(tree);
            mc = visitor.getMidleCode();

        } catch (RecognitionException e) {

			e.printStackTrace();
		}

		return mc;
	}

	public boolean hasError(){
		return errors>0;
	}

	public void increaseErrors(){
		errors++;;
	}

	public int getErrors(){
		return errors;
	}


}
