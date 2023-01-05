package cinemagico;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Sala extends Pelicula {

    private String nombreSala;
    private int capacidad;
    private LocalTime funcion;
    private int aforoActual;
    private int disponibilidad;
    private double precioVerPelicula;
    private int boletosVendidos;
    private double ingresosPorVentas;
    private LocalTime horaLimiteParaCancelacion;
    private int cancelaciones;
    private double egresoPorCancelacion;
    private double ingresoReal;
    //
    private int fila;
    private int columna;
    private String[][] sala;
    private List<Boleto> listaBoletos = new ArrayList<>();
    
    //
    // SE CREA LA CLASE PELICULA CON LA INFORMACIÓN PROPIA COMO NOMBRE Y CATEGORÍA DE EDAD, ESTO LO HEREDARÁ LA CLASE SALA.
    //

    public Sala(String nombreSala, int capacidad, LocalTime funcion, int aforoActual, int disponibilidad, double precioVerPelicula,int boletosVendidos, double ingresosPorVentas, LocalTime horaLimiteParaCancelacion, int cancelaciones, double egresoPorCancelacion, double ingresoReal, int fila, int columna, String nombrePelicula, int categoriaEdad) {
        super(nombrePelicula, categoriaEdad);
        this.nombreSala = nombreSala;
        this.capacidad = capacidad;
        this.funcion = funcion;
        this.aforoActual = aforoActual;
        this.disponibilidad = disponibilidad;
        this.precioVerPelicula = precioVerPelicula;
        this.boletosVendidos=boletosVendidos;
        this.ingresosPorVentas = ingresosPorVentas;
        this.horaLimiteParaCancelacion = horaLimiteParaCancelacion;
        this.cancelaciones = cancelaciones;
        this.egresoPorCancelacion = egresoPorCancelacion;
        this.ingresoReal = ingresoReal;
        this.fila = fila;
        this.columna = columna;
        this.sala = new String[fila + 1][columna + 1];

    }

    public Sala(String nombreSala, LocalTime funcion, double precioVerPelicula, LocalTime horaLimiteParaCancelacion, String nombrePelicula, int categoriaEdad) {
        super(nombrePelicula, categoriaEdad);
        this.nombreSala = nombreSala;
        this.funcion = funcion;
        this.precioVerPelicula = precioVerPelicula;
        this.horaLimiteParaCancelacion = horaLimiteParaCancelacion;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public LocalTime getSesion() {
        return funcion;
    }

    public void setSesion(LocalTime funcion) {
        this.funcion = funcion;
    }

    public int getAforoActual() {
        return aforoActual;
    }

    public void setAforoActual(int aforoActual) {
        this.aforoActual = aforoActual;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public double getPrecioVerPelicula() {
        return precioVerPelicula;
    }

    public void setPrecioVerPelicula(double precioVerPelicula) {
        this.precioVerPelicula = precioVerPelicula;
    }

    public double getIngresosPorVentas() {
        return ingresosPorVentas;
    }

    public void setIngresosPorVentas(double ingresosPorVentas) {
        this.ingresosPorVentas = ingresosPorVentas;
    }

    public LocalTime getHoraLimiteParaCancelacion() {
        return horaLimiteParaCancelacion;
    }

    public void setHoraLimiteParaCancelacion(LocalTime horaLimiteParaCancelacion) {
        this.horaLimiteParaCancelacion = horaLimiteParaCancelacion;
    }

    public int getCancelaciones() {
        return cancelaciones;
    }

    public void setCancelaciones(int cancelaciones) {
        this.cancelaciones = cancelaciones;
    }

    public double getEgresoPorCancelacion() {
        return egresoPorCancelacion;
    }

    public void setEgresoPorCancelacion(double egresoPorCancelacion) {
        this.egresoPorCancelacion = egresoPorCancelacion;
    }

    public double getIngresoReal() {
        return ingresoReal;
    }

    public void setIngresoReal(double ingresoReal) {
        this.ingresoReal = ingresoReal;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setSala(String[][] sala) {
        this.sala = sala;
    }

    public String[][] getSala() {
        return sala;
    }

    public List<Boleto> getListaBoletos() {
        return listaBoletos;
    }

    public void llenarSalaPorDefecto() {

        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[0].length; j++) {
                if (i == 0 && j == 0) {
                    sala[i][j] = "  ";
                } else if (i == 0) {
                    if (j < 10) {
                        sala[i][j] = "0" + String.valueOf(j);
                    } else {
                        sala[i][j] = String.valueOf(j);
                    }

                } else if (j == 0) {

                    if (i < 10) {
                        sala[i][j] = "0" + String.valueOf(i);
                    } else {
                        sala[i][j] = String.valueOf(i);
                    }

                } else {
                    sala[i][j] = " D";
                }

            }
        }
    }

    public void imprimirSala() {
        System.out.println("\nSala de cine: D= DISPONIBLE, O= OCUPADO \n");
        for (String[] asientos : sala) {
            System.out.print("Fila ");
            for (int j = 0; j < sala[0].length; j++) {

                System.out.print(asientos[j] + " ");

            }
            System.out.println("\n");
        }
    }

    public void comprarBoleto(int comprarFila, int comprarColumna, int cantidadBoletos) {
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        this.aforoActual += cantidadBoletos;
        // 
        this.disponibilidad -= cantidadBoletos;
        //  
        this.boletosVendidos+=cantidadBoletos;
        this.ingresosPorVentas += (this.precioVerPelicula * cantidadBoletos);
        // 
        this.ingresoReal += (this.precioVerPelicula * cantidadBoletos);
        sala[comprarFila][comprarColumna] = ANSI_RED + " O" + ANSI_RESET;

    }

    public void insertarMensajeDeCompra(int cantidadBoletos) {

        System.out.println("\nPrecio del boleto: " + this.precioVerPelicula + ", costo total " + (this.precioVerPelicula * cantidadBoletos) + " colones\n");
    }

    public void cancelarCompra(List<String> listColumnaElegida, List<String> listFilaElegida, int cantidadBoletosCancelar) {

        for (int i = 0; i < cantidadBoletosCancelar; i++) {

            int cancelarFila = Integer.parseInt(listFilaElegida.get(i));
            int cancelarColumna = Integer.parseInt(listColumnaElegida.get(i));
            this.aforoActual -= 1;
            this.disponibilidad += 1;
            // this.ingresosPorVentas -= (this.precioVerPelicula * 1);
            this.egresoPorCancelacion += (this.precioVerPelicula * 1);
            this.ingresoReal -= (this.precioVerPelicula * 1);
            sala[cancelarFila][cancelarColumna] = " D";
        }
        this.cancelaciones += cantidadBoletosCancelar;
        System.out.println("\n---------------------------------\nCOMPRA CANCELADA Y BOLETO REVERTIDO\n---------------------------------\n");

    }

    public String toStringAdministrador() {

        DateTimeFormatter f = DateTimeFormatter.ofPattern("hh':'mm a");

        return "Sala: " + nombreSala + "\nPelicula: " + getNombrePelicula() + "\nFunción: " + funcion.format(f);
    }

    public String toStringEstadisticas() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("hh':'mm a");

        return "\n--------------------------ESTADISTICAS--------------------------\n"
                + "\n" + nombreSala + " --- Capacidad: " + capacidad + " --- Función: " + funcion.format(f)
                + "\n\nAforo Actual: " + aforoActual + " --- Disponibilidad: " + disponibilidad + " --- Precio de boleto: "
                + precioVerPelicula +"\n\nBoletos vendidos: " + boletosVendidos+ " --- Ingresos por boletos: " + ingresosPorVentas + " --- Boletos cancelados: " + cancelaciones
                + " ---- Egreso por cancelación: " + egresoPorCancelacion + "\n\nIngreso real: " + ingresoReal + "\n"
                + "\n--------------------------ESTADISTICAS--------------------------\n";
    }

    @Override
    public String toString() {

        DateTimeFormatter f = DateTimeFormatter.ofPattern("hh':'mm a");

        return "Sala: " + nombreSala + "\nPresentando: " + getNombrePelicula() + "\nFunción: " + funcion.format(f)
                + "\nEspacios disponibles: " + disponibilidad + " espacios" + "\nPrecio de entrada: " + precioVerPelicula + " colones";
    }

}
