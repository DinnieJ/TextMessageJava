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
    public void test001ReadCorrectFile(){
        System.out.println("TC001-Test read existed file:");
        MainFunction m = new MainFunction();
        boolean result = m.readFile("src/testfile/UTC001.txt");
        boolean expectedResult = true;
        assertEquals("The file should be read without error", expectedResult, result);
        System.out.println("\tTC-001: PASS");
        System.out.println();
    }
    
    /**
     * Test case 2:File not existed
     * Success: Show error message "FILE NOT FOUND" + source file
     * Failure: Still read the file successful
     */
    @Test
    public void test002ReadNonExistFile(){
        System.out.println("TC002-Test read non-existed file:");
        System.out.println("Expected output: FILE NOT FOUND");
        MainFunction m = new MainFunction();
        boolean result = m.readFile("src/testfile/text.txt");
        boolean expectedResult = false;
        assertEquals("Should show \"FILE NOT FOUND\" message and stop the application" , expectedResult, result);
        System.out.println("\tTC-002:PASS");
        System.out.println();
    }
    
    /**
     * Test case 3: Read empty file
     * Success: Show error message "EMPTY FILE" + source file and exit
     * Failure: Still read the file successful
     */
    @Test
    public void test003ReadFileEmpty(){
        System.out.println("TC003-Test read empty file:");
        System.out.println("Expected output: EMPTY FILE");
        MainFunction m = new MainFunction();
        boolean result = m.readFile("src/testfile/UTC003.txt");
        boolean expectedResult = false;
        assertEquals("Should show the error \"EMPTY FILE\" and stop the application", expectedResult,result);
        System.out.println("\tTC-003: PASS");
        System.out.println();
    }
    /**
     * Test case 4: Test read incorrect file
     * Success: Show error message "WRONG FILE FORMAT"
     * Failure: Read file successful without error
     */
    @Test
    public void test004ReadIncorrectFile(){
        System.out.println("TC-004:Test read incorrect file:");
        System.out.println("Expected output:WRONG FILE FORMAT");
        MainFunction m = new MainFunction();
        boolean result = m.readFile("src/testfile/UTC004");
        boolean expectedResult = false;
        assertEquals("Should show the error \"WRONG FILE FORMAT\" and stop the application", expectedResult, result);
        System.out.println("\tTC-004: PASS");
        System.out.println();
    }
    
    /**
     * Test case 5:
     */
    @Test
    public void test005ReadCorrectDictionary(){
        System.out.println("TC-005-Test read correct dictionary:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC005.txt"),true);
        boolean result = m.analyzeDictionary();
        boolean expectedResult = true;
        assertEquals("Dictionary should be read successfully",expectedResult , result);
        System.out.println("\tTC-005: PASS");
        System.out.println();
    }
    /**
     * Test case 6:
     */
    @Test
    public void test006ReadSmallerNumberOfWord(){
        System.out.println("TC006-Test read smaller number of word:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC006.txt"),true);
        boolean result = m.analyzeDictionary();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-006: PASS");
        System.out.println();
    }
    /**
     *Test case 7: 
     */
    @Test
    public void test007ReadLargerNumberOfWord(){
        System.out.println("TC007-Test read larger number of word:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC007.txt"),true);
        boolean result = m.analyzeDictionary();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-007: PASS");
        System.out.println();
    }
    
    /**
     * Test case 8
     * @param args 
     */
    public void test008FileWithZero(){
        System.out.println("TC008-Test read file with zero:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC008.txt"),true);
        boolean result = m.analyzeDictionary();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-008:PASS");
        System.out.println();  
    }
    /**
     * Test case 9:
     * @param args 
     */
    public void test009FileWith30001Word(){
        System.out.println("TC009-Test read dictionary with 30001 word:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC009.txt"),true);
        boolean result = m.analyzeDictionary();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-009:PASS");
        System.out.println(); 
    }
    
    /**
     * Test case 10:
     * @param args 
     */
    public void test010DictionaryWithNegativeNumberOfWord(){
        System.out.println("TC010-Test read dictionary with negative num of word:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC010.txt"),true);
        boolean result = m.analyzeDictionary();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-010:PASS");
        System.out.println(); 
    }
    /**
     * Test case 11:
     * @param args 
     */
    @Test
    public void test011DictionaryWithDoubleNumberOfWord(){
        System.out.println("TC011-Test read dictionary with double type number of word:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC011.txt"),true);
        boolean result = m.analyzeDictionary();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-011:PASS");
        System.out.println(); 
    }
    /**
     * Test case 12:
     * @param args 
     */
    @Test
    public void test012DictionaryWithDoubleTypeButIntValue(){
        System.out.println("TC012-Test read dictionary with double type but int value:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC012.txt"),true);
        boolean result = m.analyzeDictionary();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-012:PASS");
        System.out.println(); 
    }
    /**
     * Test case 13:
     * @param args 
     */
    @Test
    public void test013DictionaryCorrectWithWhitespace(){
        System.out.println("TC013-Test dictionary correct with whitespace:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC013.txt"),true);
        boolean result = m.analyzeDictionary();
        boolean expectedResult = true;
        assertEquals("Dictionary should be read successfully",expectedResult, result);
        System.out.println("\tTC-013:PASS");
        System.out.println(); 
    }
    
    /**
     * Test case 15:
     * @param args 
     */
    @Test
    public void test015DictionaryWithOneWord(){
        System.out.println("TC015-Test dictionary correct with one word:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC015.txt"),true);
        boolean result = m.analyzeDictionary();
        boolean expectedResult = true;
        assertEquals("Dictionary should be read successfully",expectedResult, result);
        System.out.println("\tTC-015:PASS");
        System.out.println(); 
    }
    /**
     * Test case 16:
     * @param args 
     */
    public void test016DictionaryWithoutNumberOfWord(){
        System.out.println("TC016-Test dictionary without number of word:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC016.txt"),true);
        boolean result = m.analyzeDictionary();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-016:PASS");
        System.out.println(); 
    }
    /**
     * Test case 17:
     * @param args 
     */
    @Test
    public void test017ReadCorrectForbidden(){
        System.out.println("TC017-Test read correct forbidden:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC017.txt"),true);
        boolean result = m.analyzeDictionary();
        boolean expectedResult = true;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-017:PASS");
        System.out.println();
    }
    public static void main(String []args) {  
            junit.textui.TestRunner.run(new TestSuite(MainFunctionTest.class));  
    } 
}
