package ThreeSumClosest;

import java.util.Arrays;

public class Solution {
	public int threeSumClosest(int[] num, int target) {

		Arrays.sort(num);
		int threeCloset = Integer.MAX_VALUE;
		int threeSum = 0;
		for (int i = 0; i < num.length - 2; i++) {
			int twoSumTarget = target - num[i];
			int l = i + 1;
			int r = num.length - 1;
			int twoCloset = Integer.MAX_VALUE;
			int twoSum = 0;
			while (l < r) {
				int tmp = Math.abs(twoSumTarget - (num[l] + num[r]));
				if (tmp < twoCloset) {
					twoCloset = tmp;
					twoSum = num[l] + num[r];
				}
				if (num[l] + num[r] > twoSumTarget) {
					r--;
				} else if (num[l] + num[r] < twoSumTarget) {
					l++;
				} else {
					twoCloset = 0;
					break;
				}
			}
			int tmp1 = Math.abs(target - (num[i] + twoSum));
			if (tmp1 < threeCloset) {
				threeCloset = tmp1;
				threeSum = num[i] + twoSum;
			}
		}
		return threeSum;
	}
}
