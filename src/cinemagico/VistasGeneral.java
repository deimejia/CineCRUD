/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemagico;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Zeus
 */
public class VistasGeneral {

    private ExcepcionesCine excepciones = new ExcepcionesCine();
    private ControladorGeneral controlador = new ControladorGeneral();
    Scanner datoIng = new Scanner(System.in);

    public VistasGeneral() {
    }

    //MÉTODO PARA RELLENAR LA NUMERACIÓN DE ASIENTOS, FILAS Y COLUMNAS
    public void llenarTableros() {
        controlador.crearSalas();
        for (Sala sala : controlador.getListaDeSalasPresentando()) {
            sala.llenarSalaPorDefecto();
        }
    }

    public void vistaInicio() {
        boolean banderaInterna = true;
        do {

            try {
                System.out.println("\n\n\tBienvenido a CINEMAGICO");
                System.out.println("1. Comprar boletos\n2. Cancelar compra\n3. Ver resultados por sala (ingresar solo si es administrador y desea ver resultados de ventas y otros datos)\n"
                        + "4. Salir");

                System.out.print("\nPor favor seleccione lo que desea realizar: ");
                int opcion = datoIng.nextInt();
                switch (opcion) {
                    case 1:
                        vistaCartelera();

                        break;
                    case 2:
                        vistaCancelarCompra();
                        break;

                    case 3:
                        vistaEstadisticasPorSala();
                        break;
                    case 4:
                        banderaInterna = false;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción no disponible, elija otra por favor");
                        datoIng.nextLine();
                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "No ingresó un número, por favor intente de nuevo");
                datoIng.nextLine();

            }
        } while (banderaInterna);

    }

    public void vistaCartelera() {
        boolean banderaInterna = true;

        int opcion = 0;
        // controlador.crearSalas();

        System.out.println("\n\tBienvenido a CINEMAGICO");
        System.out.println("\n\tPor favor seleccione la pelicula que desea ver de nuestra cartelera:\n");
        //
        //TRAIGO LAS SALAS GUARDADAS EN UN LIST PARA IMPRIMIR, se presentará la info solo de la pelicula a presentar por medio del método programado tostring (ubicado en SALA CLASS)

        for (Sala sala : controlador.getListaDeSalasPresentando()) {
            System.out.println("Opción " + (controlador.getListaDeSalasPresentando().indexOf(sala) + 1));
            System.out.println(sala + "\n");

        }
        do {
            try {
                // NO SE VALIDARÁ LA HORA DE COMPRA, YA QUE EL CLIENTE ES RESPONSABLE
                //
                System.out.print("Por favor ingrese su opción preferida (o ingrese 0 para ir al menú anterior): ");
                opcion = datoIng.nextInt();
                LocalTime funcion = controlador.getListaDeSalasPresentando().get(opcion - 1).getSesion();
                excepciones.validarHoraDecompra(funcion);
                switch (opcion) {
                    case 1:
                        vistaCompra(opcion);
                        banderaInterna = false;
                        break;
                    case 2:
                        vistaCompra(opcion);
                        banderaInterna = false;
                        break;
                    case 3:
                        vistaCompra(opcion);
                        banderaInterna = false;
                        break;
                    case 4:
                        vistaCompra(opcion);
                        banderaInterna = false;
                        break;
                    case 5:
                        vistaCompra(opcion);
                        banderaInterna = false;
                        break;
                    case 6:
                        vistaCompra(opcion);
                        banderaInterna = false;
                        break;

                    case 0:

                        banderaInterna = false;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción no disponible, elija otra por favor");
                        datoIng.nextLine();
                }

            } catch (Exception e) {
                if (e instanceof InputMismatchException) {
                    JOptionPane.showMessageDialog(null, "No ingresó un número, por favor intente de nuevo");
                    datoIng.nextLine();
                } else {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    vistaCompra(opcion);
                    banderaInterna = false;

                }

            }
        } while (banderaInterna);

    }

