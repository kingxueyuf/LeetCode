package WordSearch;

public class Solution {
	boolean[][] visit;

	public boolean exist(char[][] board, String word) {
		if (board == null)
			return false;
		if (board.length == 0)
			return false;
		if (board[0].length == 0)
			return false;
		if (word == null)
			return false;
		if (word.length() == 0)
			return false;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					visit = new boolean[board.length][board[0].length];
					if (dfs(board, i, j, word, 1))
						return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, int i, int j, String word, int index) {
		if (index >= word.length())
			return true;
		boolean up = false;
		boolean down = false;
		boolean left = false;
		boolean right = false;
		visit[i][j] = true;
		// up
		if (i - 1 >= 0 && !visit[i - 1][j]
				&& word.charAt(index) == board[i - 1][j]) {
			up = dfs(board, i - 1, j, word, index + 1);
			if (up) {
				visit[i][j] = false;
				return up;
			}
		}
		// down
		if (i + 1 < board.length && !visit[i + 1][j]
				&& word.charAt(index) == board[i + 1][j]) {
			down = dfs(board, i + 1, j, word, index + 1);
			if (down) {
				visit[i][j] = false;
				return down;
			}
		}
		// left
		if (j - 1 >= 0 && !visit[i][j - 1]
				&& word.charAt(index) == board[i][j - 1]) {
			left = dfs(board, i, j - 1, word, index + 1);
			if (left) {
				visit[i][j] = false;
				return left;
			}
		}
		// right
		if (j + 1 < board[0].length && !visit[i][j + 1]
				&& word.charAt(index) == board[i][j + 1]) {
			right = dfs(board, i, j + 1, word, index + 1);
			if (right) {
				visit[i][j] = false;
				return right;
			}
		}
		visit[i][j] = false;
		return false;
	}
}
