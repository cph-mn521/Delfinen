/*
 */
package delfinen.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mint
 */
public class TopFiveTest {
    
    public TopFiveTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTopFive method, of class TopFive.
     */
    @Test
    public void testGetTopFive() {
        System.out.println("getTopFive");
        TopFive instance = new TopFive();
        String[][] expResult = null;
        String[][] result = instance.getTopFive();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkAndChangetopFive method, of class TopFive.
     */
    @Test
    public void testCheckAndChangetopFive() {
        System.out.println("checkAndChangetopFive");
        double time = 0.0;
        String timeHolder = "";
        TopFive instance = new TopFive();
        instance.checkAndChangetopFive(time, timeHolder);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
