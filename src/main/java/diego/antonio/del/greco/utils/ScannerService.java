package diego.antonio.del.greco.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerService {
    private final Scanner scanner;

    public ScannerService() {
        scanner = new Scanner(System.in);
    }

    public void escribirMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String leerString(String mensaje) {
        String input;
        do {
            escribirMensaje(mensaje);
            input = scanner.nextLine().trim();

            if (!input.matches("[a-zA-Z]+") || input.length() <= 3) {
                escribirMensaje("Debe contener solo letras y tener mas de tres caracteres. Intentelo de nuevo.");
            }
        } while (!input.matches("[a-zA-Z]+") || input.length() <= 3);

        return input;
    }

    public LocalDate leerFecha(String mensaje) {
        LocalDate fechaNacido = null;
        boolean fechaValida = false;

        while (!fechaValida) {
            escribirMensaje(mensaje + " (Anio-Mes-Dia), por ejemplo 1997-09-03: ");
            String fecha = scanner.nextLine();

            try {
                fechaNacido = LocalDate.parse(fecha);
                fechaValida = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Por favor, ingrese la fecha en el formato correcto (Año-Mes-Día).");
            }
        }

        return fechaNacido;
    }

    public int leerInteger(String mensaje) {
        int numero = 0;
        boolean inputValido = false;
        while (!inputValido) {
            try {
                escribirMensaje(mensaje);
                numero = Integer.parseInt(scanner.nextLine().trim());

                if (numero >= 0) {
                    inputValido = true;
                } else {
                    escribirMensaje("Ingrese un numero no negativo.");
                }
            } catch (NumberFormatException e) {
                escribirMensaje("Tiene que ser un numero entero positivo");
            }
        }
        return numero;
    }

//    public double leerDecimal() {
//        double decimal = 0;
//        boolean inputValido = false;
//        while (!inputValido) {
//            try {
//                decimal = scanner.nextDouble();
//                inputValido = true;
//            } catch (InputMismatchException e) {
//                scanner.nextLine();
//                escribirMensaje("Entrada invalida. Por favor, ingrese un numero decimal valido: ");
//            }
//        }
//        return decimal;
//    }

    public void limpiarBufer(){
        scanner.nextLine();
    }
}
