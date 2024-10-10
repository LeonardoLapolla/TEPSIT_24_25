package gestione_pizzeeia;
import java.util.LinkedList;
import java.util.Queue;

public class BufferV2 {
    Queue<Integer> coda;

    BufferV2() {
        coda = new LinkedList<>();
    }

    // Metodo per inserire un elemento nella coda
    public synchronized void Push(int val) {
        coda.add(val);
        notifyAll();  // Notifica eventuali thread in attesa che la coda non sia più vuota
    }

    // Metodo per rimuovere un elemento dalla coda
    public synchronized int Pop() {
        while (Vuota()) {
            try {
                wait(); // Il thread attende finché non ci sono elementi nella coda
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return -1; // Interruzione gestita
            }
        }
        return coda.poll();
    }

    // Metodo per visualizzare il prossimo ordine senza rimuoverlo
    public synchronized int MioOrdine() {
        while (Vuota()) {
            try {
                wait(); // Il thread attende finché non ci sono elementi nella coda
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return -1; // Interruzione gestita
            }
        }
        return coda.peek();
    }

    // Controllo se la coda è vuota
    public synchronized boolean Vuota() {
        return coda.isEmpty();
    }
}
