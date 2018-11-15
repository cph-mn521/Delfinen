/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Lord
 * @commentator Wulff.
 * 
 * 
 * A class for handling, and representing a Member of the swimming club "Delfinen"
 * Contains Standard information about the person and a status showing if they are
 * active or passive, or i fhtey are a coach.
 */
public class Member {
    //Preloc of required member Atributes.
    private String name, email, address;
    private int id, age, phone;
    private Status status;
    private boolean isCoach = false;
    
    public enum Status { //This enum status shows if they are active or passive.
        Active,
        Passive
    }
    
    /**
     * Constructor for the member class: takes every Attribute in a member and sets
     * them accordingly.
     * 
     * 
     * @param name      String of the Members name.
     * @param email     String of the Members Email.
     * @param address   String of the Members Address.
     * @param id        Integer containing the Members ID number in the system.
     * @param age       Integer Containing Members Age, used for calculating Subscription fee.
     * @param phone     Integer Containing the Members phone.
     * @param status    Enum of the Members current Active or passive status.
     */
    public Member(String name, String email, String address, int id, int age, int phone, Status status) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.id = id;
        this.age = age;
        this.phone = phone;
        this.status = status;
    }
    
    /**
     * Overloaded Constructor. 
     * This is used to recall a member for a json string. and recreate a member 
     * from the database.
     * 
     * 
     * @param name      String of the Members name.
     * @param email     String of the Members Email.
     * @param address   String of the Members Address.
     * @param id        Integer containing the Members ID number in the system.
     * @param age       Integer Containing Members Age, used for calculating Subscription fee.
     * @param phone     Integer Containing the Members phone.
     * @param status    Enum of the Members current Active or passive status.
     * @param isCoach   Boolean telling if the Member is a coach.
     */
    public Member(String name, String email, String address, int id, int age, int phone, Status status, boolean isCoach) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.id = id;
        this.age = age;
        this.phone = phone;
        this.status = status;
        this.isCoach = isCoach;
    }
    
    /**
     * Method for asserting if two Members are the same.
     * 
     * 
     * @param other     The Other Member to compare with.
     * @return 
     */
    public boolean equals(Member other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        
        if (this.id != other.id) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        if (this.phone != other.phone) {
            return false;
        }
        if (!this.name.equals(other.name)) {
            return false;
        }
        if (!this.email.equals(other.email)) {
            return false;
        }
        return this.address.equals(other.address);

    }
   
     /**
     * Getter for address field.
     * @return  this.address
     */
    @Override
    public String toString() {
        return "Member{" + "name=" + name + ", email=" + email + ", address=" + address + ", id=" + id + ", age=" + age + ", phone=" + phone + ", status=" + status + ", isCoach=" + isCoach + "\n";
    }

    public String getAddress() {
        return address;
    }
   
    
    ///////////////////////      GETTERS AND SETTERS       /////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
 
    /**
     * Getter for name.
     * @return  this.name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Setter for name.
     * @param name      the new name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Getter for email Attribute.
     * @return      this.email.
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Setter for email.
     * @param email     the new email.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Setter for the address field.
     * @param address   New address.
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * Getter for id field.
     * @return      this.id
     */
    public int getId() {
        return id;
    }
    
    /**
     * Setter for id Field.
     * @param id    new id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for age Field.
     * @return      this.age
     */
    public int getAge() {
        return age;
    }
    
    /**
     * Setter for age field.
     * @param age   The new Age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter for phone field.
     * @return      this.phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * Setter for phone field.
     * @param phone     new phone.
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    /**
     * getter for status field.
     * @return  this.status.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Setter for status field.
     * @param status    new status.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Mutator isCoach.
     * 
     * inverts isCoach Value.
     */
    public void changeCoachStatus() {
        isCoach = !isCoach;
    }
    
    /**
     * getter for isCoach field.
     * 
     * @return  this.isCoach 
     */
    public boolean isCoach() {
        return isCoach;
    }

    ///////////////////////      MUTATORS       ////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Mutator to change Member to CompetitiveMember.
     * Calls CompetitiveMember() constructor.
     * 
     * @param coach     coach of member.
     * @return          the new changed member.
     * @throws CoachNotFoundException   Gets thrown if coach does not have coach status.
     */
    public Member changeMembership(Member coach) throws CoachNotFoundException {
        return new CompetitiveMember(name, email, address, id, age, phone, status, coach);
    }
    
    /**
     * Mutator to change to CompetitiveMember
     * 
     * @param coach         Member. Coach of the CompetitiveMember.
     * @param discipline    Enum. What discipline the CompetitiveMember competes in.
     * @return              The new CompetitiveMember.
     * @throws CoachNotFoundException   if Coach doesn't have isCoach status.
     */
    public Member changeMembership(Member coach, Discipline discipline) throws CoachNotFoundException {
        return new CompetitiveMember(name, email, address, id, age, phone, status, discipline, coach);
    }

    /**
     * Mutator to change to CompetitiveMember
     * 
     * @param coach     Member. Coach of the CompetitiveMember.
     * @param disciplines   ArrayList<Enum> disciplines the CompetitiveMember competes in.
     * @return
     * @throws CoachNotFoundException 
     */
    public Member changeMembership(Member coach, ArrayList<Discipline> disciplines) throws CoachNotFoundException {
        return new CompetitiveMember(name, email, address, id, age, phone, status, disciplines, coach);
    }
    
    ///////////////////////      STATUS CONFIRMATION       /////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Method for asserting if this member is Competitive.
     * @return 
     */
    public boolean isCompetitive(){
        return false;
    }
}
