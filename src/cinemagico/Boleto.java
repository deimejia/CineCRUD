package cinemagico;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Boleto extends Sala {

    private String idCliente;
    private String nombreCliente;
    private int edadCliente;
    private int cantidadBoletos;
    private List<String> listColumnaElegida = new ArrayList<>();
    private List<String> listFilaElegida = new ArrayList<>();

    public Boleto(String idCliente, String nombreCliente, int edadCliente, int cantidadBoletos, String nombreSala, LocalTime funcion, double precioVerPelicula, LocalTime horaLimiteParaCancelacion, String nombrePelicula, int categoriaEdad) {
        super(nombreSala, funcion, precioVerPelicula, horaLimiteParaCancelacion, nombrePelicula, categoriaEdad);
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.edadCliente = edadCliente;
        this.cantidadBoletos = cantidadBoletos;

    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getEdadCliente() {
        return edadCliente;
    }

    public void setEdadCliente(int edadCliente) {
        this.edadCliente = edadCliente;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    public List<String> getListColumnaElegida() {
        return listColumnaElegida;
    }

    public void setListColumnaElegida(List<String> listColumnaElegida) {
        this.listColumnaElegida = listColumnaElegida;
    }

    public List<String> getListFilaElegida() {
        return listFilaElegida;
    }

    public void setListFilaElegida(List<String> listFilaElegida) {
        this.listFilaElegida = listFilaElegida;
    }

    @Override
    public String toString() {

        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        DateTimeFormatter f = DateTimeFormatter.ofPattern("hh':'mm a");
        return "\n----------------------------\nBoleto" + ANSI_RED + "\nCódigo Cliente: " + ANSI_RESET + idCliente + "\nNombre: " + nombreCliente + "\nEdad cliente que compra: "
                + "" + edadCliente + "\nCategoria pelicula: " + "+" + getCategoriaEdad() + "\nPelicula: " + getNombrePelicula() + "\nESPACIOS: " + cantidadBoletos + ""
                + "\nCOLUM ASIENTOS: " + listColumnaElegida + "\nFILAS ASIENOS: " + listFilaElegida + "\nSala: " + getNombreSala() + "\nFunción: " + getSesion().format(f) + ""
                + "\nHora límite para cancelar: " + getHoraLimiteParaCancelacion().format(f) + "\nCobro: " + (getPrecioVerPelicula()*cantidadBoletos)+" colones"+"\n----------------------------\n";
    }

}
