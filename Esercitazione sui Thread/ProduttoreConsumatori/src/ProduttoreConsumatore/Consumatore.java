package ProduttoreConsumatore;

public class Consumatore implements Runnable{

	private Buffer buffer;
	private int nNegativi;
	private int[] Ultimi = new int[4];
	float Media;
	int i = 0; //posizione ultimo valore dell'array
	
	
	public Consumatore(Buffer B) {
		buffer = B;
	}
	
	private float MediaVal(int v) {
		float m,somma = 0;
		//Calcolo La media
		for(int j = 0;j<4;j++) {
			somma = somma+Ultimi[j];
		}
		m = somma/5;
		
		if(i == 3) {
			for(int j = 0;j<3;j++) {
				Ultimi[j] = Ultimi[j+1];
			}
		}
		Ultimi[3] = v;
		return m;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			int n;
			n = buffer.Pop();
			
			//Controllo se il numero e pari o dispari
			if(n > 0) {
				nNegativi++;
			}else{
				MediaVal(n);
			}
			//Stampa prima il numero e poi la statistica
			System.out.println("ho tirato fuori" + n);
			System.out.println();
			
			//Attende 120ms
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
