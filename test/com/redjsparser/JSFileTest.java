/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redjsparser;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author bsati
 */
public class JSFileTest {
    
    public JSFileTest() {
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
 
        String path = "C:\\Users\\bsati\\Documents\\NetBeansProjects\\corefx\\web\\action007.js";
        File file = new File(path);
        JSFile f = new JSFile(file);
        int func = f.functions.records.size();
        assertEquals(10,func);
        
    }
    
}
