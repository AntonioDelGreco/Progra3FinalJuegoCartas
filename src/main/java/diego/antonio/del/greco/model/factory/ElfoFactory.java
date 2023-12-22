package diego.antonio.del.greco.model.factory;

import diego.antonio.del.greco.model.Elfo;
import diego.antonio.del.greco.utils.GeneradorID;

import java.time.LocalDate;

public class ElfoFactory {

    public Elfo nuevoElfo(){
        Elfo elfo = new Elfo();
        PersonajeFactory pjFactory = new PersonajeFactory();
        GeneradorID genID = new GeneradorID();

        elfo.setId(genID.generateID());
        elfo.setNombre(pjFactory.nombrePersonaje());
        elfo.setApodo(pjFactory.apodoPersonaje());
        elfo.setFechaNacido(pjFactory.nacimientoPersonaje());
        elfo.setEdad(pjFactory.edadPersonaje());
        elfo.setSalud(100.0);
        elfo.setVelocidad(pjFactory.velocidadPersonaje());
        elfo.setDestreza(pjFactory.destrezaPersonaje());
        elfo.setFuerza(pjFactory.fuerzaPersonaje());
        elfo.setNivel(pjFactory.nivelPersonaje());
        elfo.setArmadura(pjFactory.armaduraPersonaje());
        return elfo;
    }

    public Elfo nuevoElfo(
            String nombre,
            String apodo,
            LocalDate fechaNacido,
            Integer edad,
            Integer velocidad,
            Integer destreza,
            Integer fuerza,
            Integer nivel,
            Integer armadura
    ){
        Elfo elfo = new Elfo();
        GeneradorID genID = new GeneradorID();

        elfo.setId(genID.generateID());
        elfo.setNombre(nombre);
        elfo.setApodo(apodo);
        elfo.setFechaNacido(fechaNacido);
        elfo.setEdad(edad);
        elfo.setSalud(100.0);
        elfo.setVelocidad(velocidad);
        elfo.setDestreza(destreza);
        elfo.setFuerza(fuerza);
        elfo.setNivel(nivel);
        elfo.setArmadura(armadura);
        return elfo;
    }
}
