package WildcardMatching;

public class Solution {
	public boolean isMatch(String s, String p) {

		int pointOne = 0;
		int pointTwo = 0;
		char[] arrS = s.toCharArray();
		char[] arrP = s.toCharArray();

		while (pointOne != s.length()) {
			if (arrP[pointTwo] == '*') {
				while (true) {
					if (pointOne == s.length() - 1)
						break;
					if (arrS[pointOne] == arrS[pointOne + 1]) {
						pointOne++;
					} else {
						break;
					}
				}
			} else if (arrP[pointTwo] == '?') {
				pointOne++;
				pointTwo++;
			} else if (arrS[pointOne] != arrP[pointTwo]) {
				return false;
			} else {
				pointOne++;
				pointTwo++;
			}
		}
		if (pointTwo != p.length())
			return false;
		return true;
	}

	public void test() {
		String a = "aa";
		String p = "*";
		boolean res = isMatch(a, p);
		System.out.println(res);
	}
}
