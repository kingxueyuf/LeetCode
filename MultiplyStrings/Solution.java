package MultiplyStrings;

import java.math.BigInteger;

public class Solution {
	public String multiply(String num1, String num2) {

		BigInteger bigOne = new BigInteger(num1);
		BigInteger bigTwo = new BigInteger(num2);
		return bigOne.multiply(bigTwo).toString();
	}
}
