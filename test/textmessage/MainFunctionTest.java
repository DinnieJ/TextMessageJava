/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textmessage;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;

/**
 *
 * @author MemeLord
 */
public class MainFunctionTest extends TestCase {
    public MainFunctionTest(String name){
        super(name);
    }
    
    /**
     * Test case 1: Test for file existed to read
     * Success: Read the file succesful
     * Failure: Failed to read the source file
     */
    @Test
    public void testReadCorrectFile(){
        System.out.println("TC1-Test read existed file:");
        MainFunction m = new MainFunction();
        boolean result = m.readFile("src/textmsg.t");
        boolean expectedResult = true;
        assertEquals("The file should be read without error", expectedResult, result);
        System.out.println("\tTest read existed file: PASS");
        System.out.println();
    }
    
    /**
     * Test case 2:File not existed
     * Success: Show error message "FILE NOT FOUND" + source file
     * Failure: Still read the file successful
     */
    @Test
    public void testReadNonExistFile(){
        System.out.println("TC2-Test read non-existed file:");
        System.out.println("Expected output: FILE NOT FOUND");
        MainFunction m = new MainFunction();
        boolean result = m.readFile("src/text.txt");
        boolean expectedResult = false;
        assertEquals("Should show \"FILE NOT FOUND\" message and stop the application" , expectedResult, result);
        System.out.println("\tTest read non-existed file:PASS");
        System.out.println();
    }
    
    /**
     * Test case 3: Read empty file
     * Success: Show error message "EMPTY FILE" + source file and exit
     * Failure: Still read the file successful
     */
    @Test
    public void testReadFileEmpty(){
        System.out.println("TC3-Test read empty file:");
        System.out.println("Expected output: EMPTY FILE");
        MainFunction m = new MainFunction();
        boolean result = m.readFile("src/emptyfile.txt");
        boolean expectedResult = false;
        assertEquals("Should show the error \"EMPTY FILE\" and stop the application", expectedResult,result);
        System.out.println("\tTest Read empty file: PASS");
        System.out.println();
    }
    /**
     * Test case 4: Test read incorrect file
     * Success: Show error message "WRONG FILE FORMAT"
     * Failure: Read file successful without error
     */
    @Test
    public void testReadIncorrectFile(){
        System.out.println("Test read incorrect file:");
        System.out.println("Expected output:WRONG FILE FORMAT");
        MainFunction m = new MainFunction();
        boolean result = m.readFile("src/wrongformatfile");
        boolean expectedResult = false;
        assertEquals("Should show the error \"WRONG FILE FORMAT\" and stop the application", expectedResult, result);
        System.out.println("\tTest read incorrect file: PASS");
        System.out.println();
    }
    /**
     * 
     */
    public static void main(String []args) {  
            junit.textui.TestRunner.run(new TestSuite(MainFunctionTest.class));  
    } 
}
