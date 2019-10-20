/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textmessage;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MemeLord
 */
public class TextMessage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        MainFunction m = new MainFunction();
        m.readFile("src/textmsg.txt");
        m.analyzeFile();
        m.getAllMessage();
        m.confirmMessage();
    }
    
}
