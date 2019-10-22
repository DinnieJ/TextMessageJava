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
    private Date time;
    private String message;
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    public Message() {
    }

    public Message(Date time, String message,int length) {
        this.time = time;
        this.message = message;
        this.length = length;
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