    public void vistaCompra(int opcionElegida) {
        Boleto nuevoBoleto = null;
        String nombrePelicula = null;
        String nombredeSala = null;
        int catagoriaEdad = 0;
        int edadIng = 0;
        boolean banderaInterna = true;
        boolean banderaGlobal = true;
        int indice = 0;
        String nombreCliente = null;
        //
        int cantidadBoletosDisponibles = 0;
        int cantidadBoletosIng = 0;
        LocalTime funcion = null;
        double precioVerPelicula = 0;
        LocalTime horaLimiteParaCancelacion = null;
        int columnaElegida = 0, filaElegida = 0;
        int filasDeSala = 0, columnasDeSala = 0;
        String[][] salaElegida = null;
        List<String> provisionalFila = new ArrayList<>();
        List<String> provisionalColumna = new ArrayList<>();

        for (Sala sala : controlador.getListaDeSalasPresentando()) {

            if (controlador.getListaDeSalasPresentando().indexOf(sala) == (opcionElegida - 1)) {

                indice = controlador.getListaDeSalasPresentando().indexOf(sala);
                nombrePelicula = sala.getNombrePelicula();
                cantidadBoletosDisponibles = sala.getDisponibilidad();
                catagoriaEdad = sala.getCategoriaEdad();
                nombredeSala = sala.getNombreSala();
                funcion = sala.getSesion();
                precioVerPelicula = sala.getPrecioVerPelicula();
                horaLimiteParaCancelacion = sala.getHoraLimiteParaCancelacion();
                filasDeSala = sala.getFila();
                columnasDeSala = sala.getColumna();
                salaElegida = sala.getSala();

            }

        }

        System.out.println("\n\tElegiste la pelicula " + nombrePelicula);
        System.out.println("\nEsta pelicula es para mayores de " + catagoriaEdad + " años de edad (menores a esa edad deben ser supervisados por un adulto)");

        do {
            try {
                System.out.print("\nIndicanos tu edad por favor (o ingrese 0 para ir al menú anterior): ");
                edadIng = datoIng.nextInt();
                if (edadIng == 0) {

                    banderaInterna = false;
                    banderaGlobal = false;
                } else {
                    excepciones.validarEdadCompra(edadIng, catagoriaEdad);
                    banderaInterna = false;

                }

            } catch (Exception e) {

                if (e instanceof InputMismatchException) {

                    JOptionPane.showMessageDialog(null, "No ingresó un número, por favor intente de nuevo");
                    datoIng.nextLine();

                } else {

                    JOptionPane.showMessageDialog(null, e.getMessage());
                    datoIng.nextLine();
                }

            }

        } while (banderaInterna);

        banderaInterna = true;

        while (banderaGlobal && banderaInterna) {
            try {
                System.out.print("\nPor favor indique la cantidad de boletos que desea (o ingrese 0 para ir al menú anterior): ");
                cantidadBoletosIng = datoIng.nextInt();

                if (cantidadBoletosIng == 0) {
                    banderaInterna = false;
                    banderaGlobal = false;
                } else {

                    excepciones.validarCantidadBoletosRequeridos(cantidadBoletosDisponibles, cantidadBoletosIng);
                    banderaInterna = false;
                }

                //
            } catch (Exception e) {

                if (e instanceof InputMismatchException) {

                    JOptionPane.showMessageDialog(null, "No ingresó un número, por favor intente de nuevo");
                    datoIng.nextLine();

                } else {

                    JOptionPane.showMessageDialog(null, e.getMessage());
                    datoIng.nextLine();
                }
            }
        }

        banderaInterna = true;
        //
        //

        //
        //
        //este contador evitará comprar más boletos de los requeridos al repetir el ciclo por error (EXCEPTION) al ingresar los asientos
        int indicadorCiclo = 0;
    
       
        //
        while (banderaGlobal && banderaInterna) {
            try {
                
                System.out.println("\nAcontinuación se le presentarán los asientos disponibles,\npor favor elija muy bien el asiento deseado, "
                        + "indicando el número de la fila (números verticales) y columna (números horizontales)respectiva.\n");
                //
                controlador.getListaDeSalasPresentando().get(indice).imprimirSala();
                //
                //
                int salir = 0;
                for (int i = indicadorCiclo; i < (cantidadBoletosIng); i++) {
                    indicadorCiclo = i;
                    

                    //
                    do {
                        try {
                            System.out.print("\n\tPara continuar por favor confirma: \n\t1. Permanecer \n\t2. Regresar\n\tingresa un número: ");
                            salir = datoIng.nextInt();
                            switch (salir) {
                                case 1:
                                    banderaInterna = false;
                                    break;

                                case 2:
                                    banderaInterna = false;
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Opción no válida");
                                    datoIng.nextLine();

                            }

                        } catch (Exception e) {
                            if (e instanceof InputMismatchException) {
                                JOptionPane.showMessageDialog(null, "No ingresó un número, por favor intente de nuevo");
                                datoIng.nextLine();
                            } else {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                                datoIng.nextLine();
                            }

                        }
                    } while (banderaInterna);

                    if (salir == 2) {

                        banderaGlobal = false;
                        banderaInterna = false;
                        break;
                    } else if (salir == 1) {
                        banderaInterna = true;
                        System.out.print("\n\nTienes " + cantidadBoletosIng + " boletos\nIngrese la fila de su asiento para su boleto número " + (i + 1) + ": ");
                        filaElegida = datoIng.nextInt();
                        System.out.print("Ingrese la columna de su asiento para su boleto número " + (i + 1) + ": ");
                        columnaElegida = datoIng.nextInt();
                       

                        excepciones.verificarAsiento(filaElegida, columnaElegida, filasDeSala, columnasDeSala, salaElegida);
                        //
                        // SE LLENA INFO DEL BOLETO
                        provisionalFila.add(String.valueOf(filaElegida));
                        provisionalColumna.add(String.valueOf(columnaElegida));
                        //SE EJECUTA COMPRA

                        controlador.getListaDeSalasPresentando().get(indice).comprarBoleto(filaElegida, columnaElegida, 1);
                      

                    }

                }
                // SE MUESTRA MENSAJE DE COMPRA

                if (salir != 2) {
                    controlador.getListaDeSalasPresentando().get(indice).insertarMensajeDeCompra(cantidadBoletosIng);
                    banderaInterna = false;
                }

            } catch (Exception e) {
                if (e instanceof InputMismatchException) {

                    JOptionPane.showMessageDialog(null, "No ingresó un número, por favor intente de nuevo");
//                    
                    datoIng.nextLine();

                } else {

                    JOptionPane.showMessageDialog(null, e.getMessage());
//                

                    datoIng.nextLine();
                }
            }
        }

        banderaInterna = true;

        //
        //
        while (banderaGlobal && banderaInterna) {
            try {
                System.out.print("Por favor ingresa a nombre de quién irán los boletos: ");
                nombreCliente = datoIng.next();
                banderaInterna = false;

            } catch (Exception e) {

            }
        }
        banderaInterna = true;

        //
        //
        while (banderaGlobal && banderaInterna) {

            //ID CON EL QUE PODRÁ CANCELAR LA COMPRA
            String idCliente = String.valueOf(catagoriaEdad) + String.valueOf(edadIng) + String.valueOf(indice) + nombreCliente;
            //

            nuevoBoleto = new Boleto(idCliente, nombreCliente, edadIng, cantidadBoletosIng, nombredeSala, funcion, precioVerPelicula, horaLimiteParaCancelacion, nombrePelicula, catagoriaEdad);
            controlador.getListaDeSalasPresentando().get(indice).getListaBoletos().add(nuevoBoleto);
            //

            for (String columna : provisionalColumna) {

                nuevoBoleto.getListColumnaElegida().add(columna);
            }

            for (String fila : provisionalFila) {

                nuevoBoleto.getListFilaElegida().add(fila);
            }

            //
            // SE MUESTRA MENSAJE DE BOLETO
            System.out.println(nuevoBoleto);
            System.out.println("");
            banderaGlobal = false;

        }
    }
    // VISTA DE CANCELAR COMPRA

