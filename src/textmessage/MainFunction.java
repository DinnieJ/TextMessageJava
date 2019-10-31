/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textmessage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author MemeLord
 */
public class MainFunction {
    
    private final Set<String> allowedWords;
    private final Set<String> bannedWords;
    private final List<Message> messages;
    private final List<String> content;
    private int currentPos;
    private final DateFormat format;
    
    public MainFunction() {
        allowedWords = new HashSet<>();
        bannedWords = new HashSet<>();
        content = new ArrayList<>();
        currentPos = 0;
        messages = new ArrayList<>();
        format = new SimpleDateFormat("hh:mm a");
    }
    /**
     * Read the file and add each line into the List<String> for later usage
     * @param src
     * @return 
     */
    public boolean readFile(String src){
        BufferedReader br = null;
        if(!src.endsWith(".txt")){
            System.err.println("WRONG FILE FORMAT (require .txt)");
            return false;
        }
        try {
            File f = new File(src);
            br = new BufferedReader(new FileReader(f));
            String st="";
            while((st = br.readLine()) != null){
                if(!isWhiteSpace(st))
                content.add(st);
                //System.out.println(st);
            }
            if(content.isEmpty()){
                System.err.println("EMPTY FILE "+src);
                return false;
            }
        } catch (IOException ex) {
            System.err.println("FILE NOT FOUND "+src);
            return false;
        }
        return true;
    }
    
    /**
     * 
     * @return 
     */
    public boolean analyzeDictionary(){
        int allowedWordSize = 0;
        try{
            allowedWordSize = Integer.parseInt(content.get(currentPos));
            if(!checkMaximumAllowedWord(allowedWordSize)){
                System.err.println("The allowed word quantity reach out of boundary (0-30000 words)");
                return false;
            }
        }catch(NumberFormatException ex){
            System.err.println("YOUR FILE HAS INCORRECT FORMAT,PLEASE CHECK THE FILE AND TRY AGAIN");
            return false;
        }
        /**
         * Get all the word allowed
         */
        for(int i = currentPos+1; i<currentPos + allowedWordSize + 1 ; i++){
            if( checkWordSize(content.get(i).trim())){
                allowedWords.add(content.get(i).trim());
            } else {
                System.err.println("Word "+content.get(i).toLowerCase()+" is invalid (Reason: Too long)");
            }   
        }
        currentPos += (allowedWordSize+1);
        return true;
    }
    
    public boolean analyzeForbidden(){
        int bannedWordSize = 0;
        try{
            bannedWordSize = Integer.parseInt(content.get(currentPos)); //get the number of banned words
            if(!checkMaximumForbiddenWord(bannedWordSize)){
                System.err.println("The forbidden word quantity reach out of boundary (0-100 words)");
                return false;
            }
        }catch(NumberFormatException ex){
            System.err.println("YOUR FILE HAS INCORRECT FORMAT,PLEASE CHECK THE FILE AND TRY AGAIN");
            return false;
        }
        /**
         * Get all the banned words
         */
        for(int i = currentPos+1; i < currentPos+ bannedWordSize+1 ;i++){
            if(checkWordSize(content.get(i).trim()))
                bannedWords.add(content.get(i).toLowerCase().trim());
            else{
                System.err.println("Word "+content.get(i).toLowerCase()+" is invalid (Reason: Too long)");
            }
        }
        currentPos += (bannedWordSize+1);
        return true;
    }
    
    /**
     * Split and analyze all the message in a pair of line
     * skip the message if the format of the time is wrong (HH:MM (AM/PM))
     * or the format of the message is incorrect (Msg_length Msg_content)
     * @return 
     */
    public boolean getAllMessage(){
        int numofMessage = 0;
        try{
            numofMessage = Integer.parseInt(content.get(currentPos));
        }catch(NumberFormatException ex){
            System.err.println("YOUR FILE HAS INCORRECT FORMAT,PLEASE CHECK THE FILE AND TRY AGAIN");
            return false;
        }
        for(int i = currentPos+1; i<currentPos + (numofMessage*2) +1; i+=2){
            
            Date sendTime = null;
            
            try {
                if(validTimeFormat(content.get(i))){
                    sendTime = format.parse(content.get(i));
                }
                else{
                    System.err.println("Invalid time format \""+content.get(i)+"\"");
                    continue;
                }
            } catch (ParseException ex) {
                System.err.println("The time format of the message \""+content.get(i)+" \" is unreadable");
                continue;
            }
            
            String [] splitMsg = content.get(i+1).split("\\s+");
            
            //String message = content.get(i+1).substring(1,content.get(i+1).length()).trim();
            int length = 0;
            String message ="";
            for(int j = 1;j<splitMsg.length;j++){
                message += (splitMsg[j] +" ");
            }
            try{
               length = Integer.parseInt(splitMsg[0]);
               if(!checkMaximumWordsInMessage(message) || length != splitMsg.length-1 ){
                   System.err.println("WRONG NUMBER OF WORDS IN MESSAGE:" + message );
                   continue;
               }
            }catch(NumberFormatException e){
                System.err.println("The message: "+message+" construct is in wrong format (msg_length msg_content)");
                System.out.println(message.trim());
                continue;
            }
            
            Message m = new Message(sendTime, message.trim(),length);
            messages.add(m);
            //System.out.println(m.toString());
        }
        return true;
    }
    
