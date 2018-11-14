/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

/**
 *
 * @author Lord
 * @comentator Wulff
 */
import java.util.ArrayList;

public class CompetitiveMember extends Member {

    private ArrayList<Discipline> disciplines = new ArrayList<>();
    private Member coach;
    
    ///////////////////////      CONSTRUCTORS       ///////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    
    /**
     * OVERLOADED
     * Constructor for CompetitiveMember with multiple disciplines.
     * @param name
     * @param email
     * @param address
     * @param id
     * @param age
     * @param phone
     * @param status
     * @param disciplines
     * @param coach
     * @throws CoachNotFoundException 
     */
    public CompetitiveMember(String name, String email, String address, int id, int age, int phone, Status status, ArrayList<Discipline> disciplines, Member coach) throws CoachNotFoundException {
        super(name, email, address, id, age, phone, status);
        this.disciplines = disciplines;
        if (!coach.isCoach()) {
            throw new CoachNotFoundException();
        }
        this.coach = coach;
    }
 
    /**
     * OVERLOADED
     * Constructor for CompetitiveMember with multiple disciplines. who is also a coach.
     * @param name
     * @param email
     * @param address
     * @param id
     * @param age
     * @param phone
     * @param status
     * @param disciplines
     * @param isCoach
     * @param coach
     * @throws CoachNotFoundException 
     */
    public CompetitiveMember(String name, String email, String address, int id, int age, int phone, Status status, ArrayList<Discipline> disciplines, boolean isCoach,Member coach) throws CoachNotFoundException {
        super(name, email, address, id, age, phone, status, isCoach);
        this.disciplines = disciplines;
        if (coach == null || !coach.isCoach()) {
            throw new CoachNotFoundException();
        }
        this.coach = coach;
    }
    
    /**
     * OVERLOADED
     * Constructor for CompetitiveMember with single discipline.
     * @param name
     * @param email
     * @param address
     * @param id
     * @param age
     * @param phone
     * @param status
     * @param disciplines
     * @param coach
     * @throws CoachNotFoundException 
     */
    public CompetitiveMember(String name, String email, String address, int id, int age, int phone, Status status, Discipline disciplines, Member coach) throws CoachNotFoundException {
        super(name, email, address, id, age, phone, status);
        this.disciplines.add(disciplines);
        if (!coach.isCoach()) {
            throw new CoachNotFoundException();
        }
        this.coach = coach;       
    }
    
    /** 
     * OVERLOADED
     * Constructor for CompetitiveMember with single discipline. who is also a coach.
     * @param name
     * @param email
     * @param address
     * @param id
     * @param age
     * @param phone
     * @param status
     * @param coach
     * @throws CoachNotFoundException 
     */
    public CompetitiveMember(String name, String email, String address, int id, int age, int phone, Status status, Member coach) throws CoachNotFoundException {
        super(name, email, address, id, age, phone, status);
        disciplines = null;
        if (!coach.isCoach()) {
            throw new CoachNotFoundException();
        }
        this.coach = coach;

    }

    
    ///////////////////////      GETTERS & SETTERS       ///////////////////////
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * Getter for returning the coach of this member.
     * @return  Member
     */
    public Member getCoach() {
        return coach;
    }
    
    /**
     * Setter for coach field.
     * @param coach     Member with coach status. 
     */
    public void setCoach(Member coach) {
        this.coach = coach;
    }
    
    /**
     * Mutator for discipline. adds input to list of current disciplines.
     * @param discipline    Enum. The discipline to begin competing in.
     * @throws DisciplineException  If discipline does not exist.
     */
    public void addDiscipline(Discipline discipline) throws DisciplineException {
        if (!disciplines.contains(discipline)) {
            disciplines.add(discipline);
        } else {
            throw new DisciplineException("Discipline already in use.");

        }
    }
    
    /**
     * Mutator for Discipline field. Removes a discipline for member to compete in.
     * @param discipline    Enum. Discipline to remover.
     * @throws DisciplineNotFoundException  If discipline does not exist.
     */
    public void removeDiscipline(Discipline discipline) throws DisciplineNotFoundException {
        if (disciplines.contains(discipline)) {
            disciplines.remove(discipline);
        } else {
            throw new DisciplineNotFoundException();
        }
    }
    
    /**
     * Getter for discipline.
     * @return 
     */
    public ArrayList<Discipline> getDiscipline() {
        return disciplines;
    }
    
    /**
     * Mutator to change this member to a non Competitive.
     * @return 
     */
    public Member changeMembership() {
        if (this.isCoach()) {
            return new Member(this.getName(), this.getEmail(), this.getAddress(), this.getId(), this.getAge(), this.getPhone(), this.getStatus(), true);
        } else {
            return new Member(this.getName(), this.getEmail(), this.getAddress(), this.getId(), this.getAge(), this.getPhone(), this.getStatus());
        }
    }
    
    
    ///////////////////////      STATUS CONFIRMATION       /////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Method for asserting if this member is Competitive.
     * @return 
     */
    @Override
    public boolean isCompetitive(){
        return true;
    }
    
}
