package FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
		List<List<Integer>> res4 = new ArrayList<List<Integer>>();
		for (int i = 0; i <= num.length - 4; i++) {
			int one = num[i];
			List<List<Integer>> threeSumRes = threeSum(i + 1, num, target - one);
			if (threeSumRes != null) {
				for (List<Integer> item : threeSumRes) {
					item.add(0, one);
				}
				res4.addAll(threeSumRes);
			}
			while (i <= num.length - 4 && num[i] == num[i + 1]) {
				i++;
			}
		}
		return res4;
	}

	public List<List<Integer>> threeSum(int start, int[] num, int target) {
		List<List<Integer>> res3 = new ArrayList<List<Integer>>();
		for (int i = start; i <= num.length - 3; i++) {
			int two = num[i];
			List<List<Integer>> twoSumRes = twoSum(i + 1, num, target - two);
			if (twoSumRes != null) {
				for (List<Integer> item : twoSumRes) {
					item.add(0, two);
				}
				res3.addAll(twoSumRes);
			}
			while (i <= num.length - 3 && num[i] == num[i + 1]) {
				i++;
			}
		}
		return res3;
	}

	public List<List<Integer>> twoSum(int start, int[] num, int target) {
		List<List<Integer>> res2 = new ArrayList<List<Integer>>();
		int end = num.length - 1;
		while (start < end) {
			if (num[start] + num[end] == target) {
				List<Integer> twoSumRes = new ArrayList<Integer>();
				twoSumRes.add(num[start]);
				twoSumRes.add(num[end]);
				res2.add(twoSumRes);
				while (start < num.length - 1 && num[start] == num[start + 1]) {
					start++;
				}
				end--;
			}
			if (num[start] + num[end] > target) {
				end--;
			} else {
				start++;
			}
		}
		return res2;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		int[] arr = { 0, 0, 0, 0 };
		List<List<Integer>> res2 = s.fourSum(arr, 0);
		for (List<Integer> item : res2) {
			for (Integer a : item) {
				System.out.print(a.intValue() + "");
			}
			System.out.println();
		}
	}
}
