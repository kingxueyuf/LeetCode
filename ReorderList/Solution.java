package ReorderList;

import java.util.ArrayList;

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	public void reorderList(ListNode head) {
		if (head == null)
			return;
		ListNode tmp = head;
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		while (tmp != null) {
			list.add(tmp);
			tmp = tmp.next;
		}
		if (list.size() == 1)
			return;
		int s = 0;
		int e = list.size() - 1;
		ListNode last = null;
		while (s < e) {
			if (last != null)
				last.next = list.get(s);
			list.get(s).next = list.get(e);
			last = list.get(e);
			s++;
			e--;
		}
		if (s == e) {
			last.next = list.get(s);
			last = list.get(s);
		}
		last.next = null;

	}

	public static void main(String args[]) {
		Solution s = new Solution();
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		one.next = two;
		two.next = three;
		s.reorderList(one);
		while (one != null) {
			System.out.print(one.val);
			one = one.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}