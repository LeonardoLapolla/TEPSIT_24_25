package ProduttoreConsumatore;

import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int T;
		int N;
		int D;
		
		System.out.println("Inserisci T");
		T = cin.nextInt();

		
		Thread ArrP[] = new Thread[T];
		Thread ArrC[] = new Thread[T];
		Buffer B = new Buffer(10);
		
		//Creo i Thread
		for(int i = 0; i<T ;i++) {
			Thread t = new Thread(new Produttore(B));
			ArrP[i] = t;
		}
		for(int i = 0; i<T ;i++) {
			Thread t = new Thread(new Consumatore(B));
			ArrC[i] = t;
		}
		
		//Avvio i Thread
		for(int i = 0; i<T ;i++) {
			ArrP[i].start();
		}
		for(int i = 0; i<T ;i++) {
			ArrC[i].start();
		}
		
	}

}
