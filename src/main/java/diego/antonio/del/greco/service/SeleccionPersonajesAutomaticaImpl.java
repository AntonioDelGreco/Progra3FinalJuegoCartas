package diego.antonio.del.greco.service;

import diego.antonio.del.greco.model.Personaje;
import diego.antonio.del.greco.model.factory.ElfoFactory;
import diego.antonio.del.greco.model.factory.HumanoFactory;
import diego.antonio.del.greco.model.factory.OrcoFactory;
import diego.antonio.del.greco.utils.ScannerService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SeleccionPersonajesAutomaticaImpl implements SeleccionPersonaje {
    private final ScannerService sc = new ScannerService();

    @Override
    public ArrayList<Personaje> seleccionando() {
        Random rand;
        Personaje personaje;
        Set<Personaje> cartas = new HashSet<>();

        while(cartas.size() < 6){
            rand = new Random();
            personaje = null;

            try {
                switch (rand.nextInt(3)) {
                    case 0:
                        personaje = new OrcoFactory().nuevoOrco();
                        break;
                    case 1:
                        personaje =  new HumanoFactory().nuevoHumano();
                        break;
                    case 2:
                        personaje = new ElfoFactory().nuevoElfo();
                        break;
                }

                if (personaje != null) {
                    cartas.add(personaje);
                } else {
                    sc.escribirMensaje("No se pudo crear el personaje.");
                }
            } catch (Exception e) {
                sc.escribirMensaje("Error al crear un personaje: " + e.getMessage());
            }
        }

        if (cartas.size() != 6) {
            sc.escribirMensaje("No se crearon 6 personajes correctamente.");
        }

        return new ArrayList<>(cartas);
    }
}



