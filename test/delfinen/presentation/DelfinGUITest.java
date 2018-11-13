package delfinen.presentation;

import javax.accessibility.AccessibleContext;
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
public class DelfinGUITest {

    public DelfinGUITest() {
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
    public void testStatus() {
        System.out.println("getStatus");
        DelfinGUI instance = new DelfinGUI();
        String expResult = "Aktiv";
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }

    @Test
    public void testMotionistKonkurrence() {
        System.out.println("getMotionistKonkurrence");
        DelfinGUI instance = new DelfinGUI();
        String expResult = "Kokurrencesvømmer";
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }

    @Test
    public void testDisciplin() {
        System.out.println("getDisciplin");
        DelfinGUI instance = new DelfinGUI();
        String expResult = "Aktiv";
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetAdresse() {
        System.out.println("getAdresse");
        DelfinGUI instance = new DelfinGUI();
        String expResult = "Ligustervænget 23, 2756 Liguster";
        String result = instance.getAdresse();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAlder() {
        System.out.println("getAlder");
        DelfinGUI instance = new DelfinGUI();
        int expResult = 23;
        int result = instance.getAlder();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        DelfinGUI instance = new DelfinGUI();
        String expResult = "lm@delfinen.dk";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetID() {
        System.out.println("getID");
        DelfinGUI instance = new DelfinGUI();
        int expResult = 1;
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNavn() {
        System.out.println("getNavn");
        DelfinGUI instance = new DelfinGUI();
        String expResult = "Lars Emil";
        String result = instance.getNavn();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTelefon() {
        System.out.println("getTelefon");
        DelfinGUI instance = new DelfinGUI();
        int expResult = 25854578;
        int result = instance.getTelefon();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEXIT_ON_CLOSE() {
        System.out.println("getEXIT_ON_CLOSE");
        int expResult = 0;
        int result = DelfinGUI.getEXIT_ON_CLOSE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAccessibleContext() {
        System.out.println("getAccessibleContext");
        DelfinGUI instance = new DelfinGUI();
        AccessibleContext expResult = null;
        AccessibleContext result = instance.getAccessibleContext();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        DelfinGUI instance = new DelfinGUI();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        DelfinGUI instance = new DelfinGUI();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


}
