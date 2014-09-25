package WordBreak;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public boolean wordBreak(String s, Set<String> dict) {

		// Copy set into a new Set
		Set<String> tmpDict = new HashSet<String>(dict);

		boolean[][] dp = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (dict.contains(s.substring(i, i + 1))) {
				dp[i][i] = true;
//				tmpDict.remove(s.substring(i, i + 1));
			} else
				dp[i][i] = false;
		}
		int add = 1;
		while (add < s.length()) {
			for (int i = 0; i < s.length() - 1; i++) {
				if (i + add == s.length())
					break;
				if (tmpDict.contains(s.substring(i, i + add + 1))) {
					dp[i][i + add] = true;
//					tmpDict.remove(s.substring(i, i + add + 1));
				} else if (dpContain(dp, i, i + add)) {
					dp[i][i + add] = true;
				} else
					dp[i][i + add] = false;
			}
			add++;
		}
		return dp[0][s.length() - 1];
	}

	private boolean dpContain(boolean[][] dp, int i, int j) {
		for (int a = i; a < j; a++) {
			if (dp[i][a] && dp[a + 1][j])
				return true;
		}
		return false;
	}
}