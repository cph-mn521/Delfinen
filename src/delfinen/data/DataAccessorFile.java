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

    public DataAccessorFile(String FileName) {
        this.FileName = FileName;
    }

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

    @Override
    public List<String> searchEntries(String query) throws DataException {
        String line = null;
        List<String> Output = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FileName));
            while ((line = reader.readLine()) != null ) {
                if (line.contains(query)) {
                    Output.add(line);
                }
            }
            return Output;
        } catch (IOException e) {
            throw new DataException();
        }
    }

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
