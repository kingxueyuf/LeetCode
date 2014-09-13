package Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution2 {
	public List<String> anagrams(String[] strs) {
		HashMap<String, ArrayList<String>> map1 = new HashMap<String, ArrayList<String>>();
		HashMap<String, Integer> map2 = new HashMap<String, Integer>();
		for (String a : strs) {
			String one = sort(a);
			if (map2.get(one) == null) {
				map2.put(one, 1);
				map1.put(one, new ArrayList<String>());
				map1.get(one).add(a);
			} else {
				map2.put(one, map2.get(one) + 1);
				map1.get(one).add(a);
			}
		}
		ArrayList<String> res = new ArrayList<String>();
		for (String key : map2.keySet()) {
			if (map2.get(key) > 1)
				res.addAll(map1.get(key));
		}
		return res;
	}

	public String sort(String s) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
}
