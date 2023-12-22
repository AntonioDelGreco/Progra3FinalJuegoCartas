package diego.antonio.del.greco.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

@Getter
@Setter
@ToString
public abstract class Personaje {

    private String id;
    private String nombre;
    private String apodo;
    private LocalDate fechaNacido;
    private Integer edad; //0 a 300
    private Double salud; // 100
    private Integer velocidad; // 1 a 10
    private Integer destreza; //1 a 5
    private Integer fuerza;//1 a 10
    private Integer nivel; // 1 a 10
    private Integer armadura; // 1 a 10

    //calculos de ataque y defensa
    public Integer poderDisparo(){
        return this.destreza * this.fuerza * this.nivel;
    }

    public Integer efectividadDisparo(){
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    public Integer valorAtaque(){
        return poderDisparo() * efectividadDisparo();
    }

    public Double poderDefensa(){
        return (double) (this.armadura * this.velocidad);
    }

    public void incrementoAtributo(int atributo){
        int aumento = 20;
        switch (atributo){
            case 1:
                setSalud(getSalud() + (double) aumento);
                break;
            case 2:
                setVelocidad(getVelocidad() + aumento);
                break;
            case 3:
                setDestreza(getDestreza() + aumento);
                break;
            case 4:
                setFuerza(getFuerza() + aumento);
                break;
            case 5:
                setArmadura(getArmadura() + aumento);
                break;
            default:
                break;
        }
    }

    public abstract double danioProvocado(Personaje personajeEnDefensa);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personaje personaje = (Personaje) o;
        return Objects.equals(id, personaje.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
