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
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        
        try {
            listener = new ServerSocket(port);
            System.out.println("Server is waiting for user...");
            
            socketOfSever = listener.accept();
            
            System.out.println("Accept Client");
            
            br = new BufferedReader(new InputStreamReader(socketOfSever.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(socketOfSever.getOutputStream()));
            
            String line = br.readLine();
            System.out.println(line);
            
            System.out.println("Write response : ");
            bw.write("Server : " + scanner.nextLine());
            bw.newLine();
            bw.flush();

            
            System.out.println("Server Stop");
            
        } catch (Exception e) {
        }
        
    }
}
