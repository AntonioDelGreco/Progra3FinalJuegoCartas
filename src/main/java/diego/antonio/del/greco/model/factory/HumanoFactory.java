package diego.antonio.del.greco.model.factory;

import diego.antonio.del.greco.model.Humano;
import diego.antonio.del.greco.utils.GeneradorID;

import java.time.LocalDate;

public class HumanoFactory {

    public Humano nuevoHumano(){
        PersonajeFactory pjFactory = new PersonajeFactory();
        Humano humano = new Humano();
        GeneradorID genID = new GeneradorID();

        humano.setId(genID.generateID());
        humano.setNombre(pjFactory.nombrePersonaje());
        humano.setApodo(pjFactory.apodoPersonaje());
        humano.setFechaNacido(pjFactory.nacimientoPersonaje());
        humano.setEdad(pjFactory.edadPersonaje());
        humano.setSalud(100.0);
        humano.setVelocidad(pjFactory.velocidadPersonaje());
        humano.setDestreza(pjFactory.destrezaPersonaje());
        humano.setFuerza(pjFactory.fuerzaPersonaje());
        humano.setNivel(pjFactory.nivelPersonaje());
        humano.setArmadura(pjFactory.armaduraPersonaje());
        return humano;
    }

    public Humano nuevoHumano(
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
        Humano humano = new Humano();
        GeneradorID genID = new GeneradorID();

        humano.setId(genID.generateID());
        humano.setNombre(nombre);
        humano.setApodo(apodo);
        humano.setFechaNacido(fechaNacido);
        humano.setEdad(edad);
        humano.setSalud(100.0);
        humano.setVelocidad(velocidad);
        humano.setDestreza(destreza);
        humano.setFuerza(fuerza);
        humano.setNivel(nivel);
        humano.setArmadura(armadura);
        return humano;
    }
}
