/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemagico;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Zeus
 */
public class ExcepcionesCine extends Exception {

    public void validarEdadCompra(int edadIng, int categoriaEdad) throws Exception {

        if (edadIng != 0) {

            if (edadIng < categoriaEdad) {

                throw new Exception("Tu edad no califica para ver esta pelicula (su identificación será validada al entrar a la sala)");

            }

        }

    }

    public void validarHoraDecompra(LocalTime funcion) throws Exception {

        //SE VALIDA CONTRA HORA ATUAL REAL
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("hh':'mm a");

        if (funcion.isBefore(horaActual)) {

            throw new Exception("La película inició a las " + funcion.format(f) + "\nhora actual: " + horaActual.format(f) + " bajo su responsabilidad puede continuar");
        }
    }

    public void validarCantidadBoletosRequeridos(int boletosDisponibles, int boletosRequeridos) throws Exception {
        if (boletosRequeridos != 0) {

            if (boletosDisponibles < boletosRequeridos) {
                throw new Exception("Cantidad de boletos requerida no están disponibles, los disponibles son " + boletosDisponibles);
            }
        }

    }

    public void verificarAsiento(int filaElegida, int columnaElegida, int filas, int columnas, String[][] salaElegida) throws Exception {

        boolean verificar = filaElegida > filas || columnaElegida > columnas || filaElegida == 0 || columnaElegida == 0;
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        if (verificar) {
            throw new Exception("Asiento incorrecto");

        } else if (salaElegida[filaElegida][columnaElegida].equals(ANSI_RED + " O" + ANSI_RESET)) {
            throw new Exception("Este asiento está ocupado");

        }

    }

    public void validarCancelacionDeCompra(String idClienteIng, List<Boleto> listaBoletosVendidos, LocalTime funcion, LocalTime horaMaximaParaCancelar, Sala salaDelBoleto, boolean boletoValido) throws Exception {

        //SE VALIDA CONTRA HORA ATUAL REAL
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("hh':'mm a");
        if (boletoValido) {

            if (horaMaximaParaCancelar.isBefore(horaActual)) {

                throw new Exception("No puedes cancelar tu boleto, tiempo límite para cancelar fue agotado (" + horaMaximaParaCancelar.format(f) + ")\nhora actual: " + horaActual.format(f)+"\nhora de la función: " + funcion.format(f));
            }
        } else {
            throw new Exception("Id Cliente del boleto no se encuentra en nuestra base de datos");

        }

    }
}
