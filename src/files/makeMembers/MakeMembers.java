package files.makeMembers;

/**
 * Automatic making of members, as it can be rather cumbersome to do it manually
 *
 * @author martin b.
 */
public class MakeMembers {

    public void go() {

        DataFile dat = new DataFile();
        System.out.println(dat.getRandomName());
    }
    public static void main(String[] args) {
        new MakeMembers().go();
    }
}
