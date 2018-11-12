/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;
import java.util.Objects;

/**
 *
 * @author Lord
 */

public class Member {

    private String name, email, adress;
    private int id, age, phone;
    
    public enum Status {
        Active,
        Passive
    }

    
    public Member(String name, String email, String adress, int id, int age, int phone, Status status) {
        this.name = name;
        this.email = email;
        this.adress = adress;
        this.id = id;
        this.age = age;
        this.phone = phone;
        this.Status = status;
    }

    
    @Override    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Member other = (Member) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        if (this.phone != other.phone) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return !Objects.equals(this.adress, other.adresse);
        
    }

    @Override
    public String toString() {
        return "Member{" + "name=" + name + ", email=" + email + ", adress=" + adress + ", id=" + id + ", age=" + age + ", phone=" + phone + '}';
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adresse) {
        this.adress = adress;
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
/*
    public status getStatus() {
        return status;
    }

    public void setStatus( 
        enum status) {
        this.satatus = status;
    }
*/
    public void changeMembership() {
        // new CompetitiveMember(name, email, adress, id, age, phone, null);
    }



}
