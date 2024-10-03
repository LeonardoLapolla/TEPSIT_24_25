package Lapolla_5BI_StatoDeiThread;
import java.util.Random;
import java.util.random.*;

public class Contatore extends Thread implements Runnable {
	private int c; //Tiene traccia del conteggio al quale è arrivato il Thread
	private int val; //Il valore fino al quale il thread deve contare
	private boolean Completato = false;
	
	public Contatore(int n) {
		val = n;
		c = 0;
	}

	//Il metodo GetC inizialmente controlla se il thread ha terminato il proprio conteggio altrimenti continua a contare
	public boolean getC() {
		if(c == val) {
			if(!Completato) {
				System.out.println("COMPLETATO");
			}
			Completato = true;
			return true;
		}else {
			System.out.println("("+ Thread.currentThread().getId() +")"+ "è arrivato a " + c);
			return false;
		}
		
	}
	

	
	public void run() {
		for (int i = 0; i < val; i++) {
			c++;
			try {
				Thread.sleep(120);
			}catch (Exception e) {}
		}
	}

}
