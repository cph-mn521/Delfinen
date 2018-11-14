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
    private static boolean DEBUG = false;

    public static void main(String[] args) {
        gui.setVisible(true);

    }

    public static void init() {
        gui.setTrainedBy(findMembers("\"isCoach\":true\""));
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

        if (gui.getMotionKonkurrence().equals("Motion")) {
            newMember = new Member(name, email, adress, id, age, phoneNumber, status, isCoach);
        } else {
            ArrayList<Discipline> disciplines = new ArrayList<>();
            for (String s : gui.getDisciplin()) {
                disciplines.add(Discipline.valueOf(s));
            }
            String sCoach = gui.getTrainedBy();
            Member coach = null;
            
            for (Member m : findMembers("\"isCoach\":true\"")) {
                if (m.getName().equals(sCoach)){
                    coach = m;
                    break;
                }
            }
            try {
                newMember = new CompetitiveMember(name, email, adress, id, age, phoneNumber, status, disciplines, isCoach, coach);
            } catch (CoachNotFoundException e) {
                if (DEBUG) {
                    e.printStackTrace();
                    gui.displayBoldRed("Trainer not found.");
                }
            }

            try {
                data.addMember(newMember);
                gui.displayPlainBlack("Medlem oprættet\n");
            } catch (DataException e) {
                e.printStackTrace();
                gui.displayBoldRed("Fejl - Medlem ikke oprættet.");
            }
        }        
    }
        /*    
    public static List<Member> getMembers() {
        try {
            return data.getMembers();
        } catch (DataException e) {

        }

    }
         */
    public static List<Member> findMembers(String query) {
        List<Member> members = new ArrayList<>();
        try {
            members = data.searchMember(query);
        } catch (DataException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            gui.displayBoldRed("No members found.");
        }
        return members;
    }

}
