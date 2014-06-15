package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

public class Solution {
	public int lengthOfLongestSubstring(String s) {

		char[] arr = s.toCharArray();
		int longestLength = 0;
		HashMap<String, Integer> dic = new HashMap<String, Integer>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		int tmpLength = 0;
		String tmp = "";
		boolean useLastChar = false;
		for (int i = 0; i < arr.length; i++) {
			// contain current char
			if (dic.get(arr[i] + "") == null) {
				dic.put(arr[i] + "", i);
				if (useLastChar) {
					longestLength++;
					continue;
				}
			}
			for (int j = i; j >= 0; j--) {
				if (map.get(arr[j] + "") != null) {
					break;
				} else {
					map.put(arr[j] + "", i);
					tmpLength++;
				}
			}
			// compare
			if (tmpLength > longestLength) {
				longestLength = tmpLength;
				useLastChar = true;
			}else
			{
				useLastChar = false;
			}
			tmpLength = 0;
			tmp = "";
			map.clear();
		}
		return longestLength;
	}

	public void test() {
		Solution s = new Solution();
		String a = "abcabcbb";
		String b = "bbbbb";
		String c = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
	
		int aR = s.lengthOfLongestSubstring(a);
		int bR = s.lengthOfLongestSubstring(b);
		int cR = s.lengthOfLongestSubstring(c);
		
		System.out.println(aR);
		System.out.println(bR);
		System.out.println(cR);
	}
}