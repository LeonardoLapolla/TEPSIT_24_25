package ProduttoreConsumatore;
import java.util.Random;

public class Produttore implements Runnable{
	private Buffer buffer;
	private Random r = new Random();
	
	public Produttore(Buffer B) {
		buffer = B;
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			int n = r.nextInt(1023);
			int attesa = r.nextInt(1000) + 100;
			buffer.Push(n);
			try {
				Thread.sleep(attesa);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
