/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Test;
import junit.framework.TestCase;


/**
 *
 * @author Kommuri Rama Naveen
 */
public class TestSuite extends TestCase {
    
    public TestSuite(String testName) {
        super(testName);
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite("TestSuite");
         return suite;
    }
    
}
