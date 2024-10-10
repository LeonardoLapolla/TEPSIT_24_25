package gestione_pizzeeia;
import java.util.Random;
public class pizzaiolo implements Runnable {
	
	
	private BufferV2 OrdiniDaFare;
	private BufferV2 OrdiniPronti;
	private Random r = new Random();
	private int pizzesfornate;
	private int pizzetotali;
	private int pizzerichieste;

	pizzaiolo(BufferV2 b, BufferV2 b1){
		
		OrdiniDaFare = b;
		OrdiniPronti = b1;
		pizzetotali = 0;
	}
	
	//DA FINIRE
	public void run() {
		while(true) {
			pizzesfornate = r.nextInt(9);
			int OrdineInPreparazione = OrdiniDaFare.Pop();
			int PizzeSfornate = 0;
			for(;OrdineInPreparazione != 0;OrdineInPreparazione--,PizzeSfornate++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("("+ Thread.currentThread().getName() +")HO SFORNATO " + PizzeSfornate + " pizze");
			OrdiniPronti.Push(PizzeSfornate);
						
			
		}
		
	}

}
