package com.aluracursos.musica.modelos;
import com.aluracursos.musica.modelos.Cancion;
import com.aluracursos.musica.modelos.Podcast;


public class Principal {
    public static void main(String[] args) {
        Cancion cancion = new Cancion();
        cancion.setNombre("Corona");
        cancion.setDuracionEnSegundos(237);
        cancion.setFechaDeLanzamiento(2020);
        cancion.setAlbum("Greatest Shits");
        cancion.setGenero("Rock");
        cancion.setCompositor("Utsu-p");
        cancion.setInterprete("Rin Kagamine");
        cancion.setNumeroDeMegusta(2100);
        cancion.setNumeroDeReproducciones(141000);
        cancion.muestraFichaTecnica();

        Podcast podcast = new Podcast();
        podcast.setNombre("Caso 63");
        podcast.setNumeroDeEpisodio(1);
        podcast.setNombreDelEpisodio("La historia con la que creci");
        podcast.setEpisodiosportemporada(10);
        podcast.setDuracionEnSegundos(878);
        podcast.setTemporadas(4);
        podcast.setTema("Ciencia ficcion");
        podcast.setLocutor("Néstor Cantillana y Antonia Zegers");
        podcast.setEscritor("Julio Rojas");
        podcast.setNumeroDeMegusta(2000);
        podcast.setNumeroDeReproducciones(147000);
        podcast.muestraFichaTecnica();
    }

}
