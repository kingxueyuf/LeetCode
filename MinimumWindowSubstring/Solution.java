package MinimumWindowSubstring;

import java.util.HashSet;

public class Solution {
	public String minWindow(String S, String T) {
		char[] sArr = S.toCharArray();
		char[] tArr = T.toCharArray();
		int minLength = Integer.MAX_VALUE;
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < tArr.length; i++) {
			set.add(tArr[i] + "");
		}
		return null;
		
	}
}