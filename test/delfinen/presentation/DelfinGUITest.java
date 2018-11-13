package delfinen.presentation;

import javax.accessibility.AccessibleContext;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
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
    public void testGetComboBoxStatus() {
        System.out.println("getComboBoxStatus");
        DelfinGUI instance = new DelfinGUI();
        String expResult = "Aktiv";
        String result = instance.getComboBoxStatus();
    }

    @Test
    public void testGetjTextPane1() {
        System.out.println("getjTextPane1");
        DelfinGUI instance = new DelfinGUI();
        String expResult = null;
        String result = instance.getjTextPane1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTextFieldAdresse() {
        System.out.println("getTextFieldAdresse");
        DelfinGUI instance = new DelfinGUI();
        String expResult = "Ligustervænget 23, 2756 Liguster";
        String result = instance.getTextFieldAdresse();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTextFieldAlder() {
        System.out.println("getTextFieldAlder");
        DelfinGUI instance = new DelfinGUI();
        int expResult = 23;
        int result = instance.getTextFieldAlder();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTextFieldEmail() {
        System.out.println("getTextFieldEmail");
        DelfinGUI instance = new DelfinGUI();
        String expResult = "hjyui@delfinen.dk";
        String result = instance.getTextFieldEmail();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTextFieldID() {
        System.out.println("getTextFieldID");
        DelfinGUI instance = new DelfinGUI();
        int expResult = 1;
        int result = instance.getTextFieldID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTextFieldNavn() {
        System.out.println("getTextFieldNavn");
        DelfinGUI instance = new DelfinGUI();
        String expResult = "Lars Emil";
        String result = instance.getTextFieldNavn();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTextFieldTelefon() {
        System.out.println("getTextFieldTelefon");
        DelfinGUI instance = new DelfinGUI();
        int expResult = 25854578;
        int result = instance.getTextFieldTelefon();
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

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DelfinGUI.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
