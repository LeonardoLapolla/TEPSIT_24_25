package ProduttoreConsumatore;

public class Buffer{

	private int[] pila;
    private int top;
    private int maxSize;

    // Costruttore: inizializza la pila con una dimensione specificata
    public Buffer(int size) {
        maxSize = size;
        pila = new int[maxSize];
        top = -1; // Indice che tiene traccia dell'elemento in cima alla pila
    }

    // Metodo per inserire un elemento nella pila (PUSH)
    public synchronized void Push(int elemento) {
        if (isFull()) {
            raddoppiaDimensione();
        }
        pila[++top] = elemento;
    }

    // Metodo per rimuovere e restituire l'elemento in cima alla pila (POP)
    public synchronized int Pop() {
        if (isEmpty()) {
            return -1;
        } else {
        	top--;
            return pila[top+1];
        }
    }


    // Metodo per verificare se la pila è vuota
    public boolean isEmpty() {
        return (top == -1);
    }

    // Metodo per verificare se la pila è piena
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Metodo per ottenere la dimensione corrente della pila
    public int size() {
        return top + 1;
    }

    // Metodo per raddoppiare la dimensione della pila quando è piena
    private void raddoppiaDimensione() {
        maxSize *= 2; // Raddoppia la dimensione massima
        int[] nuovaPila = new int[maxSize]; // Crea un nuovo array di dimensione doppia
        // Copia gli elementi dalla vecchia pila alla nuova
        for (int i = 0; i <= top; i++) {
            nuovaPila[i] = pila[i];
        }
        pila = nuovaPila; // Rimpiazza la pila vecchia con quella nuova
    }
}
