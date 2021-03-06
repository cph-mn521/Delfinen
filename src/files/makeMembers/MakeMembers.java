package files.makeMembers;

import static delfinen.Controller.findMembers;
import delfinen.data.DataException;
import delfinen.data.PersistanceHandler;
import delfinen.logic.CoachNotFoundException;
import delfinen.logic.CompetitiveMember;
import delfinen.logic.Discipline;
import delfinen.logic.Member;
import delfinen.logic.Record;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        addMember("Hans Egen", "hans_egen@delfinen.dk", "Ligustervej 99, 2956 Ligust", "Lars Emil", 35, 25257890, false);
        for (int i = 0; i < 25; i++) {
            addMember("", "", "", "", 0, 0, false);
        }
    }

    /**
     * modified addMember from Controller. Used to add 1 member with random
     * names and info if needed
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
            email = name.replace(" ", "_") + "@delfinen.dk";
        }
        if (address.equals("")) {
            address = "Ligustervej " + houseNumber + ", 2750 Ligust";
        }
        int id = 0;
        try {
            id = data.getMembers().size();
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
            newMember = new Member(name, email, address, id, age, phoneNumber, status, isCoach);
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
        for (int i = 0; i < dat.memberNumbersSize() - 1; i++) { //
            LocalDateTime date = LocalDateTime.now();
            Member holder = null;
            String event = dat.getRandomPlace();

            String name = dat.getMemberName(i);
            Pattern pattern = Pattern.compile("(^\\{\"name\":\".+\",\"email\")|(,\"name\":\".+\",\"email\")");
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                System.out.println(matcher.group(0) + "\t" + matcher.group(1) + "\t" + matcher.group(2));
                String regexName[] = matcher.group().split("\"name\":\"");
                System.out.println(regexName[1]);
                String regexName2[] = regexName[1].split("\",\"email\"");
                System.out.println(regexName2[0]);
                String k = regexName2[0];
                try {
                    for (Member member : data.searchMember(k)) {
                        if (member != null || k.equals(member.getName())) {
                            holder = member;
                            break;
                        }
                    }

                } catch (DataException e) {
                    e.printStackTrace();
                }
                try {
                    ran = new randomNumbers((50));
                    float time = ran.getRandomFloat();
                    ran = new randomNumbers((15));
                    int place = ran.getRandom();
                    data.addRecord(new Record(time, date, holder, event, Discipline.Brystsvømning, place));

                    ran = new randomNumbers((50));
                    time = ran.getRandomFloat();
                    ran = new randomNumbers((15));
                    place = ran.getRandom();
                    data.addRecord(new Record(time, date, holder, event, Discipline.Butterfly, place));

                    ran = new randomNumbers((50));
                    time = ran.getRandomFloat();
                    ran = new randomNumbers((15));
                    place = ran.getRandom();
                    data.addRecord(new Record(time, date, holder, event, Discipline.Crawl, place));

                    ran = new randomNumbers((50));
                    time = ran.getRandomFloat();
                    ran = new randomNumbers((15));
                    place = ran.getRandom();
                    data.addRecord(new Record(time, date, holder, event, Discipline.Rygcrawl, place));
                } catch (DataException dataException) {
                }
            } else {
                System.out.println("No name found");
            }
        }
    }

    public static void main(String[] args) {
        new MakeMembers().fillMemberFile();
        new MakeMembers().addResult();
    }
}
