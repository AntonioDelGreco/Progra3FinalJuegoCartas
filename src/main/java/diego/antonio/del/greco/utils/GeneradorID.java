package diego.antonio.del.greco.utils;

import java.util.UUID;

public class GeneradorID {
    public String generateID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
