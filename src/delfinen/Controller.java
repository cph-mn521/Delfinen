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
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author Niels Bang
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

    /**
     * Passes a list of trainers from data to gui, and initializes the gui.
     */
    public static void init() {
        gui.setTrainedBy(getTrainers());
        gui.setVisible(true);
    }

    /**
     * Queries the PersistanceHandler for a list of trainers.
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
        Member newMember = null;
        String name = gui.getNavn();
        String email = gui.getEmail();
        String adress = gui.getAdresse();
        int id = gui.getID();
        int age = gui.getAlder();
        int phoneNumber = gui.getTelefon();
        Member.Status status = Member.Status.valueOf(gui.getStatus().equals("Aktiv") ? "Active" : "Passive");
        boolean isCoach = gui.getTrainer();

        if (gui.getMotionKonkurrence().equals("Motionist") || gui.getStatus().equals("Passive")) {
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
                    gui.displayBoldRed("Træner ikke fundet.\n");
                    e.printStackTrace();
                    return;
                }
            }
        }
        try {
            data.addMember(newMember);
            gui.displayPlainBlack("Medlem oprettet\n");
        } catch (DataException e) {
            gui.displayBoldRed("Fejl - Medlem ikke oprettet.\n");
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Queries the database for a list of members that fulfill a certain
     * criteria.
     *
     * @param query
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
            gui.displayBoldRed("Ingen medlemmer fundet.\n");
        }
        if (members == null || members.size() < 1) {
            gui.displayBoldRed("Ingen medlemmer fundet.\n");
        }
        return members;
    }
    
    /**
     * 
     */
    public static void search() {
        String regQuery = "\\{";
        ArrayList<Object> Search = new ArrayList<>();
        ArrayList<String> regex  = new ArrayList<>();
        Member.Status status = Member.Status.valueOf(gui.getStatus());
        String aktivitet = gui.getMotionKonkurrence();
        if (aktivitet.equals("Konkurrencesvømmer")) {
            List<Discipline> disciplines = new ArrayList<>();
            for (String s : gui.getDisciplin()) {
                disciplines.add(Discipline.valueOf(s));
            }
            List<Member> trainers = findMembers("\"isCoach\":true");
            String coach = gui.getTrainedBy();
            Member Coach = trainers.get(trainers.indexOf(coach));
            Search.add(disciplines);
            Search.add(Coach);
        }
        String name = gui.getNavn();
        String email = gui.getEmail();
        String address = gui.getAdresse();
        int id = gui.getID();
        int age = gui.getAlder();
        int phone = gui.getTelefon();
        boolean isCoach = gui.getTrainer();
        
        Search.add(name);
        Search.add(email);
        Search.add(address);
        Search.add(id);
        Search.add(age);
        Search.add(phone);
        Search.add(isCoach);
        
        regex.add("(\"disciplines\":(\\[.+\\]),\"coach\":(\\{.+\\}),)?");
        regex.add("\"name\":\"(.+)\",");
        regex.add("\"email\":\"(.+)\",");
        regex.add("\"address\":\"(.+)\",");
        regex.add("\"id\":([0-9]+),");
        regex.add("\"age\":([0-9]+),");
        regex.add("\"phone\":(.+),");
        regex.add("\"status\":\"((?:Active|Passive))\",");
        regex.add("\"isCoach\":((?:true|false))");     
        int i = 0;
        for(Object o : Search){
            
            if(o == null){             
                regQuery +=regex.get(i);
                continue;
            }
            //regQuery += regex.get(i).replace(regex.get(i).substring(regex.get(i).indexOf('('),regex.get(i).indexOf(')')), );
            i++;
        }
        regQuery += "\\}";
        
        List<Object> result = data.customSearch(regQuery);
    }

    public static void change() {

    }
}
