import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        Historial historial = new Historial();
        String continuar = "S";

        while (continuar.equalsIgnoreCase("S")) {
            System.out.println("**********************************************************");
            System.out.println("Bienvenido al Conversor de Monedas Java");
            System.out.println("**********************************************************");
            System.out.println("1. USD -> ARS");
            System.out.println("2. ARS -> USD");
            System.out.println("3. USD -> BRL");
            System.out.println("4. BRL -> USD");
            System.out.println("5. USD -> EUR");
            System.out.println("6. EUR -> USD");
            System.out.println("7. USD -> MXN");
            System.out.println("8. MXN -> USD");
            System.out.println("9. USD -> CLP");
            System.out.println("10. CLP -> USD");
            System.out.println("11. Ver historial conversiones");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            if (!lectura.hasNextInt()) {
                System.out.println("**********************************************************");
                System.out.println("Debes ingresar un número válido.");
                System.out.println("**********************************************************\n");
                lectura.nextLine();
                continue;
            }
            int opcion = lectura.nextInt();

            if (opcion < 0 || opcion > 11) {
                System.out.println("**********************************************************");
                System.out.println("Seleccione una opcion valida del menu");
                System.out.println("**********************************************************\n");
                continue;
            }

            if (opcion == 0) {
                System.out.println("¡Gracias por usar el conversor!");
                break;
            }
            double monto = 0;
            if (opcion != 11){
                System.out.print("Ingresa el monto a convertir: ");
                monto = lectura.nextDouble();
            }

            String base = "";
            String target = "";

            switch (opcion) {
                case 1 -> {
                    base = "USD";
                    target = "ARS";
                }
                case 2 -> {
                    base = "ARS";
                    target = "USD";
                }
                case 3 -> {
                    base = "USD";
                    target = "BRL";
                }
                case 4 -> {
                    base = "BRL";
                    target = "USD";
                }
                case 5 -> {
                    base = "USD";
                    target = "EUR";
                }
                case 6 -> {
                    base = "EUR";
                    target = "USD";
                }
                case 7 -> {
                    base = "USD";
                    target = "MXN";
                }
                case 8 -> {
                    base = "MXN";
                    target = "USD";
                }
                case 9 -> {
                    base = "USD";
                    target = "CLP";
                }
                case 10 -> {
                    base = "CLP";
                    target = "USD";
                }
                case 11 -> {
                    historial.mostrarHistorial();
                    System.out.print("¿Desea realizar alguna conversión? (S/N): ");
                    continuar = lectura.next();
                    if(!continuar.equalsIgnoreCase("S")){
                        System.out.println("¡Gracias por usar el conversor!");
                    }
                    continue;
                }
            }
            try {
                Moneda moneda = consultaMoneda.conversor(base, target);
                double resultado = monto * moneda.conversion_rate();
                LocalDateTime horaConversion = LocalDateTime.now();
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                historial.agregarRegistro(monto+" "+ base +" -> "+resultado+" "+ target +" "+ horaConversion.format(formato));
                System.out.printf("El valor de "+monto +" "+ base +" es igual a "+resultado+" "+ target + "\n"  );
                System.out.print("¿Desea realizar otra conversión? (S/N): ");
                continuar = lectura.next();
                if(!continuar.equalsIgnoreCase("S")){
                    System.out.println("¡Gracias por usar el conversor!");
                }

            } catch (Exception e) {
                System.out.println("Error al realizar la conversión: " + e.getMessage());
            }
        }
    }
}