    public void vistaCancelarCompra() {
        String idClienteIng;
        //
        List<Boleto> listaBoletosVendidos = null;
        Sala salaDelBoletoACancelar = null;
        LocalTime funcion = null;
        LocalTime horaMaximaParaCancelar = null;
        boolean boletoValido = false;
        boolean banderaInterna = true;
        List<String> listColumnaElegida = null;
        List<String> listFilaElegida = null;
        int cantidadBoletosCancelar = 0;
        int indexSala = 0;
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        int salir = 0;

        //
        do {

            do {
                try {
                    System.out.print("\n\nPara continuar por favor confirma:: \n\t1. Permanecer \n\t2. Regresar\n\tingresa un número: ");
                    salir = datoIng.nextInt();
                    switch (salir) {
                        case 1:
                            banderaInterna = false;
                            break;

                        case 2:
                            banderaInterna = false;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida");
                            datoIng.nextLine();

                    }

                } catch (Exception e) {
                    if (e instanceof InputMismatchException) {
                        JOptionPane.showMessageDialog(null, "No ingresó un número, por favor intente de nuevo");
                        datoIng.nextLine();
                    } else {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        datoIng.nextLine();
                    }

                }
            } while (banderaInterna);

            banderaInterna = true;

            if (salir == 2) {
                banderaInterna = false;

            } else if (salir == 1) {

                try {
                    System.out.println("\n\tBienvenido a CINEMAGICO");
                    System.out.print("\nPor favor ingresa el " + ANSI_RED + "Código Cliente" + ANSI_RESET + " que se encuentra en tu boleto de compra: ");
                    idClienteIng = datoIng.next();

                    //  if (Integer.parseInt(idClienteIng) != 0) {
                    for (Sala sala : controlador.getListaDeSalasPresentando()) {

                        for (Boleto boleto : sala.getListaBoletos()) {

                            if (boleto.getIdCliente().equals(idClienteIng)) {

                                listaBoletosVendidos = sala.getListaBoletos();
                                salaDelBoletoACancelar = sala;
                                funcion = boleto.getSesion();
                                //
                                listColumnaElegida = boleto.getListColumnaElegida();
                                listFilaElegida = boleto.getListFilaElegida();
                                cantidadBoletosCancelar = boleto.getCantidadBoletos();
                                horaMaximaParaCancelar = sala.getHoraLimiteParaCancelacion();
                                indexSala = controlador.getListaDeSalasPresentando().indexOf(sala);
                                boletoValido = true;
                            }
                        }

                    }
                   
                    excepciones.validarCancelacionDeCompra(idClienteIng, listaBoletosVendidos, funcion, horaMaximaParaCancelar, salaDelBoletoACancelar, boletoValido);
                    controlador.getListaDeSalasPresentando().get(indexSala).cancelarCompra(listColumnaElegida, listFilaElegida, cantidadBoletosCancelar);

                    banderaInterna = false;

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }

        } while (banderaInterna);

    }

    //VISTAS PARA ESTADISTICAS DE LAS SALAS
    public void vistaEstadisticasPorSala() {

        boolean banderaInterna = true;

        int opcion;

        System.out.println("\n\tBienvenido a CINEMAGICO");
        System.out.println("\n\tPor favor seleccione la función y sala de donde desea las estadísticas:\n");

        for (Sala sala : controlador.getListaDeSalasPresentando()) {
            System.out.println("Opción " + (controlador.getListaDeSalasPresentando().indexOf(sala) + 1));
            System.out.println(sala.toStringAdministrador() + "\n");

        }
        do {
            try {
                // 
                //
                System.out.print("Por favor ingrese su opción preferida (o ingrese 0 para ir al menú anterior): ");
                opcion = datoIng.nextInt();

                switch (opcion) {
                    case 1:
                        vistaEstadistica(opcion);
                        banderaInterna = false;
                        break;
                    case 2:
                        vistaEstadistica(opcion);
                        banderaInterna = false;
                        break;
                    case 3:
                        vistaEstadistica(opcion);
                        banderaInterna = false;
                        break;
                    case 4:
                        vistaEstadistica(opcion);
                        banderaInterna = false;
                        break;
                    case 5:
                        vistaEstadistica(opcion);
                        banderaInterna = false;
                        break;
                    case 6:
                        vistaEstadistica(opcion);
                        banderaInterna = false;
                        break;

                    case 0:

                        banderaInterna = false;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción no disponible, elija otra por favor");
                        datoIng.nextLine();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No ingresó un número, por favor intente de nuevo");
                datoIng.nextLine();
            }
        } while (banderaInterna);

    }

    public void vistaEstadistica(int opcionElegida) {

        String estadisticas = controlador.getListaDeSalasPresentando().get(opcionElegida - 1).toStringEstadisticas();
        System.out.println("\n" + estadisticas + "\n");
    }

}
