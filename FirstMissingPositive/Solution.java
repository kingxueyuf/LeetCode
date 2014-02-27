package FirstMissingPositive;

import java.util.HashMap;

public class Solution {

	public int firstMissingPositive(int[] A) {

		if (A == null)
			return 1;
		if (A.length == 0)
			return 1;
		if (A.length == 1 && A[0] <= 0)
			return 1;
		if (A.length == 1 && A[0] == 1)
			return A[0] + 1;
		if (A.length == 1 && A[0] > 1)
			return 1;

		HashMap<Integer, String> map = new HashMap<Integer, String>();

		int min = 0;
		int max = 0;
		boolean firstMin = false;
		boolean firstMax = false;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				if (!firstMin) {
					min = i;
					firstMin = true;
				}
				if (!firstMax) {
					max = i;
					firstMax = true;
				}
				if (A[i] >= A[max])
					max = i;
				if (A[i] < A[min])
					min = i;
				map.put(A[i], "1");
			}
		}

		for (int i = A[min]; i <= A[max]; i++) {
			if (map.get(i) == null) {
				return i;
			}
		}

		if (max == min)
			return A[max] + 1;
		if (A[max] == A[min] && (max - min + 1) == A.length)
			return 1;

		if (max - min + 1 < A.length) {
			return A[max] + 1;
		}
		return 1;
	}

	public void test() {
		int[] A = { 2, 2 };
		// 3,4,-1,1
		// 1, 2, 0
		int res = firstMissingPositive(A);
		System.out.println(res);
	}
}
