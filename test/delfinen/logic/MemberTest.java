/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

import java.util.ArrayList;

import delfinen.logic.Member.Status;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Lord
 */
public class MemberTest {

    private CompetitiveMember testPerson4, testPerson5;
    private Member testPerson1 = new Member("John Test", "abe@kat.dk", "Testgade 3", 2, 34, 12345678, Member.Status.Active);
    private Member testCoach = new Member("John Test", "abe@kat.dk", "Testgade 3", 2, 34, 12345678, Member.Status.Active, true);
    private Member testPerson3 = new Member("Ikke John", "ny@mailt.dk", "Anden Gade 23", 4, 89, 87654321, Member.Status.Passive);

    public MemberTest() {

    }

    /**
     * Test of equals method, of class Member.
     */
    @Test
    public void testEquals1() {
        assertTrue(testPerson1.equals(testCoach));
    }

    @Test
    public void testEquals2() {
        assertFalse(testPerson1.equals(testPerson3));
    }

    @Test
    public void nullTestEquals() {
        assertFalse(testPerson1 == null);
    }

    /**
     * Test of getName method, of class Member.
     */
    @Test
    public void testGetName() {
        String expected = "John Test";
        String result = testPerson1.getName();
        assertEquals(expected, result);
    }

    /**
     * Test of setName method, of class Member.
     */
    @Test
    public void testSetName() {
        String expected = "John Tester Set";
        testPerson1.setName(expected);
        assertEquals(expected, testPerson1.getName());
        testPerson1.setName("John Test");
    }

    /**
     * Test of getEmail method, of class Member.
     */
    @Test
    public void testGetEmail() {
        String expected = "abe@kat.dk";
        String result = testPerson1.getEmail();
        assertEquals(expected, result);

    }

    /**
     * Test of setEmail method, of class Member.
     */
    @Test
    public void testSetEmail() {
        String expected = "ny@email.dk";
        testPerson1.setEmail(expected);
        assertEquals(expected, testPerson1.getEmail());
        testPerson1.setEmail("abe@kat.dk");
    }

    /**
     * Test of getAdress method, of class Member.
     */
    @Test
    public void testGetAddress() {
        String expected = "Testgade 3";
        String result = testPerson1.getAddress();
        assertEquals(expected, result);

    }

    /**
     * Test of setAdress method, of class Member.
     */
    @Test
    public void testSetAdress() {
        String expected = "NyTestvej 18";
        testPerson1.setAddress(expected);
        assertEquals(expected, testPerson1.getAddress());
    }

    /**
     * Test of getId method, of class Member.
     */
    @Test
    public void testGetId() {
        int expected = 2;
        int result = testPerson1.getId();
        assertEquals(expected, result, 0);
    }

    /**
     * Test of setId method, of class Member.
     */
    @Test
    public void testSetId() {
        int expected = 8;
        testPerson1.setId(expected);
        assertEquals(expected, testPerson1.getId());
    }

    /**
     * Test of getAge method, of class Member.
     */
    @Test
    public void testGetAge() {
        int expected = 34;
        int result = testPerson1.getAge();
        assertEquals(expected, result, 0);
    }

    /**
     * Test of setAge method, of class Member.
     */
    @Test
    public void testSetAge() {
        int expected = 76;
        testPerson1.setAge(76);
        assertEquals(expected, testPerson1.getAge());
    }

    /**
     * Test of getPhone method, of class Member.
     */
    @Test
    public void testGetPhone() {
        int expected = 12345678;
        int result = testPerson1.getPhone();
        assertEquals(expected, result);
    }

    /**
     * Test of setPhone method, of class Member.
     */
    @Test
    public void testSetPhone() {
        int expected = 135792468;
        testPerson1.setPhone(expected);
        assertEquals(expected, testPerson1.getPhone());
    }

    /**
     * Test of getStatus method, of class Member.
     */
    @Test
    public void testGetStatus() {
        Status expected = Status.Active;
        Status result = testPerson1.getStatus();
        assertEquals(expected, result);
    }

