package SearchA2Dmatrix;

public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix == null)
			return false;
		if (matrix.length == 0)
			return false;

		int s = 0;
		int e = matrix.length-1;

		while (e - s > 1) {
			int mid = (s + e) / 2;

			if (target > matrix[mid][0]) {
				s = mid;
			} else if (target < matrix[mid][0]) {
				e = mid;
			} else {
				return true;
			}
		}
		int aimRow = 0;
		if (matrix.length == 1) {

		} else if (target < matrix[e][0]) {
			aimRow = s;
		} else if (target > matrix[s][matrix[s].length - 1]) {
			aimRow = e;
		}

		int rs = 0;
		int re = matrix[aimRow].length - 1;

		while (re - rs > 1) {
			int rmid = (rs + re) / 2;
			if (target < matrix[aimRow][rmid]) {
				re = rmid;
			} else if (target > matrix[aimRow][rmid]) {
				rs = rmid;
			} else {
				return true;
			}
		}
		if (matrix[aimRow][rs] == target)
			return true;
		if (matrix[aimRow][re] == target)
			return true;
		return false;
	}

	public void test() {
		int[][] inp = { { 1 },{3} };
		boolean res = searchMatrix(inp, 4);
		System.out.println(res);
	}
}
