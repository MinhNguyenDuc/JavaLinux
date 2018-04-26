/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author minhnguyen
 */
public class ClientSocketNetwork {
    
    
    public static void main(String[] args) {
        final String serverHost = "localhost";
        int port = 3001;
        Socket socketOfClient;
        BufferedReader br;
        BufferedWriter bw;
        
        try {
            socketOfClient = new Socket(serverHost, port);
            
            bw = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));  
            
            bw.write("Client : Hello server i'm client");
            bw.newLine();
            bw.flush();
            
            String line;
            while((line = br.readLine()) != null){
                System.out.println("Server : " + line);
            }
            
            bw.close();
            br.close();
            socketOfClient.close();
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
    }
}
