import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HtmlAnalyzer {
    public static void main(String[] args) throws IOException {

//      Get the first parameter passed in args[0]
        final String GET_URL = "http://hiring.axreng.com/internship/example1.html";

//      Initialize StringBuffer
        StringBuffer response = new StringBuffer();

//      Defines the URL
        URL url = new URL(GET_URL);

//      Instantiate a URL Connection
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

//      Set the connection method to GET
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

//      Debug purposes
        System.out.println("GET Response Code = " + responseCode); // debug

//      If the response code is 200 / OK, capture all HTML code
        if (responseCode == HttpURLConnection.HTTP_OK) { // Se o código for 200 (sucesso), captura t0d0 o HTML do link
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) { // enquanto o retorno não for vazio
                response.append(inputLine);
                response.append(System.lineSeparator());
            }
            in.close();
        }

//      Debug purposes
        System.out.println(response);

//      Debug purposes
        System.out.println("===============================================");

//      Instantiate a list of Strings
        List<String> lines = new ArrayList<>();

//      Instantiate a reader
        BufferedReader reader = new BufferedReader(new StringReader(response.toString()));
        String line;

//      While the value of a individual line is not null, add it to the lines List
        while ((line = reader.readLine()) != null) {
            System.out.println(line);

            lines.add(line);
        }

//      Debug purposes
        System.out.println("===============================================");

//      Debug purposes
        System.out.println(lines);
        System.out.println(lines.get(0));

//      Debug purposes
        System.out.println("===============================================");

        String mostSpaces = "";

//      Loop through each line
        for (int i = 0; i < lines.size(); i++) {
            String linha = lines.get(i);

//          Initialize counter to count the white spaces in the beginning of each line
            int counter = 0;

//          Debug purposes
            System.out.println("Linha " + (i + 1) + ": " + lines.get(i));

//          Loop through each character of each line

            for (int j = 0; j < linha.length(); j++) {
                if (linha.charAt(j) == ' ') {

//                  If the char value of J is a white spaces, so add 1 to the counter
                    counter++;
                }

//              If the counter is bigger than the biggest line, attribute the line value in mostSpaces
                if (counter > mostSpaces.length()) {
                    mostSpaces = linha;
                }

//              Debug purposes
                System.out.println("Ao final do loop J, o counter foi de: " + counter);
            }

//          Debug purposes
            System.out.println("===============================================");

//          Debug purposes
            System.out.println("Most spaces: " + mostSpaces.strip());

//      Set the counter to 0 again after each loop
        counter = 0;

        }

    }
}
