package Lapolla_5BI_SiVaABallare;
import java.util.Random;

public class Persona extends Thread {
    private Discoteca discoteca;
    private Random random;

    public Persona(Discoteca discoteca) {
        this.discoteca = discoteca;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                // La persona entra nella discoteca
                discoteca.entra();

                // La persona resta nella discoteca per un tempo casuale (da 1 a 5 secondi)
                Thread.sleep(random.nextInt(5000) + 1000);

                // La persona esce dalla discoteca
                discoteca.esce();

                // La persona resta fuori per un tempo casuale (da 1 a 5 secondi)
                Thread.sleep(random.nextInt(5000) + 1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}