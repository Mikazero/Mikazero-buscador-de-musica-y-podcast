package com.aluracursos.musica.modelos;

public class Audio {
    private String nombre;
    private int duracionEnSegundos;
    private int fechaDeLanzamiento;
    private int numeroDeReproducciones;
    private int numeroDeMegusta;
    private int clasificacion;
    public String separacion = "**********************************************\n";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracionEnSegundos(int i) {
        return duracionEnSegundos;
    }

    public void setDuracionEnSegundos(int duracionEnSegundos) {
        this.duracionEnSegundos = duracionEnSegundos;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public int getNumeroDeReproducciones() {
        return numeroDeReproducciones;
    }

    public void setNumeroDeReproducciones(int numeroDeReproducciones) {
        this.numeroDeReproducciones = numeroDeReproducciones;
    }

    public int getNumeroDeMegusta() {
        return numeroDeMegusta;
    }

    public void setNumeroDeMegusta(int numeroDeMegusta) {
        this.numeroDeMegusta = numeroDeMegusta;
    }

    public int getClasificacion() {
        if (numeroDeReproducciones > 1000 || numeroDeMegusta > 1000) {
            this.clasificacion = 5;
        } else if (numeroDeReproducciones > 500 || numeroDeMegusta > 500) {
            this.clasificacion = 4;
        } else if (numeroDeReproducciones > 100 || numeroDeMegusta > 100) {
            this.clasificacion = 3;
        } else if (numeroDeReproducciones > 50 || numeroDeMegusta > 50) {
            this.clasificacion = 2;
        } else {
            this.clasificacion = 1;
        }
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }



    public void muestraFichaTecnica() {
    }
}