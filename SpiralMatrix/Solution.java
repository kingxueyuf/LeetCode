package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	/*
	 * Four direction 0 -> right 1 -> down 2 -> left 3 -> up
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		if (matrix == null)
			return list;
		if (matrix.length == 0)
			return list;
		if (matrix[0].length == 0)
			return list;
		boolean[][] visit = new boolean[matrix.length][matrix[0].length];
		int direction = 0;
		int X = 0;
		int Y = 0;
		boolean end = false;
		while (!end) {
			if (!visit[X][Y]) {
				visit[X][Y] = true;
				list.add(matrix[X][Y]);
			}
			switch (direction) {
			case 0:
				// right
				for (int y = Y + 1; y < matrix[0].length; y++) {
					if (!visit[X][y]) {
						visit[X][y] = true;
						list.add(matrix[X][y]);
						Y = y;
					} else
						break;
				}
				direction = (direction + 1) % 4;
				end = visitAll(visit, X, Y);
				break;
			case 1:
				// down
				for (int x = X + 1; x < matrix.length; x++) {
					if (!visit[x][Y]) {
						visit[x][Y] = true;
						list.add(matrix[x][Y]);
						X = x;
					} else
						break;
				}
				direction = (direction + 1) % 4;
				end = visitAll(visit, X, Y);
				break;
			case 2:
				// left
				for (int y = Y - 1; y >= 0; y--) {
					if (!visit[X][y]) {
						visit[X][y] = true;
						list.add(matrix[X][y]);
						Y = y;
					} else
						break;
				}
				direction = (direction + 1) % 4;
				end = visitAll(visit, X, Y);
				break;
			case 3:
				// up
				for (int x = X - 1; x >= 0; x--) {
					if (!visit[x][Y]) {
						visit[x][Y] = true;
						list.add(matrix[x][Y]);
						X = x;
					} else
						break;
				}
				direction = (direction + 1) % 4;
				end = visitAll(visit, X, Y);
				break;
			}
		}
		return list;
	}

	private boolean visitAll(boolean[][] visit, int x, int y) {
		// TODO Auto-generated method stub
		// check up
		if (x - 1 != -1 && !visit[x - 1][y])
			return false;
		if (x + 1 != visit.length && !visit[x + 1][y])
			return false;
		if (y - 1 != -1 && !visit[x][y - 1])
			return false;
		if (y + 1 != visit[x].length && !visit[x][y + 1])
			return false;
		return true;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		int[][] matrix = { { 2, 3 } };
		List<Integer> list = s.spiralOrder(matrix);
		for (Integer i : list) {
			System.out.print(i);
		}
	}
}
