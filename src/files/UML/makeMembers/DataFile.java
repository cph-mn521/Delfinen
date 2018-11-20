package files.UML.makeMembers;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

public class DataFile {

    private String file;
    private ArrayList<String> fileContent = new ArrayList<>();

    public DataFile() {
    }


    public ArrayList<String> getFileContent() {
        BufferedReader reader = null;
        fileContent = null;
        try {
            reader = new BufferedReader(new FileReader(file));
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

    public String getRandomName() {
        randomNumbers rand;
        file = "test/testMakeDBFiles/forenames.txt";
        int k = getFileContent().size();
        rand = new randomNumbers(k);
        String foreName = getFileContent().get(rand.getRandom()) + " ";

        file = "test/testMakeDBFiles/surnames.txt";
        k = getFileContent().size();
        rand = new randomNumbers(k);
        String surname = getFileContent().get(rand.getRandom()) + " ";

        return foreName + " " + surname;
    }


}
