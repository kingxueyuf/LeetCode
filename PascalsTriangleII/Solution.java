package PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> getRow(int rowIndex) {
		ArrayList<Integer> lRow = new ArrayList<Integer>(rowIndex + 1);
		ArrayList<Integer> cRow = new ArrayList<Integer>(rowIndex + 1);
		if(rowIndex < 0)
			return lRow;
		lRow.add(1);
		for (int row = 1; row <= rowIndex; row++) {
			cRow.add(1);
			for (int i = 1; i < row; i++) {
				cRow.add(lRow.get(i) + lRow.get(i - 1));
			}
			cRow.add(1);
			copyList(lRow, cRow);
			cRow.clear();
		}
		return lRow;
	}

	private void copyList(ArrayList<Integer> lRow, ArrayList<Integer> cRow) {
		// TODO Auto-generated method stub
		lRow.clear();
		for (Integer i : cRow) {
			lRow.add(i.intValue());
		}
	}
}