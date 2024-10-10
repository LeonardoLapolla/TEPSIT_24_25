 package gestione_pizzeeia;

public class cameriere implements Runnable {
	private BufferV2 OrdiniDaFare;
	private BufferV2 OrdiniPronti;
	private BufferV2 OrdiniPerCameriere;
	private BufferV2 OrdineDaConsegnare;
	private int PizzeDaPrendere;
	private int PizzeDaConsegnare;
	
	cameriere(BufferV2 bDaFare,BufferV2 bPronti,BufferV2 bCameriere,BufferV2 bDaConsegnare){
		OrdiniDaFare = bDaFare;
		OrdiniPronti = bPronti;
		OrdiniPerCameriere = bCameriere;
		OrdineDaConsegnare = bDaConsegnare;
	}
	public void run() {
		while(true) {
			//Prendo gli ordini in sala e li metto nella lista degli ordini del pizzaiolo
			PizzeDaPrendere = OrdiniPerCameriere.Pop();
			OrdiniDaFare.Push(PizzeDaPrendere); 
			
			 //Prendo gli ordini pronti in cucina e li metto in quelli consegnabili
			PizzeDaConsegnare = OrdiniPronti.Pop();
			OrdineDaConsegnare.Push(PizzeDaConsegnare);
			
			System.out.println("("+ Thread.currentThread().getName() +") HO CONSEGNATO " + PizzeDaConsegnare + " pizze");
			
			
		}

	}

}
