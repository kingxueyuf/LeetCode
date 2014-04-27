package ValidPalindrome;

public class Solution {
	public boolean isPalindrome(String s) {
		if (s == null)
			return true;
		if (s.length() == 0)
			return true;
		char[] arr = s.toCharArray();
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			while (!Character.isLetter(arr[start])
					&& !Character.isDigit(arr[start])) {
				start++;
				if (start == arr.length)
					break;
			}
			while (!Character.isLetter(arr[end])
					&& !Character.isDigit(arr[end])) {
				end--;
				if (end == -1)
					break;
			}
			if (start == arr.length || end == -1)
				break;
			if (start > end) {
				break;
			}

			if (!charIsEqual(arr[start], arr[end]))
				return false;
			else {
				start++;
				end--;
			}
		}

		return true;
	}

	private boolean charIsEqual(char A, char B) {
		return Character.toLowerCase(A) == Character.toLowerCase(B);
	}

	public void test() {
		String A = "A man, a plan, a canal: Panama";
		String B = "race a car";
		String C = " ";
		String D = "A A";
		String E = "1a2";
		Boolean res = isPalindrome(E);
		System.out.println(res);
	}
}
