package SubstringwithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	public List<Integer> findSubstring(String S, String[] L) {
		char[] arr = S.toCharArray();
		List<Integer> resList = new ArrayList<Integer>();
		boolean[] isUse = new boolean[L.length];
		int findNum = 0;
		int sIndex = -1;
		int nextStart = 0;
		int findStart = -1;
		for (int i = 0; i < arr.length; i++) {
			boolean find = false;
			for (int j = 0; j < L.length; j++) {
				if (!isUse[j]) {
					if (arr.length - i < L[0].length())
						return resList;
					if (wordEqual(arr, i, L[j])) {
						if (sIndex == -1)
							sIndex = i;
						find = true;
						isUse[j] = true;
						break;
					}
				}
			}
			if (find) {
				// System.out.println("find");
				findNum++;
				if (findNum == 1)
					findStart = i;
				if (L.length >= 2 && findNum == 2)
					nextStart = i;
				if (findNum == L.length) {
					cleanArray(isUse);
					// find all
					resList.add(sIndex);
					sIndex = -1;
					findNum = 0;
					if (L.length >= 2)
						i = nextStart - 1;
					else
						i = i + L[0].length() - 1;
				} else {
					i = i + L[0].length() - 1;
				}
				// System.out.println(i);
			} else {
				if (findStart != -1)
					i = findStart;
				findNum = 0;
				sIndex = -1;
				cleanArray(isUse);
				findStart = -1;
			}
		}
		return resList;
	}

	private boolean wordEqual(char[] arr, int i, String string) {
		// System.out.println(i);
		for (int a = 0; a < string.length(); a++) {
			// System.out.println(i + a);
			if (arr[i + a] != string.charAt(a))
				return false;
		}
		return true;
	}

	private void cleanArray(boolean[] isUse) {
		for (int i = 0; i < isUse.length; i++) {
			isUse[i] = false;
		}
	}

	public static void main(String args[]) {
		Solution2 s2 = new Solution2();
		String s = "abababab";
		String[] l = { "a", "b", "a" };
		List<Integer> list = s2.findSubstring(s, l);
		for (Integer i : list) {
			System.out.print(i);
		}
	}
}
