package makefsm;

import makefsm.Myfsm.Event;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MyfsmTest  {

  /**
   * @throws java.lang.Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
  }

    @Test
    public void testPath0() {
       System.out.println("\n  testPath0 start.......");   
       System.out.println("start->s1 \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even1);        
       a.begin();

       System.out.println("\n  testPath0 end.......");
    }
    

    @Test
    public void testPath1() {
       System.out.println("\n  testPath1 start.......");   
       System.out.println("start->start->s1 \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even9);   
           a.emitEvent(Event.even1);        
       a.begin();

       System.out.println("\n  testPath1 end.......");
    }
    

    @Test
    public void testPath2() {
       System.out.println("\n  testPath2 start.......");   
       System.out.println("start->start->s2->s3->s2->s1 \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even9);   
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even5);   
           a.emitEvent(Event.even4);   
           a.emitEvent(Event.even6);        
       a.begin();

       System.out.println("\n  testPath2 end.......");
    }
    

    @Test
    public void testPath3() {
       System.out.println("\n  testPath3 start.......");   
       System.out.println("start->start->s2->s3->s2->start->s1 \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even9);   
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even5);   
           a.emitEvent(Event.even4);   
           a.emitEvent(Event.even10);   
           a.emitEvent(Event.even1);        
       a.begin();

       System.out.println("\n  testPath3 end.......");
    }
    

    @Test
    public void testPath4() {
       System.out.println("\n  testPath4 start.......");   
       System.out.println("start->start->s2->s1 \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even9);   
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even6);        
       a.begin();

       System.out.println("\n  testPath4 end.......");
    }
    

    @Test
    public void testPath5() {
       System.out.println("\n  testPath5 start.......");   
       System.out.println("start->start->s2->start->s1 \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even9);   
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even10);   
           a.emitEvent(Event.even1);        
       a.begin();

       System.out.println("\n  testPath5 end.......");
    }
    

    @Test
    public void testPath6() {
       System.out.println("\n  testPath6 start.......");   
       System.out.println("start->s2->s3->s2->s1 \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even5);   
           a.emitEvent(Event.even4);   
           a.emitEvent(Event.even6);        
       a.begin();

       System.out.println("\n  testPath6 end.......");
    }
    

    @Test
    public void testPath7() {
       System.out.println("\n  testPath7 start.......");   
       System.out.println("start->s2->s3->s2->start->s1 \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even5);   
           a.emitEvent(Event.even4);   
           a.emitEvent(Event.even10);   
           a.emitEvent(Event.even1);        
       a.begin();

       System.out.println("\n  testPath7 end.......");
    }
    

    @Test
    public void testPath8() {
       System.out.println("\n  testPath8 start.......");   
       System.out.println("start->s2->s3->s2->start->start->s1 \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even5);   
           a.emitEvent(Event.even4);   
           a.emitEvent(Event.even10);   
           a.emitEvent(Event.even9);   
           a.emitEvent(Event.even1);        
       a.begin();

       System.out.println("\n  testPath8 end.......");
    }
    

    @Test
    public void testPath9() {
       System.out.println("\n  testPath9 start.......");   
       System.out.println("start->s2->s1 \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even6);        
       a.begin();

       System.out.println("\n  testPath9 end.......");
    }
    

    @Test
    public void testPath10() {
       System.out.println("\n  testPath10 start.......");   
       System.out.println("start->s2->start->s1 \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even10);   
           a.emitEvent(Event.even1);        
       a.begin();

       System.out.println("\n  testPath10 end.......");
    }
    

    @Test
    public void testPath11() {
       System.out.println("\n  testPath11 start.......");   
       System.out.println("start->s2->start->start->s1 \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even10);   
           a.emitEvent(Event.even9);   
           a.emitEvent(Event.even1);        
       a.begin();

       System.out.println("\n  testPath11 end.......");
    }
    

    @Test
    public void testPath12() {
       System.out.println("\n  testPath12 start.......");   
       System.out.println("start->start->end \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even9);   
           a.emitEvent(Event.even2);        
       a.begin();

       System.out.println("\n  testPath12 end.......");
    }
    

    @Test
    public void testPath13() {
       System.out.println("\n  testPath13 start.......");   
       System.out.println("start->start->s2->s3->s2->end \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even9);   
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even5);   
           a.emitEvent(Event.even4);   
           a.emitEvent(Event.even8);        
       a.begin();

       System.out.println("\n  testPath13 end.......");
    }
    

    @Test
    public void testPath14() {
       System.out.println("\n  testPath14 start.......");   
       System.out.println("start->start->s2->s3->s2->start->end \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even9);   
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even5);   
           a.emitEvent(Event.even4);   
           a.emitEvent(Event.even10);   
           a.emitEvent(Event.even2);        
       a.begin();

       System.out.println("\n  testPath14 end.......");
    }
    

    @Test
    public void testPath15() {
       System.out.println("\n  testPath15 start.......");   
       System.out.println("start->start->s2->end \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even9);   
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even8);        
       a.begin();

       System.out.println("\n  testPath15 end.......");
    }
    

    @Test
    public void testPath16() {
       System.out.println("\n  testPath16 start.......");   
       System.out.println("start->start->s2->start->end \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even9);   
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even10);   
           a.emitEvent(Event.even2);        
       a.begin();

       System.out.println("\n  testPath16 end.......");
    }
    

    @Test
    public void testPath17() {
       System.out.println("\n  testPath17 start.......");   
       System.out.println("start->end \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even2);        
       a.begin();

       System.out.println("\n  testPath17 end.......");
    }
    

    @Test
    public void testPath18() {
       System.out.println("\n  testPath18 start.......");   
       System.out.println("start->s2->s3->s2->end \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even5);   
           a.emitEvent(Event.even4);   
           a.emitEvent(Event.even8);        
       a.begin();

       System.out.println("\n  testPath18 end.......");
    }
    

    @Test
    public void testPath19() {
       System.out.println("\n  testPath19 start.......");   
       System.out.println("start->s2->s3->s2->start->start->end \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even5);   
           a.emitEvent(Event.even4);   
           a.emitEvent(Event.even10);   
           a.emitEvent(Event.even9);   
           a.emitEvent(Event.even2);        
       a.begin();

       System.out.println("\n  testPath19 end.......");
    }
    

    @Test
    public void testPath20() {
       System.out.println("\n  testPath20 start.......");   
       System.out.println("start->s2->s3->s2->start->end \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even5);   
           a.emitEvent(Event.even4);   
           a.emitEvent(Event.even10);   
           a.emitEvent(Event.even2);        
       a.begin();

       System.out.println("\n  testPath20 end.......");
    }
    

    @Test
    public void testPath21() {
       System.out.println("\n  testPath21 start.......");   
       System.out.println("start->s2->end \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even8);        
       a.begin();

       System.out.println("\n  testPath21 end.......");
    }
    

    @Test
    public void testPath22() {
       System.out.println("\n  testPath22 start.......");   
       System.out.println("start->s2->start->start->end \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even10);   
           a.emitEvent(Event.even9);   
           a.emitEvent(Event.even2);        
       a.begin();

       System.out.println("\n  testPath22 end.......");
    }
    

    @Test
    public void testPath23() {
       System.out.println("\n  testPath23 start.......");   
       System.out.println("start->s2->start->end \n");   
       MyfsmImpl a = new MyfsmImpl();     
           a.emitEvent(Event.even7);   
           a.emitEvent(Event.even10);   
           a.emitEvent(Event.even2);        
       a.begin();

       System.out.println("\n  testPath23 end.......");
    }
    



  }    