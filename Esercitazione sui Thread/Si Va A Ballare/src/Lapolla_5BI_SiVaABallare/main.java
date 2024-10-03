package Lapolla_5BI_SiVaABallare;

public class main {
    public static void main(String[] args) {
        Discoteca discoteca = new Discoteca();
        int numeroPersone = 10;  // Numero di persone

        // Crea e avvia i thread
        for (int i = 0; i < numeroPersone; i++) {
            new Persona(discoteca).start();
        }

        // Monitoraggio dello stato della discoteca ogni secondo
        while (true) {
            try {
                Thread.sleep(1000);  // Attende 1 secondo
                System.out.println("Persone dentro la discoteca: " + discoteca.getNumeroPersoneDentro());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
