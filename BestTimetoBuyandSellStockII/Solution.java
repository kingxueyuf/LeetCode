package BestTimetoBuyandSellStockII;

public class Solution {
	public int maxProfit(int[] prices) {
		if(prices == null)return 0;
		if(prices.length == 0 )return 0;
		int max = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i]) {
				max += prices[i + 1] - prices[i];
			}
		}
		return max;
	}

	public void test() {
		int[] prices = { 1, 2, 3, 2, 4, 5 };
		int max = maxProfit(prices);
		System.out.println(max);
	}
}
