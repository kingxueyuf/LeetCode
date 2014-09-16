package ScrambleString;

import java.util.Arrays;

public class Solution {
	public boolean isScramble(String s1, String s2) {
		char[] s1arr = s1.toCharArray();
		char[] s2arr = s2.toCharArray();
		Arrays.sort(s1arr);
		Arrays.sort(s2arr);
		for (int i = 0; i < s1arr.length; i++) {
			if (s1arr[i] != s2arr[i])
				return false;
		}
		return true;
	}
}