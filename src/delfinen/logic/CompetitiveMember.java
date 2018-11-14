/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

/**
 *
 * @author Lord
 */
import java.util.ArrayList;

public class CompetitiveMember extends Member {

    private ArrayList<Discipline> disciplines = new ArrayList<>();
    private Member coach;

    public CompetitiveMember(String name, String email, String address, int id, int age, int phone, Status status, ArrayList<Discipline> disciplines, Member coach) throws CoachNotFoundException {
        super(name, email, address, id, age, phone, status);
        this.disciplines = disciplines;
        if (!coach.isCoach()) {
            throw new CoachNotFoundException();
        }
        this.coach = coach;
        isCompetitive = true;
    }

    public CompetitiveMember(String name, String email, String address, int id, int age, int phone, Status status, Discipline disciplines, Member coach) throws CoachNotFoundException {
        super(name, email, address, id, age, phone, status);
        this.disciplines.add(disciplines);
        if (!coach.isCoach()) {
            throw new CoachNotFoundException();
        }
        this.coach = coach;
        isCompetitive = true;
    }

    public CompetitiveMember(String name, String email, String address, int id, int age, int phone, Status status, Member coach) throws CoachNotFoundException {
        super(name, email, address, id, age, phone, status);
        disciplines = null;
        if (!coach.isCoach()) {
            throw new CoachNotFoundException();
        }
        this.coach = coach;
        isCompetitive = true;

    }

    public Member getCoach() {
        return coach;
    }

    public void setCoach(Member coach) {
        this.coach = coach;
    }

    public void addDiscipline(Discipline discipline) {
        disciplines.add(discipline);
    }

    public void removeDiscipline(Discipline discipline) throws DisciplineNotFoundException {
        if (disciplines.contains(discipline)) {
            disciplines.remove(discipline);
        } else {
            throw new DisciplineNotFoundException();
        }
    }

    public Member changeMembership() {
        if (this.isCoach()) {
            return new Member(this.getName(), this.getEmail(), this.getAddress(), this.getId(), this.getAge(), this.getPhone(), this.getStatus(), true);
        } else {
            return new Member(this.getName(), this.getEmail(), this.getAddress(), this.getId(), this.getAge(), this.getPhone(), this.getStatus());
        }
    }

}
