package ZigZagConversion;

public class Solution {
	public String convert(String s, int nRows) {
		if (nRows == 1)
			return s;
		char[] arr = s.toCharArray();
		int p = 0;
		String result = "";
		while (p < arr.length) {
			result += arr[p];
			p += (nRows - 1) * 2;
		}

		for (int i = 1; i < nRows - 1; i++) {
			p = i;
			boolean turn = true;
			while (p < arr.length) {
				result += arr[p];
				p += (turn == true) ? (nRows - (i + 1)) * 2 : ((i + 1) - 1) * 2;
				turn = !turn;
			}
		}

		p = nRows - 1;
		while (p < arr.length) {
			result += arr[p];
			p += (nRows - 1) * 2;
		}
		return result;
	}

	public void test() {
		String s = this.convert("PAYPALISHIRING", 3);
		System.out.println(s);
	}
}