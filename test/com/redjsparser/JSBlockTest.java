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
public class JSBlockTest {
    
    public JSBlockTest() {
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

    /**
     * Test of populateExpressions method, of class JSBlock.
     */
  //  @Test
    public void testPopulateExpressions() {
        char qu = '"';
        String r = " var myname =  myvalue ;  var  anothername= valueagain ; function someFunc("+qu+"sds"+qu+")";
        JSBlock b = new JSBlock(r);
        b.populateExpressions(r);
    
    }
    
    @Test
    public void testRegex()
    {
        JSBlock.testRegex();
    }
    
}
