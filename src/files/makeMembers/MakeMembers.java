package files.makeMembers;

import delfinen.Controller;
import static delfinen.Controller.DEBUG;
import static delfinen.Controller.findMembers;
import delfinen.data.DataException;
import delfinen.data.PersistanceHandler;
import delfinen.logic.CoachNotFoundException;
import delfinen.logic.CompetitiveMember;
import delfinen.logic.Discipline;
import delfinen.logic.Member;
import delfinen.logic.Record;
import delfinen.presentation.DelfinGUI;
import delfinen.presentation.DelfinGUImethods;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Automatic making of members, as it can be rather cumbersome to do it manually
 *
 * @author martin b.
 */
public class MakeMembers {

    private static PersistanceHandler data = new PersistanceHandler();

    public void go() {
        Controller cont = new Controller();
        DelfinGUI gui = new DelfinGUI();
        DelfinGUImethods guim = new DelfinGUImethods();

    }

    /**
     * Method for retrieving a member by ID from the gui, and editing that
     * member in the filesystem.
     */
    /**
     * Passes a member to the PersistanceHandler, for storing and databasing.
     */
    public void addMember() {
        for (int i = 0; i < 100; i++) {

            // Getting info from guim
            Member newMember = null;
            randomNumbers ran;
            DataFile dat = new DataFile();
            String name = dat.getRandomName();
            System.out.println(name);
            String email = "sammeEmail@delfinen.dk";
            String adress = "Ligustervej 12, 2750 Ligust";
            int id = 0, age = 0, phoneNumber = 0;
            try {
                id = data.getMembers().size() + 1;
                System.out.println("ID: " + id);
            } catch (DataException ex) {
                ex.printStackTrace();
            }
            try {
                ran = new randomNumbers((76));
                age = ran.getRandom();
                System.out.println("Age: " + age);
                ran = new randomNumbers((99999999));
                phoneNumber = ran.getRandom();
                System.out.println("phoneNumber: " + phoneNumber);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            Member.Status status = Member.Status.valueOf("Active");
            boolean isCoach = false;

            //Checking for Member Type, then creating it.
            ArrayList<Discipline> disciplines = new ArrayList<>();
            disciplines.add(Discipline.Brystsvømning);
            disciplines.add(Discipline.Butterfly);
            disciplines.add(Discipline.Crawl);
            disciplines.add(Discipline.Rygcrawl);
            String sCoach = "Lars Emil";
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
                e.printStackTrace();
            }

            try { // Ads member to database.
                data.addMember(newMember);
            } catch (DataException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Klog og indsigtsgivende kommentar der grundtigt beskriver følgende
     * funktion indsættes her.
     */
//    public static void addResult() {
//
//        float time = gui.getNewResultTime();
//        LocalDateTime date = gui.getNewResultDate();
//        Member holder = null;
//        String event = gui.getNewResultEvent();
//        Discipline discipline = gui.getNewResultDiscipline();
//        int place = gui.getNewResultPlace();
//
//        try {
//            for (Member member : data.searchMember(gui.getNavn())) {
//                if (Integer.parseInt(gui.getID()) == member.getId()) {
//                    holder = member;
//
//                    try {
//                        if (Integer.parseInt(gui.getID()) == member.getId()) {
//                            holder = member;
//                        }
//                    } catch (NumberFormatException e) {
//                        guim.displayPlainRed("Kun tal i ID-boksen.\n");
//                    }
//                }
//            }
//            if (holder == null) {
//                guim.displayBoldRed(gui.getNavn() + " er ikke fundet.\n");
//            }
//        } catch (DataException ex) {
//            if (DEBUG) {
//                ex.printStackTrace();
//            }
//        }
//
//        try {
//            data.addRecord(new Record(time, date, holder, event, discipline, place));
//            guim.displayPlainBlack("Resultat oprettet\n");
//        } catch (DataException e) {
//            guim.displayBoldRed("Fejl - Ny resultat ikke oprettet.\n");
//            if (DEBUG) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//}

public static void main(String[] args) {
        new MakeMembers().addMember();
    }
}
