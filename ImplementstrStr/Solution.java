package ImplementstrStr;

public class Solution {
	public String strStr(String haystack, String needle) {

		if (haystack == null)
			return null;

		if (needle == null)
			return null;

		if (haystack.length() == 0 && needle.length() == 0)
			return "";

		if (haystack.length() == 0)
			return null;

		if (needle.length() == 0) {
			System.out.println("here");
			return haystack;
		}
		int index = haystack.indexOf(needle);
		if (index == -1)
			return null;
		else {
			return haystack.substring(index);
		}
	}

	public void test() {
		if (strStr("a", "") == null) {
			System.out.println("null");
		} else
			System.out.println(strStr("a", ""));

	}
}
