/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textmessage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
    private DateFormat format = new SimpleDateFormat("hh:mm a");;
    
    public MainFunction() {
        allowedWords = new HashSet<>();
        bannedWords = new HashSet<>();
        content = new ArrayList<>();
        currentPos = 0;
        messages = new ArrayList<>();
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
    
    public void analyzeFile(){
        int allowedWordSize = Integer.parseInt(content.get(currentPos));
        //System.out.println("Allowed Words:"+allowedWordSize);
        /**
         * Get all the word allowed
         */
        for(int i = currentPos+1; i<currentPos + allowedWordSize + 1 ; i++){
            allowedWords.add(content.get(i));
            //System.out.println(content.get(i));
        }
        currentPos += (allowedWordSize+1);
        int bannedWordSize = Integer.parseInt(content.get(currentPos)); //get the number of banned words
        //System.out.println("Banned Words:" + bannedWordSize);
        /**
         * Get all the banned words
         */
        for(int i = currentPos+1; i < currentPos+ bannedWordSize+1 ;i++){
            bannedWords.add(content.get(i));
            //System.out.println(content.get(i));
        }
        currentPos += (bannedWordSize+1);
    }
    
    public void getAllMessage() throws ParseException{
        int numofMessage = Integer.parseInt(content.get(currentPos));
        for(int i = currentPos+1; i<currentPos + (numofMessage*2) +1; i+=2){
            Date sendTime = format.parse(content.get(i));
            String message = content.get(i+1);
            Message m = new Message(sendTime, message);
            messages.add(m);
            //System.out.println(m.toString());
        }
    }
    
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
        int countMisspelled = 0;
        for(String s: messArr){
            if(isForbiddenWord(s)){
                check = false;
                break;
            }
            if(isMisspelledWord(s)){
                countMisspelled++;
                continue;
            }
        }
        if(countMisspelled>=3){
            check = false;
        }
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
    public boolean isMisspelledWord(String word){
        boolean exist = false;
        for(String s:allowedWords){
            if(!s.equalsIgnoreCase(word)){
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
    
    
    
}
