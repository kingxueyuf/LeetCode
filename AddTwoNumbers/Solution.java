package AddTwoNumbers;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode start = null;
		ListNode current = null;

		int carryBit = 0;
		int tmp = 0;
		while (l1 != null && l2 != null) {
			tmp = l1.val + l2.val + carryBit;
			if (tmp >= 10) {
				carryBit = 1;
				tmp = tmp - 10;
			} else {
				carryBit = 0;
			}
			l1 = l1.next;
			l2 = l2.next;
			if (start == null) {
				start = new ListNode(tmp);
				current = start;
			} else {
				current.next = new ListNode(tmp);
				current = current.next;
			}
		}
		if (l1 == null) {
			while (l2 != null) {
				tmp = l2.val + carryBit;
				if (tmp >= 10) {
					tmp = tmp - 10;
					carryBit = 1;
				} else {
					carryBit = 0;
				}
				if (start == null) {
					start = new ListNode(tmp);
					current = start;
				} else {
					current.next = new ListNode(tmp);
					current = current.next;
				}
				l2 = l2.next;
			}
		} else if (l2 == null) {
			while (l1 != null) {
				tmp = l1.val + carryBit;
				if (tmp >= 10) {
					tmp = tmp - 10;
					carryBit = 1;
				} else {
					carryBit = 0;
				}
				if (start == null) {
					start = new ListNode(tmp);
					current = start;
				} else {
					current.next = new ListNode(tmp);
					current = current.next;
				}
				l1 = l1.next;
			}
		}

		if (carryBit == 1) {
			current.next = new ListNode(1);
		}
		return start;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
}
