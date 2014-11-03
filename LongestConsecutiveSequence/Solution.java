package LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
	public int longestConsecutive(int[] num) {
		int max = Integer.MIN_VALUE;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < num.length; i++) {
			set.add(num[i]);
		}
		HashSet<Integer> use = new HashSet<Integer>();
		for (Integer i : set) {
			if (use.contains(i))
				continue;
			// to left;
			use.add(i);
			int left = 0;
			int tmp = i - 1;
			while (set.contains(tmp)) {
				use.add(tmp);
				left++;
				tmp--;
			}
			// to right
			int right = 0;
			tmp = i + 1;
			while (set.contains(tmp)) {
				use.add(tmp);
				right++;
				tmp++;
			}
			if (left + right + 1 > max)
				max = left + right + 1;
		}
		return max;
	}

}
