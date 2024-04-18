package com.mycompany.parcial2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Clase utilitaria para crear conexiones HTTP.
 * Esta clase no debe ser instanciada.
 */
public class HttpConnectionExample {

    private static final String USER_AGENT = "Mozilla/5.0";

    /**
     * Constructor privado para prevenir la instanciación de esta clase utilitaria.
     * @throws UnsupportedOperationException si se intenta instanciar.
     */
    private HttpConnectionExample() {
        throw new UnsupportedOperationException("HttpConnectionExample es una clase utilitaria y no puede ser instanciada");
    }

    /**
     * Establece una conexión HTTP GET a la URL especificada y recupera la respuesta como una cadena de texto.
     *
     * @param arg la URL a la cual se envía la solicitud GET
     * @return la respuesta de la URL como una cadena de texto
     * @throws IOException si ocurre un error de E/S durante la comunicación de red
     */
    public static String Connection(String arg) throws IOException {
        String url = arg;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("Código de Respuesta GET :: " + responseCode);
        StringBuffer response = new StringBuffer();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Imprimir resultado
            System.out.println(response.toString());
        } else {
            System.out.println("La solicitud GET no funcionó");
        }
        System.out.println("GET FINALIZADO");
        return response.toString();
    }
}
