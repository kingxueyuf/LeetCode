package LargestRectangleinHistogram;

/**
 * @author yufanxue
 * @date Mar 1, 2014
 * @TODO TODO leetcode -- Largest Rectangle in Histogram
 *       http://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 * @analysis dp and cut branches
 */
public class Solution2 {

	int dp = 0;

	public int largestRectangleArea(int[] height) {
		if (height == null)
			return 0;
		if (height.length == 0)
			return 0;

		int start = 0;
		int end = height.length - 1;
		while (start < height.length) {
			end = height.length - 1;

			for (int i = start + 1; i < height.length; i++) {

				if (height[i - 1] > height[i]) {
					end = i - 1;
					break;
				}
			}
			dp(height, end);
			start = end + 1;
			// System.out.println(start + " " + end);
		}
		return dp;
	}

	public void dp(int[] height, int end) {
		// int maxArea = 0;
		int currentH = height[end];
		int currentArea = 0;
		for (int i = end; i >= 0; i--) {
			if (height[i] == 0)
				break;
			if (height[i] <= currentH)
				currentH = height[i];
			currentArea = currentH * (end - i + 1);
			if (currentArea > dp)
				dp = currentArea;
		}
		// System.out.println(dp);
		// this.dp = maxArea;
	}

	public void test() {
		//{ 2, 1, 5, 6, 2, 3 };
		int[] height = { 1};
		int res = largestRectangleArea(height);
		System.out.println(res);
	}

}
