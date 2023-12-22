package diego.antonio.del.greco.model.factory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PersonajeFactory {

    private final Random random = new Random(System.currentTimeMillis());

    public String nombrePersonaje() {
        ArrayList<String> nombres = new ArrayList<>(List.of("Haldor", "Elysia", "Thorian", "Isolde",
                "Alden", "Eadric", "Rowan", "Aeliana", "Caelum", "Eldric", "Lorandor", "Eldariel", "Thalindra",
                "Galwir", "Aranor", "Celeborn", "Elurin", "Silariel", "Thranduil", "Legolin", "Grukthar", "Zugnak",
                "Dorgosh", "Gorblak", "Razgrin", "Morgok", "Skarsh", "Durnak", "Thragar", "Grokul"));

        Collections.shuffle(nombres);
        Collections.shuffle(nombres);
        return nombres.get(random.nextInt(nombres.size()));
    }

    public String apodoPersonaje() {
        ArrayList<String> apodos = new ArrayList<>(List.of("Valiente", "Enigmático", "Noble",
                "Amable", "Intrépido", "El Justo", "Dama Valiente", "El Sabio", "El Generoso", "El Desafiante",
                "Veloz", "Sabio", "Grácil", "Sereno", "Eterno", "Caminante de los Bosques", "Luz Estelar",
                "Susurrante", "Arquero de la Luna", "Cazador de Sombras", "Gruñón", "Tronchacráneos", "Furioso",
                "Sanguinario", "Demente", "Colmilludo", "Martillo Negro", "Cicatriz", "Cabeza de Hacha", "Brutal"));

        Collections.shuffle(apodos);
        Collections.shuffle(apodos);
        return apodos.get(random.nextInt(apodos.size()));
    }

    public LocalDate nacimientoPersonaje() {
        int year = random.nextInt(51) + 1950;
        int dayOfYear = random.nextInt(365);
        LocalDate startDate = LocalDate.of(year, 1, 1);
        return startDate.plusDays(dayOfYear);
    }

    public Integer edadPersonaje() {
        return random.nextInt(301);
    }

    public Integer velocidadPersonaje() {
        return random.nextInt(10) + 1;
    }

    public Integer destrezaPersonaje() {
        return random.nextInt(5) + 1;
    }

    public Integer fuerzaPersonaje() {
        return random.nextInt(10) + 1;
    }

    public Integer nivelPersonaje() {
        return random.nextInt(10) + 1;
    }

    public Integer armaduraPersonaje() {
        return random.nextInt(10) + 1;
    }
}
