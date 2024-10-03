package ProduttoreConsumatore;

public class Consumatore implements Runnable{

	private Buffer buffer;
	private int nPari;
	private int nDispari;
	private int nTotali;
	
	
	public Consumatore(Buffer B) {
		buffer = B;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			int n;
			n = buffer.Pop();
			
			//Controllo se il numero e pari o dispari
			if(n % 2 == 0) {
				nPari++;
			}else{
				nDispari++;
			}
			nTotali++;
			//Stampa prima il numero e poi la statistica
			System.out.println("ho tirato fuori " + n);
			System.out.println(((nPari*100)/nTotali) + "% di numeri pari e " + ((nDispari*100)/nTotali) + "% di numeri dispari");
			
			//Attende 120ms
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
