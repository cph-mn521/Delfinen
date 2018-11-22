package delfinen.presentation;

import static delfinen.Controller.getTrainerNames;
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

    DelfinGUI GUI = new DelfinGUI();                // GUIen
    DelfinGUImethods GUIm = new DelfinGUImethods(); // og dens metoder

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
        //opret ny bruger til brug ved tests
        GUIm.menuSystemMembers();                       // gå til medlemsside
        GUIm.ClearFieldToPink();                        // tøm evt felter
        GUI.setNavn("Hans Egen");                       // Sæt Hans Egen i søgefelt
        GUI.setTrainedBy(getTrainerNames());
        GUI.setVisible(true);
        GUI.setNavn("Hans Egen");                       // Sæt Hans Egen i søgefelt
//        Controller.search();                            // Søg
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testStatusofMemberAfterSearch() {
        System.out.println("getStatus");
        String expResult = "Active";
        String result = GUI.getStatus();
        assertEquals(expResult, result);
    }

    @Test
    public void testCasualorCompetitionswimmerStatusofMemberAfterSearch() {
        System.out.println("getMotionistKonkurrence");
        String expResult = "Konkurrencesvømmer";
        String result = GUI.getMotionKonkurrence();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAdresseofMemberAfterSearch() {
        System.out.println("getAdresse");
        String expResult = "Ligustervej 99, 2956 Ligust";
        String result = GUI.getAdresse();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAlderofMemberAfterSearch() {
        System.out.println("getAlder");
        String expResult = 35 + "";
        String result = GUI.getAlder();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEmailofMemberAfterSearch() {
        System.out.println("getEmail");
        String expResult = "hans_egen@delfinen.dk";
        String result = GUI.getEmail();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNavnofMemberAfterSearch() {
        System.out.println("getNavn");
        String expResult = "Hans Egen";
        String result = GUI.getNavn();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTelefonofMemberAfterSearch() {
        System.out.println("getTelefon");
        String expResult = 25254545 + "";
        String result = GUI.getTelefon() + "";
        assertEquals(expResult, result);
    }

}
