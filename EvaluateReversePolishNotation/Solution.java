package EvaluateReversePolishNotation;

import java.util.Stack;

public class Solution {
	public int evalRPN(String[] tokens) {
		if (tokens == null)
			return 0;
		if (tokens.length == 0)
			return 0;
		if (tokens.length == 1)
			return Integer.parseInt(tokens[0]);
		Stack<String> stack = new Stack<String>();
		int res = 0;
		for (String s : tokens) {
			if (isOperator(s)) {
				String right = stack.pop();
				String left = stack.pop();
				res = cal(left, right, s);
				stack.push(res + "");
			} else
				stack.push(s);
		}
		return res;
	}

	private int cal(String pop, String pop2, String s) {
		// TODO Auto-generated method stub
		if (s.equals("+"))
			return Integer.parseInt(pop) + Integer.parseInt(pop2);
		if (s.equals("-"))
			return Integer.parseInt(pop) - Integer.parseInt(pop2);
		if (s.equals("*"))
			return Integer.parseInt(pop) * Integer.parseInt(pop2);
		if (s.equals("/"))
			return Integer.parseInt(pop) / Integer.parseInt(pop2);
		return 0;
	}

	private boolean isOperator(String s) {
		// TODO Auto-generated method stub
		return (s.equals("+") || s.equals("-") || s.equals("*") || s
				.equals("/"));
	}
}