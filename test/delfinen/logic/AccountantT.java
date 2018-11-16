/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Martin Wulff
 */
public class AccountantT {

    public List<Member> M1;
    public List<Member> M2;
    public List<Subscription> S1;
    public List<Subscription> S2;

    public AccountantT() {
        Member p1 = new Member("John Test", "abe@kat.dk", "Testgade 3", 2, 34, 12345678, Member.Status.Active);
        Member p2 = new Member("Johny Test", "abe@kat.dk", "Testgade 3", 2, 64, 12345678, Member.Status.Active, true);
        Member p3 = new Member("Ikke John", "ny@mailt.dk", "Anden Gade 23", 4, 8, 87654321, Member.Status.Passive);
        Member p4 = new Member("Ikke Johny", "ny@mailt.dk", "Anden Gade 23", 4, 19, 87654321, Member.Status.Passive);
        M1 = new ArrayList<>();
        M1.add(p4);
        M1.add(p3);
        M1.add(p2);
        M1.add(p1);

        M2 = new ArrayList<>();
        M2.add(p4);
        M2.add(p3);


        List<Subscription> TS1 = new ArrayList<>();
        for (Member member : M1) {
            TS1.add(new Subscription(1, member));
        }

        List<Subscription> TS2 = new ArrayList<>();
        for (Member member : M2) {
            TS2.add(new Subscription(2, member));
        }
        this.S1 = TS1;
        this.S2 = TS2;
    }

    /*
    @Test
    public void testAccountantConstruct() {
        Accountant A1 = new Accountant(S1, Members);

        assertNotNull(A1);
    }

    @Test
    public void testGetBank() {
        Accountant A1 = new Accountant(S1, Members);
        Accountant A2 = new Accountant(S2, Members);

        assertNotNull(A1.getBank());
        assertTrue(A1.getBank() > 0);
        assertTrue(A1.getBank() != A2.getBank());
    }

    @Test
    public void testExpectedBank() {
        Accountant A1 = new Accountant(S1, Members);
        Accountant A2 = new Accountant(S2, Members);

        assertNotNull(A2.getExpectedBank());
        assertTrue(A1.getExpectedBank() == A2.getExpectedBank());
    }

    @Test
    public void testMissingPayments() {
        Accountant A1 = new Accountant(S1, Members);
        Accountant A2 = new Accountant(S2, Members);
        
        assertNotEquals(A1.getMissingPayments(),0);
        assertNotEquals(A2.getMissingPayments(),2);

    }
     */
    @Test
    public void testDebitors() {
        Accountant A1 = new Accountant(S1, M1); //NICE! helt rigtigt i guess
        Accountant A2 = new Accountant(S2, M1);
        System.out.println(A1.getDebitors().size());
        System.out.println(A2.getDebitors().size());
        //List<Member> eh = A2.getDebitors();

        assertNotEquals(A1.getDebitors().size(), A2.getDebitors().size());

    }

}
