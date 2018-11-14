package delfinen;

import delfinen.presentation.DelfinGUI;
import delfinen.data.PersistanceHandler;
import delfinen.data.DataException;
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

    public static void main(String[] args) {
        gui.setVisible(true);

    }
    
    public static void init(){
        
        
    }

    public static void addMember() {
        String name = gui.getNavn();
        String email = gui.getEmail();
        String adress = gui.getAdresse();
        int id = gui.getID();
        int age = gui.getAlder();
        int phoneNumber = gui.getTelefon();
        Member.Status status = Member.Status.valueOf(gui.getStatus().equals("Aktiv") ? "Active" : "Passive");
        boolean isCoach = gui.getTrainer();

        if (gui.getMotionKonkurrence().equals("Motion")) {
            Member newMember = new Member(name, email, adress, id, age, phoneNumber, status, isCoach);
        } else{
            ArrayList<Discipline> disciplines = new ArrayList<>();
            for (String s: gui.getDisciplin()) {
                disciplines.add(Discipline.valueOf(s));
            }
            
            
            
            CompetitiveMember newMember = new CompetitiveMember(name, email, adress, id, age, phoneNumber, status, disciplines, isCoach ,coach);
        }
        
               
        try {
            data.addMember(new Member(name, email, adress, id, age, phoneNumber, status));
            gui.displayPlainBlack("Medlem oprættet\n");
        } catch (DataException e) {
            e.printStackTrace();
            gui.displayBoldRed("Fejl - Medlem ikke oprættet.");
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
}
