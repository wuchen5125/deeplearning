package deaplearning.thread;

import java.util.concurrent.Callable;

public class SumTask implements Callable<Integer> {

	private int start;

	private int end;

	public SumTask(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum = sum + i;
		}
		System.out.printf("%s:%d\n", Thread.currentThread().getName(), sum);
		return sum;
	}

}
