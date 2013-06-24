package makefsm.util;

import graphviz.GraphViz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class FileMaker {
	
	String target = "java";
	
	String graphPath = "./graphs/";
	String graphType = "gif";
	
	String fsmName = "";
	
	String genFolder = "./generatecodes/";
	
	public FileMaker(String xfsmName)
	{
		fsmName=xfsmName;
	}

	public void  makeGraphvizImage(String dotFileContent)
	{
		GraphViz gv = new GraphViz();
		File out = new File(graphPath+fsmName+"." + graphType);   	
				
	    gv.writeGraphToFile( gv.getGraph(dotFileContent , graphType ), out );
	}
	
	public void makeJavaSourceFile(String absClassContent,String implClassContent,String testClassContent)
	{
		 
		  write2file(genFolder+target+"/makefsm",fsmName+".java",absClassContent);
		  write2file(genFolder+target+"/makefsm",fsmName+"Impl.java",implClassContent);
		  write2file(genFolder+target+"/makefsm",fsmName+"Test.java",testClassContent);
		
	}
	
	private void write2file(String fileDir,String xfileName,String fileContent)
	{
		// System.out.println(path+fileName+".g");
		String fileName = fileDir+"/"+xfileName;
		
		//System.out.println("准备写入的文件是:" + fileName);

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fileName);
			Writer out = new OutputStreamWriter(fos, "UTF-8");
			out.write(fileContent);
			out.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
