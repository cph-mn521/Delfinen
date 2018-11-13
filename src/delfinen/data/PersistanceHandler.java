/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.data;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import delfinen.logic.CompetitiveMember;
import delfinen.logic.Member;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin Wulff
 */
public class PersistanceHandler {

    // Deklaration of filepaths.
    private final String DBMembers = "Members.txt";
    private final String DBRekords = "Rekords.txt";
    private final String DBKontigents = "Kontigents.txt";
    
    private DataAccessor dam = new DataAccessorFile(DBMembers);
    private Gson gson = new Gson();

    public PersistanceHandler() {

    }

    /*
    Method for retrieving a list of all members in the Members.txt database.
    
    * @return   members     All members int the database.
    * @throws   DataException
     */
    public List<Member> getMembers() throws DataException {
        List<Member> out = new ArrayList<>();
        try {
            List<String> jsons = dam.getEntries();
            for (String json : jsons) {
                try {
                    out.add(gson.fromJson(json, Member.class));
                } catch (JsonSyntaxException e) {
                    out.add(gson.fromJson(json, CompetitiveMember.class));
                }
            }
            return out;
        } catch (DataException e) {
            throw new DataException();
        }
    }
    
    /*
    Method for searching for keywords in the member database. Searches the
    database for all entries with containing the query. Can be used to fetch all
    Competetive members, or all with a specific address, or all males etc. etc.
    
    For more precise searches, use the "ATTRIBUTE:"+"String" or "ATTRIBUTE:"+datatype
    
    @param  Query       The wanted Query. 
    @return Members     All members in the database with maching Attribute.    
    @throws DataException.
    */
    public List<Member> searchMember(String Query) throws DataException {
        try {
            List<String> json = dam.searchEntries(Query);
            List<Member> Members = new ArrayList<>();
            for (String string : json) {
                try {
                    Members.add(gson.fromJson(string, Member.class));
                } catch (JsonSyntaxException e) {
                    Members.add(gson.fromJson(string, CompetitiveMember.class));
                }
            }
            return Members;
        } catch (DataException e) {
            throw new DataException(e.getMessage());
        }

    }
    
    
    /*
    Method for adding a member to the Member database. 
    
    @param  Member   Member to be added to the database.
    @throws DataException.
    */
    public void addMember(Member obj) throws DataException{
        dam.addEntry(gson.toJson(obj));
    }
    
    /*
    Method for edeting a member. Can also be used to remove members.
    
    @param  old     The Member that you wish to modify.
    @param  N       The Member you wish it should be. if null, removes the entry.
    */
    public void editMember(Member old, Member N) throws DataException{
        if(N!=null)dam.editEntry(gson.toJson(old), gson.toJson(N));
        else dam.editEntry(gson.toJson(old), "");
    }
}