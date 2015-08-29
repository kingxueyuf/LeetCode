package FractiontoRecurringDecimal;

import java.util.HashMap;

public class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
		int integerPart = numerator / denominator;
		int remainder = numerator % denominator;
		StringBuilder sb = new StringBuilder();
		sb.append(integerPart);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int position = 0;
		if (remainder != 0) {
			sb.append(".");
			StringBuilder sb1 = new StringBuilder();
			while (remainder != 0) {
				remainder = remainder * 10;
				int tmp = remainder / denominator;
				remainder = remainder % denominator;
				if (!map.containsKey(tmp)) {
					map.put(tmp, position);
					position++;
					sb1.append(tmp);
				} else {
					// for right ")"
					sb1.append(")");
					// for left "("
					sb1.insert(map.get(tmp), "(");
					break;
				}
			}
			sb.append(sb1);
		}
		return sb.toString();
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		int[] numerators = { 1, 1, 1 ,2};
		int[] denominators = { 8, 4, 3 ,3};
		for(int i=0 ; i<numerators.length; i++){
			System.out.println(s.fractionToDecimal(numerators[i],denominators[i]));
		}

	}
}
