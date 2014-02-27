package ValidParentheses;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
	public boolean isValid(String s) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		char[] charArr = s.toCharArray();
		char[] rightSet = { ')', '}', ']' };
		char[] leftSet = { '(', '{', '[' };
		HashMap map = new HashMap();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');

		Stack ls = new Stack();
		Stack rs = new Stack();
		for (int i = 0; i < charArr.length; i++) {
			if (inSet(leftSet, charArr[i])) {
				ls.add(charArr[i]);
				rs.add(map.get(charArr[i]));
			} else if (inSet(rightSet, charArr[i])) {
				if (rs.size() == 0)
					return false;
				if (rs.peek().equals(charArr[i])) {
					rs.pop();
					ls.pop();
				} else {
					return false;
				}
			}
		}
		return true;
	}

	private boolean inSet(char[] array, char a) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == a)
				return true;
		}
		return false;
	}
	

}
