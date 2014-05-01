package Permutations;

import java.util.ArrayList;

public class Solution {

	boolean[] used;
	int[] num;
	ArrayList<Integer> tmp = new ArrayList<Integer>();
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

	public ArrayList<ArrayList<Integer>> permute(int[] num) {

		this.num = num;
		used = new boolean[num.length];
		recursion(0);
		return res;
	}

	public void recursion(int a) {
		if (a == num.length) {
			duplicateList();
		}
		for (int i = 0; i < num.length; i++) {
			if (!used[i]) {
				tmp.add(num[i]);
				used[i] = true;
				recursion(a + 1);
				tmp.remove(tmp.size() - 1);
				used[i] = false;
			}
		}
	}

	public void duplicateList() {
		ArrayList<Integer> one = new ArrayList<Integer>();
		for (int i = 0; i < tmp.size(); i++) {
			one.add(tmp.get(i));
		}
		res.add(one);
	}

	public void test() {
		int[] a = {1,2,3};
		permute(a);
		for (int i = 0; i < res.size(); i++) {
			for (int j = 0; j < res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j));
			}
			System.out.println();
		}
	}
}