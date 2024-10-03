package Lapolla_5BI_ATeatro;

public class Teatro {
	private final int postiPerFila = 46;   //Posti per fila
    private boolean[] posti;                //Array per indicare lo stato dei posti

    public Teatro() {
        posti = new boolean[postiPerFila];
    }

    //Considero prima i posti centrali
    public synchronized boolean prenotaPosto() {
        //Tentiamo di prenotare i posti centrali posizioni da 20 a 25
        for (int i = 20; i <= 25; i++) {
            if (!posti[i]) {
                posti[i] = true;
                System.out.println(Thread.currentThread().getName() + " ha prenotato il posto " + i);
                return true; 
            }
        }

        //Se non ci sono posti centrali disponibili prenotiamo i posti più vicini
        for (int i = 0; i < postiPerFila; i++) {
            if (!posti[i]) {
                posti[i] = true;
                System.out.println(Thread.currentThread().getId() + " ha prenotato il posto " + i);
                return true;
            }
        }
        return false;
    }

    //Metodo per contare i posti disponibili
    public synchronized int postiDisponibili() {
        int disponibili = 0;
        for (boolean posto : posti) {
            if (!posto) {
                disponibili++;
            }
        }
        return disponibili;
    }
}
