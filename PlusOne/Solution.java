package PlusOne;

public class Solution {

	public int[] plusOne(int[] digits) {
		if (digits == null)
			return null;
		if (digits.length == 0)
			return null;

		int pointer = digits.length - 1;
		int current = 0;
		boolean overflow = false;
		while (true) {
			current = digits[pointer] + 1;
			if (current == 10) {
				digits[pointer] = 0;
				pointer--;
				if (pointer == -1) {
					overflow = true;
					break;
				}
			} else {
				digits[pointer] = current;
				return digits;
			}
		}

		int[] res = new int[digits.length + 1];
		res[0] = 1;
		for (int i = 1; i < res.length; i++) {
			res[i] = 0;
		}
		
		return res;
	}
	
	public void test()
	{
		int[] inp = {8,9,9,9};
		int[] res = plusOne(inp);
		for(int i = 0 ; i <res.length ; i++)
		{
			System.out.print(res[i]);
		}
	}
}
