package FindtheDifference;

public class Solution {
	public char findTheDifference(String s, String t) {
		char[] arr = new char[26];
		char[] sArr = s.toCharArray();
		for (char ch : sArr) {
			arr[ch - 'a']++;
		}
		char[] tArr = t.toCharArray();
		for (char ch : tArr) {
			if (arr[ch - 'a'] == 0)
				return ch;
			else {
				arr[ch - 'a']--;
			}
		}
		char res = 0;
		return res;
	}
}
