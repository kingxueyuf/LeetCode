package SetMatrixZeroes;

public class Solution {
	public void setZeroes(int[][] matrix) {
		if (matrix == null)
			return;
		if (matrix.length == 0)
			return;
		boolean firstCol = false;
		boolean firstRow = false;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0)
				firstCol = true;
		}
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0)
				firstRow = true;
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 0; i < matrix.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < matrix[i].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		if (matrix[0][0] == 0) {
			firstRow = true;
			firstCol = true;
		}
		if (firstRow) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}
		if (firstCol) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}