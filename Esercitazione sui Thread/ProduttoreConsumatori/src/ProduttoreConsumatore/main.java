package ProduttoreConsumatore;

import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int T;

		
		System.out.println("Inserisci il numero di consumatori");
		T = cin.nextInt();

		
		Thread ArrP[] = new Thread[T];
		Thread ArrC[] = new Thread[T];
		Buffer B = new Buffer(10);
		
		//Creo i Thread
		Thread P = new Thread(new Produttore(B));
		for(int i = 0; i<T ;i++) {
			Thread t = new Thread(new Consumatore(B));
			ArrC[i] = t;
		}
		
		//Avvio i Thread
		P.start();
		for(int i = 0; i<T ;i++) {
			ArrC[i].start();
		}
		
	}

}
