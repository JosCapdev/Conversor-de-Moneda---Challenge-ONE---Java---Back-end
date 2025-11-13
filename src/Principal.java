import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
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

            if (opcion < 0 || opcion > 6) {
                System.out.println("**********************************************************");
                System.out.println("Seleccione una opcion valida del menu");
                System.out.println("**********************************************************\n");
                continue;
            }

            if (opcion == 0) {
                System.out.println("¡Gracias por usar el conversor!");
                break;
            }

            System.out.print("Ingresa el monto a convertir: ");
            double monto = lectura.nextDouble();

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
            }
            try {
                Moneda moneda = consultaMoneda.conversor(base, target);
                double resultado = monto * moneda.conversion_rate();
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