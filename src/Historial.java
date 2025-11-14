import java.util.ArrayList;
import java.util.List;

public class Historial {
    private List<String> registros = new ArrayList<>();

    public void agregarRegistro(String registro) {
        registros.add(registro);
    }

    public void mostrarHistorial() {
        if (registros.isEmpty()) {
            System.out.println("⚠️ No hay conversiones registradas todavía.");
        } else {
            System.out.println("**********************************************************");
            System.out.println("Historial de Conversiones:");
            for (String r : registros) {
                System.out.println("* " + r + "\n");
            }
        }
    }
}
