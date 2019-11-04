/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textmessage;

import java.text.ParseException;
import java.util.Date;
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
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        boolean result = m.analyzeForbidden();
        boolean expectedResult = true;
        assertEquals("Should read successfully without error",expectedResult, result);
        System.out.println("\tTC-017:PASS");
        System.out.println();
    }
    /**
     * Test case 18:
     * @param args 
     */
    @Test
    public void test018ReadSmallerNumberOfWordForbidden(){
        System.out.println("TC018-Test read smaller number ôf word forbidden:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC018.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        boolean result = m.analyzeForbidden();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-018:PASS");
        System.out.println();
    }
    /**
     * Test case 19:
     * @param args 
     */
    @Test
    public void test019ReadLargerNumberOfWordForbidden(){
        System.out.println("TC019-Test read smaller number ôf word forbidden:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC019.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        boolean result = m.analyzeForbidden();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-019:PASS");
        System.out.println();
    }
    /**
     * Test case 20:
     * @param args 
     */
    @Test
    public void test020ReadForbiddenWithZero(){
        System.out.println("TC020-Test forbidden with zero:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC020.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        boolean result = m.analyzeForbidden();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-020:PASS");
        System.out.println();
    }
    /**
     * Test case 21:
     * @param args 
     */
    @Test
    public void test021Read100ForbiddenWord(){
        System.out.println("TC021-Test read 100 forbidden word:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC021.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        boolean result = m.analyzeForbidden();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-021:PASS");
        System.out.println();
    }
    /**
     * Test case 22:
     * @param args 
     */
    @Test
    public void test022ReadNegativeForbiddenWordNumber(){
        System.out.println("TC022-Test read 100 forbidden word:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC022.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        boolean result = m.analyzeForbidden();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-022:PASS");
        System.out.println();
    }
    /**
     * Test case 23:
     * @param args 
     */
    @Test
    public void test023ForbiddenWithDoubleTypeNumOfWord(){
        System.out.println("TC023-Test read forbidden with double type num of word:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC023.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        boolean result = m.analyzeForbidden();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-023:PASS");
        System.out.println();
    }
    /**
     * Test case 24
     * @param args 
     */
    public void test024ForbiddenWithDoubleTypeButIntValue(){
        System.out.println("TC024-Test read forbidden with double type but int value:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC024.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        boolean result = m.analyzeForbidden();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-024:PASS");
        System.out.println();
    }
    /**
     * Test case 25:
     * @param args 
     */
    @Test
    public void test025ForbiddenCorrectWithWhitespace(){
        System.out.println("TC025-Test read forbidden with whitespace:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC025.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        boolean result = m.analyzeForbidden();
        boolean expectedResult = true;
        assertEquals("Should be read with out error",expectedResult, result);
        System.out.println("\tTC-025:PASS");
        System.out.println();
    }
    /**
     * Test case 26:
     * @param args 
     */
    public void test026ForbiddenWithOneWord(){
        System.out.println("TC026-Test read forbidden with one word:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC026.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        boolean result = m.analyzeForbidden();
        boolean expectedResult = true;
        assertEquals("Should be read with out error",expectedResult, result);
        System.out.println("\tTC-026:PASS");
        System.out.println();
    }
    /**
     * Test case 28:
     * @param args 
     */
    @Test
    public void test028ReadCorrectMessage(){
        System.out.println("TC028-Test get correct message");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC028.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.getAllMessage();
        boolean expectedResult = true;
        assertEquals("Should be read with out error",expectedResult, result);
        System.out.println("\tTC-028:PASS");
        System.out.println();
    }
    /**
     * Test case 29:
     * @param args 
     */
    @Test
    public void test029ReadLargerNumberOfMessage(){
        System.out.println("TC029-Test get correct message");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC029.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.getAllMessage();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-029:PASS");
        System.out.println();
    }
    /**
     * Test case 30:
     * @param args 
     */
    @Test
    public void test030ReadSmallerNumberOfMessage(){
        System.out.println("TC030-Test smaller number of message:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC030.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.getAllMessage();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-030:PASS");
        System.out.println();
    }
    /**
     * Test case 31:
     * @param args 
     */
    public void test031ReadWrongNumberOfMessage(){
        System.out.println("TC031-Test wrong number of message:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC031.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.getAllMessage();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-031:PASS");
        System.out.println();
    }
    /**
     * Test case 32:
     * @param args 
     */
    @Test
    public void test032ReadWrongFormatNumberOfMessage(){
        System.out.println("TC032-Test wrong format number of message:");
        MainFunction m = new MainFunction();
        m.setSrc("src/testfile/UTC032.txt");
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC032.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        boolean result = m.analyzeForbidden();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-032:PASS");
        System.out.println();
    }
    /**
     * Test case 33:
     * @param args 
     */
    @Test
    public void test033ReadSmallerNumberOfWordInMessage(){
        System.out.println("TC033-Test smaller number of word in message:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC033.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.getAllMessage();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-033:PASS");
        System.out.println();
    }
    /**
     * Test case 34:
     * @param args 
     */
    @Test
    public void test034ReadLargerNumberOfWordInMessage(){
        System.out.println("TC034-Test larger number of word in message:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC034.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.getAllMessage();
        boolean expectedResult = false;
        assertEquals("Should not be read and stop the application",expectedResult, result);
        System.out.println("\tTC-034:PASS");
        System.out.println();
    }
    /**
     * Test case 35:
     * @param args 
     */
    @Test
    public void test035ReadEmptyMessage(){
        System.out.println("TC035-Test empty message:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC035.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.getAllMessage();
        boolean expectedResult = true;
        assertEquals("Should be read without error",expectedResult, result);
        System.out.println("\tTC-035:PASS");
        System.out.println();
    }
    /**
     * Test case 36:
     * @param args 
     */
    @Test
    public void test036ReadWrongFormatNumberOfWordInMessage(){
        System.out.println("TC036-Test wrong format number of word in message:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC036.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.getAllMessage();
        boolean expectedResult = false;
        assertEquals("Should be read without error",expectedResult, result);
        System.out.println("\tTC-036:PASS");
        System.out.println();
    }
    /**
     * Test case 37:
     * @param args 
     */
    @Test
    public void test037ReadWrongTimeFormat(){
        System.out.println("TC037-Test wrong time format:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/UTC037.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.getAllMessage();
        boolean expectedResult = false;
        assertEquals("Should be read without error",expectedResult, result);
        System.out.println("\tTC-037:PASS");
        System.out.println();
    }
    /**
     * Test case 38:
     * @param args 
     */
    @Test
    public void test038CheckSendTime1_00AM() throws ParseException{
        System.out.println("TC038-Check send time at 1:00 AM :");
        MainFunction m = new MainFunction();
        Date d = m.format.parse("1:00 AM");
        boolean result = m.checkValidTime(d);
        boolean expectedResult = false;
        assertEquals("Should be read without error",expectedResult, result);
        System.out.println("\tTC-038:PASS");
        System.out.println();
    }
    /**
     * Test case 39:
     * @param args 
     */
    @Test
    public void test039CheckSendTime00_59AM() throws ParseException{
        System.out.println("TC033-Check send time at 00:59 AM :");
        MainFunction m = new MainFunction();
        Date d = m.format.parse("00:59 AM");
        boolean result = m.checkValidTime(d);
        boolean expectedResult = true;
        assertEquals("Should be read without error",expectedResult, result);
        System.out.println("\tTC-039:PASS");
        System.out.println();
    }
    /**
     * Test case 40:
     * @param args 
     */
    @Test
    public void test040CheckSendTime1_01AM() throws ParseException{
        System.out.println("TC040-Check send time at 1:01AM :");
        MainFunction m = new MainFunction();
        Date d = m.format.parse("1:01 AM");
        boolean result = m.checkValidTime(d);
        boolean expectedResult = false;
        assertEquals("Should be read without error",expectedResult, result);
        System.out.println("\tTC-040:PASS");
        System.out.println();
    }
    /**
     * Test case 41:
     * @param args 
     */
    @Test
    public void test041CheckSendTime6_59AM() throws ParseException{
        System.out.println("TC041-Check send time at 6:59AM :");
        MainFunction m = new MainFunction();
        Date d = m.format.parse("6:59 AM");
        boolean result = m.checkValidTime(d);
        boolean expectedResult = false;
        assertEquals("Should be read without error",expectedResult, result);
        System.out.println("\tTC-040:PASS");
        System.out.println();
    }
    /**
     * Test case 42:
     * @param args 
     */
    @Test
    public void test042CheckSendTime7_00AM() throws ParseException{
        System.out.println("TC042-Check send time at 7:00AM :");
        MainFunction m = new MainFunction();
        Date d = m.format.parse("7:00 AM");
        boolean result = m.checkValidTime(d);
        boolean expectedResult = true;
        assertEquals("Should be read without error",expectedResult, result);
        System.out.println("\tTC-041:PASS");
        System.out.println();
    }
    /**
     * Test case 43:
     * @param args 
     */
    @Test
    public void test043CheckSendTime6_58AM() throws ParseException{
        System.out.println("TC043-Check send time at 7:00AM :");
        MainFunction m = new MainFunction();
        Date d = m.format.parse("6:58 AM");
        boolean result = m.checkValidTime(d);
        boolean expectedResult = false;
        assertEquals("Should be read without error",expectedResult, result);
        System.out.println("\tTC-042:PASS");
        System.out.println();
    }
    @Test
    public void defaultd(){
        MainFunction m = new MainFunction();
        boolean result = m.validTimeFormat("06:59 AM");
        boolean ex = true;
        assertEquals(ex, result);
    }
    public static void main(String []args) {  
            junit.textui.TestRunner.run(new TestSuite(MainFunctionTest.class));  
    } 
}
