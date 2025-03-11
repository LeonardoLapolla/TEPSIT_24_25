package ClientRest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Client {

    private  final String BASE_URL = "http://localhost:8080/api/books";
    private  final Gson gson = new Gson();


    public  void getAllBooks() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(BASE_URL).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            String response = readResponse(connection.getInputStream());
            List<Book> books = gson.fromJson(response, new TypeToken<List<Book>>(){}.getType());
            System.out.println("Books: " + books);
        } else {
            System.out.println("GET All Books failed: " + responseCode);
        }
        connection.disconnect();
    }

    public  void addBook() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(BASE_URL).openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        Book newBook = new Book(0, "New Book", "english", List.of(new Author(1, "AuthorName", "Surname")));
        try (OutputStream os = connection.getOutputStream()) {
            os.write(gson.toJson(newBook).getBytes());
        }

        int responseCode = connection.getResponseCode();
        System.out.println("POST Book response: " + responseCode);
        connection.disconnect();
    }

    private  String readResponse(InputStream inputStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}