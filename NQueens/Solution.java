package NQueens;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	int total;
	List<String[]> res;
	char[][] board;
	boolean[] use;

	public List<String[]> solveNQueens(int n) {
		this.total = n;
		this.res = new ArrayList<String[]>();
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

	ArrayList<String> oneSolution = new ArrayList<String>();

	public void permutation(int row) {
		if (row == total) {
			res.add(oneSolution.toArray(new String[0]));

		}
		for (int i = 0; i < total; i++) {
			if (!use[i] && validDiagonal(row, i)) {
				this.board[row][i] = 'Q';
				use[i] = true;
				oneSolution.add(new String(this.board[row]));
				permutation(row + 1);
				oneSolution.remove(oneSolution.size() - 1);
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

	public static void main(String args[]) {
		Solution s = new Solution();
		s.solveNQueens(8);

	}

}