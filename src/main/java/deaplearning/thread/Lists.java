package deaplearning.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Lists {

	public static void main(String[] args) {
		final List<Integer> unsafeList = new ArrayList<Integer>();
		final List<Integer> salelist =  Collections.synchronizedList(unsafeList);
		Integer n = 10;
		Thread[] tread = new Thread[10];

		for (int i = 0; i < 10; i++) {
			tread[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10; i++) {
						salelist.add(Integer.valueOf((int) Math.random()));
					}
				}
			});
		}
		for (Thread t : tread) {
			t.start();
		}
		System.out.println(salelist);
	}
}
