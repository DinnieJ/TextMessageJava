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
    
    private Set<String> allowedWords;
    private Set<String> bannedWords;
    private List<Message> messages;
    private List<String> content;
    private int currentPos;
    private DateFormat format;
    
    public MainFunction() {
        allowedWords = new HashSet<>();
        bannedWords = new HashSet<>();
        content = new ArrayList<>();
        currentPos = 0;
        messages = new ArrayList<>();
        format = new SimpleDateFormat("hh:mm a");
    }
    
    public void readFile(String src){
        BufferedReader br = null;
        try {
            File f = new File(src);
            br = new BufferedReader(new FileReader(f));
            String st="";
            while((st = br.readLine()) != null){
                content.add(st);
                //System.out.println(st);
            }
        } catch (IOException ex) {
            System.out.println("FILE NOT FOUND");
            System.exit(0);
        }
    }
    
    public boolean analyzeFile(){
        int allowedWordSize = 0;
        try{
            allowedWordSize = Integer.parseInt(content.get(currentPos));
        }catch(NumberFormatException ex){
            System.err.println("YOUR FILE HAS INCORRECT FORMAT,PLEASE CHECK THE FILE AND TRY AGAIN");
            return false;
        }
        //System.out.println("Allowed Words:"+allowedWordSize);
        /**
         * Get all the word allowed
         */
        for(int i = currentPos+1; i<currentPos + allowedWordSize + 1 ; i++){
            if( checkWordSize(content.get(i)) ){
                allowedWords.add(content.get(i));
            } else {
                System.err.println("Word "+content.get(i).toLowerCase()+" is invalid (Reason: Too long)");
            }
            
        }
        currentPos += (allowedWordSize+1);
        int bannedWordSize = 0;
        try{
            bannedWordSize = Integer.parseInt(content.get(currentPos)); //get the number of banned words
        }catch(NumberFormatException ex){
            System.err.println("YOUR FILE HAS INCORRECT FORMAT,PLEASE CHECK THE FILE AND TRY AGAIN");
            return false;
        }
        
        /**
         * Get all the banned words
         */
        for(int i = currentPos+1; i < currentPos+ bannedWordSize+1 ;i++){
            bannedWords.add(content.get(i).toLowerCase());
        }
        currentPos += (bannedWordSize+1);
        return true;
    }
    
    /**
     * Split and analyze all the message in a pair of line
     * skip the message if the format of the date is wrong;
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
            String message = content.get(i+1);
            Date sendTime = null;
            
            try {
                if(validTimeFormat(content.get(i))){
                    sendTime = format.parse(content.get(i));
                }
                else{
                    System.err.println("Invalid time for message \""+message+"\"");
                    continue;
                }
            } catch (ParseException ex) {
                System.err.println("The time format of the message \""+message+" \" is unreadable");
                continue;
            }
            Message m = new Message(sendTime, message);
            messages.add(m);
            //System.out.println(m.toString());
        }
        return true;
    }
    
    /**
     * Checking the time allowed to test
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
    
    public boolean checkValidMessage(Message m){
        boolean check = true;
        if(m.getMessage().toLowerCase().contains("I love you".toLowerCase())){
            check = false;
        }
        String[] messArr = m.getMessage().split(" ");
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
     * Valid the format of the time imput
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

}
