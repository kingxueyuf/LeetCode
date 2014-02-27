package Generate_Parentheses;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
	ArrayList<String> resultList = new ArrayList<String>();
	int n;

	public ArrayList<String> generateParenthesis(int n) {

		Stack ls = new Stack();
		Stack rs = new Stack();
		String result = "";
		this.n = n;
		iteration(ls, rs, n, n, result);
//		test();
		return  resultList;
	}

	public void test() {
		for (int i = 0; i < resultList.size(); i++) {
			System.out.println(resultList.get(i));
		}
	}

	public void iteration(Stack ls, Stack rs, int left, int right, String result) {
//		System.out.println(result);
		if (left == 0 && right == 0) {
			
//			System.out.println(result.toString());
			resultList.add(new String(result));
			return;
		}

		if (left > 0) {
			Stack copyLs = getCopy(ls);
			Stack copyRs = getCopy(rs);
			result = result + '(';

			copyLs.push('(');
			copyRs.push(')');

			iteration(copyLs, copyRs, left - 1, right, result);
			result = result.substring(0, result.length() - 1);
		} 
		if (right > 0) {
			Stack copyLs = getCopy(ls);
			Stack copyRs = getCopy(rs);

			if (copyRs.size() > 0) {
				result = result + ')';
				copyLs.pop();
				copyRs.pop();
				iteration(copyLs, copyRs, left, right -1, result);
				result = result.substring(0, result.length() - 1);
			} else {
				return;
			}
		}

	}

	public Stack getCopy(Stack s) {
		Stack sN = new Stack();
		for (int i = 0; i < s.size(); i++) {
			sN.add(i, s.get(i));
		}
		return sN;
	}
}