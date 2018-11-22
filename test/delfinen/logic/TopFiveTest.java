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
     * Initial values (time [double] and name [String]) are entered through method checkAndChangetopFive
     * Afterwards result can be read from getTopFive (time [String] and name [String])
     */
    @Test
    public void testGetTopFive() {
        System.out.println("getTopFive");
        TopFive instance = new TopFive();
        instance.checkAndChangetopFive(6.6, "Hans Egen");
        instance.checkAndChangetopFive(3.3, "Børge Egen");
        instance.checkAndChangetopFive(2.2, "Jørgen Egen");
        instance.checkAndChangetopFive(8.8, "Bruno Egen");
        instance.checkAndChangetopFive(7.7, "Jens Egen");
        instance.checkAndChangetopFive(1.1, "Jan Egen");
        String[][] result=new String[2][5];
        result[0][0]="1.1";result[1][0]="Jan Egen";
        result[0][1]="2.2";result[1][1]="Jørgen Egen";
        result[0][2]="3.3";result[1][2]="Børge Egen";
        result[0][3]="6.6";result[1][3]="Hans Egen";
        result[0][4]="7.7";result[1][4]="Jens Egen";
        String[][] expResult = instance.getTopFive();
        result = instance.getTopFive();
        assertArrayEquals(expResult, result);
    }
    
}
