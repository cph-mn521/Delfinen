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
public class SubscriptionIT {

    private Member p1 = new Member("John Test", "abe@kat.dk", "Testgade 3", 2, 34, 12345678, Member.Status.Active);
    private Member p2 = new Member("John Test", "abe@kat.dk", "Testgade 3", 2, 62, 12345678, Member.Status.Active, true);
    private Member p3 = new Member("Ikke John", "ny@mailt.dk", "Anden Gade 23", 4, 89, 87654321, Member.Status.Passive);
    private Subscription S1 = new Subscription(1, p1);
    private Subscription S2 = new Subscription(2, p2);
    private Subscription S3 = new Subscription(3, p3);
    

    public SubscriptionIT() {
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
    public void testGetYear() {
        assertEquals(S1.getYear(), 1);
        assertEquals(S2.getYear(), 2);
        assertEquals(S3.getYear(), 3);
    }

    @Test
    public void testGetPrice() {
        float e1 = 1600;
        float e2 =  (float) (1600 * 0.75);
        float e3 = 500;
        
        assertTrue(S1.getPrice()== e1);
        assertTrue(S2.getPrice()== e2);
        assertTrue(S3.getPrice()== e3);
        
    }

    @Test
    public void testGetHolder() {
        
        assertTrue(S1.getHolder().equals(p1));
        assertTrue(S2.getHolder().equals(p2));
        assertTrue(S3.getHolder().equals(p3));
    }

}
