package SudokuSolver;

public class Solution {
	char[][] board;
	boolean[][] row = new boolean[9][10];
	boolean[][] col = new boolean[10][9];
	boolean[][] part = new boolean[9][10];

	public void solveSudoku(char[][] board) {
		this.board = board;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int num = (int) board[i][j] - (int) '0';
					row[i][num] = true;
					col[num][j] = true;
					int partN = getPart(i, j);
					part[partN][num] = true;
				}
			}
		}
		dfs(0, 0);
	}

	boolean find = false;

	public void dfs(int row, int col) {
		if (row == 9) {
			find = true;
			return;
		}
		if (board[row][col] == '.') {
			char[] number = findNumber(row, col);
			for (int i = 0; i < number.length; i++) {
				board[row][col] = number[i];
				int num = (int) number[i] - (int) '0';
				this.row[row][num] = true;
				this.col[num][col] = true;
				this.part[getPart(row, col)][num] = true;
				if (col == 8)
					dfs(row + 1, 0);
				else
					dfs(row, col + 1);
				if (find)
					return;
				board[row][col] = '.';
				this.row[row][num] = false;
				this.col[num][col] = false;
				this.part[getPart(row, col)][num] = false;
				
			}
		} else {
			if (col == 8)
				dfs(row + 1, 0);
			else
				dfs(row, col + 1);
			if (find)
				return;
		}

	}

	public static void main(String args[]) {
		String[] arr = { "..9748...", "7........", ".2.1.9...", "..7...24.",
				".64.1.59.", ".98...3..", "...8.3.2.", "........6", "...2759.." };
		char[][] charArr = new char[9][9];
		for (int i = 0; i < arr.length; i++) {
			charArr[i] = arr[i].toCharArray();
		}

		Solution s = new Solution();
		s.solveSudoku(charArr);
	}

	private char[] findNumber(int row2, int col2) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < 10; i++) {
			if (!row[row2][i] && !col[i][col2] && !part[getPart(row2, col2)][i])
				sb.append(i);
		}
		return sb.toString().toCharArray();
	}

	public int getPart(int row, int col) {
		return (row / 3) * 3 + col / 3;
	}
}
