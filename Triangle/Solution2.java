package Triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	public int minimumTotal(List<List<Integer>> triangle) {
		ArrayList<Integer> lRow = new ArrayList<Integer>(triangle.size());
		ArrayList<Integer> cRow = new ArrayList<Integer>(triangle.size());
		if(triangle ==  null)
			return 0;
		lRow.add(triangle.get(0).get(0));
		for (int row = 1; row < triangle.size(); row++) {
			// 0th element
			cRow.add(lRow.get(0) + triangle.get(row).get(0));
			// 1 -> row;
			for (int i = 1; i < row; i++) {
				cRow.add((int) Math.min(lRow.get(i - 1), lRow.get(i))
						+ triangle.get(row).get(i));
			}
			cRow.add(lRow.get(lRow.size() - 1) + triangle.get(row).get(row));
			copyList(lRow, cRow);
			cRow.clear();
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < triangle.size(); i++) {
			if (lRow.get(i) < min)
				min = lRow.get(i);
		}
		return min;
	}

	private void copyList(ArrayList<Integer> lRow, ArrayList<Integer> cRow) {
		// TODO Auto-generated method stub
		lRow.clear();
		for (Integer i : cRow) {
			lRow.add(i.intValue());
		}
	}
}
