/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textmessage;


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
        if(!m.readFile("src/textmsg.txt")){
            System.exit(-1);
        }
        if(m.analyzeFile()){
            if(m.getAllMessage()){
                m.confirmMessage();
            }else{
                System.exit(-1);
            }
        }else{
            System.exit(-1);
        }
        

    }
    
}
