/**
 *
 */
package com.github.alan2lin.makefsm;

import com.github.alan2lin.makefsm.generate.GenerateJavaCode;
import com.github.alan2lin.makefsm.check.DefaultCheck;
import com.github.alan2lin.makefsm.check.ICheck;
import com.github.alan2lin.makefsm.generate.GenerateGraphviz;
import com.github.alan2lin.makefsm.generate.IGenerateCode;
import com.github.alan2lin.makefsm.parser.MidleCode;
import com.github.alan2lin.makefsm.parser.ParserWrapper;
import com.github.alan2lin.makefsm.util.FileMaker;
import org.antlr.v4.runtime.RecognitionException;

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
        String destFolderName = ".\\generatecodes";

		if(args.length!=2)
		{
			System.out.println("Usage: java -cp makefsm.jar makefsm.Run <sourcefilename> ");
			return;
		}
		srcFileName =  args[0].replace("\'","");
		destFolderName = args[1].replace("\'","");

        System.out.println("source file:["+srcFileName+"] ");
        System.out.println("destination folder:["+destFolderName+"] ");



		//解析得到中间代码格式
        ParserWrapper pw = new ParserWrapper(srcFileName);
        MidleCode mc = pw.parser4MidleCode();

        if(pw.hasError()){
            System.out.println("syntax error["+pw.getErrors()+"] detects, program stop...");
            return ;
        }


        //分拣符号，构建状态图。
        mc.pickupSymbols();
        mc.printSymbols();
        mc.makeGraph();

        //调用默认检查器进行检查
        ICheck icheck = new DefaultCheck();
        if (!icheck.check(mc)) {
            System.out.print(icheck.getErrorMsg());
        }

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
        fm.setGenFolder(destFolderName);
        fm.makeGraphvizImage(genGraph.makeGraphContent(mc, null));
        fm.makeJavaSourceFile(iGenJava.getAbstractClassContent(), iGenJava.getImplementClassContent(), iGenJava.getTestClassContent());

	}

}
