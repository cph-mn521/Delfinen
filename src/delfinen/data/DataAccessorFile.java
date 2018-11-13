package delfinen.data;
import com.google.gson.Gson;
import delfinen.logic.Member;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin Wulff
 */
public class DataAccessorFile implements DataAccessor {
    private final String FileName;
    //private final String FilePath;
    private FileReader FR;
    private FileWriter FW;
    private Gson gson;
    

    public DataAccessorFile(String FileName){
        this.FileName=FileName;
        //this.FilePath=FilePath;
        this.gson = new Gson();
        try {
            this.FR = new FileReader(FileName);
            this.FW = new FileWriter(FileName);
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
        }
    }
    
    
    /*
    Method for searching a json string for a specifik entry. expecst input to be of string type.
    Will return first member that meets konditions, OBS! might be inacurate when using ID numbers.
    */
    @Override
    public Member getMember(String query) throws DataException{
    String line = null;
    Member bufferMember;
    try {
            BufferedReader bufferedReader = 
                new BufferedReader(FR);

            while((line = bufferedReader.readLine()) != null) {
                if(line.contains(query)){
                    bufferedReader.close(); 
                    return gson.fromJson(line, Member.class);
                }
            }   
            throw new DataException("EntryNotFound!");
            // Always close files.
  

        } catch (IOException ree) {
            System.out.println("Exception: File Not Found.");
            throw new DataException("FileNotFound!");
        }
    };
    
    /*
    @Override
    public Member getMember(int query) throws DataException{
    String line = null;
    try {
            BufferedReader bufferedReader = 
                new BufferedReader(FR);

            while((line = bufferedReader.readLine()) != null) {
                if(line.contains("\"id:\""+query)||line.contains("\"phone\":"+query) ){
                    bufferedReader.close(); 
                    return gson.fromJson(line, Member.class);
                }
            }
            bufferedReader.close(); 
            throw new DataException("EntryNotFound!");
            // Always close files.
  

        } catch (IOException ree) {
            System.out.println("Exception: File Not Found.");
            throw new DataException("FileNotFound!");
        }
    };
    */
   
    @Override
    public void saveMember(Member obj) throws DataException{
        BufferedWriter writer = new BufferedWriter(FW);
        try {
            writer.append(gson.toJson(obj));
            writer.close();
        } catch (IOException ree) {
            throw new DataException("FileNotFound");
        }
        
    };
    
    
   
   
   
}
