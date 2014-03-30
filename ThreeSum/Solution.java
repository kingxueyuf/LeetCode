package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);

		int start;
		int end;
		int twoSum;
		int tmp;
		for (int i = 0; i < num.length - 2; i++) {
			if (i > 0 && num[i] == num[i - 1])
				continue;
			twoSum = 0 - num[i];
			start = i + 1;
			end = num.length - 1;
			while (start < end) {
				tmp = num[start] + num[end];
				if (tmp == twoSum) {
					ArrayList list = new ArrayList<Integer>();
					list.add(num[i]);
					list.add(num[start]);
					list.add(num[end]);
					res.add(list);
					while (start <= num.length - 2
							&& num[start] == num[start + 1])
						start++;
					while (end >= 1 && num[end] == num[end - 1])
						end--;
					start++;
					end--;
				} else if (tmp > twoSum) {
					end--;
				} else if (tmp < twoSum) {
					start++;
				}
			}
		}
		return res;
	}
}