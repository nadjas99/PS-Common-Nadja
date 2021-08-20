/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author FON
 */
public class Sender implements Serializable{
    private Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
    }
    
    
    public void send(Object object) throws Exception{
        try{
            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            out.writeObject(object);
            out.flush();
    
        }catch(SocketException se){
            throw se;
        }
        catch(Exception e){
            throw new Exception("Error sending object!\n"+e.getMessage());
        }
    }
    
    
}
