package deaplearning.thread.sumtask;

import java.util.concurrent.Callable;

public class SumTask implements Callable<Long>{

	private Long start;
	
	private Long end;
	
	public SumTask(Long start, Long end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public Long call() throws Exception {
		Long sum = 0L;
		int count = 0;
		System.out
		.println(Thread.currentThread().getName() + "计算的起始值为：" + start+","+end);
		for (long i = start; i <= end; i++) {
			sum = sum + i;
			count++;
		}
		System.out
				.println(Thread.currentThread().getName() + "计算的个数为：" + (end-start));
		return sum;
	}

}
