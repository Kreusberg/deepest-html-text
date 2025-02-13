import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        final String GET_URL = "http://hiring.axreng.com/internship/example1.html";
        StringBuffer response = new StringBuffer();

        URL url = new URL(GET_URL); // Define a URL
        HttpURLConnection con = (HttpURLConnection) url.openConnection(); // instancia uma instância da HttpURLConnection
        con.setRequestMethod("GET"); // define o metodo HTTP como Get
        int responseCode = con.getResponseCode(); // captura o código de retorno. Se sucesso, 200 é retornado.
        System.out.println("GET Response Code = " + responseCode); // debug

        if (responseCode == HttpURLConnection.HTTP_OK) { // Se o código for 200 (sucesso), captura t0d0 o HTML do link
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) { // enquanto o retorno não for vazio
                response.append(inputLine);
                response.append(System.lineSeparator());
            }
            in.close();
        }

        // print result
        System.out.println(response);

    }
}