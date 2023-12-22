package diego.antonio.del.greco.service;

import diego.antonio.del.greco.model.Personaje;
import diego.antonio.del.greco.model.TipoPersonajes;
import diego.antonio.del.greco.model.factory.ElfoFactory;
import diego.antonio.del.greco.model.factory.HumanoFactory;
import diego.antonio.del.greco.model.factory.OrcoFactory;
import diego.antonio.del.greco.utils.ScannerService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SeleccionPersonajesManualImpl implements SeleccionPersonaje{

    private final ScannerService sc = new ScannerService();

    @Override
    public ArrayList<Personaje> seleccionando() {
        Personaje personaje;
        Set<Personaje> cartas = new HashSet<>();

        while(cartas.size() < 6){
            int opcion = sc.leerInteger("\nQue desea crear? \n1) Orco\n2) Humano \n3) Elfo");

            try {
                personaje = pidiendoDatosPersonaje(opcion);

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

    private Personaje pidiendoDatosPersonaje(int opcion) {
        if (opcion <= 0 || opcion >= 4) return null;
        String nombre = sc.leerString("Ingrese el nombre del personaje");
        String apodo = sc.leerString("Ingrese el apodo del personaje");
        LocalDate fechaNacimiento = sc.leerFecha("Ingrese la fecha de nacimiento del personaje");
        int edad = sc.leerInteger("Ingrese la edad del personaje");
        int velocidad = sc.leerInteger("Ingrese la velocidad del personaje");
        int destreza = sc.leerInteger("Ingrese la destreza del personaje");
        int fuerza = sc.leerInteger("Ingrese la fuerza del personaje");
        int nivel = sc.leerInteger("Ingrese el nivel del personaje");
        int armadura = sc.leerInteger("Ingrese la armadura del personaje");

        return switch (opcion){
            case 1 -> new OrcoFactory().nuevoOrco(nombre, apodo, fechaNacimiento,
                    edad, velocidad, destreza, fuerza, nivel, armadura);
            case 2 -> new HumanoFactory().nuevoHumano(nombre, apodo, fechaNacimiento,
                        edad, velocidad, destreza, fuerza, nivel, armadura);
            case 3 -> new ElfoFactory().nuevoElfo(nombre, apodo, fechaNacimiento,
                    edad, velocidad, destreza, fuerza, nivel, armadura);
            default -> throw new IllegalStateException("Valor invalido: " + opcion);
        };
    }
}
