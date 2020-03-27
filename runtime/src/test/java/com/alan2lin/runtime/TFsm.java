package com.alan2lin.runtime;

import com.alan2lin.runtime.impl.BaseFsm;
import com.alan2lin.runtime.impl.DefaultExceptionEvent;
import com.alan2lin.runtime.intf.EnumInterface;
import com.alan2lin.runtime.intf.ExceptionEvent;

import java.util.HashMap;

public abstract class TFsm extends BaseFsm {

     String instanceId ="justtest";

     String fsmType = "MEALY";

     @Override
     public String getInstanceId() {
         return instanceId;
     }

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

     //构造输出表  TODO: 最好的做法是  符号映射成数组，再通过数组进行映射. 后续统一规划这个
     public HashMap<String,String>  outputTable = new HashMap<>(){
         {
             put("start__init","aa");
             put("ready__start","bb");
         }
     };


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


    protected  States __currentState = States.start;

    protected abstract void enterStart__init(EVENT event);
    protected abstract void enterReady__start(EVENT event);


    /**
      * 激发某一个事件
      *
      * @param eventName
      * @return
      */
     @Override
     public void fireEvent(String eventName) {
        //利用反射 从事件类型名称 调用相关的响应函数
       EVENT event =   EnumInterface.getFromTypeName(eventName,EVENT.class);
       __processEvent(event);
     }



     void __processEvent( EVENT event ){

         switch(__currentState) {
             case start:
                 if( event == EVENT.start__init) {
                     enterStart__init(event);
                 }
                 break;
             case ready:
                 if( event == EVENT.ready__start) {

                     enterReady__start(event);
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


