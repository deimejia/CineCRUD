package cinemagico;

import java.util.Scanner;

public class CinemagicoMain {

    private static ControladorGeneral controlador = new ControladorGeneral();
    private static VistasGeneral vistas = new VistasGeneral();

    public static void main(String[] args) {
        
        

        vistas.llenarTableros();
        vistas.vistaInicio();

    }

}
