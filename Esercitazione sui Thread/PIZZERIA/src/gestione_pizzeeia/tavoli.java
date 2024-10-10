package gestione_pizzeeia;
import java.util.Random;

public class tavoli implements Runnable {

    private BufferV2 OrdiniPerCameriere;
    private BufferV2 OrdineDaConsegnare;
    private Random r = new Random();
    private int PizzeOrdinate;
    private boolean PuoOrdinare;

    tavoli(BufferV2 b, BufferV2 b1) {
        OrdiniPerCameriere = b;
        OrdineDaConsegnare = b1;
        PuoOrdinare = true;
    }

    public void run() {
        while (true) {
            if (PuoOrdinare) {
                PizzeOrdinate = r.nextInt(4) + 1;  // Ordina da 1 a 4 pizze
                OrdiniPerCameriere.Push(PizzeOrdinate);  // Invia ordine al buffer
                //System.out.println("(" + Thread.currentThread().getName() + ") ORDINE INVIATO: " + PizzeOrdinate + " pizze");
                PuoOrdinare = false;
            } else {
                int ordinePronto = OrdineDaConsegnare.MioOrdine();  // Controlla se il prossimo ordine è pronto
                if (ordinePronto == PizzeOrdinate) {
                    OrdineDaConsegnare.Pop();  // Rimuovi l'ordine dal buffer
                    System.out.println("(" + Thread.currentThread().getName() + ") ORDINE RICEVUTO: " + PizzeOrdinate + " pizze");
                    PuoOrdinare = true;
                }
            }

            // Aggiungi una piccola pausa per evitare uso eccessivo della CPU
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
