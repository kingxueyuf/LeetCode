package DistinctSubsequences;

public class Solution {
	public int numDistinct(String S, String T) {
		char[] s = S.toCharArray();
		char[] t = T.toCharArray();
		int sLength = S.length(); // j
		int tLength = T.length(); // i
		int[][] arr = new int[tLength + 1][sLength + 1];
		arr[0][0] = 1;
		for (int i = 1; i <= sLength; i++) {
			arr[0][i] = 1;
		}
		for (int i = 1; i <= tLength; i++) {
			arr[i][0] = 0;
		}
		for (int i = 1; i <= tLength; i++) {
			for (int j = 0; j <= sLength; j++) {
				if (i > j) {
					arr[i][j] = 0;
				} else {
					arr[i][j] = arr[i][j - 1]
							+ (t[i - 1] == s[j - 1] ? arr[i - 1][j - 1] : 0);
				}
			}
		}
		return arr[tLength][sLength];
	}

	public void test() {
		String s = "rabbbit";
		String t = "rabbit";
		int length = this.numDistinct(s, t);
		System.out.println(length);
	}
}
