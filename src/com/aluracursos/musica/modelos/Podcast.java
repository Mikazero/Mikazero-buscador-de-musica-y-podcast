package com.aluracursos.musica.modelos;



public class Podcast extends Audio{
    private int numeroDeEpisodio;
    private String nombreDelEpisodio;
    private int episodiosportemporada;
    private int temporadas;
    private String tema;
    private String locutor;
    private String escritor;


    public int getNumeroDeEpisodio() {
        return numeroDeEpisodio;
    }

    public void setNumeroDeEpisodio(int numeroDeEpisodio) {
        this.numeroDeEpisodio = numeroDeEpisodio;
    }

    public String getNombreDelEpisodio() {
        return nombreDelEpisodio;
    }

    public void setNombreDelEpisodio(String nombreDelEpisodio) {
        this.nombreDelEpisodio = nombreDelEpisodio;
    }

    public int getEpisodiosportemporada() {
        return episodiosportemporada;
    }

    public void setEpisodiosportemporada(int episodiosportemporada) {
        this.episodiosportemporada = episodiosportemporada;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getLocutor() {
        return locutor;
    }

    public void setLocutor(String locutor) {
        this.locutor = locutor;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    @Override
    public void muestraFichaTecnica() {
        super.muestraFichaTecnica();
        System.out.println("Ficha técnica del podcast:");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Fecha de lanzamiento: " + getFechaDeLanzamiento());
        System.out.println("Duración: " + getDuracionEnSegundos(0) + " segundos");
        System.out.println("Número de me gusta: " + getNumeroDeMegusta());
        System.out.println("Número de reproducciones: " + getNumeroDeReproducciones());
        System.out.println("Clasificación: " + getClasificacion());
        System.out.println("Número de episodio: " + numeroDeEpisodio);
        System.out.println("Nombre del episodio: " + nombreDelEpisodio);
        System.out.println("Episodios por temporada: " + episodiosportemporada);
        System.out.println("Temporadas: " + temporadas);
        System.out.println("Tema: " + tema);
        System.out.println("Locutor: " + locutor);
        System.out.println("Escritor: " + escritor);
        System.out.println(separacion);
    }
}
