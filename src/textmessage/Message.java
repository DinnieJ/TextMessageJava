/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textmessage;

import java.util.Date;

/**
 *
 * @author MemeLord
 */
public class Message {
    public  Date time;
    private String message;

    public Message() {
    }

    public Message(Date time, String message) {
        this.time = time;
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    @Override
    public String toString() {
        return "Message{" + "time=" + time + ", message=" + message + '}';
    }
    
    
    
    
}
