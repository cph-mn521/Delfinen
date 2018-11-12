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
    
    
    public Member getMember() throws DataException;
   
   
    public void saveMember() throws DataException;

}