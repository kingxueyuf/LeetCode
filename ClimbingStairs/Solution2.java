package ClimbingStairs;

public class Solution2 {
	public int climbStairs(int n) {
		if (n == 0)
			return 0;
		if( n == 1)
			return 1;
		
		int[] array = new int[n + 1];
		array[1] = 1;
		array[2] = 2;
		for (int i = 3; i <= n; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}
		return array[n];
	}
}
