package DecodeWays;

public class Solution {
	public int numDecodings(String s) {

		if (s.equals("0"))
			return 0;

		char[] arr = s.toCharArray();
		int[] num = new int[arr.length];
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(arr[i] + "");
		}
		int canUse = 0;
		int total = 0;
		int lastDigit = 0;
		// dp start
		for (int i = 0; i < num.length; i++) {
			if (i == 0) {
				if (num[i] == 0) {
					total = 0;
				} else {
					total = 1;
					if (num[i] == 1 || num[i] == 2) {
						canUse = 1;
					}
				}
			} else {
				int tmp = total;
				if (num[i] == 0) {
					total = 0;
				}
				if (lastDigit == 1 || lastDigit == 2) {
					if (lastDigit == 1) {
						total += canUse;
					} else if (lastDigit == 2) {
						if (num[i] == 0 || num[i] == 1 || num[i] == 2
								|| num[i] == 3 || num[i] == 4 || num[i] == 5
								|| num[i] == 6) {
							total += canUse;
						}
					}

				}
				canUse = tmp;
			}
			lastDigit = num[i];
		}
		return total;
	}

	public void test() {
		int res = numDecodings("01");
		System.out.println(res);
	}
}