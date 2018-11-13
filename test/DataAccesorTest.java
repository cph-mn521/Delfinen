
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
import java.util.ArrayList;

/**
 *
 * @author Martin Wulff
 */
public class DataAccesorTest {

    private DataAccessor da;
    private DataAccessor DAW;
    public DataAccesorTest() {
        try {
            da = new DataAccessorFile("DataMembers.txt");
            DAW = new DataAccessorFile("DataMembersWrite.txt");
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
        } catch (DataException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void testGetMember() {
        Gson gson = new Gson();

        try {
            List<Member> mmbrs = da.getMembers();
            Member target = mmbrs.get(5);
            Member fetch = da.getMember(target.getName());
            
            assertTrue(gson.toJson(target).equals(gson.toJson(fetch)));
            
            fetch = da.getMember("id\":"+Integer.toString(target.getId()));
            assertTrue(gson.toJson(target).equals(gson.toJson(fetch)));
            
            
            fetch = da.getMember(Integer.toString(target.getPhone()));
            assertTrue(gson.toJson(target).equals(gson.toJson(fetch)));

        } catch (DataException e) {
            fail(e.getMessage());
        }
    }
    @Test
    public void testSaveMember(){
        try {
            List<Member> members= da.getMembers();
            DAW.saveMember(members.get(0));
            DAW.saveMember(members.get(1));
            DAW.saveMember(members.get(2));
            DAW.saveMember(members.get(3));
            DAW.saveMember(members.get(4));
            DAW.saveMember(members.get(5));
            List<Member> members2= DAW.getMembers();
            assertTrue(members.size() == members2.size());
        } catch (Exception e) {
        }
    }
}
