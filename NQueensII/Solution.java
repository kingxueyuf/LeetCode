package NQueensII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	int total;
	int res;
	char[][] board;
	boolean[] use;

	public int totalNQueens(int n) {
		this.total = n;
		this.board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				this.board[i][j] = '.';
			}
		}
		this.use = new boolean[n];
		permutation(0);
		return res;
	}

	public void permutation(int row) {
		if (row == total) {
			res++;
		}
		for (int i = 0; i < total; i++) {
			if (!use[i] && validDiagonal(row, i)) {
				this.board[row][i] = 'Q';
				use[i] = true;
				permutation(row + 1);
				this.board[row][i] = '.';
				use[i] = false;
			}
		}
	}

	private boolean validDiagonal(int row, int i) {
		// TODO Auto-generated method stub
		// check toward up left
		int tmpR = row;
		int tmpC = i;
		while (tmpR >= 0 && tmpC >= 0) {
			if (this.board[tmpR][tmpC] == 'Q')
				return false;
			tmpR--;
			tmpC--;
		}

		// check toward up right
		tmpR = row;
		tmpC = i;
		while (tmpR >= 0 && tmpC < total) {
			if (this.board[tmpR][tmpC] == 'Q')
				return false;
			tmpR--;
			tmpC++;
		}
		return true;
	}

}