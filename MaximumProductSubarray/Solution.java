package MaximumProductSubarray;

public class Solution {
	public int maxProduct(int[] A) {
		if (A == null)
			return 0;
		if (A.length == 0)
			return 0;
		if (A.length == 1)
			return A[0];
		int max = A[0];
		int cMin = A[0];
		int cMax = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] == 0) {
				cMin = 0;
				cMax = 0;
			} else {
				int[] arr = max(A[i] * cMin, A[i] * cMax, A[i]);
				cMax = arr[0];
				cMin = arr[1];
				max = (cMax > max) ? cMax : max;
			}
			max = (cMax > max) ? cMax : max;
		}
		return max;
	}

	private int[] max(int i, int j, int k) {
		// TODO Auto-generated method stub
		int[] arr = new int[2];
		arr[0] = Math.max(Math.max(i, j), k);
		arr[1] = Math.min(Math.min(i, j), k);
		return arr;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		int[] arr = { 2, -5, -2, -4, 3 };
		System.out.println(s.maxProduct(arr));
	}
}
