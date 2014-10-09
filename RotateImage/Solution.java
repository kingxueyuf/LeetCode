package RotateImage;

public class Solution {
	public void rotate(int[][] matrix) {

		int top;
		int right;
		int bottom;
		int left;

		top = 0;
		right = matrix[top].length - 1;
		bottom = matrix.length - 1;
		left = 0;
		while (top < bottom) {
			for (int i = 0; i <= right - left - 1; i++) {
				int tmp = matrix[top][left + i];
				matrix[top][left + i] = matrix[bottom - i][left];
				matrix[bottom - i][left] = matrix[bottom][right - i];
				matrix[bottom][right - i] = matrix[top + i][right];
				matrix[top + i][right] = tmp;
			}
			top++;
			right--;
			bottom--;
			left++;
		}
	}

	public void output(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}
