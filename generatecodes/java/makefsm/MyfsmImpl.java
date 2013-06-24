package makefsm;

public class MyfsmImpl extends Myfsm {


      @Override
      protected void enterStart() {
        System.out.println(" enterStart .....");
      }
     

      @Override
      protected void enterS1() {
        System.out.println(" enterS1 .....");
      }
     

      @Override
      protected void enterS2() {
        System.out.println(" enterS2 .....");
      }
     

      @Override
      protected void enterS3() {
        System.out.println(" enterS3 .....");
      }
     

      @Override
      protected void enterEnd() {
        System.out.println(" enterEnd .....");
      }
         
  }    