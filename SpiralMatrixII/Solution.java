package SpiralMatrixII;

public class Solution {
	public int[][] generateMatrix(int n) {
		int direction = 0;
		if (n <= 0)
			return new int[0][0];
		int[][] board = new int[n][n];
		board[0][0] = 1;
		int num = 2;
		int cX = 0;
		int cY = 0;
		while (num <= n * n) {
			switch (direction) {
			case 0:
				// right
				cY++;
				for (; cY < n; cY++) {
					if (board[cX][cY] != 0) {
						cY--;
						break;
					} else {
						board[cX][cY] = num;
						num++;
					}
					if (cY == n - 1)
						break;
				}
				direction++;
				break;
			case 1:
				// down
				cX++;
				for (; cX < n; cX++) {
					if (board[cX][cY] != 0) {
						cX--;
						break;
					} else {
						board[cX][cY] = num;
						num++;
					}
					if (cX == n - 1)
						break;
				}
				direction++;
				break;
			case 2:
				// left
				cY--;
				for (; cY >= 0; cY--) {
					if (board[cX][cY] != 0) {
						cY++;
						break;
					} else {
						board[cX][cY] = num;
						num++;
					}
					if (cY == 0)
						break;
				}
				direction++;
				break;
			case 3:
				// up
				cX--;
				for (; cX >= 0; cX--) {
					if (board[cX][cY] != 0) {
						cX++;
						break;
					} else {
						board[cX][cY] = num;
						num++;
					}
					if (cX == 0)
						break;
				}
				direction++;
				break;
			}
			direction = direction % 4;
		}
		return board;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		s.generateMatrix(4);
	}
}
