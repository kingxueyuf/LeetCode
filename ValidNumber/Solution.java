package ValidNumber;

public class Solution {

	
	public boolean isNumber(String s) {
	    String valid = "\\s*[\\+\\-]?(([0-9]+\\.[0-9]+)|[0-9]+\\.|\\.[0-9]+|([0-9]+))([eE][\\+\\-]?[0-9]+)?\\s*";
	    return s.matches(valid);
	}
	public boolean isNumber2(String s) {

		if (s == null)
			return false;
		if (s.length() == 0)
			return false;

		boolean start = false;
		boolean hasPoint = false;
		boolean hasSpace = false;
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (start) {
				if (arr[i] == '.') {
					if (hasPoint)
						return false;
					else {
						if (hasSpace)
							return false;
						hasPoint = true;
					}
				} else if (Character.isLetter(arr[i])) {
					if (!isHex(arr[i]))
						return false;
					if (hasSpace)
						return false;
				} else if (Character.isDigit(arr[i])) {
					if (hasSpace)
						return false;
				} else if (arr[i] == ' ') {
					hasSpace = true;
				}
			} else {
				if (Character.isLetter(arr[i]))
					return false;
				else if (arr[i] == '.') {
					start = true;
					hasPoint = true;
					if (i == arr.length - 1)
						return false;
				} else if (Character.isDigit(arr[i])) {
					if (arr[i] == '0') {
						if (i + 1 < arr.length && Character.isLetter(arr[i+1]))
							return false;
					}
					start = true;
				}
			}
		}
		if (!start)
			return false;
		return true;
	}

	private boolean isHex(char item) {
		if (item == 'a' || item == 'b' || item == 'c' || item == 'd'
				|| item == 'e')
			return true;
		else
			return false;
	}

	// "0" => true
	// " 0.1 " => true
	// "abc" => false
	// "1 a" => false
	// "2e10" => true
	public void test() {
		String[] test = { " ", "0e", " 0.1 ", "abc", "1 a", "2e10" };
		for (int i = 0; i < test.length; i++) {
			boolean res = this.isNumber(test[i]);
			System.out.println(res);
		}
	}
}
