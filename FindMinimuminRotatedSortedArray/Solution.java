package FindMinimuminRotatedSortedArray;

public class Solution {
	public int findMin(int[] num) {
		int l = 0;
		int r = num.length - 1;
		if (num == null)
			return 0;
		if (num.length == 0)
			return 0;
		if (num.length == 1)
			return num[0];
		int mid = (l + r) / 2;
		if (mid == 0)
			return (num[0] > num[1]) ? num[1] : num[0];
		while (true) {
			if (num[l] < num[r]) {
				break;
			} else if (num[l] > num[r]) {
				if (num[mid] > num[l]) {
					l = mid + 1;
				} else if (num[mid] < num[l]) {
					r = mid;
				} else {
					// mid == l
					l = l + 1;
				}
			}else{
				break;
			}
			mid = (l + r) / 2;
		}
		return num[l];
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		int[] arr = { 4, 5, 6, 7, 8, 9, 0, 1, 2 };
		int[] arr2 = { 1, 2,3,0 };
		System.out.println(s.findMin(arr2));
	}
}
