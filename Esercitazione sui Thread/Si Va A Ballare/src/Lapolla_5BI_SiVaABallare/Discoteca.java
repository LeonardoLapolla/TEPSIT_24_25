package Lapolla_5BI_SiVaABallare;

public class Discoteca {
    private int personeDentro = 0;

    // Aggiunge una persona
    public synchronized void entra() {
        personeDentro++;
    }

    // Rimuove una persona
    public synchronized void esce() {
        personeDentro--;
    }

    // Restituisce il numero di persone all'interno
    public synchronized int getNumeroPersoneDentro() {
        return personeDentro;
    }
}
