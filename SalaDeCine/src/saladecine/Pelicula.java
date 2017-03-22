/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saladecine;

/**
 *
 * @author Tatiana Almansa
 * @author Juan David Ojeda
 */
public class Pelicula {
  private String nombrePelicula;
    private String generoPelicula;
    private short  duracion;

    public Pelicula(String nombrePelicula, String generoPelicula, short duracion) {
        this.nombrePelicula = nombrePelicula;
        this.generoPelicula = generoPelicula;
        this.duracion = duracion;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getGeneroPelicula() {
        return generoPelicula;
    }

    public void setGeneroPelicula(String generoPelicula) {
        this.generoPelicula = generoPelicula;
    }

    public short getDuracion() {
        return duracion;
    }

    public void setDuracion(short duracion) {
        this.duracion = duracion;
    }
     public void mostrarInfoPelicula(){
        System.out.println();                
        System.out.println("Nombre Pelicula" + "<" + nombrePelicula  + ">");
        System.out.println("Genero Pelicula" + "<" + generoPelicula + ">");
        
     }
    
}
