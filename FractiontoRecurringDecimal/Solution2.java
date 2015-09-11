package FractiontoRecurringDecimal;

import java.util.HashMap;

public class Solution2 {
	public String fractionToDecimal(int numerator, int denominator) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		long res = (long)numerator * (long)denominator;
		if (res < 0) {
			sb.append("-");
		}
		long numerator1 = Math.abs((long)numerator);
		long denominator1 = Math.abs((long)denominator);
		long integerPart = (long) (numerator1 / denominator1);
		numerator1 = numerator1 % denominator1;

		sb.append(integerPart);
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		if (numerator1 != 0) {
			sb.append(".");
			numerator1 = numerator1 * 10;
			int index = 0;
			boolean finish = false;
			while (numerator1 != 0) {
				while (numerator1 < denominator1) {
					if (!map.containsKey(numerator1)) {
						sb1.append("0");
						map.put(numerator1, index);
						index++;
						numerator1 = numerator1 * 10;
					} else {
						sb1.insert(map.get(numerator1), "(");
						sb1.append(")");
						finish = true;
						break;
					}
				}
				if (finish)
					break;
				if (!map.containsKey(numerator1)) {
					map.put(numerator1, index);
					index++;
					sb1.append(numerator1 / denominator1);
					numerator1 = numerator1 % denominator1;
					if (numerator1 < denominator1) {
						numerator1 = numerator1 * 10;
					}
				} else {
					sb1.insert(map.get(numerator1), "(");
					sb1.append(")");
					break;
				}
			}
		}
		sb.append(sb1);
		return sb.toString();
	}

	public static void main(String args[]) {
		Solution2 s = new Solution2();
		int[] numerators = { 1, 1, 1, 2, 1, -50, -1,-2147483648 };
		int[] denominators = { 8, 4, 3, 3, 333, 8, -2147483648,1 };
		for (int i = 0; i < numerators.length; i++) {
			System.out.println(s.fractionToDecimal(numerators[i], denominators[i]));
		}

	}
}