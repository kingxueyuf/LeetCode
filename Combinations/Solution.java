package Combinations;

import java.util.ArrayList;

public class Solution {
	int n;
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	int k;
	ArrayList<Integer> tmp = new ArrayList<Integer>();

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {

		this.k = k;
		this.n = n;
		recursion(0, 0);

		return null;
	}

	private void recursion(int start, int a) {
		for (int i = start; i < n; i++) {
			tmp.add(i);
			recursion(start + 1, a + 1);
		}
	}
}
