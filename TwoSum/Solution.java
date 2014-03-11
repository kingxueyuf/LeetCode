package TwoSum;

import java.util.Arrays;

public class Solution {

	public int[] twoSum(int[] numbers, int target) {

		int[] copy = new int[numbers.length];
		arrayCopy(copy, numbers);
		Arrays.sort(copy);
		int[] res = new int[2];
		int start = 0;
		int end = numbers.length - 1;
		int tmp = 0;
		while (start < end) {
			tmp = copy[start] + copy[end];
			if (tmp == target) {
				break;
			} else if (tmp > target) {
				end--;
			} else if (tmp < target) {
				start++;
			}
		}

		if (start < end) {
			boolean equal = false;
			if (copy[start] == copy[end])
				equal = true;
			if (equal) {
				int a = -1;
				int b = -1;
				for (int i = 0; i < numbers.length; i++) {
					if (numbers[i] == copy[start])
						if (a == -1)
							a = i;
						else
							b = i;
				}
				res[0] = a + 1;
				res[1] = b + 1;
			} else {
				int j = 0;
				for (int i = 0; i < numbers.length; i++) {
					if (numbers[i] == copy[start]) {
						res[j] = i + 1;
						j++;
					}
					if (numbers[i] == copy[end]) {
						res[j] = i + 1;
						j++;
					}
				}
			}

		}

		return res;
	}

	public void arrayCopy(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			a[i] = b[i];
		}
	}

	public void test() {
		int[] numbers = { 0, 4, 3, 0 };
		int target = 0;
		int[] res = twoSum(numbers, target);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
