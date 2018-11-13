/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import delfinen.data.DataException;
import delfinen.data.PersistanceHandler;
import delfinen.logic.CompetitiveMember;
import delfinen.logic.Discipline;
import delfinen.logic.Member;
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
public class PersistanceHandlerTest {

    Gson gson = new Gson();
    private PersistanceHandler PH;

    public PersistanceHandlerTest() {
        PH = new PersistanceHandler();
        // Creating a library
        Member p1 = new Member("John Test", "abe@kat.dk", "Reeeeee 3", 1, 34, 12345678, Member.Status.Active);
        Member p2 = new Member("Johnny Test", "kit@kat.dk", "StReeeeet 3", 2, 34, 12345678, Member.Status.Active);
        Member p3 = new Member("Ikke John", "ny@mailt.dk", "Anden Gade 23", 3, 89, 87654321, Member.Status.Passive);
        Member p4 = new CompetitiveMember("david\"THE HASSLE!\" Hoff", "bay.wathc@watchit.com", "The Bay", 4, 25, 12345677, Member.Status.Active, p3);
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
;

// TODO add test methods here.
// The methods must be annotated with annotation @Test. For example:
//
// @Test
// public void hello() {}
}
