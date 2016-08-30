package PalindromePairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

	public List<List<Integer>> palindromePairs(String[] words) {
		if (words == null)
			return null;
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (words.length == 0)
			return list;
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if (isPalindrome(words[i], words[j])) {
					List<Integer> tmp = new ArrayList<Integer>();
					tmp.add(i);
					tmp.add(j);
					list.add(tmp);
				}
				if (isPalindrome(words[j], words[i])) {
					List<Integer> tmp = new ArrayList<Integer>();
					tmp.add(j);
					tmp.add(i);
					list.add(tmp);
				}
			}
		}
		return list;
	}

	private boolean isPalindrome(String word1, String word2) {
		String ab = word1 + word2;
		char[] arr = ab.toCharArray();
		int i = 0;
		int j = arr.length - 1;
		while (i <= j) {
			if (arr[i] != arr[j])
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
	}
}
