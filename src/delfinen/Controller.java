package delfinen;

import delfinen.presentation.DelfinGUI;
import delfinen.presentation.DelfinGUImethods;
import delfinen.data.PersistanceHandler;
import delfinen.data.DataException;
import delfinen.logic.CoachNotFoundException;
import delfinen.logic.Member;
import delfinen.logic.CompetitiveMember;
import delfinen.logic.Discipline;
import delfinen.logic.Accountant;
import delfinen.logic.Record;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Niels Bang
 * @author addResults martin b.
 */
public class Controller {

    /**
     * @param args the command line arguments
     */
    private static DelfinGUI gui = new DelfinGUI();
    private static DelfinGUImethods guim = new DelfinGUImethods();

    private static PersistanceHandler data = new PersistanceHandler();
    public static boolean DEBUG = true;

    public static void main(String[] args) {
        init();
    }

    /**
     * Passes a list of trainers from data to guim, and activates the guim.
     */
    public static void init() {
        gui.setTrainedBy(getTrainers());
        gui.setVisible(true);

    }

    /**
     * Queries the PersistanceHandler for a list of trainers.
     *
     * @return
     */
    public static List<String> getTrainers() {
        List<String> trainers = new ArrayList<>();
        List<Member> buffer = findMembers("\"isCoach\":true");
        if (buffer == null || buffer.size() < 1) {
            trainers.add("Ingen trænere i systemet.");
        }
        for (Member m : buffer) {
            trainers.add(m.getName());
        }
        return trainers;
    }

