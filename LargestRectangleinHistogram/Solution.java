package LargestRectangleinHistogram;

/**
 * @author yufanxue
 * @date Mar 1, 2014
 * @TODO [leetcode] Largest Rectangle in Histogram
 * @analysis dp[i] = max{ dp[i-1](not use num[i]) , dp[i](must use num[i]) }
 * 
 * this solution can work but not efficiency
 * it time complexity was n^2
 */
public class Solution {

	int dp[];

	public int largestRectangleArea(int[] height) {

		if (height == null)
			return 0;
		if (height.length == 0)
			return 0;
		
		dp = new int[height.length];
		dp[0] = height[0];
		for (int i = 1; i < height.length; i++) {
			dp[i] = Math.max(dp[i - 1], useHeightI(height, i));
		}
		return dp[height.length - 1];
	}

	public int useHeightI(int[] height, int a) {
		if (height[a] == 0)
			return 0;
		int maxArea = 0;
		int currentH = height[a];
		int currentArea = 0;
		for (int i = a; i >= 0; i--) {
			if (height[i] == 0)
				break;
			if (height[i] <= currentH)
				currentH = height[i];
			currentArea = currentH * (a - i + 1);
			if (maxArea < currentArea)
				maxArea = currentArea;
		}
		return maxArea;
	}

	public void test() {
		//{ 2, 1, 5, 6, 2, 3 }
		int[] height = { 6, 2, 5, 4, 5, 1, 6};
		int res = largestRectangleArea(height);
		for(int i = 0 ; i <dp.length ; i++)
		{
			System.out.print(dp[i]+" ");
		}
		System.out.println();
		System.out.println(res);
	}
}
