/*
 * Classe pertencente ao módulo de webservice do projeto CadHab.
 */
package com.conn;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class ConnectionManager {
    
    public ConnectionManager() {
        
        
        
    }
    
    public static void connect(String urlConnection, String input) throws MalformedURLException, IOException {
        
        java.net.URL url = new java.net.URL(com.sys.SystemSettings.url + urlConnection);  
        java.net.URLConnection urlConn = url.openConnection();  
        urlConn.setDoInput(true);  
        urlConn.setDoOutput(true);  
        urlConn.setUseCaches(false);
        urlConn.setDefaultUseCaches(false);
        urlConn.setRequestProperty("content-type", "text/plain");

        java.io.OutputStreamWriter outStream = new java.io.OutputStreamWriter(urlConn.getOutputStream());
        outStream.write(input);
        outStream.flush();  
        outStream.close();
                        
        java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(urlConn.getInputStream()));  
        java.io.DataInputStream objectInputStream = new java.io.DataInputStream(urlConn.getInputStream());
        String objectReceived = objectInputStream.readLine();
        objectInputStream.close();
        
    }
    
}
