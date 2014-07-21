package PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> permuteUnique(int[] num) {
		Arrays.sort(num);
		length = num.length;
		used = new boolean[num.length];
		dfs(0);
		return null;
	}

	int length;
	boolean[] used;
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	List<Integer> tmp = new ArrayList<Integer>();

	public void dfs(int num) {
		if (num == length) {
			addToRes(tmp, res);
		} else {
			
		}
	}
	private void addToRes(List<Integer> tmp,List<List<Integer>> res){
		
	}
}
