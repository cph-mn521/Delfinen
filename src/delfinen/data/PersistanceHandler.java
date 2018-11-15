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
import delfinen.logic.Record;
import delfinen.logic.Subscription;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin Wulff
 */
public class PersistanceHandler {

    // Deklaration of filepaths.
    private final String DBMembers = "Members.txt";
    private final String DBRekords = "Records.txt";
    private final String DBSubscriptions = "Subscriptions.txt";

    final DataAccessor dam = new DataAccessorFile(DBMembers);
    final DataAccessor dar = new DataAccessorFile(DBRekords);
    final DataAccessor das = new DataAccessorFile(DBSubscriptions);
    final Gson gson = new Gson();

    public PersistanceHandler() {

    }

    
    ///////////////////////      MEMBER HANDLING       ////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Method for retrieving a list of all members in the Members database.
     *
     * @return members All members in the database.
     * @throws DataException
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
            throw new DataException(e.getMessage());
        }
    }

    /**
     * Method for searching for keywords in the member database. Searches the
     * database for all entries with containing the query. Can be used to fetch
     * all Competetive members, or all with a specific address, or all males
     * etc. etc.
     *
     * For more precise searches, use the "ATTRIBUTE:"+"String" or
     * "ATTRIBUTE:"+datatype
     *
     * @param Query The wanted Query.
     * @return Members All members in the database with maching Attribute.
     * @throws delfinen.data.DataException
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

    /**
     * Method for adding a member to the Member database.
     *
     *
     * @param obj Member to be added to the database.
     * @throws delfinen.data.DataException
     */
    public void addMember(Member obj) throws DataException {
        dam.addEntry(gson.toJson(obj));
    }

    /**
     * Method for editing a member. Can also be used to remove members.
     *
     * @param old The Member that you wish to modify.
     * @param N The Member you wish it should be. if null, removes the entry.
     * @throws delfinen.data.DataException
     */
    public void editMember(Member old, Member N) throws DataException {
        if (N != null) {
            dam.editEntry(gson.toJson(old), gson.toJson(N));
        } else {
            dam.editEntry(gson.toJson(old), "");
        }
    }
    

    ///////////////////////      REKORDS HANDLING       ////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Method for retrieving a list of all Records in the Records database.
     *
     * @return Records All members in the database.
     * @throws DataException
     */
    public List<Record> getRecords() throws DataException {
        List<Record> out = new ArrayList<>();
        try {
            List<String> jsons = dar.getEntries();
            for (String json : jsons) {
                out.add(gson.fromJson(json, Record.class));
            }
            return out;
        } catch (DataException e) {
            throw new DataException(e.getMessage());
        }
    }

    /**
     * Method for searching for keywords in the Records database. Searches the
     * database for all entries with containing the query. * For more precise
     * searches, use the "ATTRIBUTE:"+"String" or "ATTRIBUTE:"+query
     *
     * @param Query         The wanted Query.
     * @return records      All members in the database with maching Attribute.
     * @throws delfinen.data.DataException
     */
    public List<Record> searchRecord(String Query) throws DataException {
        try {
            List<String> json = dar.searchEntries(Query);
            List<Record> records = new ArrayList<>();
            json.forEach((string) -> {
                records.add(gson.fromJson(string, Record.class));
            });
            return records;
        } catch (DataException e) {
            throw new DataException(e.getMessage());
        }

    }

    /**
     * Method for adding a Record to the Record database.
     *
     *
     * @param obj       Record to be added to the database.
     * @throws delfinen.data.DataException
     */
    public void addRecord(Record obj) throws DataException {
        dar.addEntry(gson.toJson(obj));
    }

    /**
     * Method for editing a Record. Can also be used to remove Record.
     *
     * @param old The Record that you wish to modify.
     * @param N The Record you wish it should be. if null, removes the entry.
     * @throws delfinen.data.DataException
     */
    public void editRecord(Record old, Record N) throws DataException {
        if (N != null) {
            dar.editEntry(gson.toJson(old), gson.toJson(N));
        } else {
            dar.editEntry(gson.toJson(old), "");
        }
    }

    
    ///////////////////////      SUBSCRIPTION HANDLING       ////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Method for retrieving a list of all Subscriptions in the Subscriptions database.
     *
     * @return out              All Subscriptions in the database.
     * @throws DataException
     */
    public List<Subscription> getSubscriptions() throws DataException {
        List<Subscription> out = new ArrayList<>();
        try {
            List<String> jsons = das.getEntries();
            for (String json : jsons) {
                out.add(gson.fromJson(json, Subscription.class));
            }
            return out;
        } catch (DataException e) {
            throw new DataException(e.getMessage());
        }
    }
    
    /**
     * Method for searching for keywords in the Subscription database. Searches the
     * database for all entries with containing the query. * For more precise
     * searches, use the "ATTRIBUTE:"+"String" or "ATTRIBUTE:"+query
     *
     * @param Query     The wanted Query.
     * @return result   All members in the database with maching Attribute.
     * @throws delfinen.data.DataException
     */
    public List<Subscription> searhcSubscriptions(String Query) throws DataException{
        List<String> jsons = das.searchEntries(Query);
        List<Subscription> result= new ArrayList<>();
        for (String json : jsons) {
            result.add(gson.fromJson(json, Subscription.class));
        }
        return result;
    }
    
    /**
     * Method for adding a Subscription to the Subscription database.
     *
     *
     * @param obj Record to be added to the database.
     * @throws delfinen.data.DataException
     */
    public void addSubscription(Subscription obj) throws DataException{
        das.addEntry(gson.toJson(obj));
    }
    
    /**
     * Method for editing a Subscription. Can also be used to remove Subscription.
     * if N is null, removes entry.
     *
     * @param old   The Subscription that you wish to modify.
     * @param N     The Subscription you wish it should be. if null, removes the entry.
     * @throws delfinen.data.DataException
     */
    public void editSubscription(Subscription old,Subscription N) throws DataException{
        das.editEntry(gson.toJson(old), gson.toJson(N));
    }

    public List<Object> customSearch(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
