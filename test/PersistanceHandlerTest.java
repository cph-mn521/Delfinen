/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import delfinen.data.DataException;
import delfinen.data.PersistanceHandler;
import delfinen.logic.CoachNotFoundException;
import delfinen.logic.CompetitiveMember;
import delfinen.logic.Discipline;
import delfinen.logic.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class PersistanceHandlerTest {

    Gson gson = new Gson();
    private PersistanceHandler PH;
    private Member p1;
    private Member p2;
    private Member p3;
    private Member p4;
    
    public PersistanceHandlerTest() {
        PH = new PersistanceHandler();
        // Creating a library
        p1 = new Member("John Test", "abe@kat.dk", "Reeeeee 3", 1, 34, 12345678, Member.Status.Active);
        p2 = new Member("Johnny Test", "kit@kat.dk", "StReeeeet 3", 2, 34, 12345678, Member.Status.Active);
        p3 = new Member("Ikke John", "ny@mailt.dk", "Anden Gade 23", 3, 89, 87654321, Member.Status.Passive);
        p3.changeCoachStatus();
        try {
            p4 = new CompetitiveMember("david\"THE HASSLE!\" Hoff", "bay.wathc@watchit.com", "The Bay", 4, 25, 12345677, Member.Status.Active, p3);
        } catch (CoachNotFoundException ex) {
            Logger.getLogger(PersistanceHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testGetMembers() {
        try {
            List<Member> mmbrs = PH.getMembers();                    
            assertNotNull(mmbrs);
            assertTrue(mmbrs.size()>=1);
            for (Member mmbr : mmbrs) {
                assertNotNull(mmbr);
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
    @Test
    public void testsearchMembers(){
        try {
            List<Member> Search; 
            Search =  PH.searchMember("Hoff");
            System.out.println(gson.toJson(p2));
            assertTrue(p4.equals(Search.get(0)));
            
            Search =  PH.searchMember("Active");
            assertEquals(3, Search.size());
            
            Search = PH.searchMember("StReeeeet 3");
            assertTrue(p2.equals(Search.get(0)));
            
            Search = PH.searchMember("1234567890");
            assertNull(Search);
            
        } catch (DataException ex) {
            Logger.getLogger(PersistanceHandlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// TODO add test methods here.
// The methods must be annotated with annotation @Test. For example:
//
// @Test
// public void hello() {}
}
