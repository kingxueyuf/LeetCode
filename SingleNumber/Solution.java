package SingleNumber;

public class Solution {
	
	// 0 ^ 0 = 0
	// 1 ^ 0 = 1
	// 0 ^ 1 = 1
	// 1 ^ 1 = 0
	public int singleNumber(int[] A) {
		int res = 0 ; 
		for(int i = 0 ; i <A.length ;i++)
		{
			res = res ^ A[i];
		}
		return res;
	}
}
