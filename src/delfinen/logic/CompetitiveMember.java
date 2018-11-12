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
    ArrayList<String> disciplines;
    
    public CompetitiveMember(String name, String email, String adresse, int id, int age, int phone, Status status,ArrayList<String> disciplines) {
        super(name, email, adresse, id, age, phone, status);
        this.disciplines = disciplines;
    }
    
    public CompetitiveMember(String name, String email, String adresse, int id, int age, int phone, Status status,String disciplines) {
        super(name, email, adresse, id, age, phone, status);
        this.disciplines.add(disciplines);
    }
    
 
}
