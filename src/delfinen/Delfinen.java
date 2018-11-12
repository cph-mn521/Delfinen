package delfinen;

import io.IOtest;
import java.io.IOException;

/**
 *
 * @author Martin Wulff
 */
public class Delfinen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Delfinen().go();
    }

    public void go() {
        IOtest io = new IOtest();
        for (String string : io.readFile("medlemmer.csv")) {
            System.out.println(string);
        }
        
        try {
            io.replaceSelected("medlemmer.csv", "Lars Emil", "Emil Lars");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
