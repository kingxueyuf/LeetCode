package PalindromeNumber;

public class Solution {

	public boolean isPalindrome(int x) {
		if( x < 0 )return false;

		long palindrome = 0;
		int temp = x;
		while (temp / 10 != 0) {
			palindrome = palindrome * 10 + temp % 10;
			temp = temp / 10;
		}
		palindrome = palindrome * 10 + temp;

		if (palindrome == x)
			return true;
		else
			return false;
	}

	public void test() {
		int a = 999999999;
		boolean res = isPalindrome(a);
		System.out.println(res);
	}
}
