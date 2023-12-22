package diego.antonio.del.greco.service;

import diego.antonio.del.greco.model.Personaje;
import diego.antonio.del.greco.persistence.LogTurnos;
import diego.antonio.del.greco.utils.ScannerService;

import java.util.ArrayList;


public class LuchaPersonajesImpl implements LuchaPersonaje{

    private final ScannerService sc = new ScannerService();
    private final LogTurnos logger = new LogTurnos();

    @Override
    public void luchando(ArrayList<Personaje> equipo1, ArrayList<Personaje> equipo2) {
        if (equipo1.size() < 3 || equipo2.size() < 3) {
            msjAConsolaYLog("No hay suficientes personajes para la lucha.");
            return;
        }

        while (hayPersonajesVivos(equipo1) && hayPersonajesVivos(equipo2)) {
            msjAConsolaYLog(
                    " _____                    _                            _          _             _           _  _         _ \n" +
                            "/  __ \\                  (_)                          | |        | |           | |         | || |       | |\n" +
                            "| /  \\/  ___   _ __ ___   _   ___  _ __   ____  __ _  | |  __ _  | |__    __ _ | |_   __ _ | || |  __ _ | |\n" +
                            "| |     / _ \\ | '_ ` _ \\ | | / _ \\| '_ \\ |_  / / _` | | | / _` | | '_ \\  / _` || __| / _` || || | / _` || |\n" +
                            "| \\__/\\| (_) || | | | | || ||  __/| | | | / / | (_| | | || (_| | | |_) || (_| || |_ | (_| || || || (_| ||_|\n" +
                            " \\____/ \\___/ |_| |_| |_||_| \\___||_| |_|/___| \\__,_| |_| \\__,_| |_.__/  \\__,_| \\__| \\__,_||_||_| \\__,_|(_)\n"
            );
            realizarRonda(equipo1, equipo2);
            pausar(2000);
        }

        mostrarResultadoFinal(equipo1, equipo2);
    }

    private void realizarRonda(ArrayList<Personaje> equipo1, ArrayList<Personaje> equipo2) {
        Personaje personajeEnJuego1 = seleccionarPersonaje(equipo1);
        Personaje personajeEnJuego2 = seleccionarPersonaje(equipo2);
        Personaje personajeConVida = null;

        while (personajeEnJuego1.getSalud() > 0 && personajeEnJuego2.getSalud() > 0) {
            simularAtaque(personajeEnJuego1, personajeEnJuego2);

            Personaje temp = personajeEnJuego1;
            personajeEnJuego1 = personajeEnJuego2;
            personajeEnJuego2 = temp;
        }

        msjAConsolaYLog("La ronda termino con los siguientes resultados:");
        escribirEstadoPersonaje(personajeEnJuego1);
        escribirEstadoPersonaje(personajeEnJuego2);

        if (personajeEnJuego1.getSalud() > 0) {
            personajeConVida = personajeEnJuego1;
        } else if (personajeEnJuego2.getSalud() > 0) {
            personajeConVida = personajeEnJuego2;
        }

        if (personajeConVida != null) {
            incrementoAtributoPersonaje(personajeConVida);
        }

        //verificacion y borrado de personajes sin uso
        equipo1.removeIf(p -> p.getSalud() <= 0);
        equipo2.removeIf(p -> p.getSalud() <= 0);
    }



    private void simularAtaque(Personaje atacante, Personaje defensor) {
        msjAConsolaYLog("Ataca: \"" + atacante.getNombre() + "\" con apodo: \"" + atacante.getApodo() +
                "\" VS. \"" + defensor.getNombre() + "\" con apodo: \"" + defensor.getApodo() + "\"");

        double danioProvocado = atacante.danioProvocado(defensor);
        int danioRedondeado = Math.max(1, (int) Math.round(danioProvocado));
        int soloDosCifras = Integer.parseInt(Integer.toString(danioRedondeado).substring(0, 2));

        msjAConsolaYLog("El luchador: " + atacante.getNombre() + " realizo: " + soloDosCifras +
                " de danio a: " + defensor.getNombre());

        defensor.setSalud(Math.max(0, defensor.getSalud() - soloDosCifras));

        pausar(1000);
    }

    private boolean hayPersonajesVivos(ArrayList<Personaje> equipo) {
        return !equipo.isEmpty();
    }

    private Personaje seleccionarPersonaje(ArrayList<Personaje> equipo) {
        for (Personaje pj : equipo) {
            return pj;
        }
        return null;
    }

