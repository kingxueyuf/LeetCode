package SearchInsertPosition;

public class Solution {
	public int searchInsert(int[] A, int target) {

		if (A == null)
			return 0;
		if (A.length == 0)
			return 0;
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

		if (find != -1) {
			return find;
		} else {
			return end + 1;
		}
	}

	public void test() {
		int[] A = { 1, 3, 5, 6 };
		int target = 0;
		// 5,2,7,0
		int a = searchInsert(A, target);
		System.out.println(a);
	}
}
