package deaplearning.algorithms;

/**
 * 打印1到N
 * @author WU-CHEN
 *
 */
public class PrintN {

	public static void main(String[] args) {
		int N =3;
		printN2(N);
	}
	
	public static void printN1(int N){
		for(int i=0;i<=N;i++){
			System.out.println(i);
		}
	}
	
	public static void printN2(int N){
			printN2(N-1);
			System.out.println(N);
	}
}
