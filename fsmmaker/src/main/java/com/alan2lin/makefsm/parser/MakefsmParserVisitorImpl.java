
package com.alan2lin.makefsm.parser;

import com.alan2lin.makefsm.entity.SymbolBean;
import com.alan2lin.makefsm.parser.autogen.MakefsmParserBaseVisitor;
import com.alan2lin.makefsm.util.Constant;
import com.alan2lin.makefsm.parser.autogen.MakefsmParser;
import org.antlr.v4.runtime.Token;

/**
 * @Description: TODO
 * @Author: alan2lin
 * @Date: 2020/3/5 12:49
 * @Version V1.0
 */
public class MakefsmParserVisitorImpl<T> extends MakefsmParserBaseVisitor<T> {

    public MakefsmParser parser ;

    public MakefsmParserVisitorImpl(MakefsmParser parser){
        this.parser = parser;
    }

    public MidleCode mc = new MidleCode();
    public MidleCode getMidleCode() {
        return mc;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public T visitFsm_type(MakefsmParser.Fsm_typeContext ctx) {
        //填充 状态机类型 无该节点时  默认情况下是 MOORE
        mc.setFsmType("MOORE".equals(ctx.getText())? Constant.FSMType.MOORE: Constant.FSMType.MEALY);
        return super.visitFsm_type(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public T visitFsm_name(MakefsmParser.Fsm_nameContext ctx) {
        //填充状态机名字和描述
        mc.setFsmName( ctx.name.getText());
        mc.setFsmDesc( ctx.desc.getText());

        return super.visitFsm_name(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public T visitDef_status(MakefsmParser.Def_statusContext ctx) {
       //扫描状态定义 生成符号表
        String statusName = ctx.statusName.getText();
        boolean symbolRedefined = mc.isSymbolExists(statusName,Constant.SymbolType.STATUS) ;
        if(symbolRedefined) {
            int line  = ctx.statusName.getLine();
            int position = ctx.statusName.getCharPositionInLine();
            //throw new FailedPredicateException(parser,"def_stauts check redefined", String.format("stauts [%s]defined again,please check, line[%d] position[%d] ",statusName,line,position));
            parser.notifyErrorListeners( String.format("stauts [%s]defined again,please check, line[%d] position[%d] ",statusName,line,position));
        }

        SymbolBean sb = new SymbolBean();
        sb.setIndex(mc.getCount());
        sb.setType(Constant.SymbolType.STATUS);
        sb.setStatus(Constant.StatusAttr.NONTERMINAL);
        sb.setName(statusName);

        Token output = ctx.output;
        //如果是moore fsm 则检查输出， 如果没有输出则用新状态的名字来 填充
        if( Constant.FSMType.MOORE.equals(mc.getFsmType())){
            sb.setOutput(output==null? statusName :output.getText());
        }else{
           if(output!=null) {
               int line  = output.getLine();
               int position = output.getCharPositionInLine();
               //throw new FailedPredicateException(parser,"def_stauts check output", String.format("stauts [%s] cannot have output definition[%s] in mealy fsm ,please check, line[%d] position[%d] ",statusName,output.getText(),line,position));
               parser.notifyErrorListeners(String.format("stauts [%s] cannot have output definition[%s] in mealy fsm ,please check, line[%d] position[%d] ",statusName,output.getText(),line,position));
           }
        }

        Token desc = ctx.statusDesc;
        if(desc!=null){
            sb.setDesc(desc.getText());
        }

        mc.addSymbol(sb);

        return super.visitDef_status(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public T visitStart_status(MakefsmParser.Start_statusContext ctx) {
        //处理开始状态
        String starterString = ctx.starter.getText();
        SymbolBean starter = mc.getSymbol(starterString, Constant.SymbolType.STATUS);

        if(null == starter) {
            int line = ctx.starter.getLine();
            int position = ctx.starter.getCharPositionInLine();
            //throw new FailedPredicateException(parser,"start_status_defined_check", String.format("status [%s] that you want to start is not defined yet ,line[%d] position[%d] ",starterString,line,position));
            parser.notifyErrorListeners( String.format("status [%s] that you want to start is not defined yet ,line[%d] position[%d] ",starterString,line,position));
        }
        starter.setStatus(Constant.StatusAttr.START); //denfine this status to start status;

        return super.visitStart_status(ctx);
    }


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public T visitEnd_status(MakefsmParser.End_statusContext ctx) {
        String enderString = ctx.ender.getText();
        SymbolBean ender = mc.getSymbol(enderString, Constant.SymbolType.STATUS);

        int line = ctx.ender.getLine();
        int position = ctx.ender.getCharPositionInLine();

        if(null == ender) {
            //throw new FailedPredicateException(parser,"end_status_defined_check", String.format("status [%s] that you want to start is not defined yet,line[%d] position[%d]",enderString,line,position));
            parser.notifyErrorListeners(String.format("status [%s] that you want to start is not defined yet,line[%d] position[%d]",enderString,line,position));
        }

        if(ender.getStatus()== Constant.StatusAttr.START) {
            //throw new FailedPredicateException(parser,"end_status_defined_check", String.format("status [%s] have been defined as start status,line[%d] position[%d]",enderString,line,position));
            parser.notifyErrorListeners( String.format("status [%s] have been defined as start status,line[%d] position[%d]",enderString,line,position));
        }
        ender.setStatus(Constant.StatusAttr.TERMINAL);

        return super.visitEnd_status(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public T visitTransfer(MakefsmParser.TransferContext ctx) {
       //处理状态迁移
       // 迁移也不允许 重复
       // 开始状态和结束状态 必须要存在
       //
        SymbolBean s1 = new SymbolBean();

        //check for whether the status undefined and whether event redefined;
        String eventName = ctx.eventName.getText();
        boolean symbolRedefined = mc.isSymbolExists(eventName, Constant.SymbolType.EVENT) ;
        if(symbolRedefined) {
            int line = ctx.eventName.getLine();
            int position = ctx.eventName.getCharPositionInLine();
            //throw new FailedPredicateException(parser,"transfer_check_redefined", String.format("event [%s] redefined!!! please check,line[%s] postion[%s]",eventName,line,position));
            parser.notifyErrorListeners(String.format("event [%s] redefined!!! please check,line[%s] postion[%s]",eventName,line,position));
        }

        String srcStatusString = ctx.src.getText();
        if(!mc.isSymbolExists(srcStatusString, Constant.SymbolType.STATUS)) {
            int line = ctx.src.getLine();
            int position = ctx.src.getCharPositionInLine();
            //throw new FailedPredicateException(parser,"transfer_check_src_status", String.format("status [%s] that transfer from is not  defined yet,line[%d] position[%d]",srcStatusString,line,position));
            parser.notifyErrorListeners(String.format("status [%s] that transfer from is not  defined yet,line[%d] position[%d]",srcStatusString,line,position));
        }

        String destStatusString  = ctx.dest.getText();
        if(!mc.isSymbolExists(destStatusString, Constant.SymbolType.STATUS)) {
            int line = ctx.dest.getLine();
            int position = ctx.dest.getCharPositionInLine();
            //throw new FailedPredicateException(parser,"transfer_check_dest_status", String.format( "status [%s] that transfer to is not  defined yet,line[%d] position[%d]",destStatusString,line,position));
            parser.notifyErrorListeners(String.format( "status [%s] that transfer to is not  defined yet,line[%d] position[%d]",destStatusString,line,position));
        }

        s1.setIndex(mc.getCount());
        s1.setName(eventName);
        s1.setType(Constant.SymbolType.EVENT);
        s1.setPstart(mc.getSymbol(srcStatusString, Constant.SymbolType.STATUS));
        s1.setPend(mc.getSymbol(destStatusString, Constant.SymbolType.STATUS));

        //检查输出
        Token output = ctx.output;
        //如果是moore fsm  不能有输出
        // 如果mealy fsm 没有输出则用 起始状态+"__"+迁移的名字 来 填充
        if( Constant.FSMType.MOORE.equals(mc.getFsmType())){
            if(output!=null) {
                int line  = output.getLine();
                int position = output.getCharPositionInLine();
                //throw new FailedPredicateException(parser,"def_transfer check output", String.format("transfer [%s] cannot have output definition[%s] in fsm moore,please check, line[%d] position[%d] ",eventName,output.getText(),line,position));
                parser.notifyErrorListeners( String.format("transfer [%s] cannot have output definition[%s] in fsm moore,please check, line[%d] position[%d] ",eventName,output.getText(),line,position));
            }
        }else{
            String spliter = "__";
            s1.setOutput(output==null? s1.getPstart().getName() + spliter+ eventName  :output.getText());
        }





        mc.addSymbol(s1);

        return super.visitTransfer(ctx);
    }
}
