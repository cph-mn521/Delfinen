/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.data;

import delfinen.logic.Member;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin Wulff
 */
public class DataAccessorFile implements DataAccessor {

    private final String FileName;
    
    /*
    Constructor for the class, used to assign the current database.
    
    @param FileName     The File to pull data from.
    */
    public DataAccessorFile(String FileName) {
        this.FileName = FileName;
    }
    
    /*
    Method for retrieving all entries in the current selected txt document. Will not return
    blank entries
    
    @throws DataException.
    */
    @Override
    public List<String> getEntries() throws DataException {
        String line = null;
        List<String> Output = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FileName));
            while ((line = reader.readLine()) != null && line != "") {
                Output.add(line);
            }
            return Output;
        } catch (IOException e) {
            throw new DataException();
        }
    }
    
        /*
    Method for searching for keywords in the database. Searches the
    database for all entries with containing the query.
    
    For more precise searches, knowledge of the data strukture is required.
    
    @param  Query               The wanted Query. 
    @return machingEntries      All entries that contains the query.   
    @throws DataException
    */    
    @Override
    public List<String> searchEntries(String query) throws DataException {
        String line = null;
        List<String> machingEntries = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FileName));
            while ((line = reader.readLine()) != null && line != "") {
                if (line.contains(query)) {
                    machingEntries.add(line);
                }
            }
            return machingEntries;
        } catch (IOException e) {
            throw new DataException();
        }
    }
    
    /*
    Method for adding a new entry to the currently selected file. New entry is
    always appended, and will apear last in the database.
    
    @param  obj The object to add to the database 
    @throws DataException
    */
    @Override
    public void addEntry(String obj) throws DataException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FileName, true));
            writer.newLine();
            writer.write(obj);
            writer.close();
        } catch (IOException e) {
            throw new DataException();
        }
    }
    
    /*
    Method for edeting an entry in the databse. Works by finding the object to 
    change, and then we writing the file to match the new signature.
    Takes 2 parameters, bot of string type.
    
    @param  old     The entry to change.
    @param  N       The changed entry.
    @throws DataException.
    */
    @Override
    public void editEntry(String old, String N) throws DataException {
        try {
            List<String> newFile = getEntries();
            String lines = "";
            BufferedWriter writer = new BufferedWriter(new FileWriter(FileName, false));
            for (String string : newFile) {
                if (string.equals(old)) {
                    lines += N+"\r\n";
                }
                else lines +=string +"\r\n";
            }
            writer.write(lines);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            throw new DataException();
        }
    }
;

}
