package com.aluracursos.musica.servicios;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class YoutubeSearch {
    private static final String API_KEY = "AIzaSyDWO_F1_Pl-TmkdoAfNCaxZsOm24KjHHr4"; // Reemplaza con tu clave de API
    private static final String SEARCH_URL = "https://www.googleapis.com/youtube/v3/search";

    public static void buscarEnYouTube(String query) {
        try {
            // Codificar la consulta de búsqueda
            String queryEncoded = URLEncoder.encode(query, "UTF-8");
            String urlString = SEARCH_URL + "?part=snippet&q=" + queryEncoded + "&type=video&videoCategoryId=10&maxResults=1&key=" + API_KEY;
            URL url = new URL(urlString);

            // Realizar la solicitud HTTP
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Leer la respuesta
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Error en la conexión: " + responseCode);
            }

            Scanner scanner = new Scanner(url.openStream());
            StringBuilder inline = new StringBuilder();
            while (scanner.hasNext()) {
                inline.append(scanner.nextLine());
            }
            scanner.close();

            // Procesar la respuesta JSON con Gson
            JsonObject jsonResponse = JsonParser.parseString(inline.toString()).getAsJsonObject();
            JsonArray items = jsonResponse.getAsJsonArray("items");

            if (items != null && items.size() > 0) {
                for (int i = 0; i < items.size(); i++) {
                    JsonObject item = items.get(0).getAsJsonObject();
                    JsonObject snippet = item.getAsJsonObject("snippet");

                    String title = snippet.get("title").getAsString();
                    String description = snippet.get("description").getAsString();
                    System.out.println("Título: " + title);
                    System.out.println("Descripción: " + description);
                    System.out.println("-------------------");
                }
            } else {
                System.out.println("No se encontraron resultados.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la consulta de búsqueda: ");
        String query = scanner.nextLine();
        buscarEnYouTube(query);
    }
}