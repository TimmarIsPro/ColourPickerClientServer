/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colourpicker;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.FileInputStream;
import org.json.JSONObject;

public class ColourPickerServer {
    
    static String filename = "colors.ser";
    
    public static void main(String[] args)
    {
        JSONObject[] listColor = new JSONObject[4];
        String input = "";
        
        System.out.println("Server waiting.");
        
        try {
            FileInputStream fis = new FileInputStream(filename);
            int i = 0;
            StringBuilder sb = new StringBuilder();
            while ((i=fis.read())!=-1){
                //System.out.print((char)i);
                sb.append((char)i);
            }
            fis.close();
            input = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try
        {
            ServerSocket srvr = new ServerSocket(1234);
            Socket skt = srvr.accept();
            
            System.out.println("Connected");
            PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
            System.out.println("Sending JSON");
            out.println(input);
            out.close();
            
            skt.close();
            srvr.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
