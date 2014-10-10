package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

public class Solution2 {
	public int lengthOfLongestSubstring(String s) {
		if (s == null)
			return 0;
		if (s.length() == 0)
			return 0;
		HashMap<String, Integer> visit = new HashMap<String, Integer>();

		char[] arr = s.toCharArray();
		int tmpLength = 0;
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!visit.containsKey(arr[i] + "")) {
				visit.put(arr[i] + "", i);
				tmpLength++;
			} else {
				// visited
				if (tmpLength > max)
					max = tmpLength;
				tmpLength = 0;
				i = visit.get(arr[i] + "");
				visit.clear();
			}
		}
		return max;
	}

	public static void main(String args[]) {
		Solution2 s = new Solution2();
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
