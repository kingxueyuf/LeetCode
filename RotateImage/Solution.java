package RotateImage;

public class Solution {
	public void rotate(int[][] matrix) {
		int midX = matrix.length-1;
		int midY = 0;

		for (int i = 0; i < matrix.length; i++) {
			midX -= i;
			midY += i;

			for (int j = 1; j <= midX; j++) {
				int temp = 0;
				temp = matrix[midX - i][midY];
				matrix[midX - i][midY] = matrix[midX][midY + i];
				matrix[midX][midY + 1] = temp;

			}
		}

		output(matrix);
	}

	public void output(int[][]matrix)
	{
		for(int i = 0 ; i <matrix.length ;i++)
		{
			for(int j = 0 ;j < matrix[0].length ; j++)
			{
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}
