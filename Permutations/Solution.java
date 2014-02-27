package Permutations;

import java.util.ArrayList;

public class Solution {
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	int size = 0;

	public ArrayList<ArrayList<Integer>> permute(int[] num) {

		this.size = num.length;
		ArrayList<Integer> range = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) {
			range.add(num[i]);
		}

		permutation(range, 0);
		return res;
	}

	ArrayList<Integer> temp = new ArrayList<Integer>();

	public void permutation(ArrayList<Integer> range, int index) {

		if (index == this.size) {
			addToRes(temp, res);
		}

		for (int i = 0; i < range.size(); i++) {
			int val = range.get(i).intValue();
			temp.add(val);
			range.remove(i);
			permutation(range, index + 1);
			range.add(val);
		}
	}

	public void addToRes(ArrayList<Integer> temp,
			ArrayList<ArrayList<Integer>> res) {
		ArrayList<Integer> temp2 = new ArrayList<Integer>();
		for (int i = 0; i < temp.size(); i++) {
			temp2.add(temp.get(i).intValue());
		}
		res.add(temp2);
	}
}