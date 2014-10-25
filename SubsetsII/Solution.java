package SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jws.Oneway;

public class Solution {
	boolean[] use;
	int[] num;

	public List<List<Integer>> subsetsWithDup(int[] num) {
		this.num =num;
		Arrays.sort(num);
		this.use = new boolean[num.length];
		
		recursion(0);
		return res;
	}

	List<Integer> one = new ArrayList<Integer>();
	List<List<Integer>> res = new ArrayList<List<Integer>>();

	private void recursion(int i) {
		if (i == num.length) {
			List<Integer> oneCopy = new ArrayList<Integer>(one);
			res.add(oneCopy);
			return;
		}
		if (i >= 1 && num[i] == num[i - 1] && !use[i - 1]) {
			// can not choose since has been choose before
			recursion(i + 1);
		} else {
			// can choose
			// choose
			one.add(num[i]);
			use[i] = true;
			recursion(i + 1);
			// not choose
			one.remove(one.size() - 1);
			use[i] = false;
			recursion(i + 1);
		}
	}
}
