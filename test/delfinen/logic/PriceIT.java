package delfinen.logic;

import delfinen.logic.Member.Status;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author martin b.
 */
public class PriceIT {

    public PriceIT() {
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

    @Test
    public void testGetAge() {
        System.out.println("getAge");
        Price instance = new Price(25, Member.Status.Active);
        int expResult = 25;
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Price instance = new Price(25, Member.Status.Active);
        Member.Status expResult = Status.Active;
        Member.Status result = instance.getStatus();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPris() {
        System.out.println("getPris");
        Price instance = new Price(25, Member.Status.Active);
        int expResult = 1600;
        int result = instance.getPris();
        assertEquals(expResult, result);
    }


}
