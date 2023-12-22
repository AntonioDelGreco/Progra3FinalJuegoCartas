package diego.antonio.del.greco.persistence;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LogTurnos {
    private final String LOG_FILE_NAME = "logs.txt";

    public void log(String message) {
        String filePath = getLogsDirectoryPath() + "/" + LOG_FILE_NAME;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteLogsFile() {
        String filePath = getLogsDirectoryPath() + "/" + LOG_FILE_NAME;
        Path path = Paths.get(filePath);

        if (Files.exists(path)) {
            try {
                Files.deleteIfExists(path);
                System.out.println("\n\nSu archivo de logs fue borrado con exito.\n\n");
            } catch (IOException e) {
                System.out.println("Error al intentar borrar el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo no existe en la ubicacion especificada.");
        }
    }

    public void openLogsFile() {
        File file = new File(getLogsDirectoryPath() + "/" + LOG_FILE_NAME);

        if (file.exists()) {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.open(file);
                } catch (IOException e) {
                    System.out.println("No se pudo abrir el archivo: " + e.getMessage());
                }
            } else {
                System.out.println("El escritorio no es compatible para abrir archivos.");
            }
        } else {
            System.out.println("El archivo no existe en la ubicacion especificada.");
        }
    }

    private String getLogsDirectoryPath() {
        File currentDir = new File(System.getProperty("user.dir"));
        return currentDir.getAbsolutePath();
    }
}

