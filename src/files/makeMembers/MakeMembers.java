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

    private DataFile dat = new DataFile();
    private randomNumbers ran;
    private static PersistanceHandler data = new PersistanceHandler();

    /**
     *
     *
     */
    public void fillMemberFile() {
        // Add Lars Emil. There has to be at least one trainer
        addMember("Lars Emil", "le@delfinen.dk", "Ligustervej 23, 2956 Ligust", "", 23, 25254545, true);
        for (int i = 0; i < 200; i++) {
            addMember("", "", "", "", 0, 0, false);
        }
    }

    /**
     * modified addMember from Controller. Used to add 100 members with random
     * names and info
     */
    public void addMember(String name, String email, String address, String sCoach, int age,
            int phoneNumber, boolean isCoach) {

        // Getting info from guim
        Member newMember = null;
        if (name.equals("")) {
            name = dat.getRandomName();
        }
        System.out.println(name);
        ran = new randomNumbers((76));
        int houseNumber = ran.getRandom();
        if (email.equals("")) {
            email = name + "@delfinen.dk";
        }
        if (address.equals("")) {
            address = "Ligustervej " + houseNumber + ", 2750 Ligust";
        }
        int id=0;
        try {
            id = data.getMembers().size() + 1;
            System.out.println("ID: " + id);
        } catch (DataException ex) {
            ex.printStackTrace();
        }
        try {
            if (age == 0) {
                ran = new randomNumbers((76));
                age = ran.getRandom();
            }
            System.out.println("Age: " + age);
            if (phoneNumber == 0) {
                ran = new randomNumbers((99999999));
                phoneNumber = ran.getRandom();
            }
            System.out.println("phoneNumber: " + phoneNumber);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Member.Status status = Member.Status.valueOf("Active");
        //Checking for Member Type, then creating it.
        ArrayList<Discipline> disciplines = new ArrayList<>();
        disciplines.add(Discipline.Brystsvømning);
        disciplines.add(Discipline.Butterfly);
        disciplines.add(Discipline.Crawl);
        disciplines.add(Discipline.Rygcrawl);
        if (sCoach.equals("")) {
            sCoach = "Lars Emil";
        }
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
            newMember = new CompetitiveMember(name, email, address, id, age, phoneNumber, status, disciplines, isCoach, coach);
        } catch (CoachNotFoundException e) {
            e.printStackTrace();
        }

        try { // Ads member to database.
            data.addMember(newMember);
        } catch (DataException e) {
            e.printStackTrace();
        }

    }

    /**
     * Klog og indsigtsgivende kommentar der grundtigt beskriver følgende
     * funktion indsættes her.
     */
    public void addResult() {
        for (int i = 0; i < dat.memberNumbersSize() - 1; i++) {
            ran = new randomNumbers((5));
            float time = ran.getRandomFloat();
            LocalDateTime date = LocalDateTime.now();
            Member holder = null;
            String event = dat.getRandomPlace();
            ran = new randomNumbers((15));
            int place = ran.getRandom();

            try {
                String name = dat.getMemberName(i);
                while (name == "") {
                    try {
                        name = dat.getMemberName(i++);
                    } catch (Exception e) {

                        e.printStackTrace();
                    }

                }
                for (Member member : data.searchMember(name)) {
                    if (member.getName().equals(name)) {
                        holder = member;
                    }
                }

            } catch (DataException ex) {
                ex.printStackTrace();
            }

            try {
                Discipline discipline = Discipline.Brystsvømning;
                data.addRecord(new Record(time, date, holder, event, discipline, place));
                discipline = Discipline.Butterfly;
                data.addRecord(new Record(time, date, holder, event, discipline, place));
                discipline = Discipline.Crawl;
                data.addRecord(new Record(time, date, holder, event, discipline, place));
                discipline = Discipline.Rygcrawl;
                data.addRecord(new Record(time, date, holder, event, discipline, place));
            } catch (DataException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MakeMembers().fillMemberFile();
//        new MakeMembers().addResult();
    }
}
