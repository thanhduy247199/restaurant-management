/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
 import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;
/**
 *
 * @author Administrator
 */
public class GETData {
   
   


	public static String MyGETRequest(String text) throws IOException {
    URL urlForGetRequest = new URL("https://smartroomserver.herokuapp.com/api/class/createQRCode?text=" + text);
    String readLine = null;
    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
    conection.setRequestMethod("GET");
    conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
    int responseCode = conection.getResponseCode();
    if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader in = new BufferedReader(
            new InputStreamReader(conection.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((readLine = in .readLine()) != null) {
            response.append(readLine);
        } in .close();
        // print result
         return response.toString();
        //GetAndPost.POSTRequest(response.toString());
    } else {
        return "GET NOT WORKED";
    }
}
	
}
