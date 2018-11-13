package delfinen.data;


import delfinen.logic.Member;
import java.util.List;


/**
 *
 * @author Martin Wulff
 */
public interface DataAccessor {
   
    // Methods for getting members from a txt database.
    public List<String> getEntries() throws DataException;
    
    
    public List<String> searchEntries(String query) throws DataException;
   
   
    public void addEntry(String obj) throws DataException;
    
    public void editEntry(String old,String N) throws DataException;
    
}