    /**
     * Passes a member to the PersistanceHandler, for storing and databasing.
     */
    public static void addMember() {
        // Getting info from guim
        Member newMember = null;
        String name = strFormatter(gui.getNavn());
        String email = strFormatter(gui.getEmail());
        String adress = strFormatter(gui.getAdresse());
        int id, age, phoneNumber;
        try {
            id = Integer.parseInt(gui.getID());
            age = Integer.parseInt(gui.getAlder());
            phoneNumber = Integer.parseInt(gui.getTelefon());
        } catch (NumberFormatException e) {
            guim.displayBoldRed("Fejl i indtastningerne!");
            if (DEBUG) {
                e.printStackTrace();
            }
            return;
        }
        Member.Status status = Member.Status.valueOf(gui.getStatus());
        boolean isCoach = gui.getTrainer();

        //Checking for Member Type, then creating it.
        if (gui.getMotionKonkurrence().equals("Motionist")) {
            newMember = new Member(name, email, adress, id, age, phoneNumber, status, isCoach);
        } else {
            ArrayList<Discipline> disciplines = new ArrayList<>();
            for (String s : gui.getDisciplin()) {
                disciplines.add(Discipline.valueOf(s));
            }
            String sCoach = gui.getTrainedBy();
            Member coach = null;
            //Coach Check.
            for (Member m : findMembers("\"isCoach\":true")) {
                if (m.getName().equals(sCoach)) {
                    coach = m;
                    break;
                }
            }
            try {
                //Creating a competetive member.
                newMember = new CompetitiveMember(name, email, adress, id, age, phoneNumber, status, disciplines, isCoach, coach);
            } catch (CoachNotFoundException e) {
                if (DEBUG) {
                    guim.displayBoldRed("Træner ikke fundet.\n");
                    e.printStackTrace();
                    return;
                }
            }
        }
        try { // Ads member to database.
            data.addMember(newMember);
            guim.displayPlainBlack("Medlem oprettet\n");
        } catch (DataException e) {
            guim.displayBoldRed("Fejl - Medlem ikke oprettet.\n");
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Queries the database for a list of members that fulfill a certain
     * criteria.
     *
     * @param query criteria to fulfill.
     * @return
     */
    public static List<Member> findMembers(String query) {
        List<Member> members = new ArrayList<>();
        try {
            members = data.searchMember(query);
        } catch (DataException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            guim.displayBoldRed("Ingen medlemmer fundet.\n");
        }
        if (members == null || members.size() < 1) {
            guim.displayBoldRed("Ingen medlemmer fundet.\n");
        }
        return members;
    }

    /**
     * A method for creating an array with information to be searched for. Takes
     * information from the gui, and passes it to the PersistanceHandler for a
     * fuzzy search in the filesystem. If there's any results this method
     * handles passing information about the results to the gui.
     */
    public static void search() {
        ArrayList<String> Search = new ArrayList<>();
        List<Member> result = new ArrayList<>();
        Member Coach = null;
        List<String> disciplines = null;
        String status = gui.getStatus();
        String aktivitet = gui.getMotionKonkurrence();

        if (aktivitet.equals("Konkurrencesvømmer")) {
            disciplines = gui.getDisciplin();
            List<Member> trainers = findMembers("\"isCoach\":true");
            String coach = gui.getTrainedBy();
            Coach = trainers.get(trainers.indexOf(coach));
        }

        String name = gui.getNavn();
        String email = gui.getEmail();
        String address = gui.getAdresse();
        String isCoach = gui.getTrainer() + "";
        Search.add(strFormatter(name));
        Search.add(strFormatter(email));
        Search.add(strFormatter(address));
        Search.add(gui.getID());
        Search.add(gui.getAlder());
        Search.add(gui.getTelefon());
        Search.add(status);
        Search.add(isCoach);

        try {
            result = data.searchMember(Search, disciplines, Coach);
        } catch (DataException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            guim.displayPlainRed("Fejl - Ingen medlemmer fundet.\n");
        }
        if (result == null || result.isEmpty()) {
            guim.displayPlainRed("Fejl - Ingen medlemmer fundet.\n");
        } else {
            for (Member m : result) {
                if (result.size() == 1) {
                    gui.setAdresse(m.getAddress());
                    gui.setAlder(m.getAge());
                    gui.setEmail(m.getEmail());
                    gui.setNavn(m.getName());
                    gui.setID(m.getId());
                    gui.setTelefon(m.getPhone());
                    try { // write records for searched member
                        if (data.searchRecord(m.getName()).size() > 0) {
                            guim.displayBoldBlack("Disciplin: \tTid: \tDato: \t\tStævne: \t\tPlacering: \n");
                            for (Record rec : data.searchRecord(m.getName())) {
                                guim.displayPlainBlue(rec.toString() + '\n');
                            }
                            guim.displayPlainBlack("\n");
                        } else{
                            guim.displayPlainBlack("Ingen resultater.");
                        }
                    } catch (DataException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    guim.displayPlainBlack(m.toString() + '\n');
                }
            }
        }
    }

    /**
     * Method for retrieving a member by ID from the gui, and editing that
     * member in the filesystem.
     */
    public static void change() {
        List<Member> members = findMembers(",\"id\":" + gui.getID() + ",");
        Member old = null;
        if (members == null || members.size() > 1) {

        } else {
            old = members.get(0);
        }

        int id, age, phone;
        try {
            id = Integer.parseInt(gui.getID());
            age = Integer.parseInt(gui.getAlder());
            phone = Integer.parseInt(gui.getTelefon());
        } catch (NumberFormatException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            guim.displayPlainRed("Fejl i indtastet data! - Prøv igen.\n");
            return;
        }
        Member.Status status = Member.Status.valueOf(gui.getStatus());
        Member N = new Member(gui.getNavn(), gui.getEmail(), gui.getAdresse(), id, age, phone, status, gui.getTrainer());

        try {
            data.editMember(old, N);
        } catch (DataException e) {
            if (DEBUG) {
                e.printStackTrace();
                guim.displayPlainRed("Medlem ikke fundet! - Prøv igen. \n");
            }
        }
    }

    /**
     * Klog og indsigtsgivende kommentar der grundtigt beskriver følgende
     * funktion indsættes her.
     */
    public static void addResult() {

        float time = gui.getNewResultTime();
        LocalDateTime date = gui.getNewResultDate();
        Member holder = null;
        String event = gui.getNewResultEvent();
        Discipline discipline = gui.getNewResultDiscipline();
        int place = gui.getNewResultPlace();

        try {
            for (Member member : data.searchMember(gui.getNavn())) {
                if (Integer.parseInt(gui.getID()) == member.getId()) {
                    holder = member;

                    try {
                        if (Integer.parseInt(gui.getID()) == member.getId()) {
                            holder = member;
                        }
                    } catch (NumberFormatException e) {
                        guim.displayPlainRed("Kun tal i ID-boksen.\n");
                    }
                }
            }
            if (holder == null) {
                guim.displayBoldRed(gui.getNavn() + " er ikke fundet.\n");
            }
        } catch (DataException ex) {
            if (DEBUG) {
                ex.printStackTrace();
            }
        }

        try {
            data.addRecord(new Record(time, date, holder, event, discipline, place));
            guim.displayPlainBlack("Resultat oprettet\n");
        } catch (DataException e) {
            guim.displayBoldRed("Fejl - Ny resultat ikke oprettet.\n");
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method for formatting Strings to a known format. Takes a string and
     * capitalizes the first letter of every word.
     *
     * @param str The String to be formattet.
     * @return The formatted String.
     */
    static String strFormatter(String str) {
        // Create a char array of given String
        char ch[] = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {

            // If first character of a word is found
            if (i == 0 && ch[i] != ' '
                    || ch[i] != ' ' && ch[i - 1] == ' ') {

                // If it is in lower-case
                if (ch[i] >= 'a' && ch[i] <= 'z') {

                    // Convert into Upper-case
                    ch[i] = (char) (ch[i] - 'a' + 'A');
                }
            } // If apart from first character
            // Any one is in Upper-case
            else if (ch[i] >= 'A' && ch[i] <= 'Z') // Convert into Lower-Case
            {
                ch[i] = (char) (ch[i] + 'a' - 'A');
            }
        }
        // Convert the char array to equivalent String
        String st = new String(ch);
        return st;
    }

    public static void bookKeeping(int Year) {
        try {
            Accountant Acc = new Accountant(data.searhcSubscriptions(Integer.toString(Year)), data.getMembers());
            // Add guim plug inn here.
        } catch (DataException e) {

        }
    }
}
