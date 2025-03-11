package ClientRest;

import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {
        // Esegui richieste di esempio
		Client c  = new Client();
        c.getAllBooks();
        c.addBook();
    }

}
