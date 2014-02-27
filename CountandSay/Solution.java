package CountandSay;

import java.util.HashMap;

public class Solution {

	HashMap<Integer, String> map = new HashMap<Integer, String>();

	public String countAndSay(int n) {

		if (n == 0)
			return "10";
		if (n == 1)
			return "1";
		if (n == 2)
			return "11";

		generateMap(map, n);

		return map.get(n - 1);
	}

	public void generateMap(HashMap<Integer, String> map, int n) {
		String[] array = new String[n];
		array[0] = "1";
		array[1] = "11";
		for (int i = 2; i < n; i++) {
			String s = array[i - 1];
			char[] arr = s.toCharArray();
			// System.out.println(arr.length);
			char last = arr[0];
			String res = "";
			int num = 1;
			for (int j = 1; j < arr.length; j++) {
				if (arr[j] != last) {
					res += num + "" + last;
					last = arr[j];
					num = 1;
				} else {
					num++;
				}
			}
			res += num + "" + last;
			// System.out.println(res);
			array[i] = res;
			map.put(i, res);
		}
	}

	public void test() {
		String res = countAndSay(0);
		System.out.println(res);
	}
}
