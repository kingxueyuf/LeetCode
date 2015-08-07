package MaximumGap;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
	public int maximumGap(int[] nums) {
		if (nums.length < 2)
			return 0;
		if (nums.length == 2) {
			return Math.abs(nums[1] - nums[0]);
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
			if (nums[i] < min) {
				min = nums[i];
			}
			set.add(nums[i]);
		}
		int bucketSize = (max - min) / set.size() - 1;
		int bucketNum = (max - min) / bucketSize;
		int[] minInBucket = new int[bucketNum];
		int[] maxInBucket = new int[bucketNum];
		init(minInBucket, Integer.MAX_VALUE);
		init(maxInBucket, Integer.MIN_VALUE);
		for (int i = 0; i < nums.length; i++) {
			int bucketIndex = (nums[i] - min) / bucketSize;
			if (bucketIndex == bucketNum) {
				bucketIndex--;
			}
			if (nums[i] < minInBucket[bucketIndex]) {
				minInBucket[bucketIndex] = nums[i];
			}
			if (nums[i] > maxInBucket[bucketIndex]) {
				maxInBucket[bucketIndex] = nums[i];
			}
		}
		int maxGap = 0;
		int last = Integer.MIN_VALUE;
		for (int i = 0; i < bucketNum; i++) {
			if (minInBucket[i] == Integer.MAX_VALUE) {
				continue;
			} else {
				if (last == Integer.MIN_VALUE) {
					last = maxInBucket[i];
					continue;
				}
				if (minInBucket[i] - last > maxGap) {
					maxGap = minInBucket[i] - last;
				}
				last = maxInBucket[i];
			}
		}
		return maxGap;

	}

	private void init(int[] arr, int value) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			arr[i] = value;
		}
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		int[] arr = { 111, 3, 94, 23, 57 };
		System.out.println(s.maximumGap(arr));
	}
}
