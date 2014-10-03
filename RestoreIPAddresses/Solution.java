package RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<String> item = new ArrayList<String>();
	List<String> res = new ArrayList<String>();

	public List<String> restoreIpAddresses(String s) {
		if (s == null)
			return res;
		if (s.length() <= 3)
			return res;
		recursion(1, s);
		return res;
	}

	public void recursion(int a, String s) {
		if (a == 5) {
			if (s.length() == 0) {
				String tmp = "";
				for (int i = 0; i < item.size(); i++) {
//					System.out.print(item.get(i));
					tmp += item.get(i);
					if (i != item.size() - 1) {
						tmp += ".";
					}
				}
//				System.out.println();
				res.add(tmp);
			} else
				return;
		}
		for (int i = 1; i <= 3; i++) {
			if (i > s.length())
				return;
			String current = s.substring(0, i);
			Integer currentDigit = Integer.parseInt(current);
			if (currentDigit <= 255) {
				item.add(current);
				String next = "";
				next = s.substring(i);
				recursion(a + 1, next);
				item.remove(item.size() - 1);
				if (currentDigit == 0)
					break;
			}
		}
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		s.restoreIpAddresses("19216");
	}
}
