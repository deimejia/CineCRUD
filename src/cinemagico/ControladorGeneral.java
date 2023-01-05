/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemagico;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zeus
 */
public class ControladorGeneral {

    // SE CREAN LOS OBJETOS SALAS DE CINE, CADA HORARIO TIENE SU RESPECTIVO OBJETO, ASÍ SE LLEVA EL CONTROL DE TODAS LAS VARIACIONES.
    //
    //SALAS CENTRALES
    private final List<Sala> listaDeSalasPresentando = new ArrayList<>();

    //SI DESEA CAMBIAR CANTIDAD DE FILAS Y COLUMNAS, DEBE CAMBIAR LA DISPONIBILIDAD Y CAPACIDAD MANUALMENTE TAMBIÉN // 25X20=500
    private Sala salaCentralTresPM = new Sala("SALA CENTRAL", 500, LocalTime.of(11, 00), 0, 500, 5000, 0, 0, LocalTime.of(10, 30), 0, 0, 0, 20, 25, "BLACK PANTHER", 15);
    private Sala salaCentralSeisPM = new Sala("SALA CENTRAL", 500, LocalTime.of(18, 00), 0, 500, 5000, 0, 0, LocalTime.of(17, 30), 0, 0, 0, 20, 25, "BLACK PANTHER", 15);
    private Sala salaCentralNuevePM = new Sala("SALA CENTRAL", 500, LocalTime.of(21, 00), 0, 500, 5000, 0, 0, LocalTime.of(20, 30), 0, 0, 0, 20, 25, "BLACK PANTHER", 15);

    //
    //SALAS SECUNDARIAS
    //SI DESEA CAMBIAR CANTIDAD DE FILAS Y COLUMNAS, DEBE CAMBIAR LA DISPONIBILIDAD Y CAPACIDAD MANUALMENTE TAMBIÉN // 8X10=80
    private Sala salaSecundariaTresPM = new Sala("SALA SECUNDARIA", 80, LocalTime.of(11, 00), 0, 80, 3500, 0, 0, LocalTime.of(10, 30), 0, 0, 0, 8, 10, "EL TITANIC", 12);
    private Sala salaSecundariaSeisPM = new Sala("SALA SECUNDARIA", 80, LocalTime.of(18, 00), 0, 80, 3500, 0, 0, LocalTime.of(17, 30), 0, 0, 0, 8, 10, "EL TITANIC", 12);
    private Sala salaSecundariaNuevePM = new Sala("SALA SECUNDARIA", 80, LocalTime.of(21, 00), 0, 80, 3500, 0, 0, LocalTime.of(20, 30), 0, 0, 0, 8, 10, "EL TITANIC", 12);

    public void crearSalas() {
        listaDeSalasPresentando.add(salaCentralTresPM);
        listaDeSalasPresentando.add(salaCentralSeisPM);
        listaDeSalasPresentando.add(salaCentralNuevePM);
        //
        listaDeSalasPresentando.add(salaSecundariaTresPM);
        listaDeSalasPresentando.add(salaSecundariaSeisPM);
        listaDeSalasPresentando.add(salaSecundariaNuevePM);
    }

    public void mostrarSala() {

        salaCentralTresPM.llenarSalaPorDefecto();
        salaCentralTresPM.imprimirSala();

    }

    public Sala getSalaCentralTresPM() {
        return salaCentralTresPM;
    }

    public List<Sala> getListaDeSalasPresentando() {
        return listaDeSalasPresentando;
    }

}
