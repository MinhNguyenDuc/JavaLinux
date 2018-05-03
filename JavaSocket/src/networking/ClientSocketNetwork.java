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
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        
        try {
            socketOfClient = new Socket(serverHost, port);
            
            bw = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));  
            
            System.out.println("Write message");
            String message = scanner.nextLine();
            bw.write("Client : " + message);
            bw.newLine();
            bw.flush();
            
            System.out.println("Client waiting for response...");
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            
            bw.close();
            br.close();
            socketOfClient.close();
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
    }
}
