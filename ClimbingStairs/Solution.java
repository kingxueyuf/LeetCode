package ClimbingStairs;

/**
 * @author robin-xue
 * @project_name LeetCode
 * @file_name Solution.java
 * @tag 
 * @date 2014-2-16
 */
public class Solution {

	public int climbStairs(int n) {
		if (n <= 0)
			return 0;

		int sum = 0;
		for (int i = 0; i <= n / 2; i++) {
			int numOfOne = n - i * 2;
			int total = numOfOne + i;
			int choose;
			if( i > total/2)
			{
				choose = total -i;
			}else
			{
				choose = i;
			}
			long tmp =  calculateC(total, choose);
			System.out.println(total+" "+choose+" "+tmp);
			sum += tmp;
		}
		return sum;
	}

	public long calculateC(int n, int m) {
		if( m == 0)
			return 1;

		// A(n,m)
		long Anm = 1;
		for (int i = n; i >= n - m + 1; i--) {
			Anm *= i;
		}
		// A(m,m)
		long Amm = 1;
		for (int i = 1; i <= m; i++) {
			Amm *= i;
		}
		return Anm / Amm;
	}
	
	public void test()
	{
		int inp = 44;
		System.out.println(climbStairs(44));
	}
}