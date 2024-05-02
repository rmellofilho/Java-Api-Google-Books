import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner leitura = new Scanner(System.in);
        
        System.out.println("Digite um livro para a busca:");
        var busca = leitura.nextLine();

        String chave = "SUA CHAVE AQUI";
        String endereco = "https://www.googleapis.com/books/v1/volumes?q=" + busca + "&key=" + chave;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        }

        

    }
}
