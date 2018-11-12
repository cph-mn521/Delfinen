/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.data;
import com.google.gson.Gson;
import delfinen.logic.Member;
import java.io.*;
import java.util.List;

/**
 *
 * @author Martin Wulff
 */
public class DataAccessorFile implements DataAccessor {
    private final String FileName;
    //private final String FilePath;
    private FileReader FR;
    private Gson gson;
    

    public DataAccessorFile(String FileName){
        this.FileName=FileName;
        //this.FilePath=FilePath;
        this.gson = new Gson();
        try {
            this.FR = new FileReader(FileName);
        } catch (Exception e) {
            System.out.println("Exception: File Not Found.");
        }
        
    }
    // Methods for getting members from a txt database.
    @Override
    public List<Member>  getMembers() throws DataException{
        String line = null;
        List<Member> Output = new ArrayList<>();
        try {
            BufferedReader bufferedReader = 
                new BufferedReader(FR);

            while((line = bufferedReader.readLine()) != null) {
                Output.add(gson.fromJson(line, Member.class));
            }   
            
            // Always close files.
            bufferedReader.close();   
            return Output;
        } catch (Exception e) {
            System.out.println("Exception: File Not Found.");
            throw new DataException("FileNotFound!");
            return null;
        }
    }
    
    @Override
    public Member getMember() throws DataException{
    return null;
    };
   
    @Override
    public void saveMember() throws DataException{
    
    };
    
    
   
   
   
}
