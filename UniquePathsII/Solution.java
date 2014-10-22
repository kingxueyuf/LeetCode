package UniquePathsII;

public class Solution {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

		int rowNum = obstacleGrid.length - 1;
		int colNum = obstacleGrid[0].length - 1;
		if (obstacleGrid[rowNum][colNum] == 1) {
			return 0;
		}
		if (obstacleGrid[0][0] == 1)
			return 0;
		dp[rowNum][colNum] = 1;
		for (int i = rowNum - 1; i >= 0; i--) {
			dp[i][colNum] = (obstacleGrid[i][colNum] == 1) ? 0
					: dp[i + 1][colNum];
		}
		for (int j = colNum - 1; j >= 0; j--) {
			dp[rowNum][j] = (obstacleGrid[rowNum][j] == 1) ? 0
					: dp[rowNum][j + 1];
		}
		for (int j = colNum - 1; j >= 0; j--) {
			for (int i = rowNum - 1; i >= 0; i--) {
				dp[i][j] = (obstacleGrid[i][j] == 1) ? 0
						: (dp[i + 1][j] + dp[i][j + 1]);
			}
		}
		return dp[0][0];
	}
}
