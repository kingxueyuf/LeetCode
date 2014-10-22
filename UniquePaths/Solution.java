package UniquePaths;

import java.math.BigInteger;

public class Solution {
	public int uniquePaths(int m, int n) {
		if (m == 1 || n == 1)
			return 1;
		if (m <= 0 || n <= 0)
			return 0;

		int mStep = m - 1;
		int nStep = n - 1;
		int sum = mStep + nStep;
		return combination(sum, (int) Math.min(nStep, mStep)).intValue();

	}

	private BigInteger combination(int sum, int n) {
		// TODO Auto-generated method stub
		BigInteger up = new BigInteger(sum + "");
		for (int i = 1; i < n; i++) {
			up = up.multiply(new BigInteger(sum - i + ""));
		}

		BigInteger down = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			down = down.multiply(new BigInteger(i + ""));
		}
		return up.divide(down);
	}
}