    /**
     * Checking the time allowed to test
     * The time the message must be tested is from 1:00 AM - 6:59 AM
     * @param m
     * @return 
     */
    public boolean checkValidTime(Message m){
        boolean check = true;
        Date FROM_TIME = null;
        Date TO_TIME = null;
        try {
            FROM_TIME = format.parse("1:00 AM");
            TO_TIME = format.parse("6:59 AM");
        } catch (ParseException ex) {
            Logger.getLogger(MainFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(m.getTime().compareTo(FROM_TIME) >= 0 && m.getTime().compareTo(TO_TIME) <= 0){
            check = false;
        }
        else check = true;
        return check;
    }
    
    /**
     * Validate the content of the message
     * The condition to block the message:
     * 1.The strings “I”, “love”, and “you” appear consecutively, in that order, in any capitalization
     * 2.Three or more misspelled words
     * 3.Has a forbidden word
     * @param m
     * @return 
     */
    public boolean checkValidMessage(Message m){
        boolean check = true;
        if(m.getMessage().toLowerCase().contains("I love you".toLowerCase())){
            check = false;
        }
        String[] messArr = m.getMessage().split("\\s+");
        int misspellWordCount = 0;
        for(String s: messArr){
            if(isForbiddenWord(s)){
                check = false;
                break;
            }
            if(!isCorrectWord(s)){
                misspellWordCount++;
            }
        }
        if(misspellWordCount >=3){
            check = false;
        }
        //System.out.println("Message:"+m.getMessage()+"/"+misspellWordCount);
        return check;
    }
    
    /**
     * End point function: Show all the message,
     * if the message is failed in the validation, will print out Message #n: FAILED TO SEND
     * otherwise, print out Message #n: (message_content)
     */
    public void confirmMessage(){
        int current = 1;
        for(Message m: messages){
            if(checkValidTime(m)){
                System.out.println("Message #"+ (current++)+": "+m.getMessage());
                System.out.println();
            }
            else{
                if(checkValidMessage(m)){
                    System.out.println("Message #"+ (current++)+": "+m.getMessage());
                    System.out.println();
                }else{
                    System.out.println("Message #"+(current++)+": FAILED TO SEND");
                    System.out.println();
                }
            }
        }
    }
    
    /**
     * Check if the word exist in the dictionary
     * @param word
     * @return 
     */
    public boolean isCorrectWord(String word){
        boolean exist = false;
        for(String s:allowedWords){
            if(s.equalsIgnoreCase(word)){
                //System.out.println(word);
                exist = true;
                break;
            }
        }
        return exist;
    }
    
    /**
     * Check if the word is the forbidden word
     * @param word
     * @return 
     */
    public boolean isForbiddenWord(String word){
        boolean exist = false;
        for(String s:bannedWords){
            if(word.equalsIgnoreCase(s)){
                exist = true;
                break;
            }
        }
        return exist;
    }
    
    /**
     * Valid the format of the time input
     * @param timeString
     * @return 
     */
    public boolean validTimeFormat(String timeString){
        return timeString.matches("(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)");
    }
    
    /**
     * Check if the word is longer than 29 letters
     * @param word
     * @return 
     */
    public boolean checkWordSize(String word){
        return word.length() <= 29;
    }
    
    /**
     * Check the boundary of the allowed word
     * @param size
     * @return 
     */
    public boolean checkMaximumAllowedWord(int size){
        return size > 0 && size <30000;
    }
    
    /**
     * Check the boundary of the forbidden word
     * @param size
     * @return 
     */
    public boolean checkMaximumForbiddenWord(int size){
        return size >0 && size <100;
    }
    
    /**
     * Check maximum word in the message
     * @param message
     * @return 
     */
    public boolean checkMaximumWordsInMessage(String message){
        String [] sMessage = message.split("\\s+");
        return sMessage.length < 50 && sMessage.length > 0;
    }
    
    /**
     * Check if the word is whitespace
     * @param word
     * @return 
     */
    public boolean isWhiteSpace(String word){
        return word.trim().equals("");
    }
}
