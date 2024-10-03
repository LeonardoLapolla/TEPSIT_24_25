package Lapolla_5BI_StatoDeiThread;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		int T, N;
		Scanner cin = new Scanner(System.in);
		
		//Input dei dati
		System.out.println("Inserisci T: ");
		T = cin.nextInt();
		System.out.println("Inserisci N: ");
		N = cin.nextInt();
		
		Contatore arr[] = new Contatore[T];
		double rand;
		boolean check = true;
		
		//Creo e avvio tutti i Thread
		for(int i = 0; i < T; i++) {
			rand = Math.random() * N;
			int num = (int)rand;
			arr[i] = new Contatore(num);
			Thread t = new Thread(arr[i]);
			t.start();
		}
		
		
		//Effettuo il controllo sui vari Thread ed esco solo quando sono tutti terminati
		while(check) {
			check = false;
			for(int i = 0; i < T ; i++) {
				if(!arr[i].getC()) {
					check = true;
				}
			}
			try {
				Thread.sleep(1000);
			}catch (Exception e) {}
			
		}
		
		System.out.println("TUTTI I THREAD SONO TERMINATI");
	}

}
