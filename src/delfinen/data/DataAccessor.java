package delfinen.data;


import delfinen.logic.Member;
import java.util.List;


/**
 *
 * @author Martin Wulff
 */
public interface DataAccessor {
   
    // Methods for getting members from a txt database.
    public List<Member>  getMembers() throws DataException;
    
    
    public Member getMember(String query) throws DataException;
   
   
    public void saveMember(Member obj) throws DataException;
    
    public void editMember(Member old,Member N) throws DataException;
    
}