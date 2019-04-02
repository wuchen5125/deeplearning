package deaplearning.thread.sumtask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class HomeWorkSum {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		long a = sum(10L, 7909L);
		System.out.println(a);
	}

	private static long sum(long start, long end) throws InterruptedException,
			ExecutionException {
		int threadCount = 6;
		long sum = 0;
		long x = (end - start + 1) / threadCount;// 取除数
		ThreadPoolExecutor ex = (ThreadPoolExecutor) Executors
				.newFixedThreadPool(threadCount);
		List<Future<Long>> fList = new ArrayList<Future<Long>>();
		for (int i = 0; i < threadCount; i++) {
			long s = (i * (x + 1) + start);
			long e = ((i + 1) * x + start + i);
			if (s >= end || e >= end) {
				SumTask st = new SumTask(s, end);
				Future<Long> f = ex.submit(st);
				fList.add(f);
				break;
			} else {
				SumTask st = new SumTask((i * (x + 1) + start), ((i + 1) * x
						+ start + i));
				Future<Long> f = ex.submit(st);
				fList.add(f);
			}
		}

		do {
			System.out.println("线程执行完毕的个数：" + ex.getCompletedTaskCount());
		} while (ex.getCompletedTaskCount() == threadCount);

		for (Future<Long> f : fList) {
			sum = sum + f.get();
		}
		System.out.println("计算的总和为：" + sum);
		return sum;
	}
}
