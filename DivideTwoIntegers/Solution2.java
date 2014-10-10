package DivideTwoIntegers;

public class Solution2 {

	public int divide(int dividend, int divisor) {
		int res = 0;
		int num = 0;
		int negative = 1;

		int tmpDividend = dividend;
		if (tmpDividend < 0) {
			negative *= -1;
			tmpDividend = -tmpDividend;
		}
		int tmpDivisor = divisor;
		if (tmpDivisor < 0) {
			negative *= -1;
			tmpDivisor = -tmpDivisor;
		}
		if (divisor == Integer.MIN_VALUE) {
			return (dividend == Integer.MIN_VALUE) ? 1 : 0;
		}

		if (dividend == Integer.MIN_VALUE) {
			int newDividend = dividend + Math.abs(divisor);
			int resPart = divide(newDividend, divisor);
			// System.out.println(resPart);
			return (divisor > 0) ? resPart - 1 : resPart + 1;
		}

		while ((tmpDividend >= (tmpDivisor << 1))
				&& (tmpDivisor < tmpDivisor << 1)) {
			num++;
			tmpDivisor = tmpDivisor << 1;

		}
		if (num > 0) {
			tmpDividend = tmpDividend - tmpDivisor;
			res += Math.pow(2, num);
			while (num >= 0) {
				if (tmpDividend >= tmpDivisor) {
					tmpDividend = tmpDividend - tmpDivisor;
					res += Math.pow(2, num);
				} else {
					tmpDivisor = tmpDivisor >> 1;
					num--;
				}
			}
		} else {
			if (tmpDividend >= tmpDivisor)
				res += 1;
			else {
				res += 0;
			}
		}

		return res * negative;
	}

	public static void main(String args[]) {
		System.out.println(new Solution2().divide(5, 2));
	}
}
