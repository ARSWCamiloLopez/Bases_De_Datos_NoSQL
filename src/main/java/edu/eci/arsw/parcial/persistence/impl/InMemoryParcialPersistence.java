/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.persistence.impl;

import edu.eci.arsw.parcial.persistence.ParcialPersistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Service;

/**
 *
 * @author camilolopez
 */
@Service
public class InMemoryParcialPersistence implements ParcialPersistence {

    @Override
    public String obtenerAccionesIntraDia(String identificador) throws IOException {
        String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol="
                + identificador + "&interval=5min&apikey=P46J69T1UVRIYV4L";
        return getHtppRequest(GET_URL);
    }

    @Override
    public String obtenerAccionesDiarias(String identificador) throws IOException{
                String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" +
                        identificador + "&apikey=P46J69T1UVRIYV4L";
        return getHtppRequest(GET_URL);
    }

    @Override
    public String obtenerAccionesSemanales(String identificador) throws IOException{
                String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_WEEKLY&symbol=" +
                        identificador + "&apikey=P46J69T1UVRIYV4L";
        return getHtppRequest(GET_URL);
    }

    @Override
    public String obtenerAccionesMensuales(String identificador) throws IOException{
                String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol=" +
                        identificador + "&apikey=P46J69T1UVRIYV4L";
        return getHtppRequest(GET_URL);
    }

    private final String USER_AGENT = "Mozilla/5.0";

    public String getHtppRequest(String GET_URL) throws IOException {

        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response.toString();

        } else {
            System.out.println("GET request not worked");
            return "No se han podido obtener las acciones";
        }
    }

}
