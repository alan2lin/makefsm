package com.alan2lin;

import com.alan2lin.runtime.DefaultFsmFramework;
import com.alan2lin.runtime.impl.DefaultInputEvent;
import com.alan2lin.runtime.intf.EnumInterface;
import com.alan2lin.runtime.intf.Fsm;
import com.alan2lin.runtime.intf.FsmFramework;
import org.junit.Test;

 public class TFsm implements Fsm {
        String instanceId ="justtest";

        public enum EVENT implements EnumInterface<EVENT> {aa("aa"),bb("bb");
            String text;

            private EVENT(String text){
                this.text = text;
            }
            @Override
            public String getText(){
                return this.text;
            }
        }
        @Override
        public String getInstanceId() {
            return instanceId;
        }

}


