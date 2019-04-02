package deaplearning.thread;

import java.util.concurrent.TimeUnit;

public class Volit implements Runnable{

	private  boolean runing = true;
	
	int i=0;
	
	@Override
	public void run() {
		while (runing) {
			i++;
		}
	}
	
	public static void main(String[] args) {
		try {
			Volit v = new Volit();
			Thread t1 = new Thread(v);
			t1.start();
			t1.sleep(1000L);
			v.runing = false;
			System.out.println(v.i);
		} catch (InterruptedException e) {

		}
	}
}
