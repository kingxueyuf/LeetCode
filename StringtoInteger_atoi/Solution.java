package StringtoInteger_atoi;

public class Solution {
	public int atoi(String str) {
		char[] arr = str.toCharArray();
		int res = 0;
		boolean start = false;
		int isPositive = 1;
		boolean overflow = false;
		for (int i = 0; i < arr.length; i++) {
			if (start) {
				if (isdigit(arr[i])) {
					// System.out.print(arr[i]);
					int tmp = res * 10;
					if (tmp / 10 != res) {
						overflow = true;
						break;
					}
					tmp += Integer.parseInt(arr[i] + "");
					if (tmp < 0) {
						overflow = true;
						break;
					}
					res = tmp;
				} else
					break;

			} else {
				if (arr[i] == '+') {
					start = true;
				} else if (arr[i] == '-') {
					start = true;
					isPositive = -1;
				} else if (isdigit(arr[i])) {
//					System.out.print(arr[i]);
					start = true;
					res += Integer.parseInt(arr[i] + "");
				} else if (arr[i] == ' ') {

				} else {
					break;
				}
			}
		}
		if (overflow) {
//			System.out.println("here");
			if (isPositive == 1)
				return Integer.MAX_VALUE;
			else
				return Integer.MIN_VALUE;
		}
		return res * isPositive;
	}

	public boolean isdigit(char a) {
		if (a == '1' || a == '2' || a == '3' || a == '4' || a == '5'
				|| a == '6' || a == '7' || a == '8' || a == '9' || a == '0') {
			return true;
		}
		return false;
	}

	public void test() {
		int res = atoi("    10522545459");
		System.out.println(res);
	}
}