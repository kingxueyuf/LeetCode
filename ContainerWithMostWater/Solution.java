package ContainerWithMostWater;

public class Solution {
	public int maxArea(int[] height) {
		if (height == null)
			return 0;
		if (height.length == 0)
			return 0;
		if (height.length == 1)
			return 0;
		int i = 0;
		int j = height.length - 1;
		int max = 0;
		while (i < j) {
			int area = 0;
			if (height[i] < height[j]) {
				area = height[i] * (j - i);
				i++;
			} else {
				// height[i] > height[j]
				area = height[j] * (j - i);
				j--;
			}
			if (area > max)
				max = area;
		}
		return max;
	}
}