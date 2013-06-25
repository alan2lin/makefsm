package makefsm;

public class DoorImpl extends Door {


      @Override
      protected void enterOpened() {
        System.out.println(" enterOpened .....");
      }
     

      @Override
      protected void enterClosed() {
        System.out.println(" enterClosed .....");
      }
     

      @Override
      protected void enterLocked() {
        System.out.println(" enterLocked .....");
      }
     

      @Override
      protected void enterUnlocked() {
        System.out.println(" enterUnlocked .....");
      }
     

      @Override
      protected void enterEnd() {
        System.out.println(" enterEnd .....");
      }
         
  }    