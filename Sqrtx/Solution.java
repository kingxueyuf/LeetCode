package Sqrtx;

public class Solution {
	public int sqrt(int x) {

		long start = 0;
		long end = x;

		long last = 0;
		long middle = 0;

		while (start <= end) {
			// System.out.println(start + " " + end);
			middle = (start + end) / 2;
			long mul = middle * middle;
			if (mul > x) {
				end = middle - 1;
			} else if (mul < x) {
				start = middle + 1;
				last = middle;
			} else if (mul == x) {
				return (int) middle;
			}
		}
		return (int) last;
	}

	public void test() {
		int res = sqrt(17);
		System.out.println(res);
	}

}
