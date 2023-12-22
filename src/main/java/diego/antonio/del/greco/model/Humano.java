package diego.antonio.del.greco.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Humano extends Personaje{
    @Override
    public double danioProvocado(Personaje personajeEnDefensa) {
        Double defensa = personajeEnDefensa.poderDefensa();
        return ((valorAtaque() * efectividadDisparo()) - defensa / 500) * 100;
    }
}
