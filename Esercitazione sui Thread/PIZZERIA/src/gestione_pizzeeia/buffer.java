package gestione_pizzeeia;

public class buffer
{
	 private int[] coda;
	    private int front;
	    private int rear;
	    private int grandezzaMassima;
	    private int conteggioElementi;
	buffer(){
	    this.grandezzaMassima = grandezzaMassima;
	    coda = new int[grandezzaMassima];
	    front = 0;
	    rear = -1;
	    conteggioElementi = 0;
	}
	
	// Metodo per aggiungere un elemento alla coda
	public synchronized void push(int elemento) {
	    if (conteggioElementi < grandezzaMassima) {
	        rear = (rear + 1) % grandezzaMassima; // Gestione circolare dell'indice rear
	        coda[rear] = elemento;
	        conteggioElementi++;
	        System.out.println("Elemento aggiunto: " + elemento);
	    } else {
	        //System.out.println("Coda piena! Impossibile aggiungere l'elemento: " + elemento);
	    }
	}
	
	// Metodo per rimuovere un elemento dalla coda
	public synchronized int pop() {
		int elementoRimosso = 0 ;
	    if (conteggioElementi > 0) {
	         elementoRimosso = coda[front];
	        front = (front + 1) % grandezzaMassima; // Gestione circolare dell'indice front
	        conteggioElementi--;
	        System.out.println("Elemento rimosso: " + elementoRimosso);
	    } else {
	        //System.out.println("Coda vuota! Nessun elemento da rimuovere.");
	    }
	    return elementoRimosso;
	}
}
