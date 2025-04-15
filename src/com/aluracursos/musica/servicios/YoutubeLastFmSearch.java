package com.aluracursos.musica.servicios;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

    public class YoutubeLastFmSearch {
    private static final String YOUTUBE_API_KEY = "AIzaSyDWO_F1_Pl-TmkdoAfNCaxZsOm24KjHHr4"; // Reemplaza con tu clave de API
    private static final String YOUTUBE_SEARCH_URL = "https://www.googleapis.com/youtube/v3/search";
    private static final String LAST_FM_API_KEY = "bf321295e4d700d0f842130b7cc06b81"; // Reemplaza con tu clave de API
    private static final String LAST_FM_SEARCH_URL = "http://ws.audioscrobbler.com/2.0/";

    public static void buscarFichaTecnica(String query) {
        try {
            // Primera búsqueda en YouTube
            String queryEncoded = URLEncoder.encode(query, "UTF-8");
            String youtubeUrl = YOUTUBE_SEARCH_URL + "?part=snippet&q=" + queryEncoded + "&type=video&videoCategoryId=10&maxResults=1&key=" + YOUTUBE_API_KEY;
            URL url = new URL(youtubeUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Error en la conexión a YouTube: " + responseCode);
            }

            Scanner scanner = new Scanner(url.openStream());
            StringBuilder inline = new StringBuilder();
            while (scanner.hasNext()) {
                inline.append(scanner.nextLine());
            }
            scanner.close();

            JsonObject youtubeResponse = JsonParser.parseString(inline.toString()).getAsJsonObject();
            JsonArray items = youtubeResponse.getAsJsonArray("items");

            if (items != null && items.size() > 0) {
                JsonObject item = items.get(0).getAsJsonObject();
                JsonObject snippet = item.getAsJsonObject("snippet");

                String title = snippet.get("title").getAsString();
                String artist = snippet.get("channelTitle").getAsString();

                System.out.println("Resultado de YouTube:");
                System.out.println("Título: " + title);
                System.out.println("Artista: " + artist);

                // Segunda búsqueda en Last.fm
                buscarEnLastFm(title, artist);
            } else {
                System.out.println("No se encontraron resultados en YouTube.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void buscarEnLastFm(String title, String artist) {
        try {
            String titleEncoded = URLEncoder.encode(title, "UTF-8");
            String artistEncoded = URLEncoder.encode(artist, "UTF-8");
            String lastFmUrl = LAST_FM_SEARCH_URL + "?method=track.getInfo&api_key=" + LAST_FM_API_KEY + "&artist=" + artistEncoded + "&track=" + titleEncoded + "&format=json";

            URL url = new URL(lastFmUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Error en la conexión a Last.fm: " + responseCode);
            }

            Scanner scanner = new Scanner(url.openStream());
            StringBuilder inline = new StringBuilder();
            while (scanner.hasNext()) {
                inline.append(scanner.nextLine());
            }
            scanner.close();

            JsonObject lastFmResponse = JsonParser.parseString(inline.toString()).getAsJsonObject();
            JsonObject track = lastFmResponse.getAsJsonObject("track");

            if (track != null) {
                // Verificar si el objeto "album" existe
                String album = track.has("album") && track.getAsJsonObject("album").has("title")
                        ? track.getAsJsonObject("album").get("title").getAsString()
                        : "No disponible";

                // Verificar si el array "toptags" existe y tiene elementos
                String genre = track.has("toptags") && track.getAsJsonObject("toptags").has("tag")
                        ? track.getAsJsonObject("toptags").getAsJsonArray("tag").size() > 0
                            ? track.getAsJsonObject("toptags").getAsJsonArray("tag").get(0).getAsJsonObject().get("name").getAsString()
                            : "No disponible"
                        : "No disponible";

                // Verificar si la duración existe
                int duration = track.has("duration") ? track.get("duration").getAsInt() / 1000 : 0;

                System.out.println("Ficha técnica de Last.fm:");
                System.out.println("Álbum: " + album);
                System.out.println("Género: " + genre);
                System.out.println("Duración: " + duration + " segundos");
            } else {
                System.out.println("No se encontró información en Last.fm.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la consulta de búsqueda: ");
        String query = scanner.nextLine();
        buscarFichaTecnica(query);
    }
}
