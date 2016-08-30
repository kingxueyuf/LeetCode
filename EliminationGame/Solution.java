package EliminationGame;

import java.util.Stack;

public class Solution {
	public int lastRemaining(int n) {
		// log(n) efficiency;
		Stack<Integer> stack = new Stack<Integer>();
		boolean left = true;
		while (n != 1) {
			if (left) {
				n = n / 2;
				stack.push(1); // 1 means index = index / 2
				left = false;
			} else {
				// right
				if (n % 2 == 0) {
					// even
					stack.push(2); // 2 means index= (index+1)/2
				} else {
					// odd
					stack.push(1);
				}
				n = n / 2;
				left = true;
			}
		}
		int res = 1;
		while (!stack.isEmpty()) {
			int i = stack.pop().intValue();
			if (i == 1) {
				res = res * 2;
			} else {
				res = res * 2 - 1;
			}
		}
		return res;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		int n = 9;
		int res = s.lastRemaining(n);
		System.out.println(res);
	}
}
