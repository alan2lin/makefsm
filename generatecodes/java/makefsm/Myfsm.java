package makefsm;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Myfsm {

   //当前状态
   private States __Y;
   private boolean __exitFlag = false;

   //状态队列
   private ConcurrentLinkedQueue<Event> __events = new ConcurrentLinkedQueue<Event>();

    //状态和事件的枚举变量
   public enum States { 
       start,
       s1,
       s2,
       s3,
       end 
       } ;
   public enum Event { 
       even1,
       even9,
       even2,
       even7,
       even5,
       even4,
       even6,
       even8,
       even10 
       } ;

   //输出列表 ， 为事件响应或或则进入状态的动作，
   //事件响应 与动作的区别是 事件响应完后才改变状态。 mealy型状态机会生成这个
   //进入状态动作 ，是状态改变后，才触发该状态的动作  。moore型状态机会生成这个。
   //这两者区分的的形式标准是  
   // 事件响应  onEvent(Event e) 以on开头，带参数，参数是为了代码重用方便
   // 动作 enterAction()  以 enter开头，不带参数 

      protected abstract void enterStart();
      protected abstract void enterS1();
      protected abstract void enterS2();
      protected abstract void enterS3();
      protected abstract void enterEnd();

   //主要实现的函数
      public void begin()
      {
        __Y = States.start;

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
   		   case start:  
   		         if( e == Event.even1 ) {      
   		                  __Y = States.s1;
   		                  enterS1();           
   		                  exit(__Y);
   		               } else if( e == Event.even9 ) {      
   		                  __Y = States.start;
   		                  enterStart();           
   		               } else if( e == Event.even2 ) {      
   		                  __Y = States.end;
   		                  enterEnd();           
   		                  exit(__Y);
   		               } else if( e == Event.even7 ) {      
   		                  __Y = States.s2;
   		                  enterS2();           
   		               }
   		         break;      
   		   case s1:  
   		         break;      
   		   case s2:  
   		         if( e == Event.even5 ) {      
   		                  __Y = States.s3;
   		                  enterS3();           
   		               } else if( e == Event.even6 ) {      
   		                  __Y = States.s1;
   		                  enterS1();           
   		                  exit(__Y);
   		               } else if( e == Event.even8 ) {      
   		                  __Y = States.end;
   		                  enterEnd();           
   		                  exit(__Y);
   		               } else if( e == Event.even10 ) {      
   		                  __Y = States.start;
   		                  enterStart();           
   		               }
   		         break;      
   		   case s3:  
   		         if( e == Event.even4 ) {      
   		                  __Y = States.s2;
   		                  enterS2();           
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