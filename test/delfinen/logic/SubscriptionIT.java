/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

import delfinen.logic.Member.Status;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author martin
 */
public class SubscriptionIT {

    Price pris = new Price(25, Status.Active);
    Subscription instance = new Subscription(2018, pris, 25, Status.Active);

    public SubscriptionIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetYear() {
        System.out.println("getYear");
        int expResult = 2018;
        int result = instance.getYear();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Price expResult = pris;
        Price result = instance.getPrice();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAge() {
        System.out.println("getAge");
        int expResult = 25;
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

}
