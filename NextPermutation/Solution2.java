package NextPermutation;

import java.util.Arrays;

public class Solution2 {

	public void nextPermutation(int[] num) {
		if (num == null)
			return;
		boolean find = false;
		for (int i = num.length - 1; i > 0; i--) {
			if (num[i - 1] < num[i]) {
				find = true;
				// find num[i -1]
				int tmp = i;
				for (int j = i; j < num.length; j++) {
					if (num[j] > num[i - 1]) {
						if (num[j] - num[i - 1] < num[tmp])
							tmp = j;
					}
				}
				/*
				 * swap num[i-1] num[tmp]
				 */
				int ts = num[i - 1];
				num[i - 1] = num[tmp];
				num[tmp] = ts;
				Arrays.sort(num, i, num.length);
				break;
			}
		}
		if (!find)
			Arrays.sort(num);
	}

	public static void main(String args[]) {
		Solution2 s2 = new Solution2();
		int[] arr = { 1, 3, 2 };
		s2.nextPermutation(arr);
	}
}