    private void mostrarResultadoFinal(ArrayList<Personaje> equipo1, ArrayList<Personaje> equipo2) {
        if (equipo1.isEmpty()) {

            msjAConsolaYLog(" ______          _   _          _   _                    _                                                         _                     ___  \n" +
                    "|  ____|        | | (_)        (_) | |                  (_)                                                       (_)                   |__ \\ \n" +
                    "| |__      ___  | |  _    ___   _  | |_    __ _    ___   _    ___    _ __     ___   ___      ___    __ _   _   _   _   _ __     ___        ) |\n" +
                    "|  __|    / _ \\ | | | |  / __| | | | __|  / _` |  / __| | |  / _ \\  | '_ \\   / _ \\ / __|    / _ \\  / _` | | | | | | | | '_ \\   / _ \\      / / \n" +
                    "| |      |  __/ | | | | | (__  | | | |_  | (_| | | (__  | | | (_) | | | | | |  __/ \\__ \\   |  __/ | (_| | | |_| | | | | |_) | | (_) |    / /_ \n" +
                    "|_|       \\___| |_| |_|  \\___| |_|  \\__|  \\__,_|  \\___| |_|  \\___/  |_| |_|  \\___| |___/    \\___|  \\__, |  \\__,_| |_| | .__/   \\___/    |____|\n" +
                    "                                                                                                       | |             | |                     \n" +
                    "                                                                                                       |_|             |_|                     ");
            msjAConsolaYLog("El equipo 2 ha ganado la batalla.\n\n");
        } else {
            msjAConsolaYLog(" ______          _   _          _   _                    _                                                         _                     __ \n" +
                    "|  ____|        | | (_)        (_) | |                  (_)                                                       (_)                   /_ |\n" +
                    "| |__      ___  | |  _    ___   _  | |_    __ _    ___   _    ___    _ __     ___   ___      ___    __ _   _   _   _   _ __     ___      | |\n" +
                    "|  __|    / _ \\ | | | |  / __| | | | __|  / _` |  / __| | |  / _ \\  | '_ \\   / _ \\ / __|    / _ \\  / _` | | | | | | | | '_ \\   / _ \\     | |\n" +
                    "| |      |  __/ | | | | | (__  | | | |_  | (_| | | (__  | | | (_) | | | | | |  __/ \\__ \\   |  __/ | (_| | | |_| | | | | |_) | | (_) |    | |\n" +
                    "|_|       \\___| |_| |_|  \\___| |_|  \\__|  \\__,_|  \\___| |_|  \\___/  |_| |_|  \\___| |___/    \\___|  \\__, |  \\__,_| |_| | .__/   \\___/     |_|\n" +
                    "                                                                                                       | |             | |                   \n" +
                    "                                                                                                       |_|             |_|                   ");
            msjAConsolaYLog("El equipo 1 ha ganado la batalla.\n\n");
        }
    }

    private void escribirEstadoPersonaje(Personaje personaje) {
        msjAConsolaYLog(personaje.getNombre() + " vida: " + personaje.getSalud());
    }

    private void pausar(int pausa){
        try {
            Thread.sleep(pausa);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void msjAConsolaYLog(String msj){
        sc.escribirMensaje(msj);
        logger.log(msj);
    }

    private void incrementoAtributoPersonaje(Personaje personajeConVida) {
        int opcion = 0;
        while (opcion <= 0 || opcion > 5) {
            sc.escribirMensaje("\nPor la victoria de su personaje se le otorga poder subir 20 puntos al atributo que desee: \n");
            opcion = sc.leerInteger("1) Salud\n2) Velocidad\n3) Destreza\n4) Fuerza\n5) Armadura");

            if (opcion <= 0 || opcion > 5) {
                sc.escribirMensaje("Solo numeros del 1 al 5 por favor");
            } else {
                String atributoASubir = obtenerAtributo(personajeConVida, opcion);
                sc.escribirMensaje("Valor actual del atributo " + atributoASubir + ": " + obtenerValorAtributo(personajeConVida, opcion));

                personajeConVida.incrementoAtributo(opcion);

                sc.escribirMensaje(atributoASubir + " ha sido mejorado!");
                sc.escribirMensaje("Nuevo valor de " + atributoASubir + ": " + obtenerValorAtributo(personajeConVida, opcion));
            }
        }
    }

    private String obtenerAtributo(Personaje personaje, int opcion) {
        switch (opcion) {
            case 1:
                return "Salud";
            case 2:
                return "Velocidad";
            case 3:
                return "Destreza";
            case 4:
                return "Fuerza";
            case 5:
                return "Armadura";
            default:
                return "";
        }
    }

    private Integer obtenerValorAtributo(Personaje personaje, int opcion) {
        switch (opcion) {
            case 1:
                double saludDouble = personaje.getSalud();
                return (int) saludDouble;
            case 2:
                return personaje.getVelocidad();
            case 3:
                return personaje.getDestreza();
            case 4:
                return personaje.getFuerza();
            case 5:
                return personaje.getArmadura();
            default:
                return 0;
        }
    }
}

