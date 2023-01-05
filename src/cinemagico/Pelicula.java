/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemagico;

/**
 *
 * @author Zeus
 */
public class Pelicula {

    private String nombrePelicula;
    private int categoriaEdad;
    //
    // SE CREA LA CLASE PELICULA CON LA INFORMACIÓN PROPIA COMO NOMBRE Y CATEGORÍA DE EDAD, ESTO LO HEREDARÁ LA CLASE SALA.
    //
    public Pelicula(String nombrePelicula, int categoriaEdad) {
        this.nombrePelicula = nombrePelicula;
        this.categoriaEdad = categoriaEdad;
    }

    public Pelicula() {
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public int getCategoriaEdad() {
        return categoriaEdad;
    }

    public void setCategoriaEdad(int categoriaEdad) {
        this.categoriaEdad = categoriaEdad;
    }

}
