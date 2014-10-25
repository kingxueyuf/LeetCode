package MinimumWindowSubstring;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
	public String minWindow(String S, String T) {
		char[] sArr = S.toCharArray();
		char[] tArr = T.toCharArray();
		HashMap<String, Integer> scan = new HashMap<String, Integer>();
		HashMap<String, Integer> need = new HashMap<String, Integer>();
		// init need;
		for (int i = 0; i < tArr.length; i++) {
			if (need.get(tArr[i] + "") == null)
				need.put(tArr[i] + "", 1);
			else
				need.put(tArr[i] + "", need.get(tArr[i] + "") + 1);
		}
		int s = 0;
		int e = 0;
		int min = Integer.MAX_VALUE;
		int minS = 0;
		int minE = 0;
		boolean find = false;
		boolean resFind = false;
		while (s < S.length() && e < S.length()) {
			find = false;
			do {
				String tmp = sArr[e] + "";
				if (T.contains(tmp)) {
					if (!scan.containsKey(tmp))
						scan.put(tmp, 1);
					else
						scan.put(tmp, scan.get(tmp) + 1);
				}
				e++;
				if (!notFinish(scan, need)) {
					resFind = true;
					find = true;
					break;
				}
			} while (e < S.length());
			e--;
			while (s < S.length() && canMoveToNext(sArr[s] + "", T, need, scan)) {
				s++;
			}
			if (find && e - s + 1 < min) {
				min = e - s + 1;
				minS = s;
				minE = e;
//				System.out.println("minS=" + minS + " minE=" + minE);
			}
			s++;
			e = s;
			scan.clear();
		}
		if (!resFind)
			return "";
		return S.substring(minS, minE + 1);
	}

	private boolean notFinish(HashMap<String, Integer> scan,
			HashMap<String, Integer> need) {
		// TODO Auto-generated method stub
		for (String key : need.keySet()) {
			if (!scan.containsKey(key)) {
				return true;
			} else if (scan.get(key) < need.get(key))
				return true;
		}
		return false;
	}

	private boolean canMoveToNext(String item, String s2,
			HashMap<String, Integer> need, HashMap<String, Integer> scan) {
		// TODO Auto-generated method stub
		if (!s2.contains(item))
			return true;
		else {
			if (scan.get(item) - 1 >= need.get(item)) {
				scan.put(item, scan.get(item) - 1);
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		String S = "ADOBECODEBANC";
		String T = "ABC";
		S = "a";
		T = "b";
		S = "ebadbaccb";
		T = "abc";
		System.out.println(s.minWindow(S, T));
	}
}