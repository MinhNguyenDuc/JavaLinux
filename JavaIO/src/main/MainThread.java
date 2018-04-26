/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.sun.org.apache.xerces.internal.impl.io.ASCIIReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author minhnguyen
 */
public class MainThread {
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("https://vnexpress.net/");
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(is));
        
//        String line;
//        while((line = bf.readLine()) != null){
//            System.out.println(line);
//        }
        
//        Reader reader  = new InputStreamReader(is);
//        int i = -1;
//        while((i=reader.read()) != -1){
//            System.out.println((char)i);
//        }
//        reader.close();

        Writer writer = new FileWriter("/home/minhnguyen/Private/Project/java/Java/JavaIO/text/index.html");
        BufferedWriter bw = new BufferedWriter(writer);
        String line;
        while((line = bf.readLine()) != null){
            bw.write(line);
        }
        bw.close();
    }
}
