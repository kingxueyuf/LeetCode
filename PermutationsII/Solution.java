package PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> permuteUnique(int[] num) {
		this.numArr = num;
		Arrays.sort(num);
		length = num.length;
		used = new boolean[num.length];
		dfs(0);
		return null;
	}

	int[] numArr;
	int length;
	boolean[] used;
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	List<Integer> tmp = new ArrayList<Integer>();

	public void dfs(int num) {
		if (num == length) {
			addToRes(tmp, res);
		} else {
			for (int i = 0; i < used.length; i++) {
				if (!used[i]) {
					if (i - 1 > -1 && numArr[i - 1] == numArr[i] && used[i - 1]) {

					} else {
						used[i] = true;
						tmp.add(numArr[i]);
						dfs(num + 1);
					}
				}
			}
		}
	}

	private void addToRes(List<Integer> tmp, List<List<Integer>> res) {

	}
}
