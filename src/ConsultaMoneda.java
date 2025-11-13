import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda conversor(String monedaOrigen,String monedaDestino){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/7a3e298b02a61a891173809d/pair/"+monedaOrigen+"/"+monedaDestino);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .GET()
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Error en la busqueda del tipo de Moneda.");
        }
    }

}
