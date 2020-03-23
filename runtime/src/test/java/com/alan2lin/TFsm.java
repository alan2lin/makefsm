package com.alan2lin;

import com.alan2lin.runtime.DefaultFsmFramework;
import com.alan2lin.runtime.impl.BaseFsm;
import com.alan2lin.runtime.impl.DefaultExceptionEvent;
import com.alan2lin.runtime.impl.DefaultInputEvent;
import com.alan2lin.runtime.intf.EnumInterface;
import com.alan2lin.runtime.intf.ExceptionEvent;
import com.alan2lin.runtime.intf.Fsm;
import com.alan2lin.runtime.intf.FsmFramework;
import org.junit.Test;

 public abstract class TFsm extends BaseFsm {


     //状态和事件的枚举变量
     public enum States {
         start,
         ready,
         running,
         pause_locked,
         pause,
         pause_unlocked,
         stop_locked,
         stop
     } ;


     protected abstract void enterStart__init();
     protected abstract void enterReady__start();

     private States __Y;

        public enum EVENT implements EnumInterface<EVENT> {start__init("start__init","init"),ready__start("ready__start","start");

            String name;
            String value;

            private EVENT(String name,String value){
                this.name = name;
                this.value = value;
            }

            @Override
            public String getName() {
                return this.name;
            }

            @Override
            public String getValue(){
                return this.value;
            }

        }



     /**
      * 激发某一个事件
      *
      * @param eventName
      * @return
      */
     @Override
     public String fireEvent(String eventName) {
        //利用反射 从事件类型名称 调用相关的响应函数

       EVENT event =   EnumInterface.getFromTypeName(eventName,EVENT.class);
       __processEvent(event);

       return null;
     }



     void __processEvent( EVENT event ){

         switch( __Y ) {
             case start:
                 if( event == EVENT.start__init) {
                     enterStart__init();
                 }
                 break;
             case ready:
                 if( event == EVENT.ready__start) {

                     enterReady__start();
                 }
                 break;

             case stop:
                 break;
             default:
                 fsmFramework.exception(new DefaultExceptionEvent(this, ExceptionEvent.EXCETPION_TYPE.TRANSITION_NOT_DEFINED,null));
                 break;
         }
     }

 }


