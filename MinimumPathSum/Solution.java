package MinimumPathSum;

public class Solution {
	public int minPathSum(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		int rN = grid.length - 1;
		int cN = grid[0].length - 1;
		dp[0][0] = grid[0][0];
		// init 0th col
		for (int i = 1; i <= rN; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		for (int col = 1; col <= cN; col++) {
			for (int row = 0; row <= rN; row++) {
				dp[row][col] = (row == 0) ? dp[row][col - 1] + grid[row][col]
						: Math.min(dp[row - 1][col], dp[row][col - 1])
								+ grid[row][col];
			}
		}
		
		return dp[rN][cN];
	}
}
