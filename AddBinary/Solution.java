package AddBinary;

public class Solution {

	public String addBinary(String a, String b) {
		if (a == null || b == null)
			return null;
		if (a.length() == 0) {
			return b;
		}
		if (b.length() == 0) {
			return a;
		}
		char[] arr1 = a.toCharArray();
		char[] arr2 = b.toCharArray();
		int shortLength = Math.min(arr1.length, arr2.length);
		int longLength = Math.max(arr1.length, arr2.length);

		char[] longerArr = null;
		char[] shortArr = null;
		if (arr2.length == arr1.length) {
			longerArr = arr1;
			shortArr = arr2;
		} else if (arr1.length == shortLength) {
			longerArr = arr2;
			shortArr = arr1;
		} else {
			longerArr = arr1;
			shortArr = arr2;
		}

		int increase = 0;
		int[] res = new int[longLength + 1];
		int pointer = res.length - 1;

		for (int i = shortArr.length - 1; i > -1; i--) {
			int aInt = Integer.valueOf(shortArr[i] + "");
			int bInt = Integer.valueOf(longerArr[i
					+ (longerArr.length - shortArr.length)]
					+ "");
			// System.out.println(aInt);
			if (aInt + bInt + increase >= 2) {
				res[pointer] = (aInt + bInt + increase - 2);
				increase = 1;
			} else {
				res[pointer] = (aInt + bInt + increase);
				increase = 0;
			}
			pointer--;
		}

		for (int i = longerArr.length - shortArr.length - 1; i > -1; i--) {
			if (increase + Integer.valueOf(longerArr[i] + "") == 2) {
				res[pointer] = 0;
				increase = 1;
			} else {
				res[pointer] = increase + Integer.valueOf(longerArr[i] + "");
				increase = 0;
			}
			pointer--;
		}
		if (increase == 1) {
			res[pointer] = 1;
		}

		String resString = "";
		if (res[pointer] == 1)
			resString += "1";

		for (int i = pointer + 1; i < res.length; i++) {
			resString += res[i];
			// System.out.println(res[i]);
		}
		return resString;
	}

	public void test() {
		String a = "1010";
		String b = "1011";
		String res = addBinary(a, b);
		System.out.println(res);
	}
}
