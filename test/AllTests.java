/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class AllTests extends TestCase {
    
    public AllTests(String testName) {
        super(testName);
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite("AllTests");
        return suite;
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
}
