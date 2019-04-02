package deaplearning.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SumThread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ThreadPoolExecutor executors = (ThreadPoolExecutor) Executors
				.newFixedThreadPool(4);
		List<Future<Integer>> fList = new ArrayList<Future<Integer>>();
		for (int i = 0; i < 10; i++) {
			SumTask t = new SumTask(i * 100 + 1, (i + 1) * 100);
			Future<Integer> f = executors.submit(t);
			fList.add(f);
		}
		
		do {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("已经完成的任务数："+executors.getCompletedTaskCount());
		} while (executors.getCompletedTaskCount()==4);
		
		Integer sum = 0;
		for(Future<Integer>  f: fList){
			sum = sum + f.get().intValue();
		}
		
		System.out.println(sum);
	}
}
