package makefsm;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Door {

   //状态机类型
   String fsmType = "MOORE";

   //当前状态
   private States __Y;
   private boolean __exitFlag = false;

   //状态队列
   private ConcurrentLinkedQueue<Event> __events = new ConcurrentLinkedQueue<Event>();

    //状态和事件的枚举变量
   public enum States { 
       opened,
       closed,
       locked,
       unlocked,
       end 
       } ;
   public enum Event { 
       closeDoor,
       openDoor,
       lockDoor,
       unLockDoor,
       lockDoor2,
       openDoor2,
       finish 
       } ;

   //输出列表 ， 为事件响应或或则进入状态的动作，
   //事件响应 与动作的区别是 事件响应完后才改变状态。 mealy型状态机会生成这个
   //进入状态动作 ，是状态改变后，才触发该状态的动作  。moore型状态机会生成这个。
   //这两者区分的的形式标准是  
   // 事件响应  onEvent(Event e) 以on开头，带参数，参数是为了代码重用方便
   // 动作 enterAction()  以 enter开头，不带参数 

      protected abstract void enterOpened();
      protected abstract void enterClosed();
      protected abstract void enterLocked();
      protected abstract void enterUnlocked();
      protected abstract void enterEnd();

   //主要实现的函数
      public void begin()
      {
        __Y = States.opened;

        while(!__exitFlag){
          Event  e = null;
          synchronized (__events) {        
            e = __events.poll();         
            if(e==null)
            {
              try {
             __events.wait();         
              } catch (InterruptedException e1) {          
                e1.printStackTrace();
              }
              continue;
            }
       }
          __processEvent(e);      
        }
        }

   void __processEvent( Event e ){    
   		   switch( __Y ) {   
   		   case opened:  
   		         if( e == Event.closeDoor ) {      
   		                  __Y = States.closed;
   		                  enterClosed();           
   		               }
   		         break;      
   		   case closed:  
   		         if( e == Event.openDoor ) {      
   		                  __Y = States.opened;
   		                  enterOpened();           
   		               } else if( e == Event.lockDoor ) {      
   		                  __Y = States.locked;
   		                  enterLocked();           
   		               }
   		         break;      
   		   case locked:  
   		         if( e == Event.unLockDoor ) {      
   		                  __Y = States.unlocked;
   		                  enterUnlocked();           
   		               } else if( e == Event.finish ) {      
   		                  __Y = States.end;
   		                  enterEnd();           
   		                  exit(__Y);
   		               }
   		         break;      
   		   case unlocked:  
   		         if( e == Event.lockDoor2 ) {      
   		                  __Y = States.locked;
   		                  enterLocked();           
   		               } else if( e == Event.openDoor2 ) {      
   		                  __Y = States.opened;
   		                  enterOpened();           
   		               }
   		         break;      
   		   case end:  
   		         break;       
   		   }  
       } 


   public void exit(States state) {

      __exitFlag = true; 

      System.out.println(" exit from state["+state.toString()+"]");

   }



   public void emitEvent(Event e)
   {
     //往队列中添加事件
     synchronized (__events) {      
       __events.add(e);
       if (__events.size()==1) __events.notify();

  }     

    }
}    