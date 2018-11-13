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
import delfinen.logic.Member.Status;

/**
 *
 * @author Martin Wulff
 */
public class DataAccesorTest {
      private DataAccessor da;

    public DataAccesorTest() {
        try {
            da = new DataAccessorFile("DataMembers.txt");
            Member target1 =new Member("hernik Henriksen", "abc@abs.dk","vinder vænget 4",1,48,12345678,Status.Passive);
            Member target2 =new Member("hernik Henriksen", "abc@abs.dk","vinder vænget 5",2,48,12345678,Status.Passive);
            Member target3 =new Member("hernik Henriksen", "abc@abs.dk","vinder vænget 6",3,48,12345678,Status.Passive);
            da.saveMember(target1);
            da.saveMember(target2);
            da.saveMember(target3);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testGetMembers() {
        try {
            List<Member> obj = da.getMembers();
            assertNotNull(obj);
            assertEquals(6, obj.size());
        } catch (DataException ex){
            fail(ex.getMessage());
        }
    }
    @Test
    public void testGetMember(){
        Gson gson = new Gson();
        Member target =new Member("hernik Henriksen", "abc@abs.dk","vinder vænget 4",4,48,12345678,Status.Passive);
        try {
            Member fetch = da.getMember(target.getAdress());
            assertTrue(target.equals(fetch));
            fetch = da.getMember(Integer.toString(target.getId()) );
            assertTrue(target.equals(fetch));
            fetch = da.getMember(Integer.toString(target.getPhone()) );
            assertTrue(target.equals(fetch));
            
        } catch (DataException e) {
            fail(e.getMessage());
        }      
    }

}
