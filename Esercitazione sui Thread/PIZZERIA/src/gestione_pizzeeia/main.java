package gestione_pizzeeia;

public class main {

	public static void main(String[] args) {
		
		//Inizializzo i buffer che mi servono nel programma
		BufferV2 OrdiniDaFare = new BufferV2(); //Il buffer contiene gli ordini che il pizzaiolo deve fare
		BufferV2 OrdiniPronti = new BufferV2(); //Il buffer contiene gli ordini che il pizzaiolo ha pronti in cucina che attendono che vengano consegnati dal cameriere
		BufferV2 OrdiniPerCameriere = new BufferV2(); //Il buffer contiene gli ordini che i tavoli fanno ai camerieri
		BufferV2 OrdineDaConsegnare = new BufferV2(); //Il buffer contiene gli ordini che il cameriere porta ai tavoli
		
		//Inizializzo i camerieri
		Thread ArrayCamerieri[] = new Thread[3]; 
		for(int i = 0; i < 3; i++) {
			cameriere c = new cameriere(OrdiniDaFare,OrdiniPronti,OrdiniPerCameriere,OrdineDaConsegnare);
			ArrayCamerieri[i] = new Thread(c);
		}

		//Inizializzo i tavoli
		Thread [] ArrayTavoli = new Thread [20];
		tavoli OggettoTavolo = new tavoli (OrdiniPerCameriere,OrdineDaConsegnare);
		for(int i =0;i<20;i++) {
			Thread t = new Thread(OggettoTavolo);
			ArrayTavoli[i] = t;
			ArrayTavoli[i].setName(String.valueOf(i));
		}
		
		//Inizializzo l'oggetto pizzaiolo
		pizzaiolo capo = new pizzaiolo(OrdiniDaFare,OrdiniPronti);
		
		//Avvio i Thread Camerieri
		for(int i = 0; i < 3; i++) {
			ArrayCamerieri[i].start();
		}

		//Avvio i Thread Tavoli
		for(int i =0;i<20;i++) {
			Thread t = new Thread(OggettoTavolo);
			ArrayTavoli[i] = t;
			ArrayTavoli[i].setName(String.valueOf(i));
			ArrayTavoli[i].start();
			
		}
		
		//Avvio il Thread pizzaiolo
		Thread pizzaiolo = new Thread(capo);
		pizzaiolo.start();
		
		

	}

}
 