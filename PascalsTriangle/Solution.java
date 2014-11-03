package PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (numRows <= 0)
			return res;
		ArrayList<Integer> oneRow = new ArrayList<Integer>();
		oneRow.add(1);
		res.add(oneRow);
		for (int row = 1; row < numRows; row++) {
			oneRow = new ArrayList<Integer>();
			oneRow.add(1);
			for (int i = 1; i < row; i++) {
				int num = res.get(row - 1).get(i - 1) + res.get(row - 1).get(i);
				oneRow.add(num);
			}
			oneRow.add(1);
			res.add(oneRow);
		}
		return res;
	}
}
