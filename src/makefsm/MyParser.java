/**
 * 
 */
package makefsm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

import org.antlr.runtime.*;



/**
 * @author "linc"
 * date   :2012-4-21 
 * time   :下午05:19:55
 *
 */
public class MyParser extends Parser {
	


	/**
	 * @param input
	 */
	public MyParser(TokenStream input) {
		super(input);
	}

	/**
	 * @param input
	 * @param state
	 */
	public MyParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}
		

	  Vector<ExceptionBean> vctError = new   Vector<ExceptionBean>();
	  Vector<ExceptionBean> vctWarning = new   Vector<ExceptionBean>();
	  
	/**获取拆包过程中，发生错误的个数
	 * @return  错误的个数，如果是0 则是没有错误
	 */
	public int getErrorCount()
	  {
	     return vctError.size();
	  }	  
	  
	/**获取拆包过程中，发生警告的个数，这些警告不一定是错误。
	 * @return 警告的个数，如果是0，则没有警告
	 */
	public int getWarningCount()
	  {
	     return vctWarning.size();
	  }

	  
	  public Vector<ExceptionBean> getErrors()
	  {
	    return vctError;
	  }
	  
	  public Vector<ExceptionBean> getWarnings()
	  {
	    return vctWarning;
	  }

	  
	  
	  
	 @Override 
	 public void displayRecognitionError(String[] tokenNames,
	                    RecognitionException e)
	  {
	    ExceptionBean  eb = new ExceptionBean();
	    
	    String hdr = getErrorHeader(e,eb);
	    String msg = getErrorMessage(e, tokenNames,eb);
	    
	    if (eb.getLevel()==ExceptionBean.ERROR)
	    {	       
	       vctError.add(eb);
	    }
	    else
	    {
	       vctWarning.add(eb);
	    }
	    
	    emitErrorMessage(hdr+" "+msg);
	  }
	    
	 public String getErrorHeader(RecognitionException e,ExceptionBean xeb) {
	 
	    xeb.setLine(e.line);
	    xeb.setCharPoint(e.charPositionInLine);
	    xeb.setSourceName("非文件输入");   
	 
	    if ( getSourceName()!=null )
	    {
	      xeb.setSourceName(getSourceName());      
	      return getSourceName()+" 第   "+e.line+" 行:第  "+e.charPositionInLine+" 列 ";
	    }
	        
	    return " 第  "+e.line+" 行:第 "+e.charPositionInLine+" 列 ";
	  } 
	  

	  public String getErrorMessage(RecognitionException e, String[] tokenNames,ExceptionBean xeb) {
	    String msg = e.getMessage();
	    if ( e instanceof UnwantedTokenException ) {
	      UnwantedTokenException ute = (UnwantedTokenException)e;
	      String tokenName="<unknown>";
	      if ( ute.expecting== Token.EOF ) {
	        tokenName = "EOF";
	      }
	      else {
	        tokenName = tokenNames[ute.expecting];
	      }
	      msg = "无关的输入 (extraneous input)  "+getTokenErrorDisplay(ute.getUnexpectedToken())+
	        " 期望的输入(expecting)： "+tokenName;        
	        
	    }
	    else if ( e instanceof MissingTokenException ) {
	      MissingTokenException mte = (MissingTokenException)e;
	      String tokenName="<unknown>";
	      if ( mte.expecting== Token.EOF ) {
	        tokenName = "EOF";
	      }
	      else {
	        tokenName = tokenNames[mte.expecting];
	      }
	      msg = " 在 "+getTokenErrorDisplay(e.token)+"处"+"缺少(missing) "+tokenName;
	    }
	    else if ( e instanceof MismatchedTokenException ) {
	      MismatchedTokenException mte = (MismatchedTokenException)e;
	      String tokenName="<unknown>";
	      if ( mte.expecting== Token.EOF ) {
	        tokenName = "EOF";
	      }
	      else {
	        tokenName = tokenNames[mte.expecting];
	      }
	      msg = "不匹配的输入(mismatched input) "+getTokenErrorDisplay(e.token)+
	        " 期待的输入(expecting) "+tokenName;
	    }
	    else if ( e instanceof MismatchedTreeNodeException ) {
	      MismatchedTreeNodeException mtne = (MismatchedTreeNodeException)e;
	      String tokenName="<unknown>";
	      if ( mtne.expecting==Token.EOF ) {
	        tokenName = "EOF";
	      }
	      else {
	        tokenName = tokenNames[mtne.expecting];
	      }
	      msg = "不匹配输入树节点(mismatched tree node): "+mtne.node+
	        " 期待的输入(expecting) "+tokenName;
	    }
	    else if ( e instanceof NoViableAltException ) {

	      msg = "在输入流上无可行的选择 ( no viable alternative at input) "+getTokenErrorDisplay(e.token);
	    }
	    else if ( e instanceof EarlyExitException ) {

	      msg = "要求的正则闭包循环没有匹配到任何东西 ( required (...)+ loop did not match anything at input) "+
	        getTokenErrorDisplay(e.token);
	    }
	    else if ( e instanceof MismatchedSetException ) {
	      MismatchedSetException mse = (MismatchedSetException)e;
	      msg = "集合形式的不匹配输入(mismatched input)"+getTokenErrorDisplay(e.token)+
	        " 期待的输入集合(expecting set) "+mse.expecting;
	    }
	    else if ( e instanceof MismatchedNotSetException ) {
	      MismatchedNotSetException mse = (MismatchedNotSetException)e;
	      msg = "含not谓词的集合输入不匹配(mismatched input) "+getTokenErrorDisplay(e.token)+
	        " 期待输入(expecting set) "+mse.expecting;
	    }
	    else if ( e instanceof FailedPredicateException ) {
	      FailedPredicateException fpe = (FailedPredicateException)e;
	      msg = "规则(rule): "+fpe.ruleName+" 语义断言失败 (failed predicate): {"+
	        fpe.predicateText+"}?";
	        xeb.setLevel(ExceptionBean.WARNING);
	    }
	    xeb.setMessage(msg);
	    return msg;
	  }
	  



}
