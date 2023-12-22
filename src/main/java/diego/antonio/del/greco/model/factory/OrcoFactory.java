package diego.antonio.del.greco.model.factory;

import diego.antonio.del.greco.model.Orco;
import diego.antonio.del.greco.utils.GeneradorID;

import java.time.LocalDate;

public class OrcoFactory {

    public Orco nuevoOrco(){
        PersonajeFactory pjFactory = new PersonajeFactory();
        Orco orco = new Orco();
        GeneradorID genID = new GeneradorID();

        orco.setId(genID.generateID());
        orco.setNombre(pjFactory.nombrePersonaje());
        orco.setApodo(pjFactory.apodoPersonaje());
        orco.setFechaNacido(pjFactory.nacimientoPersonaje());
        orco.setEdad(pjFactory.edadPersonaje());
        orco.setSalud(100.0);
        orco.setVelocidad(pjFactory.velocidadPersonaje());
        orco.setDestreza(pjFactory.destrezaPersonaje());
        orco.setFuerza(pjFactory.fuerzaPersonaje());
        orco.setNivel(pjFactory.nivelPersonaje());
        orco.setArmadura(pjFactory.armaduraPersonaje());
        return orco;
    }

    public Orco nuevoOrco(
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
        Orco orco = new Orco();
        GeneradorID genID = new GeneradorID();

        orco.setId(genID.generateID());
        orco.setNombre(nombre);
        orco.setApodo(apodo);
        orco.setFechaNacido(fechaNacido);
        orco.setEdad(edad);
        orco.setSalud(100.0);
        orco.setVelocidad(velocidad);
        orco.setDestreza(destreza);
        orco.setFuerza(fuerza);
        orco.setNivel(nivel);
        orco.setArmadura(armadura);
        return orco;
    }
}
