package ValidSudoku;

public class Solution {
	public boolean isValidSudoku(char[][] board) {
		boolean[][] row = new boolean[9][10];
		boolean[][] col = new boolean[10][9];
		boolean[][] part = new boolean[9][10];
		// row
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != '.') {
					int num = (int) board[i][j] - (int) '0';
					if (row[i][num])
						return false;
					else
						row[i][num] = true;
					if (col[num][j])
						return false;
					else
						col[num][j] = true;
					int partNum = getPart(i, j);
					if (part[partNum][num])
						return false;
					else
						part[partNum][num] = true;
				}
			}
		}
		return true;
	}
	
	public static void main(String args[])
	{
		String[] arr ={".........","4........","......6..","...38....",".5...6..1","8......6.",".........","..7.9....","...6....."};
		char[][] charArr = new char[9][9];
		for(int i = 0 ; i <arr.length ; i++)
		{
			charArr[i] = arr[i].toCharArray();
		}
		
		Solution s = new Solution();
		s.isValidSudoku(charArr);
	}
	

	private int getPart(int i, int j) {
		// TODO Auto-generated method stub

		return (i / 3) * 3 + j / 3;
	}

}