package PalindromePairs;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		// build Trie
		TrieNode root = new TrieNode();
		for (int i = 0; i < words.length; i++) {
			char[] arr = words[i].toCharArray();
			TrieNode pointer = root;
			for (int j = arr.length - 1; j >= 0; j--) {
				if ( isPalindrome(0, j, arr))
					pointer.isPalindrome.add(i);
				if (pointer.next[arr[j] - 'a'] == null) {
					TrieNode node = new TrieNode();
					pointer.next[arr[j] - 'a'] = node;
				}
				pointer = pointer.next[arr[j] - 'a'];
				if (j == 0) {
					pointer.index = i;
				}
			}
		}

		// search Trie
		for (int i = 0; i < words.length; i++) {
			char[] arr = words[i].toCharArray();
			TrieNode pointer = root;
			if (words[i].equals("")) {
				for (Integer num : root.isPalindrome) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(i);
					tmp.add(num);
					list.add(tmp);
					tmp = new ArrayList<Integer>();
					tmp.add(num);
					tmp.add(i);
					list.add(tmp);
				}
				break;
			}
			int j;
			for (j = 0; j < arr.length; j++) {
				if (pointer.next[arr[j] - 'a'] != null) {
					pointer = pointer.next[arr[j] - 'a'];
				} else {
					// A.length > B.length (abcd,a)
					if (j == 0)
						break;
					if (isPalindrome(j, arr.length - 1, arr)) {
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(i);
						tmp.add(pointer.index);
						list.add(tmp);
					} else {
						break;
					}
				}
			}
			if (j == arr.length) {
				// A.length == B.length
				if (pointer.index != -1 && i != pointer.index) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(i);
					tmp.add(pointer.index);
					list.add(tmp);
				}
				if (pointer.isPalindrome.size() > 0) {
					// A.length < B.length
					for (Integer num : pointer.isPalindrome) {
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(i);
						tmp.add(num);
						list.add(tmp);
					}
				}
			}
		}
		return list;
	}

	private boolean isPalindrome(int i, int j, char[] arr) {
		while (i <= j) {
			if (arr[i] != arr[j])
				return false;
			i++;
			j--;
		}
		return true;
	}

	class TrieNode {
		TrieNode[] next = new TrieNode[26];
		List<Integer> isPalindrome = new ArrayList<Integer>();
		int index = -1;
	}
}