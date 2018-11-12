/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redjsparser;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bsati
 */
public class BordersTest {
    
    public BordersTest() {
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
    public void testSomeMethod() {
         
        String s = "sometext { sdsd { {ddfgd} } }";
        int va = Borders.numberedIndex(s, "{", 3);
        assertEquals(va,18);
        
    }
    
    @Test
    public void testBorders()
    {
        String s = "sometext { sdsd { {ddfgd} } }";
        Borders bo = new Borders(s);
        assertEquals(37,bo.openIndex + bo.closeIndex);
    }
    
}
