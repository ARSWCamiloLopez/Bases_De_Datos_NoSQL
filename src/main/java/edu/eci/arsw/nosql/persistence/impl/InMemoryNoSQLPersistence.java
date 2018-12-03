/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.nosql.persistence.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import edu.eci.arsw.nosql.model.Accion;
import edu.eci.arsw.nosql.model.AccionRepository;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Service;
import edu.eci.arsw.nosql.persistence.NoSQLPersistence;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author camilolopez
 */
@Service
public class InMemoryNoSQLPersistence implements NoSQLPersistence {

    @Autowired
    AccionRepository repository;
    
    @Override
    public String obtenerAccionesIntraDia(String identificador) throws IOException {

        String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol="
                + identificador + "&interval=5min&apikey=P46J69T1UVRIYV4L";

        String identificadorAccion = identificador + "intraday";

        if (verifyIfShareIsSaved(identificadorAccion)) {

            String stringAccion = repository.findBynombreAccion(identificadorAccion).getStringAccion();
            boolean condicion = updateShareInformationInDataBase(GET_URL, identificadorAccion, stringAccion);
            if (condicion) {
                System.out.println("Acciones actualizadas");
                obtenerAccionesIntraDia(identificador);
            }
            System.out.println("Acciones no actualizadas");
            return stringAccion;

        } else {

            String shareString = getHtppRequest(GET_URL);
            Accion accionIntradia = new Accion(identificadorAccion, "intraday", shareString);
            repository.save(accionIntradia);
            return shareString;
        }
    }

    @Override
    public String obtenerAccionesDiarias(String identificador) throws IOException {

        String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="
                + identificador + "&apikey=P46J69T1UVRIYV4L";

        String identificadorAccion = identificador + "daily";

        if (verifyIfShareIsSaved(identificadorAccion)) {

            String stringAccion = repository.findBynombreAccion(identificadorAccion).getStringAccion();
            boolean condicion = updateShareInformationInDataBase(GET_URL, identificadorAccion, stringAccion);
            if (condicion) {
                System.out.println("Acciones actualizadas");
                obtenerAccionesDiarias(identificador);
            }
            System.out.println("Acciones no actualizadass");
            return stringAccion;

        } else {

            String shareString = getHtppRequest(GET_URL);
            Accion accionDiaria = new Accion(identificadorAccion, "daily", shareString);
            repository.save(accionDiaria);
            return shareString;
        }
    }

    @Override
    public String obtenerAccionesSemanales(String identificador) throws IOException {
        String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_WEEKLY&symbol="
                + identificador + "&apikey=P46J69T1UVRIYV4L";

        String identificadorAccion = identificador + "weekly";

        if (verifyIfShareIsSaved(identificadorAccion)) {

            String stringAccion = repository.findBynombreAccion(identificadorAccion).getStringAccion();
            boolean condicion = updateShareInformationInDataBase(GET_URL, identificadorAccion, stringAccion);
            if (condicion) {
                System.out.println("Acciones actualizadas");
                obtenerAccionesSemanales(identificador);
            }
            System.out.println("Acciones no actualizadas");
            return stringAccion;

        } else {

            String shareString = getHtppRequest(GET_URL);
            Accion accionSemanal = new Accion(identificadorAccion, "weekly", shareString);
            repository.save(accionSemanal);
            return shareString;
        }
    }

    @Override
    public String obtenerAccionesMensuales(String identificador) throws IOException {
        String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol="
                + identificador + "&apikey=P46J69T1UVRIYV4L";

        String identificadorAccion = identificador + "monthly";

        if (verifyIfShareIsSaved(identificadorAccion)) {

            String stringAccion = repository.findBynombreAccion(identificadorAccion).getStringAccion();
            boolean condicion = updateShareInformationInDataBase(GET_URL, identificadorAccion, stringAccion);
            if (condicion) {
                System.out.println("Acciones actualizadas");
                obtenerAccionesMensuales(identificador);
            }
            System.out.println("Acciones no actualizadas");
            return stringAccion;

        } else {

            String shareString = getHtppRequest(GET_URL);
            Accion accionMensual = new Accion(identificadorAccion, "monthly", shareString);
            repository.save(accionMensual);
            return shareString;
        }
    }

    /**
     *
     * @param identificador
     * @param identificadorAccion
     * @param jsonAntiguo
     * @throws IOException
     */
    public boolean updateShareInformationInDataBase(String identificador, String identificadorAccion,
            String jsonAntiguo) throws IOException {

        String jsonNuevo = getHtppRequest(identificador);

        String fechaAccionAntigua = getShareDate(jsonAntiguo);
        String fechaAccionNueva = getShareDate(jsonNuevo);

        String fechaAntigua = fechaAccionAntigua.substring(1, 10);
        String horaAntigua = fechaAccionAntigua.substring(12, 19);

        String fechaNueva = fechaAccionNueva.substring(1, 10);
        String horaNueva = fechaAccionNueva.substring(12, 19);

        if (fechaAntigua.equals(fechaNueva)) {
            if (!horaAntigua.equals(horaNueva)) {
                repository.delete(identificadorAccion);
                return true;
            }
        } else {
            repository.delete(identificadorAccion);
            return true;
        }

        return false;
    }

    /**
     *
     * @param informacionAccion
     * @return
     */
    public String getShareDate(String informacionAccion) {

        String dateString;
        return dateString = informacionAccion.substring(informacionAccion.indexOf("Last") + 17,
                informacionAccion.indexOf("Last") + 38);

    }

    /**
     *
     * @param identifier
     * @return
     */
    public boolean verifyIfShareIsSaved(String identifier) {

        boolean condition = false;

        if (repository.findBynombreAccion(identifier) != null) {
            condition = true;
        }

        return condition;
    }

    private final String USER_AGENT = "Mozilla/5.0";

    /**
     *
     * @param GET_URL
     * @return
     * @throws IOException
     */
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
            return response.toString();

        } else {
            System.out.println("GET request not worked");
            return "No se han podido obtener las acciones";
        }
    }

}
