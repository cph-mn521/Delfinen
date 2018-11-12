/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
