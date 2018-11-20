package files.makeMembers;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;

public class DataFile {

    private String file;
    private ArrayList<String> fileContent = new ArrayList<>();

    public DataFile() {
    }

    public ArrayList<String> getFileContent() {
        BufferedReader reader = null;
        fileContent.clear();
        try {
            File fil = new File(file);
            reader = new BufferedReader(new FileReader(fil));
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                String name = line.trim();
                if (name == null || name.isEmpty()) {
                    throw new IOException("Unable to read name!");
                }
                fileContent.add(name);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileContent;
    }

    public int memberNumbersSize(){
        file = "Members.txt";
        return getFileContent().size();
    }
    
    public String getMemberName(int memberNumber) {

        file = "Members.txt";
        int k = getFileContent().size();
        if (memberNumber>k){
            k=memberNumber;
        }
        String name = getFileContent().get(memberNumber);
        return name;
    }

    public String getRandomName() {
        randomNumbers rand;
        file = "src/files/makeMembers/forenames.txt";
        int k = getFileContent().size();
        rand = new randomNumbers(k - 1);
        String foreName = getFileContent().get(rand.getRandom());

        file = "src/files/makeMembers/surnames.txt";
        k = getFileContent().size();
        rand = new randomNumbers(k - 1);
        String surname = getFileContent().get(rand.getRandom());

        return foreName + " " + surname;
    }

    public String getRandomPlace() {
        randomNumbers rand;
        file = "src/files/makeMembers/place.txt";
        int k = getFileContent().size();
        rand = new randomNumbers(k - 1);

        return getFileContent().get(rand.getRandom());
    }
}
