// Generated from E:/repo/mvn/makefsm/src/main/resources/parser\MakefsmParser.g4 by ANTLR 4.7.2

package  makefsm.parser.autogen;

import makefsm.parser.FSMParser;
import makefsm.util.Constant.FSMType;
import makefsm.util.Constant.StatusAttr;
import makefsm.util.Constant.SymbolType;
import makefsm.entity.SymbolBean;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MakefsmParser}.
 */
public interface MakefsmParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MakefsmParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MakefsmParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakefsmParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MakefsmParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakefsmParser#statment}.
	 * @param ctx the parse tree
	 */
	void enterStatment(MakefsmParser.StatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakefsmParser#statment}.
	 * @param ctx the parse tree
	 */
	void exitStatment(MakefsmParser.StatmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakefsmParser#fsm_name}.
	 * @param ctx the parse tree
	 */
	void enterFsm_name(MakefsmParser.Fsm_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakefsmParser#fsm_name}.
	 * @param ctx the parse tree
	 */
	void exitFsm_name(MakefsmParser.Fsm_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakefsmParser#status_list}.
	 * @param ctx the parse tree
	 */
	void enterStatus_list(MakefsmParser.Status_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakefsmParser#status_list}.
	 * @param ctx the parse tree
	 */
	void exitStatus_list(MakefsmParser.Status_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakefsmParser#def_status}.
	 * @param ctx the parse tree
	 */
	void enterDef_status(MakefsmParser.Def_statusContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakefsmParser#def_status}.
	 * @param ctx the parse tree
	 */
	void exitDef_status(MakefsmParser.Def_statusContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakefsmParser#start_status}.
	 * @param ctx the parse tree
	 */
	void enterStart_status(MakefsmParser.Start_statusContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakefsmParser#start_status}.
	 * @param ctx the parse tree
	 */
	void exitStart_status(MakefsmParser.Start_statusContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakefsmParser#end_status_list}.
	 * @param ctx the parse tree
	 */
	void enterEnd_status_list(MakefsmParser.End_status_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakefsmParser#end_status_list}.
	 * @param ctx the parse tree
	 */
	void exitEnd_status_list(MakefsmParser.End_status_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakefsmParser#end_status}.
	 * @param ctx the parse tree
	 */
	void enterEnd_status(MakefsmParser.End_statusContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakefsmParser#end_status}.
	 * @param ctx the parse tree
	 */
	void exitEnd_status(MakefsmParser.End_statusContext ctx);
	/**
	 * Enter a parse tree produced by {@link MakefsmParser#transfer}.
	 * @param ctx the parse tree
	 */
	void enterTransfer(MakefsmParser.TransferContext ctx);
	/**
	 * Exit a parse tree produced by {@link MakefsmParser#transfer}.
	 * @param ctx the parse tree
	 */
	void exitTransfer(MakefsmParser.TransferContext ctx);
}