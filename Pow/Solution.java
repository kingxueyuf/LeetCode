package Pow;

public class Solution {
	public double pow(double x, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		if (n == -1)
			return 1 / x;
		double tmp = pow(x, n / 2);
		return tmp * tmp * pow(x, n % 2);

	}

	public static void main(String args[]) {
		Solution s = new Solution();
		System.out.println(s.pow(0.00001, Integer.MAX_VALUE));
	}
}