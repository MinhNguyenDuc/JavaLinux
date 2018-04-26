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
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author minhnguyen
 */
public class ServerSocketNetwork {
    public static void main(String[] args) {
        ServerSocket listener = null;
        Socket socketOfSever;
        int port = 3001;
        BufferedReader br;
        BufferedWriter bw;
        
        
        try {
            listener = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            System.out.println("Server is waiting for user...");
            
            socketOfSever = listener.accept();
            
            System.out.println("Accept Client");
            
            br = new BufferedReader(new InputStreamReader(socketOfSever.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(socketOfSever.getOutputStream()));
            
            String line;
            
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            
            bw.write("Server rep Client");
            bw.newLine();
            bw.flush();
            
            bw.close();
            br.close();
            socketOfSever.close();
            
            System.out.println("Server Stop");
            
        } catch (Exception e) {
        }
        
    }
}
