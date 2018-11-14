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
 */
public class Member {

    private String name, email, address;
    private int id, age, phone;
    private Status status;
    private boolean isCoach = false;
    
    public enum Status {
        Active,
        Passive
    }
    
    public Member(String name, String email, String address, int id, int age, int phone, Status status) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.id = id;
        this.age = age;
        this.phone = phone;
        this.status = status;
    }
    
    public Member(String name, String email, String address, int id, int age, int phone, Status status, boolean isCoach) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.id = id;
        this.age = age;
        this.phone = phone;
        this.status = status;
        isCompetitive = false;
        this.isCoach = isCoach;
    }
    
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void changeCoachStatus() {
        isCoach = !isCoach;
    }

    public boolean isCoach() {
        return isCoach;
    }

    public Member changeMembership(Member coach) throws CoachNotFoundException {
        return new CompetitiveMember(name, email, address, id, age, phone, status, coach);
    }

    public Member changeMembership(Member coach, Discipline discipline) throws CoachNotFoundException {
        return new CompetitiveMember(name, email, address, id, age, phone, status, discipline, coach);
    }

    public Member changeMembership(Member coach, ArrayList<Discipline> disciplines) throws CoachNotFoundException {
        return new CompetitiveMember(name, email, address, id, age, phone, status, disciplines, coach);
    }

    public boolean isCompetitive(){
        return false;
    }
}
