package TrappingRainWater;

public class Solution {
	public int trap(int[] A) {
		if (A == null)
			return 0;
		if (A.length == 0)
			return 0;
		if (A.length == 1)
			return 0;
		if (A.length == 2)
			return 0;

		int sum = 0;

		int max = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[max])
				max = i;
		}

		// to left
		int maxTL = max;
		while (maxTL != 0) {
			int maxL = maxTL - 1;
			for (int i = maxTL - 1; i > -1; i--) {
				if (A[i] >= A[maxL])
					maxL = i;
			}
			if (A[maxL] == 0)
				break;
			int subsum = 0;
			for (int i = maxL; i < maxTL; i++) {
				subsum += A[i];
			}
			sum = sum + (maxTL - maxL) * A[maxL] - subsum;
			maxTL = maxL;
		}
//		System.out.println(sum);

		// to right
		int maxTR = max;
		while (maxTR != A.length - 1) {
			int maxR = maxTR + 1;
			for (int i = maxTR + 1; i < A.length; i++) {
				if (A[i] >= A[maxR])
					maxR = i;
			}
			if (A[maxR] == 0)
				break;

			int subsum = 0;
			for (int i = maxTR + 1; i <= maxR; i++) {
				subsum += A[i];
			}
			sum = sum + (maxR - maxTR) * A[maxR] - subsum;
			maxTR = maxR;
		}
		return sum;
	}

	public void test() {
		int[] A = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int sum = this.trap(A);
		System.out.println(sum);
	}
}
