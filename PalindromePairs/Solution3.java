package PalindromePairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution3 {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		List<Integer> palindromeList = new ArrayList<Integer>();
		int emptyIntIndex = -1;
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (isPalindrome(0, word.length()-1, word.toCharArray())) {
				palindromeList.add(i);
			}
			// 0) If it is ''
			if (word.equals("")) {
				emptyIntIndex = i;
				continue;
			}
			// 1) Find exact reverse
			int index = getReverseIndex(word, map);
			if (index != -1 && index != i) {
				ArrayList<Integer> oneRes = new ArrayList<Integer>();
				oneRes.add(i);
				oneRes.add(index);
				res.add(oneRes);
			}
			/*
			 * 2) Scan from left to right, if there's a palindrome part, find
			 * the reverse of remaining ex. for 'lls', 'll' is palindrome
			 */
			char[] arr = word.toCharArray();
			for (int j = 0; j < arr.length - 1; j++) {
				if (isPalindrome(0, j, arr)) {
					index = getReverseIndex(word.substring(j + 1, arr.length), map);
					if (index != -1 && index != i) {
						ArrayList<Integer> oneRes = new ArrayList<Integer>();
						oneRes.add(index);
						oneRes.add(i);
						res.add(oneRes);
					}
				}
			}
			/*
			 * 3) Scan from right to left, if there's a palindrome part, find
			 * the reverse of the remaining ex. for 'sssll', 'sss' is palindrome
			 */
			for (int j = arr.length - 1; j > 0; j--) {
				if (isPalindrome(j, arr.length - 1, arr)) {
					index = getReverseIndex(word.substring(0, j), map);
					if (index != -1 && index != i) {
						ArrayList<Integer> oneRes = new ArrayList<Integer>();
						oneRes.add(i);
						oneRes.add(index);
						res.add(oneRes);
					}
				}
			}
		}
		if (emptyIntIndex != -1) {
			for (Integer in : palindromeList) {
				if (in != emptyIntIndex) {
					ArrayList<Integer> oneRes = new ArrayList<Integer>();
					oneRes.add(in);
					oneRes.add(emptyIntIndex);
					res.add(oneRes);
					oneRes = new ArrayList<Integer>();
					oneRes.add(emptyIntIndex);
					oneRes.add(in);
					res.add(oneRes);
				}
			}
		}
		return res;
	}

	private boolean isPalindrome(int i, int j, char[] arr) {
		// TODO Auto-generated method stub
		while (i <= j) {
			if (arr[i] != arr[j])
				return false;
			i++;
			j--;
		}
		return true;
	}

	private int getReverseIndex(String word, HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		char[] arr = word.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; i--) {
			sb.append(arr[i]);
		}
		if (map.get(sb.toString()) != null)
			return map.get(sb.toString());
		return -1;
	}

	public static void main(String args[]) {
		Solution3 s3 = new Solution3();
		String[] arr = { "abcd", "dcba", "lls", "s", "sssll", "" };
		List<List<Integer>> arr1 = s3.palindromePairs(arr);
		for (int i = 0; i < arr1.size(); i++) {
			for (int j = 0; j < arr1.get(i).size(); j++) {
				System.out.print(arr1.get(i).get(j));
			}
			System.out.println();
		}
	}
}
