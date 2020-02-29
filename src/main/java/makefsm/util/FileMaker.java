package makefsm.util;

import graphviz.GraphViz;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;

import java.io.*;

public class FileMaker {

	String target = "java";

	String graphType = "png";

	String fsmName = "";

	String genFolder = "./generates/";
	String graphPath = genFolder.replaceFirst("[/\\\\]+$","") + "/graphs/";

	public FileMaker(String xfsmName)
	{
		fsmName=xfsmName;
	}

	public void setGenFolder(String genFolder){
		this.genFolder = genFolder;
		this.graphPath = genFolder.replaceFirst("[/\\\\]+$","") + "/graphs/" ;
	}

	public void  makeGraphvizImage(String dotFileContent)
	{
		GraphViz gv = new GraphViz();
		File out = new File(graphPath+fsmName+"." + graphType);

	    //将dot内容 刷到文件
		write2file(graphPath,fsmName+".dot",dotFileContent);
		//将dot的图像内容刷到文件
		try {
			Graphviz.fromString(dotFileContent).height(800).render(Format.PNG).toFile(new File(graphPath+fsmName+"." + graphType));
		} catch (IOException e) {
			e.printStackTrace();
		}


		//gv.writeGraphToFile( gv.getGraph(dotFileContent , graphType ), out );
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

		File file = new File(fileName);
		File dir = file.getParentFile();
		if(!dir.exists()) {
			dir.mkdirs();
		}

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
