package delfinen;

import delfinen.presentation.DelfinGUI;
import delfinen.data.PersistanceHandler;
import delfinen.data.DataException;
import delfinen.logic.CoachNotFoundException;
import delfinen.logic.Member;
import delfinen.logic.CompetitiveMember;
import delfinen.logic.Discipline;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Martin Wulff
 */
public class Controller {

    /**
     * @param args the command line arguments
     */
    private static DelfinGUI gui = new DelfinGUI();
    private static PersistanceHandler data = new PersistanceHandler();
    private static boolean DEBUG = true;

    public static void main(String[] args) {
        init();
    }

    public static void init() {
        gui.setVisible(true);
    }

    public List<String> getTrainers(){
    List<String> trainers = new ArrayList<>();
        List<Member> buffer = findMembers("\"isCoach\":true");
        
        if(buffer == null || buffer.size() < 1){
            trainers.add("Ingen trænere i systemet.");
        }
        for (Member m : buffer) {
            trainers.add(m.getName());
        }
      
        return trainers;
    }
    
    public static void addMember() {
        Member newMember = null;
        String name = gui.getNavn();
        String email = gui.getEmail();
        String adress = gui.getAdresse();
        int id = gui.getID();
        int age = gui.getAlder();
        int phoneNumber = gui.getTelefon();
        Member.Status status = Member.Status.valueOf(gui.getStatus().equals("Aktiv") ? "Active" : "Passive");
        boolean isCoach = gui.getTrainer();

        if (gui.getMotionKonkurrence().equals("Motionist")) {
            newMember = new Member(name, email, adress, id, age, phoneNumber, status, isCoach);
        } else {
            ArrayList<Discipline> disciplines = new ArrayList<>();
            for (String s : gui.getDisciplin()) {
                disciplines.add(Discipline.valueOf(s));
            }
            String sCoach = gui.getTrainedBy();
            Member coach = null;

            for (Member m : findMembers("\"isCoach\":true")) {
                if (m.getName().equals(sCoach)) {
                    coach = m;
                    break;
                }
            }
            try {
                newMember = new CompetitiveMember(name, email, adress, id, age, phoneNumber, status, disciplines, isCoach, coach);
            } catch (CoachNotFoundException e) {
                if (DEBUG) {
                    gui.displayBoldRed("Træner ikke fundet.");
                    e.printStackTrace();
                    return;
                }
            }
        }
        try {
            data.addMember(newMember);
            gui.displayPlainBlack("Medlem oprettet\n");
        } catch (DataException e) {
            gui.displayBoldRed("Fejl - Medlem ikke oprettet.");
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public static List<Member> findMembers(String query) {
        List<Member> members = new ArrayList<>();
        try {
            members = data.searchMember(query);
        } catch (DataException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            gui.displayBoldRed("Ingen medlemmer fundet.");
        }
        if (members == null || members.size() < 1) {
            gui.displayBoldRed("Ingen medlemmer fundet.");            
        }
        return members;
    }
}
