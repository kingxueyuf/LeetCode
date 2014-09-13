package Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
	public List<String> anagrams(String[] strs) {
		ArrayList<String> tmp = new ArrayList<String>(Arrays.asList(strs));
		Collections.sort(tmp, new MyComparator());
		List<String> result = new ArrayList<String>();
		strs = tmp.toArray(new String[0]);
		boolean[] isAnagrams = new boolean[strs.length];
		for (int i = 0; i < strs.length - 1; i++) {
			if (isAnagrams[i])
				continue;
			boolean first = true;
			for (int j = i + 1; j < strs.length; j++) {
				if (isAnagrams[j])
					continue;
				else if (strs[i].length() != strs[j].length())
					break;
				else if (isAnagrams(strs[i], strs[j])) {
					if (first) {
						result.add(strs[i]);
					}
					result.add(strs[j]);
					isAnagrams[i] = true;
					isAnagrams[j] = true;
					first = false;
				}
			}
		}
		return result;
	}

	private boolean isAnagrams(String string, String string2) {
		char[] one = string.toCharArray();
		char[] two = string2.toCharArray();
		Arrays.sort(one);
		Arrays.sort(two);
		for (int i = 0; i < one.length; i++) {
			if (one[i] != two[i])
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		String[] arr = { "ranted", "ardent" };
		List<String> res = s.anagrams(arr);
		for (String a : res) {
			System.out.println(a);
		}
	}

	class MyComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			if (o1.length() > o2.length()) {
				return 1;
			} else if (o1.length() < o2.length()) {
				return -1;
			}
			return o1.compareTo(o2);
		}
	}
}