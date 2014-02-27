package DivideTwoIntegers;

public class Solution {
	public int divide(int dividend, int divisor) {

		if (divisor == 0)
			return 0;

		if (dividend == 0)
			return 0;

		if (divisor == 1)
			return Math.abs(dividend);

		if (dividend < divisor)
			return 0;

		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		int reminder = 0;
		int num = 0;

		do {
			dividend = dividend - divisor;
			reminder = dividend;
			num++;
		} while (reminder >= divisor);

		return num;
	}

	public void test() {
		System.out.println(divide(2147483647, 2));

	}
}