    /**
     * Test of setStatus method, of class Member.
     */
    @Test
    public void testSetStatus() {
        Status expected = Status.Passive;
        testPerson1.setStatus(expected);
        assertEquals(expected, testPerson1.getStatus());

    }

    /**
     * Test of changeCoachStatus method, of class Member.
     */
    @Test
    public void testChangeCoachStatus() {
        boolean expected = true;
        testPerson1.changeCoachStatus();
        assertTrue(testPerson1.isCoach());
    }

    /**
     * Test of isCoach method, of class Member.
     */
    @Test
    public void testIsCoach() {
        boolean expected = false;
        assertEquals(expected, testPerson1.isCoach());

    }

    /**
     * Test of changeMembership method, of class Member.
     *
     * @throws CoachNotFoundException
     */
    @Test
    public void testChangeMembership_Member() throws CoachNotFoundException {
        testPerson3 = testPerson3.changeMembership(testCoach);
        assertTrue(testPerson3.isCompetitive());
    }

    /**
     * Test of changeMembership method, of class Member.
     *
     * @throws CoachNotFoundException
     */
    @Test
    public void testChangeMembership_Member_Discipline() throws CoachNotFoundException {
        Member testPerson6 = new Member("John Test", "abe@kat.dk", "Testgade 3", 2, 34, 12345678, Member.Status.Active,true);
        Member testPerson7 = new Member("John Test", "abe@kat.dk", "Testgade 3", 2, 34, 12345678, Member.Status.Active);
        testPerson7 = testPerson7.changeMembership(testPerson6, Discipline.Crawl);

        assertTrue(testPerson7.isCompetitive());
    }

    /**
     * Test of changeMembership method, of class Member.
     *
     * @throws CoachNotFoundException
     */
    @Test
    public void testChangeMembership_Member_ArrayList() throws CoachNotFoundException {
        Member testPerson8 = new Member("John Test", "abe@kat.dk", "Testgade 3", 2, 34, 12345678, Member.Status.Active, true);
        Member testPerson9 = new Member("John Test", "abe@kat.dk", "Testgade 3", 2, 34, 12345678, Member.Status.Active);
        ArrayList<Discipline> disciplines = new ArrayList<>();
        disciplines.add(Discipline.Butterfly);
        disciplines.add(Discipline.Rygcrawl);

        testPerson9 = testPerson9.changeMembership(testPerson8, disciplines);

        assertTrue(testPerson9.isCompetitive());

    }

    /**
     * Test of changeMembership CompetitiveMember -> Member
     *
     * @throws delfinen.logic.CoachNotFoundException
     */
    @Test
    public void testChangeMembership() throws CoachNotFoundException {
        boolean expected = false;
        testPerson1.changeCoachStatus();
        Member testPerson4 = new CompetitiveMember("David Hassellhoff", "david@thehoff.com", "Hoffstreet 5", 1, 66, 12345678, Status.Active, Discipline.Crawl, testPerson1);
        testPerson4 = ((CompetitiveMember) testPerson4).changeMembership();
        boolean results = testPerson4.isCompetitive();
        assertEquals(expected, results);
    }

    /**
     * Test of Competitive Member constructor
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Test of competitiveMember constructor.
     *
     * @throws CoachNotFoundException
     */
    @Test
    public void testCompetitiveMemberConstructor1() throws CoachNotFoundException {
        thrown.expect(CoachNotFoundException.class);
        testPerson4 = new CompetitiveMember("David Hassellhoff", "david@thehoff.com", "Hoffstreet 5", 1, 66, 12345678, Status.Active, Discipline.Crawl, testPerson1);

    }

    @Test
    public void testCompetitiveMemberConstructor2() throws CoachNotFoundException {
        ArrayList<Discipline> disciplines = new ArrayList<>();
        disciplines.add(Discipline.Crawl);
        disciplines.add(Discipline.Brystsvømning);
        disciplines.add(Discipline.Butterfly);
        testPerson5 = new CompetitiveMember("Pamela Anderson", "pamela@anderson.com", "Hollywood 2", 9, 76, 98765432, Status.Active, disciplines, testCoach);
    }

