
import delfinen.data.DataAccessor;
import delfinen.data.DataAccessorFile;
import delfinen.data.DataException;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.*;
import delfinen.logic.Member;
import java.util.List;

/**
 * Tests any inserted DataAccessor
 *
 * @author RODA
 */
public class DataAccessorTest {

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
