package LongestValidParentheses;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

	public int longestValidParentheses(String s) {
		if (s == null)
			return 0;
		if (s.length() == 0)
			return 0;
		if (s.length() == 1)
			return 0;

		char[] arr = s.toCharArray();
		ArrayList<String> arrRes = new ArrayList<String>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				arrRes.add("L");
			} else {
				boolean find = false;
				for (int j = arrRes.size() - 1; j > -1; j--) {
					if (arrRes.get(j).equals("L")) {
						arrRes.set(j, "Y");
						find = true;
						break;
					}
				}
				if (!find)
					arrRes.add("N");
			}
		}

		int max = 0;
		int currentLength = 0;
		for (int i = 0; i < arrRes.size(); i++) {
			if (arrRes.get(i).equals("Y")) {
				currentLength++;
				if (currentLength > max)
					max = currentLength;
			} else if (arrRes.get(i).equals("N") || arrRes.get(i).equals("L"))
				currentLength = 0;
		}
		return max * 2;
	}

	public void test() {
		int num = longestValidParentheses(")()())()()(");
		System.out.println(num);
	}
}
