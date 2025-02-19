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
        final String GET_URL = args[0];

//      Initialize StringBuffer
        StringBuilder response = new StringBuilder();

//      Defines the URL
        URL url = new URL(GET_URL);

//      Instantiate a URL Connection
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

//      Set the connection method to GET
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

//      If the response code is 200 / OK, capture all HTML code
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                response.append(System.lineSeparator());
            }
            in.close();
        } else {
            System.out.println("URL connection error");
        }

//      Instantiate a list of Strings
        List<String> lines = new ArrayList<>();

//      Instantiate a reader
        BufferedReader reader = new BufferedReader(new StringReader(response.toString()));
        String line;

//      While the value of a individual line is not null, add it to the lines List
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        String mostSpaces = "";

//      Loop through each line
        for (int i = 0; i < lines.size(); i++) {
            String linha = lines.get(i);

//          Initialize counter to count the white spaces in the beginning of each line
            int counter = 0;

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
            }

//      Set the counter to 0 again after each loop
        counter = 0;
            
        }
        System.out.println(mostSpaces.strip());

    }
}
