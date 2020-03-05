// Generated from E:/repo/mvn/makefsm/src/main/resources/parser\MakefsmParser.g4 by ANTLR 4.7.2

package  makefsm.parser.autogen;

import makefsm.parser.FSMParser;
import makefsm.util.Constant.FSMType;
import makefsm.util.Constant.StatusAttr;
import makefsm.util.Constant.SymbolType;
import makefsm.entity.SymbolBean;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MakefsmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MakefsmParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MakefsmParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(MakefsmParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakefsmParser#fsm_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFsm_type(MakefsmParser.Fsm_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakefsmParser#fsm_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFsm_name(MakefsmParser.Fsm_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakefsmParser#status_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatus_list(MakefsmParser.Status_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakefsmParser#def_status}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef_status(MakefsmParser.Def_statusContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakefsmParser#statment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatment(MakefsmParser.StatmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakefsmParser#start_status}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_status(MakefsmParser.Start_statusContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakefsmParser#end_status_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd_status_list(MakefsmParser.End_status_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakefsmParser#end_status}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd_status(MakefsmParser.End_statusContext ctx);
	/**
	 * Visit a parse tree produced by {@link MakefsmParser#transfer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransfer(MakefsmParser.TransferContext ctx);
}