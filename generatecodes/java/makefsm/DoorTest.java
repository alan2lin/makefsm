package makefsm;

import makefsm.Door.Event;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class DoorTest  {

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
       System.out.println("opened->closed->locked->unlocked->locked->end \n");   
       DoorImpl a = new DoorImpl();     
           a.emitEvent(Event.closeDoor);   
           a.emitEvent(Event.lockDoor);   
           a.emitEvent(Event.unLockDoor);   
           a.emitEvent(Event.lockDoor2);   
           a.emitEvent(Event.finish);        
       a.begin();

       System.out.println("\n  testPath0 end.......");
    }
    

    @Test
    public void testPath1() {
       System.out.println("\n  testPath1 start.......");   
       System.out.println("opened->closed->locked->end \n");   
       DoorImpl a = new DoorImpl();     
           a.emitEvent(Event.closeDoor);   
           a.emitEvent(Event.lockDoor);   
           a.emitEvent(Event.finish);        
       a.begin();

       System.out.println("\n  testPath1 end.......");
    }
    



  }    