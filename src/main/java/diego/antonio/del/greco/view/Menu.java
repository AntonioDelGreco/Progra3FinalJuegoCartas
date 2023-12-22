package diego.antonio.del.greco.view;

import diego.antonio.del.greco.persistence.LogTurnos;
import diego.antonio.del.greco.service.*;
import diego.antonio.del.greco.utils.ScannerService;

public class Menu {

    private final ScannerService sc;
    private SeleccionPersonaje seleccion;
    private InicioJuego init;
    private final LogTurnos logg = new LogTurnos();

    public Menu(){
       this.sc = new ScannerService();
    }

    public void runGame() {
        boolean salir = false;
        while (!salir) {
            String titulo = "─────────█▄██▄█\n" +
                    "█▄█▄█▄█▄█▐█┼██▌█▄█▄█▄█▄█\n" +
                    "███┼█████▐████▌█████┼███\n" +
                    "█████████▐████▌█████████\n" +
                    "Bienvenido al juego de cartas\n";
            sc.escribirMensaje(titulo);
            sc.escribirMensaje("1. Iniciar partida con personajes aleatorios");
            sc.escribirMensaje("2. Iniciar partida con personajes ingresados a mano");
            sc.escribirMensaje("3. Leer logs de partidas jugadas");
            sc.escribirMensaje("4. Borrar archivo de logs");
            sc.escribirMensaje("5. Salir");

            int opcion = sc.leerInteger("Ingrese su opcion: ");

            switch (opcion) {
                case 1:
                    seleccion = new SeleccionPersonajesAutomaticaImpl();
                    init = new InicioJuego(seleccion);
                    init.juego();
                    break;
                case 2:
                    seleccion = new SeleccionPersonajesManualImpl();
                    init = new InicioJuego(seleccion);
                    init.juego();
                    break;
                case 3:
                    logg.openLogsFile();
                    break;
                case 4:
                    logg.deleteLogsFile();
                    break;
                case 5:
                    salir = true;
                    sc.escribirMensaje("Hasta luego!");
                    break;
                default:
                    sc.escribirMensaje("Colocar un numero del 1 al 5 por favor.");
                    break;
            }
        }
    }
}
