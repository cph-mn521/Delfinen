/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.data;

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
 * @author Niels Bang
 */
public class DataSearchEngineTest {

    public DataSearchEngineTest() {
    }

    /**
     * Test of Search method, of class DataSearchEngine.
     */
    @Test
    public void testSearch() throws Exception {
        ArrayList<String> Search = null;
        List<String> disciplines = null;
        Member Coach = null;
        List<String> data = null;
        boolean isCompetitive = false;
        DataSearchEngine instance = new DataSearchEngine();
        List<String> expResult = null;
        List<String> result = instance.Search(Search, disciplines, Coach, data, isCompetitive);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
