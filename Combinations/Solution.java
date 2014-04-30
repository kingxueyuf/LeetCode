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
		recursion(1, 0);

		return res;
	}

	private void recursion(int start, int a) {
		if (a == k) {
			addToRes();
		}
		for (int i = start; i <= n; i++) {
			tmp.add(i);
			recursion(i + 1, a + 1);
			tmp.remove(tmp.size() - 1);
		}
	}

	private void addToRes() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < tmp.size(); i++) {
			list.add(tmp.get(i));
		}
		res.add(list);
	}

	public void test() {
		ArrayList<ArrayList<Integer>> res = combine(5, 3);
		for (int i = 0; i < res.size(); i++) {
			for (int j = 0; j < res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j));
			}
			System.out.println();
		}
	}
}
