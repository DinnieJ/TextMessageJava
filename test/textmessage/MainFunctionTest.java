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
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////readFile() test/////////////////////////////////////
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
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////analyzeDictionary() test/////////////////////////////////////
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
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////analyzeForbidden() test/////////////////////////////////////
    /**
     * Test case 17: 
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
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////getAllMessage() test/////////////////////////////////////
    /**
     * Test case 28: 
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
     */
    @Test
    public void test032ReadWrongFormatNumberOfMessage(){
        System.out.println("TC032-Test wrong format number of message:");
        MainFunction m = new MainFunction();
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
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////checkValidTime() test/////////////////////////////////////
    /**
     * Test case 38: 
     * @throws java.text.ParseException
     */
    @Test
    public void test038CheckSendTime1_00AM() throws ParseException{
        System.out.println("TC038-Check send time at 1:00 AM :");
        MainFunction m = new MainFunction();
        Date d = MainFunction.format.parse("1:00 AM");
        boolean result = m.checkValidTime(d);
        boolean expectedResult = false;
        assertEquals("Should be read without error",expectedResult, result);
        System.out.println("\tTC-038:PASS");
        System.out.println();
    }
    /**
     * Test case 39: 
     * @throws java.text.ParseException
     */
    @Test
    public void test039CheckSendTime00_59AM() throws ParseException{
        System.out.println("TC033-Check send time at 00:59 AM :");
        MainFunction m = new MainFunction();
        Date d = MainFunction.format.parse("00:59 AM");
        boolean result = m.checkValidTime(d);
        boolean expectedResult = true;
        assertEquals("Should be read without error",expectedResult, result);
        System.out.println("\tTC-039:PASS");
        System.out.println();
    }
    /**
     * Test case 40: 
     * @throws java.text.ParseException
     */
    @Test
    public void test040CheckSendTime1_01AM() throws ParseException{
        System.out.println("TC040-Check send time at 1:01AM :");
        MainFunction m = new MainFunction();
        Date d = MainFunction.format.parse("1:01 AM");
        boolean result = m.checkValidTime(d);
        boolean expectedResult = false;
        assertEquals("Should be read without error",expectedResult, result);
        System.out.println("\tTC-040:PASS");
        System.out.println();
    }
    /**
     * Test case 41: 
     * @throws java.text.ParseException 
     */
    @Test
    public void test041CheckSendTime6_59AM() throws ParseException{
        System.out.println("TC041-Check send time at 6:59AM :");
        MainFunction m = new MainFunction();
        Date d = MainFunction.format.parse("6:59 AM");
        boolean result = m.checkValidTime(d);
        boolean expectedResult = false;
        assertEquals("Should be read without error",expectedResult, result);
        System.out.println("\tTC-040:PASS");
        System.out.println();
    }
    /**
     * Test case 42: 
     * @throws java.text.ParseException 
     */
    @Test
    public void test042CheckSendTime7_00AM() throws ParseException{
        System.out.println("TC042-Check send time at 7:00AM :");
        MainFunction m = new MainFunction();
        Date d = MainFunction.format.parse("7:00 AM");
        boolean result = m.checkValidTime(d);
        boolean expectedResult = true;
        assertEquals("Should be read without error",expectedResult, result);
        System.out.println("\tTC-041:PASS");
        System.out.println();
    }
    /**
     * Test case 43: 
     * @throws java.text.ParseException 
     */
    @Test
    public void test043CheckSendTime6_58AM() throws ParseException{
        System.out.println("TC043-Check send time at 7:00AM :");
        MainFunction m = new MainFunction();
        Date d = MainFunction.format.parse("6:58 AM");
        boolean result = m.checkValidTime(d);
        boolean expectedResult = false;
        assertEquals("Should be read without error",expectedResult, result);
        System.out.println("\tTC-043:PASS");
        System.out.println();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////checkValidMessage() test/////////////////////////////////////
    /**
     * Test case 44: 
     */
    public void test044CheckCorrectMessage(){
        System.out.println("TC044-Check correct message");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/Lib.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.checkValidMessage("I Jason love you");
        boolean expectedResult = true;
        assertEquals("Should return true",expectedResult, result);
        System.out.println("\tTC-044:PASS");
    }
    /**
     * Test case 45: 
     */
    public void test045CheckMessageWith2Mispells(){
        System.out.println("TC045-Check message with 2 misspell:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/Lib.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.checkValidMessage("i joson lve you");
        boolean expectedResult = true;
        assertEquals("Should return true",expectedResult, result);
        System.out.println("\tTC-045:PASS");
    }
    /**
     * Test case 46: 
     */
    public void test046CheckMessageWith3Misspells(){
        System.out.println("TC046-Check message with 3 misspell:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/Lib.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.checkValidMessage("i joson lve yu");
        boolean expectedResult = false;
        assertEquals("Should return false",expectedResult, result);
        System.out.println("\tTC-046:PASS");
    }
    /**
     * Test case 47 
     */
    @Test
    public void test047CheckMessageWithCaseInsensitive(){
        System.out.println("TC047-Check message with case insensitve:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/Lib.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.checkValidMessage("I Jason LoVe YoU");
        boolean expectedResult = true;
        assertEquals("Should return false",expectedResult, result);
        System.out.println("\tTC-047:PASS");
    }
    /**
     * Test case 48: 
     */
    @Test
    public void test048CheckMessageContainILoveYou(){
        System.out.println("TC048-Check message contain i love you:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/Lib.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.checkValidMessage("i love you jason");
        boolean expectedResult = false;
        assertEquals("Should return false",expectedResult, result);
        System.out.println("\tTC-048:PASS");
    }
    /**
     * Test case 49
     */
    @Test
    public void test049CheckMessageContainWhitespace(){
        System.out.println("TC049-Check message contain whitespace:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/Lib.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.checkValidMessage("i               jason      love    you");
        boolean expectedResult = true;
        assertEquals("Should return true",expectedResult, result);
        System.out.println("\tTC-049:PASS");
    }
    /**
     * Test case 50:
     */
    @Test
    public void test050CheckMessageContainForbiddenWord(){
        System.out.println("TC050-Check message contain forbidden word:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/Lib.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.checkValidMessage("jason you ahole");
        boolean expectedResult = false;
        assertEquals("Should return false",expectedResult, result);
        System.out.println("\tTC-050:PASS");
    }
    /**
     * Test case 51:
     */
    @Test
    public void test051CheckMessageWithOnlyForbiddenWord(){
        System.out.println("TC051-Check message contain only forbidden word:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/Lib.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.checkValidMessage("ahole jerk");
        boolean expectedResult = false;
        assertEquals("Should return false",expectedResult, result);
        System.out.println("\tTC-051:PASS");
    }
    /**
     * Test case 52:
     */
    @Test
    public void test052CheckMessageBlank(){
        System.out.println("TC052-Check message contain only forbidden word:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/Lib.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.checkValidMessage("");
        boolean expectedResult = true;
        assertEquals("Should return true",expectedResult, result);
        System.out.println("\tTC-052:PASS");
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////isCorrectWord() test/////////////////////////////////////
    /**
     * Test case 53:
     */
    @Test
    public void test053CheckExistedWordInDictionary(){
        System.out.println("TC053-Check correct word in dictionary:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/Lib.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        boolean result = m.isCorrectWord("love");
        boolean expectedResult = true;
        assertEquals("Should return true",expectedResult, result);
        System.out.println("\tTC-053:PASS");
    }
    /**
     * Test case 54
     */
    @Test
    public void test054CheckExistedWordCaseInsensitive(){
        System.out.println("TC054-Check correct word in dictionary case insensitive:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/Lib.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        boolean result = m.isCorrectWord("LoVe");
        boolean expectedResult = true;
        assertEquals("Should return true",expectedResult, result);
        System.out.println("\tTC-054:PASS");
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////isForbiddenWord() test/////////////////////////////////////
    /**
     * Test case 55
     */
    @Test
    public void test055CheckNotExistedWordInDictionary(){
        System.out.println("TC055-Check correct word in dictionary case insensitive:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/Lib.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        boolean result = m.isCorrectWord("lve");
        boolean expectedResult = false;
        assertEquals("Should return false",expectedResult, result);
        System.out.println("\tTC-055:PASS");
    }
    /**
     * Test case 56
     */
    @Test
    public void test056CheckExistedForbiddenWord(){
        System.out.println("TC056-Check word existed in forbidden:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/Lib.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.isForbiddenWord("jerk");
        boolean expectedResult = true;
        assertEquals("Should return true",expectedResult, result);
        System.out.println("\tTC-056:PASS");
    }
    /**
     * Test case 57
     */
    public void test057CheckExistedForbiddenWordCaseInsensitive(){
        System.out.println("TC057-Check word existed in forbidden case insensitive:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/Lib.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.isForbiddenWord("jErK");
        boolean expectedResult = true;
        assertEquals("Should return true",expectedResult, result);
        System.out.println("\tTC-057:PASS");
    }
    /**
     * Test case 58
     */
    public void test058CheckNotExistedForbiddenWord(){
        System.out.println("TC058-Check word existed in forbidden case insensitive:");
        MainFunction m = new MainFunction();
        assertEquals("FAILED TO READ FILE", m.readFile("src/testfile/Lib.txt"),true);
        assertEquals("Read first dictionary failed",m.analyzeDictionary(),true);
        assertEquals("Failed to read forbidden", m.analyzeForbidden(),true);
        boolean result = m.isForbiddenWord("hole");
        boolean expectedResult = false;
        assertEquals("Should return false",expectedResult, result);
        System.out.println("\tTC-058:PASS");
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////validTimeFormat() test/////////////////////////////////////
    /**
     * Test case 59:
     */
    @Test
    public void test059CheckCorrectAMFormat(){
        System.out.println("TC059-Check correct a.m time format:");
        MainFunction m = new MainFunction();
        boolean result = m.validTimeFormat("7:00 AM");
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-059:PASS");
    }
    /**
     * Test case 60:
     */
    @Test
    public void test060CheckCorrectPMFormat(){
        System.out.println("TC060-Check correct p.m time format:");
        MainFunction m = new MainFunction();
        boolean result = m.validTimeFormat("7:00 PM");
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-059:PASS");
    }
    /**
     * Test case 61:
     */
    @Test
    public void test061CheckNot12HFormat(){
        System.out.println("TC061-Check correct p.m time format:");
        MainFunction m = new MainFunction();
        boolean result = m.validTimeFormat("13:40");
        boolean expectedResult = false;
        assertEquals("Should return false", result,expectedResult);
        System.out.println("\tTC-061:PASS");
    }
    /**
     * Test case 62:
     */
    @Test
    public void test062CheckWrongHourValueFormat(){
        System.out.println("TC062-Check wrong hour value format:");
        MainFunction m = new MainFunction();
        boolean result = m.validTimeFormat("15:20 AM");
        boolean expectedResult = false;
        assertEquals("Should return false", result,expectedResult);
        System.out.println("\tTC-062:PASS");
    }
    /**
     * Test case 63
     */
    @Test
    public void test063CheckWrongMinuteValueFormat(){
        System.out.println("TC063-Check wrong hour value format:");
        MainFunction m = new MainFunction();
        boolean result = m.validTimeFormat("11:72 AM");
        boolean expectedResult = false;
        assertEquals("Should return false", result,expectedResult);
        System.out.println("\tTC-063:PASS");
    }
    /**
     * Test case 64
     */
    @Test
    public void test064CheckWrongBothHourAndMinuteValueFormat(){
        System.out.println("TC064-Check wrong both hour and minute value format:");
        MainFunction m = new MainFunction();
        boolean result = m.validTimeFormat("33:214 AM");
        boolean expectedResult = false;
        assertEquals("Should return false", result,expectedResult);
        System.out.println("\tTC-064:PASS");
    }
    /**
     * Test case 65:
     */
    @Test
    public void test065CheckWrongHourDataType(){
        System.out.println("TC065-Check wrong hour data type:");
        MainFunction m = new MainFunction();
        boolean result = m.validTimeFormat("aa:20 PM");
        boolean expectedResult = false;
        assertEquals("Should return false", result,expectedResult);
        System.out.println("\tTC-065:PASS");
    }
    /**
     * Test case 66:
     */
    @Test
    public void test066CheckWrongMinuteDataType(){
        System.out.println("TC066-Check wrong minute data type:");
        MainFunction m = new MainFunction();
        boolean result = m.validTimeFormat("10:bb AM");
        boolean expectedResult = false;
        assertEquals("Should return false", result,expectedResult);
        System.out.println("\tTC-066:PASS");
    }
    /**
     * Test case 67:
     */
    @Test
    public void test067CheckWrongBothHourAndMinuteDataType(){
        System.out.println("TC067-Check wrong both hour and minute data type:");
        MainFunction m = new MainFunction();
        boolean result = m.validTimeFormat("cc:dd AM");
        boolean expectedResult = false;
        assertEquals("Should return false", result,expectedResult);
        System.out.println("\tTC-067:PASS");
    }
    /**
     * Test case 68:
     */
    @Test
    public void test068CheckWrongAmPmFormat(){
        System.out.println("TC068-Check wrong a.m,p.m format:");
        MainFunction m = new MainFunction();
        boolean result = m.validTimeFormat("7:00 CM");
        boolean expectedResult = false;
        assertEquals("Should return false", result,expectedResult);
        System.out.println("\tTC-068:PASS");
    }
    /**
     * Test case 69:
     */
    @Test
    public void test069CheckCorrectAmPmFormatCaseInsensitive(){
        System.out.println("TC069-Check wrong a.m,p.m format:");
        MainFunction m = new MainFunction();
        boolean result = m.validTimeFormat("7:00 am");
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-069:PASS");
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////checkWordSize() test/////////////////////////////////////
    /**
     * Test case 70:
     */
    @Test
    public void test070CheckCorrectWordSize(){
        System.out.println("TC070-Check correct word size:");
        MainFunction m = new MainFunction();
        boolean result = m.checkWordSize("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-070:PASS");
    }
    /**
     * Test case 71:
     */
    @Test
    public void test071CheckWordLargerThan29Letter(){
        System.out.println("TC071-Check correct word size:");
        MainFunction m = new MainFunction();
        boolean result = m.checkWordSize("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        boolean expectedResult = false;
        assertEquals("Should return false", result,expectedResult);
        System.out.println("\tTC-071:PASS");
    }
    /**
     * Test case 72:
     */
    @Test
    public void test072CheckWordBetween0To29Letter(){
        System.out.println("TC072-Check word between 0-29 letters:");
        MainFunction m = new MainFunction();
        boolean result = m.checkWordSize("Jason");
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-072:PASS");
    }
    /**
     * Test case 73
     */
    @Test
    public void test073CheckBlankWord(){
        System.out.println("TC073-Check blank word:");
        MainFunction m = new MainFunction();
        boolean result = m.checkWordSize("");
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-073:PASS");
    }
    /**
     * Test case 74:
     */
    @Test
    public void test074CheckWordWith1Letter(){
        System.out.println("TC074-Check word with 1 letter:");
        MainFunction m = new MainFunction();
        boolean result = m.checkWordSize("a");
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-074:PASS");
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////checkMaximumAllowedWord() test/////////////////////////////////////
    /**
     * Test case 75:
     */
    @Test
    public void test075Check29999Word(){
        System.out.println("TC075-Check 29999 word:");
        MainFunction m = new MainFunction();
        boolean result = m.checkMaximumAllowedWord(29999);
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-075:PASS");
    }
    /**
     * Test case 76:
     */
    @Test
    public void test076Check30000Word(){
        System.out.println("TC076-Check 30000 word:");
        MainFunction m = new MainFunction();
        boolean result = m.checkMaximumAllowedWord(30000);
        boolean expectedResult = false;
        assertEquals("Should return false", result,expectedResult);
        System.out.println("\tTC-076:PASS");
    }
    /**
     * Test case 77:
     */
    @Test
    public void test077Check1Word(){
        System.out.println("TC077-Check 1 word:");
        MainFunction m = new MainFunction();
        boolean result = m.checkMaximumAllowedWord(1);
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-077:PASS");
    }
    /**
     * Test case 78:
     */
    @Test
    public void test078CheckNoWord(){
        System.out.println("TC078-Check 0 word:");
        MainFunction m = new MainFunction();
        boolean result = m.checkMaximumAllowedWord(0);
        boolean expectedResult = false;
        assertEquals("Should return false", result,expectedResult);
        System.out.println("\tTC-078:PASS");
    }
    /**
     * Test case 79:
     */
    @Test
    public void test079Check10000Word(){
        System.out.println("TC079-Check 10000 word:");
        MainFunction m = new MainFunction();
        boolean result = m.checkMaximumAllowedWord(10000);
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-079:PASS");
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////checkMaximumForbiddenWord() test/////////////////////////////////////
    /**
     * Test case 80:
     */
    @Test
    public void test080Check99ForbiddenWords(){
        System.out.println("TC080-Check 99 forbidden word:");
        MainFunction m = new MainFunction();
        boolean result = m.checkMaximumForbiddenWord(99);
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-080:PASS");
    }
    /**
     * Test case 81:
     */
    @Test
    public void test081Check100ForbiddenWords(){
        System.out.println("TC081-Check 100 forbidden word:");
        MainFunction m = new MainFunction();
        boolean result = m.checkMaximumForbiddenWord(100);
        boolean expectedResult = false;
        assertEquals("Should return false", result,expectedResult);
        System.out.println("\tTC-081:PASS");
    }
    /**
     * Test case 82:
     */
    @Test
    public void test082Check1ForbiddenWords(){
        System.out.println("TC082-Check 100 forbidden word:");
        MainFunction m = new MainFunction();
        boolean result = m.checkMaximumForbiddenWord(1);
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-082:PASS");
    }
    /**
     * Test case 83:
     */
    @Test
    public void test083CheckZeroForbiddenWords(){
        System.out.println("TC083-Check 0 forbidden word:");
        MainFunction m = new MainFunction();
        boolean result = m.checkMaximumForbiddenWord(0);
        boolean expectedResult = false;
        assertEquals("Should return false", result,expectedResult);
        System.out.println("\tTC-083:PASS");
    }
    /**
     * Test case 84:
     */
    @Test
    public void test084Check50ForbiddenWords(){
        System.out.println("TC084-Check 50 forbidden word:");
        MainFunction m = new MainFunction();
        boolean result = m.checkMaximumForbiddenWord(50);
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-084:PASS");
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////checkMaximumWordsInMessage() test/////////////////////////////////////
    /**
     * Test case 85:
     */
    @Test
    public void test085CheckCorrectMessageLength(){
        System.out.println("TC085-Check correct message length:");
        MainFunction m = new MainFunction();
        boolean result = m.checkMaximumWordsInMessage("hold it lul");
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-085:PASS");
    }
    /**
     * Test case 86:
     */
    @Test
    public void test086Check50WordsMessage(){
        System.out.println("TC086-Check correct message length:");
        MainFunction m = new MainFunction();
        boolean result = m.checkMaximumWordsInMessage("a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a ");
        boolean expectedResult = false;
        assertEquals("Should return false", result,expectedResult);
        System.out.println("\tTC-086:PASS");
    }
    /**
     * Test case 87:
     */
    @Test
    public void test087Check49WordsMessage(){
        System.out.println("TC087-Check correct message length:");
        MainFunction m = new MainFunction();
        boolean result = m.checkMaximumWordsInMessage("a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a");
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-087:PASS");
    }
    /**
     * Test case 88:
     */
    @Test
    public void test088Check1WordsMessage(){
        System.out.println("TC088-Check correct message length:");
        MainFunction m = new MainFunction();
        boolean result = m.checkMaximumWordsInMessage("a");
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-088:PASS");
    }
    /**
     * Test case 89:
     */
    @Test
    public void test089CheckBlankMessage(){
        System.out.println("TC089-Check correct message length:");
        MainFunction m = new MainFunction();
        boolean result = m.checkMaximumWordsInMessage("");
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-089:PASS");
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////isWhiteSpace() test/////////////////////////////////////
    /**
     * Test case 90:
     */
    @Test
    public void test090CheckEmptyWhitespace(){
        System.out.println("TC090-Check whitespace:");
        MainFunction m = new MainFunction();
        boolean result = m.isWhiteSpace("");
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-090:PASS");
    }
    /**
     * Test case 91:
     */
    @Test
    public void test091heckWhitespace(){
        System.out.println("TC091-Check whitespace:");
        MainFunction m = new MainFunction();
        boolean result = m.isWhiteSpace("          ");
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-091:PASS");
    }
    /**
     * Test case 92:
     */
    @Test
    public void test092CheckWhitespace(){
        System.out.println("TC092-Check whitespace:");
        MainFunction m = new MainFunction();
        boolean result = m.isWhiteSpace("test");
        boolean expectedResult = false;
        assertEquals("Should return false", result,expectedResult);
        System.out.println("\tTC-092:PASS");
    }
    /**
     * Test case 93:
     */
    @Test
    public void test093CheckLineBreak(){
        System.out.println("TC093-Check whitespace:");
        MainFunction m = new MainFunction();
        boolean result = m.isWhiteSpace("\n");
        boolean expectedResult = true;
        assertEquals("Should return true", result,expectedResult);
        System.out.println("\tTC-093:PASS");
    }
    public static void main(String []args) {  
            junit.textui.TestRunner.run(new TestSuite(MainFunctionTest.class));  
    } 
}
