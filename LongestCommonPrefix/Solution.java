package LongestCommonPrefix;

public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if(strs == null)
			return "";
		
		String res = "";
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			String currentChar = null;
			for (String s : strs) {
				if (i >= s.length())
					return res;
				else {
					if (currentChar == null)
						currentChar = s.charAt(i) + "";
					else {
						if (!currentChar.equals(s.charAt(i) + ""))
							return res;
					}
				}
			}
			res += currentChar;
		}
		return res;
	}
}
