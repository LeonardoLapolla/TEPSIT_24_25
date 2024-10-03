package Lapolla_5BI_ATeatro;

public class Spettatore implements Runnable{
	//La classe deve accedere a teatro per poter provare a prenotare
	
	private Teatro teatro;

    public Spettatore(Teatro t) {
        teatro = t;
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
