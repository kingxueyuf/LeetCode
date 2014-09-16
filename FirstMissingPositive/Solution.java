package FirstMissingPositive;

public class Solution {
	public int firstMissingPositive(int[] A) {

		int i = 0;
		while (i < A.length) {
			if (A[i] != (i + 1) && A[i] >= 1 && A[i] <= A.length
					&& A[A[i] - 1] != A[i]) {
				// swap(A[i], A[A[i] - 1]);
				int temp = A[i];
				int pointer = A[i] - 1;
				A[i] = A[pointer];
				A[pointer] = temp;
			} else {
				i++;
			}
		}
		for (i = 0; i < A.length; ++i) {
			if (A[i] != (i + 1)) {
				return i + 1;
			}
		}
		return A.length + 1;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		int[] arr = { 2, 1 };
		s.firstMissingPositive(arr);
	}
};