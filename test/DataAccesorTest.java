
import com.google.gson.Gson;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import delfinen.data.DataException;
import delfinen.data.DataAccessorFile;
import delfinen.data.DataAccessor;
import delfinen.logic.Member;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Martin Wulff
 */
public class DataAccesorTest {

    private DataAccessor da;

    public DataAccesorTest() {
        try {
            da = new DataAccessorFile("DataMembers.txt");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testGetEntries() {
        try {
            List<String> obj = da.getEntries();
            assertNotNull(obj);
            assertTrue(1 <= obj.size());
        } catch (DataException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void testSearchEntries() {
        Gson gson = new Gson();

        try {
            List<String> mmbrs = da.getEntries();
            String target = mmbrs.get(1);
            List<String> fetch = da.searchEntries("entry");
            assertTrue(fetch.size() == 3);

            fetch = da.searchEntries("entry 1");
            assertTrue(fetch.size() == 1);

            fetch = da.searchEntries("asdf");
            assertTrue(fetch.size() == 1);

        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAddEntry() {
        try {
            File file = new File("DataMembersWrite.txt");
            file.delete();
            file.createNewFile();
            DataAccessor DAW = new DataAccessorFile("DataMembersWrite.txt");

            assertTrue(DAW.getEntries().size() == 0);
            DAW.addEntry("reee");
            assertTrue(DAW.getEntries().size() == 2);
            DAW.addEntry("woooo");
            assertTrue(DAW.getEntries().size() == 3);

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testEditEntry() {
        try {
            da.editEntry("entry 1", "entry 1, nu med lidt extra");
            List<String> whatevs = da.searchEntries("entry 1");
            assertTrue(whatevs.get(0).equals("entry 1, nu med lidt extra"));
            
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

}
