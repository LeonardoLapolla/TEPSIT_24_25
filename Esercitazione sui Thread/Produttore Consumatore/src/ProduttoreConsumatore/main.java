package ProduttoreConsumatore;

import java.util.Scanner;


public class main {

	public static void main(String[] args) {

		
		Buffer B = new Buffer(10);
		Thread Produttore = new Thread(new Produttore(B));
		Thread Consumatore = new Thread(new Consumatore(B));
		Produttore.start();
		Consumatore.start();
		
		
		
		
	}

}
