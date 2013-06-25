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
import makefsm.parser.ParserWrapper;
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
		
		
		//解析得到中间代码格式
        ParserWrapper pw = new ParserWrapper(srcFileName);
        MidleCode mc = pw.parser4MidleCode();
        
        //分拣符号，构建状态图。
        mc.pickupSymbols();            
        mc.printSymbols();
        mc.makeGraph();
        
        //调用默认检查器进行检查
        ICheck icheck = new DefaultCheck();
        if (!icheck.check(mc)) System.out.print(icheck.getErrorMsg());
        
        //生成graphviz的dot文件内容，用来显示状态图的。
        GenerateGraphviz genGraph = new GenerateGraphviz();
        System.out.println(genGraph.makeGraphContent(mc,null));
        
        
        //产生java代码内容
        IGenerateCode iGenJava = new GenerateJavaCode();
        iGenJava.generateCode(mc);
        
        System.out.println(iGenJava.getAbstractClassContent());
        System.out.println(iGenJava.getImplementClassContent());
        System.out.println(iGenJava.getTestClassContent());
        
        
        //将产生的代码内容写入到文件中
        FileMaker fm = new FileMaker(mc.getFsmName());
        fm.makeGraphvizImage(genGraph.makeGraphContent(mc, null));
        fm.makeJavaSourceFile(iGenJava.getAbstractClassContent(), iGenJava.getImplementClassContent(), iGenJava.getTestClassContent());

	}

}
