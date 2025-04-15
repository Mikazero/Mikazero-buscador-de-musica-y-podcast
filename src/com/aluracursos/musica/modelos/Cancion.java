package com.aluracursos.musica.modelos;

public class Cancion extends Audio{
    private String album;
    private String genero;
    private String compositor;
    private String interprete;

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }
    @Override
    public void muestraFichaTecnica(){
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Fecha de lanzamiento: " + this.getFechaDeLanzamiento());
        System.out.println("Duracion: " + this.getDuracionEnSegundos(0) + " Segundos");
        System.out.println("Album: " + this.album);
        System.out.println("Genero: " + this.genero);
        System.out.println("Compositor: " + this.compositor);
        System.out.println("Interprete: " + this.interprete);
        System.out.println("Numero de reproducciones: " + this.getNumeroDeReproducciones());
        System.out.println("Numero de me gusta: " + this.getNumeroDeMegusta());
        System.out.println("Clasificacion: " + this.getClasificacion());
        System.out.println(separacion);
    }
}
