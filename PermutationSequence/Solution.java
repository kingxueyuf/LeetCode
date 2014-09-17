package PermutationSequence;

import java.util.ArrayList;

public class Solution {
	public String getPermutation(int n, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		int quotient; // 商
		int remainder = k; // 余数
		int remain = n;
		String res = "";
		for (int i = 1; i < n; i++) {
			quotient = remainder / factorial(n - i);
			if (remainder == 0) {
				res = res + list.get(list.size()-1);
				list.remove(list.size()-1);
			}
			else if (remainder % factorial(n - i) == 0) {
				res = res + list.get(quotient - 1);
				list.remove(quotient - 1);
			} else {
				res = res + list.get(quotient);
				list.remove(quotient);
			}
			remainder = remainder % factorial(n - i);
		}
		res = res + list.get(0);
		return res;
	}

	public int factorial(int n) {
		int res = 1;
		for (int i = n; i > 0; i--) {
			res = res * i;
		}
		return res;
	}

	public static void main(String args[]) {
		String res = new Solution().getPermutation(3, 2);
		System.out.println(res);
	}
}
