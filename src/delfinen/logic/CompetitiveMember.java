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
import java.util.Objects;

public class CompetitiveMember extends Member {
    private ArrayList<Discipline> disciplines;
    private Member coach;
    
    
    public CompetitiveMember(String name, String email, String adresse, int id, int age, int phone, Status status,ArrayList<Discipline> disciplines, Member coach) {
        super(name, email, adresse, id, age, phone, status);
        this.disciplines = disciplines;
        this.coach = coach;
    }
    
    public CompetitiveMember(String name, String email, String adresse, int id, int age, int phone, Status status,Discipline disciplines, Member coach) {
        super(name, email, adresse, id, age, phone, status);
        this.disciplines.add(disciplines);
        this.coach = coach;
    }
    public CompetitiveMember(String name, String email, String adresse, int id, int age, int phone, Status status, Member coach) {
        super(name, email, adresse, id, age, phone, status);
        disciplines = null;
        this.coach = coach;
    }

    public Member getCoach() {
        return coach;
    }

    public void setCoach(Member coach) {
        this.coach = coach;
    }
 
    public void addDiscipline(Discipline discipline){
        disciplines.add(discipline);
    }
    
    public void removeDiscipline(Discipline discipline)throws DisciplineNotFoundException{
        if(disciplines.contains(discipline))
            disciplines.remove(discipline);
        else
            throw new DisciplineNotFoundException();
    }
 
    
    public Member changeMembership() {
        return new Member(this.getName(), this.getEmail(), this.getAdress(), this.getId(), this.getAge(), this.getPhone(), this.getStatus());
    }

}
