package LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	char[] arr;
	Map<Character, Character[]> map;

	public List<String> letterCombinations(String digits) {

		if (digits == null)
			return list;
		if (digits.length() == 0) {
			list.add("");
			return list;
		}
		arr = digits.toCharArray();
		map = new HashMap<Character, Character[]>();
		map.put('2', new Character[] { 'a', 'b', 'c' });
		map.put('3', new Character[] { 'd', 'e', 'f' });
		map.put('4', new Character[] { 'g', 'h', 'i' });
		map.put('5', new Character[] { 'j', 'k', 'l' });
		map.put('6', new Character[] { 'm', 'n', 'o' });
		map.put('7', new Character[] { 'p', 'q', 'r', 's' });
		map.put('8', new Character[] { 't', 'u', 'v' });
		map.put('9', new Character[] { 'w', 'x', 'y', 'z' });
		dfs(0);
		return list;
	}

	StringBuilder sb = new StringBuilder();
	List<String> list = new ArrayList<String>();

	public void dfs(int index) {
		if (index == arr.length) {
			// System.out.println(sb.toString());
			list.add(sb.toString());
			return;
		}
		for (int i = 0; i < map.get(arr[index]).length; i++) {
			char a = map.get(arr[index])[i];
			sb.append(a);
			dfs(index + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static void main(String args[]) {
		new Solution().letterCombinations("2");
	}
}