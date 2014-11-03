package PalindromePartitioningII;

public class Solution {
	public int minCut(String s) {
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		int[] minCut = new int[s.length()];
		for (int start = s.length() - 1; start >= 0; start--) {
			minCut[start] = s.length() - 1 - start;
			for (int end = start; end < s.length(); end++) {
				if (start == end) {
					isPalindrome[start][end] = true;
				} else if (start == end - 1) {
					isPalindrome[start][end] = s.charAt(start) == s.charAt(end);
				} else {
					isPalindrome[start][end] = (s.charAt(start) == s
							.charAt(end)) ? isPalindrome[start + 1][end - 1]
							: false;
				}
				if (isPalindrome[start][end]) {
					if (end == s.length() - 1)
						minCut[start] = 0;
					else
						minCut[start] = Math.min(minCut[start],
								1 + minCut[end + 1]);
				}
			}
		}
		return minCut[0];
	}
}
