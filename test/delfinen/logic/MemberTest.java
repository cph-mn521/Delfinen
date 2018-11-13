/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lord
 */
public class MemberTest {
    
    
    private Member testPerson1 = new Member("John Test","abe@kat.dk","Reeeeee 3",2,34, 12345678, Member.Status.Active);
    private Member testPerson2 = new Member("John Test","abe@kat.dk","Reeeeee 3",2,34, 12345678, Member.Status.Active);
    private Member testPerson3 = new Member("Ikke John","ny@mailt.dk","Anden Gade 23",4,89, 87654321, Member.Status.Passive);
    public MemberTest() {
    
        
    }
    
   

    /**
     * Test of equals method, of class Member.
     */
    @Test
    public void testEquals1() {
        assertTrue(testPerson1.equals(testPerson2));
    }

    @Test
    public void testEquals2(){
        assertFalse(testPerson1.equals(testPerson3));
    }
    
    @Test
    public void nullTestEquals(){
        assertFalse(testPerson1.equals(null));
    }
    
    
    /**
     * Test of toString method, of class Member.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Member instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Member.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Member instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Member.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Member instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Member.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Member instance = null;
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Member.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Member instance = null;
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdress method, of class Member.
     */
    @Test
    public void testGetAdress() {
        System.out.println("getAdress");
        Member instance = null;
        String expResult = "";
        String result = instance.getAdress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAdress method, of class Member.
     */
    @Test
    public void testSetAdress() {
        System.out.println("setAdress");
        String adress = "";
        Member instance = null;
        instance.setAdress(adress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Member.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Member instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Member.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Member instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAge method, of class Member.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        Member instance = null;
        int expResult = 0;
        int result = instance.getAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAge method, of class Member.
     */
    @Test
    public void testSetAge() {
        System.out.println("setAge");
        int age = 0;
        Member instance = null;
        instance.setAge(age);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhone method, of class Member.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        Member instance = null;
        int expResult = 0;
        int result = instance.getPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPhone method, of class Member.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        int phone = 0;
        Member instance = null;
        instance.setPhone(phone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Member.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Member instance = null;
        Member.Status expResult = null;
        Member.Status result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class Member.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        Member.Status status = null;
        Member instance = null;
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeCoachStatus method, of class Member.
     */
    @Test
    public void testChangeCoachStatus() {
        System.out.println("changeCoachStatus");
        Member instance = null;
        instance.changeCoachStatus();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCoach method, of class Member.
     */
    @Test
    public void testIsCoach() {
        System.out.println("isCoach");
        Member instance = null;
        boolean expResult = false;
        boolean result = instance.isCoach();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeMembership method, of class Member.
     */
    @Test
    public void testChangeMembership_Member() {
        System.out.println("changeMembership");
        Member coach = null;
        Member instance = null;
        Member expResult = null;
        Member result = instance.changeMembership(coach);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeMembership method, of class Member.
     */
    @Test
    public void testChangeMembership_Member_Discipline() {
        System.out.println("changeMembership");
        Member coach = null;
        Discipline discipline = null;
        Member instance = null;
        Member expResult = null;
        Member result = instance.changeMembership(coach, discipline);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeMembership method, of class Member.
     */
    @Test
    public void testChangeMembership_Member_ArrayList() {
        System.out.println("changeMembership");
        Member coach = null;
        ArrayList<Discipline> disciplines = null;
        Member instance = null;
        Member expResult = null;
        Member result = instance.changeMembership(coach, disciplines);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
