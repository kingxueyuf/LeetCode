package NextPermutation;

import java.util.Arrays;

public class Solution {
	public void nextPermutation(int[] num) {

		if (num == null)
			return;
		if (num.length == 1)
			return;

		int min = 0;
		int i = num.length - 1;
		for (; i > 0; i--) {
			if (num[i - 1] < num[i]) {
				min = i;
				for (int j = i; j < num.length; j++) {
					if (num[j] > num[i - 1] && num[min] > num[j]) {
						min = j;
					}
				}
				int temp = num[i - 1];
				num[i - 1] = num[min];
				num[min] = temp;
				// for i to um.length-1 sort asscending
				sort(i, num);
				return;
			}
		}
		Arrays.sort(num);
	}

	public void sort(int i, int[] num) {

		int start = i;
		for (; i < num.length - 1; i++)
			if (num[i] > num[i + 1]) {
				swap(i, i + 1, num);
				for (int j = i; j > start; j--) {
					if (num[j] < num[j - 1]) {
						swap(j, j - 1, num);
					} else {
						break;
					}
				}
			}
	}

	public void swap(int i, int j, int[] num) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public void test() {
		int[] a = { 3, 2, 1 };

		//
		// a = { 1, 2, 3 };
		nextPermutation(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}
}
