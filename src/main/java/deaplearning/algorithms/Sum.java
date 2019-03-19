package deaplearning.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 	你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * @author WU-CHEN
 *
 */
public class Sum {

	public static void main(String[] args) {
		int a[] = {2,3,4,5,6};
		int b[] = sum(a, 5);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}
	
	public static int[] sum(int[] nums,int target){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++){
			int com = target-nums[i];
			if(map.containsKey(com)){
				return new int[]{map.get(com),i};
			}
			map.put(nums[i], i);
		}
		return null;
	}
}
