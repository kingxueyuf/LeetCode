package GrayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	ArrayList<Integer> list = new ArrayList<Integer>();
	int total = 0;

	public List<Integer> grayCode(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
		total = (int) Math.pow(2, n);
		list.add(0);
		dfs(arr, 2);
		return list;
	}

	public boolean dfs(int[] arr, int num) {
		if (num == total + 1)
			return true;
		for (int i = arr.length - 1; i >= 0; i--) {
			arr[i] = (arr[i] == 0) ? 1 : 0;
			int a = getNum(arr);
			if (list.contains(a))
				arr[i] = (arr[i] == 0) ? 1 : 0;
			else {
				list.add(a);
				if (dfs(arr, num + 1))
					return true;
				else
					return false;
			}
		}
		return true;
	}

	public int getNum(int[] arr) {
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			total = total * 2 + arr[i];
		}
		return total;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		List<Integer> list = s.grayCode(2);
		for (Integer i : list) {
			System.out.println(i);
		}
	}
}
