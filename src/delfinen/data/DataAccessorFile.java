/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.data;
import delfinen.logic.Member;
import java.io.*;
/**
 *
 * @author Martin Wulff
 */
public class DataAccessorFile implements DataAccessor {
    private final String FileName;
    //private final String FilePath;
    private FileReader FR;
    
    
    
    public DataAccessorFile(String FileName){
        this.FileName=FileName;
        //this.FilePath=FilePath;
        try {
            this.FR = new FileReader(FileName);
        } catch (Exception e) {
            System.out.println("Exception: File Not Found.");
        }
        
    }
    // Methods for getting members from a txt database.
    public List<Member>  getMembers() throws DataException{
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(FileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            // Always close files.
            bufferedReader.close();         
        } catch (Exception e) {
            System.out.println("Exception: File Not Found.");
        }
    }
    
    
    public Member getMember() throws DataException{
    return null;
    };
   
   
    public void saveMember() throws DataException{
    
    };
    
    
   
   
   
}
