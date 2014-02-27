package SubstringwithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Solution {
	public ArrayList<Integer> findSubstring(String S, String[] L) {

		HashSet<String> set = generateArrange(L);
		ArrayList<Integer> list = new ArrayList<Integer>();

		Iterator<String> iter = set.iterator();
		String n = "";
		while (iter.hasNext()) {
			n = iter.next();
			 System.out.println(n);
			list.add(S.indexOf(n));
		}
		return list;
	}

	public HashSet generateArrange(String[] L) {

		ArrayList<String> list = new ArrayList<String>();
		String result = "";
		generate(L, list, result);

		return set;
	}

	HashSet set = new HashSet<String>();

	public void generate(String[] L, ArrayList<String> list, String result) {

		if (list.size() == L.length) {
//			System.out.println(result);
			set.add(result);
			return;
		}

		for (int i = 0; i < L.length; i++) {
			if (list.contains(i + ""))
				continue;
			else {
				result += L[i];
				list.add(i + "");
				generate(L, list, result);
				list.remove(i + "");
				result = result.substring(0, result.length() - L[0].length());
			}
		}
	}

}
