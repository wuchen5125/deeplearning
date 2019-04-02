package deaplearning.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 求最长子串长度
 * @author WU-CHEN
 *
 */
public class SubStringLength {

	public static void main(String[] args) {
		String s = "au";
		System.out.println(getSubString(s));
	}

	private static int getSubString(String s) {
		List<Integer> sizeLengthList = new ArrayList<Integer>();
		List<String> subStringList = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return 0;
		}
		for (int i = 0; i < s.length(); i++) {
			String subString = String.valueOf(s.charAt(i));
			if (subStringList.contains(String.valueOf(subString))) {
				sizeLengthList.add(subStringList.size());
				subStringList = new ArrayList<String>();
			}
			subStringList.add(String.valueOf(subString));
		}
		Collections.sort(sizeLengthList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2) {
					return -1;
				}
				if (o1 == o2) {
					return 0;
				}
				if (o1 < o2) {
					return 1;
				}
				return 1;
			}
		});

		if (sizeLengthList.size() > 0) {
			return sizeLengthList.get(0);
		}
		return 1;
	}
	
	
	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>(); // current index of
														// character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}
}
