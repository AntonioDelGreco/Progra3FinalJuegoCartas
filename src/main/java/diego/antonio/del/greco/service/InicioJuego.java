package diego.antonio.del.greco.service;

import diego.antonio.del.greco.model.Personaje;

import java.util.ArrayList;

public class InicioJuego {

    private final SeleccionPersonaje seleccion;
    private final LuchaPersonaje lucha = new LuchaPersonajesImpl();

    public InicioJuego(SeleccionPersonaje seleccion) {
        this.seleccion = seleccion;
    }

    public void juego() {
        ArrayList<Personaje> listaPJ = seleccion.seleccionando();
        ArrayList<Personaje> equipoJugador1 = new ArrayList<>(listaPJ.subList(0, 3));
        ArrayList<Personaje> equipoJugador2 = new ArrayList<>(listaPJ.subList(3, 6));
        System.out.println("\n\nLos personajes fueron creados correctamente.\n\n");
        lucha.luchando(equipoJugador1, equipoJugador2);
    }
}