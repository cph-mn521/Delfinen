import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import delfinen.data.DataException;
import delfinen.data.
import delfinen.data.DataAccessor;

/**
 *
 * @author Martin Wulff
 */
public class DataAccesorTest {
      private DataAccessor da;

    public DataAccessorTest() {
        try {
            da = new DataAccessorFile("DataMembers.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testGetMembers() {
        try {
            List<Member> obj = da.getMembers();
            assertNotNull(obj);
        } catch (DataException ex){
            fail(ex.getMessage());
        }
    }

}
