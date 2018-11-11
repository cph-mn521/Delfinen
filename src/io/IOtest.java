package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author martin
 */
public class IOtest {

    public void writeFile(String pathFile, String content) {
        File fileToBeModified = new File(pathFile);
        try {
            FileWriter writer = new FileWriter(fileToBeModified);
            writer.write(content);
            writer.close();
        } catch (IOException ex) {
            System.out.println("7. " + ex);
        }
        ;
    }

    public ArrayList<String> readFile(String pathFile) {
        ArrayList<String> fileContent = new ArrayList<>();
        File fileToBeModified = new File(pathFile);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String lines = reader.readLine();
            while (lines != null) {
                fileContent.add(lines);
                lines = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("5. " + ex);
        } catch (IOException ex) {
            System.out.println("6. " + ex);
        }
        return fileContent;
    }

    public void replaceSelected(String filePath, String query, String newString) throws FileNotFoundException, IOException {
        String oldContent = "";
        BufferedReader reader = null;
        String lines = "";
        String nl = System.lineSeparator();

        File fileToBeModified = new File(filePath);
        reader = new BufferedReader(new FileReader(fileToBeModified));

        //Reading all the lines of input text file into oldContent
        lines = reader.readLine();
        while (lines != null) {
            String[] str = lines.split(",");
            if (str[0].equals(query)) {
                lines = str[0] + newString + nl;
            }
            oldContent = oldContent + lines + nl;
            try {
                lines = reader.readLine();
            } catch (IOException ex) {
                System.out.println("3. " + ex);
            }
        }

        writeFile(filePath, oldContent);
        try {
            //Closing the resources
            reader.close();
        } catch (IOException e) {
            System.out.println("4. " + e);
        }
    }
}