    /**
     * Tests of isCompetitive.
     */
    @Test
    public void testIsCompetitiveMember1() {
        boolean expected = false;
        assertEquals(expected, testPerson1.isCompetitive());
    }

    @Test
    public void testIsCompetitiveMember2() throws CoachNotFoundException {
        boolean expected = true;
        Member Coach = new Member("PamCoach", "I.coach@pam.anderson", "123Street", 11, 23, 12345678, Status.Active, true);
        testPerson5 = new CompetitiveMember("Pamela Anderson", "pamela@anderson.com", "Hollywood 2", 9, 76, 98765432, Status.Active, Discipline.Crawl, Coach);

        assertEquals(expected, testPerson5.isCompetitive());
    }

    /**
     * Test for getCoach(), in CompetitiveMember class.
     * @throws delfinen.logic.CoachNotFoundException
     */
    @Test
    public void testgetCoach() throws CoachNotFoundException {
        Member expected = testCoach;
        testPerson5 = new CompetitiveMember("Pamela Anderson", "pamela@anderson.com", "Hollywood 2", 9, 76, 98765432, Status.Active, Discipline.Crawl, testCoach);
        Member result = testPerson5.getCoach();
        assertEquals(expected, result);
    }

    /**
     * Test of setCoach, from CompetitiveMember class
     * @throws CoachNotFoundException
     */
    @Test
    public void testSetCoach() throws CoachNotFoundException {
        testPerson5 = new CompetitiveMember("Pamela Anderson", "pamela@anderson.com", "Hollywood 2", 9, 76, 98765432, Status.Active, Discipline.Crawl, testCoach);
        Member expected = testPerson3;
        testPerson5.setCoach(testPerson3);
        assertEquals(expected, testPerson5.getCoach());
    }

    /**
     * Test of addDiscipline, from CompetitiveMember class
     *
     * @throws DisciplineException
     * @throws CoachNotFoundException
     */
    @Test
    public void testAddDiscipline1() throws DisciplineException, CoachNotFoundException {
        testPerson5 = new CompetitiveMember("Pamela Anderson", "pamela@anderson.com", "Hollywood 2", 9, 76, 98765432, Status.Active, Discipline.Crawl, testCoach);
        thrown.expect(DisciplineException.class);
        testPerson5.addDiscipline(Discipline.Crawl);
    }

    /**
     * @throws DisciplineException
     * @throws CoachNotFoundException
    */
    @Test
    public void testAddDiscipline2() throws DisciplineException,CoachNotFoundException {
        int expected = 2;
        testPerson5 = new CompetitiveMember("Pamela Anderson", "pamela@anderson.com", "Hollywood 2", 9, 76, 98765432, Status.Active, Discipline.Crawl, testCoach);
        testPerson5.addDiscipline(Discipline.Brystsvømning);
        int result = testPerson5.getDiscipline().size();
        assertEquals(expected, result);
    }

    /**
     * Test of getDiscipline, from CompetitiveMember class
     * @throws CoachNotFoundException
     */
    @Test
    public void testGetDiscipline() throws CoachNotFoundException {
        Discipline expected = Discipline.Crawl;
        testPerson5 = new CompetitiveMember("Pamela Anderson", "pamela@anderson.com", "Hollywood 2", 9, 76, 98765432, Status.Active, Discipline.Crawl, testCoach);
        ArrayList<Discipline> result = testPerson5.getDiscipline();
        assertEquals(expected, result.get(0));
    }

    /**
     * Test of removeDiscipline, from CompetitiveMember class
     * @throws CoachNotFoundException
     * @throws DisciplineNotFoundException
     */
    @Test
    public void testRemoveDiscipline() throws CoachNotFoundException, DisciplineNotFoundException {
        testPerson5 = new CompetitiveMember("Pamela Anderson", "pamela@anderson.com", "Hollywood 2", 9, 76, 98765432, Status.Active, Discipline.Crawl, testCoach);
        testPerson5.removeDiscipline(Discipline.Crawl);
        assertTrue(testPerson5.getDiscipline().isEmpty());
    }
}
