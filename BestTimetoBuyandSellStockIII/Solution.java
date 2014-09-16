package BestTimetoBuyandSellStockIII;

public class Solution {
	public int maxProfit(int[] prices) {
		if (prices == null)
			return 0;
		if (prices.length == 0)
			return 0;
		int[] arr1 = new int[prices.length];
		arr1[0] = 0;
		int min = prices[0];
		int maxRange = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > min) {
				int tmp = prices[i] - min;
				if (tmp > maxRange)
					maxRange = tmp;
			}
			if (prices[i] < min)
				min = prices[i];
			arr1[i] = maxRange;
		}

		int[] arr2 = new int[prices.length];
		arr2[prices.length-1] = 0;
		int max = prices[prices.length - 1];
		int maxRange2 = 0;
		for (int i = prices.length - 2; i >-1; i--) {
			if (prices[i] < max) {
				int tmp = max - prices[i];
				if (tmp > maxRange2)
					maxRange2 = tmp;
			}
			if (prices[i] > max)
				max = prices[i];
			arr2[i] = maxRange2;
		}
		int maxProfit = 0;
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] + arr2[i] > maxProfit) {
				maxProfit = arr1[i] + arr2[i];
			}
		}
		return maxProfit;
	}
}
