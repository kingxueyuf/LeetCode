package SearchforaRange;

public class Solution {
	public int[] searchRange(int[] A, int target) {

		if (A == null)
			return null;
		if (A.length == 0)
			return null;

		int start = 0;
		int end = A.length - 1;

		int find = -1;

		do {
			int mid = (start + end) / 2;
			if (target > A[mid]) {
				start = mid + 1;
			} else if (target < A[mid]) {
				end = mid - 1;
			} else if (target == A[mid]) {
				find = mid;
				break;
			}
		} while (start <= end);


		if (find == -1) {
			int[] a = { -1, -1 };
			return a;
		}

		boolean findS = false;
		int s = 0;
		int e = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == A[find]) {
				e = i;
				if (!findS) {
					s = i;
					findS = true;
				}
			}
		}

		int[] a = { s, e };
		return a;
	}

	public void test() {
		// { 5, 7, 7, 8, 8, 10 }
		// {1}
		int[] A = { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		int[] res = searchRange(A, target);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
}
