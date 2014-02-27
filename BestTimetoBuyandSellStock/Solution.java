package BestTimetoBuyandSellStock;

public class Solution {

	public int maxProfit(int[] prices) {
		if (prices == null)
			return 0;
		if (prices.length == 0)
			return 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int maxP = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] > max) {
				max = prices[i];
				if (max - min > maxP) {
					maxP = max - min;
				}
			}
			if (prices[i] < min) {
				min = prices[i];
				max = prices[i];
			}
		}
		return maxP;
	}
}
