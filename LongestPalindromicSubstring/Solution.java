package LongestPalindromicSubstring;

public class Solution {
	public String longestPalindrome(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];
		char[] arr = s.toCharArray();
		String longestString = "";
		int maxLength = 0;
		for (int a = 0; a < s.length(); a++) {
			for (int i = 0; i < s.length(); i++) {
				if (a + i >= s.length())
					break;
				if (a == 0)
					dp[i][i + a] = true;
				if (a == 1)
					dp[i][i + a] = (arr[i] == arr[i + a]);
				if (a > 1)
					dp[i][i + a] = (arr[i] == arr[i + 1])
							&& dp[i + 1][i + a - 1];
				if (dp[i][i + a])
					if (a + 1 > maxLength) {
						maxLength = a;
						longestString = s.substring(i, i + a + 1);
					}
			}
		}
		return longestString;
	}
}
