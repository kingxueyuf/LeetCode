package MergeTwoSortedLists;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode start = null;
		ListNode current = null;

		while (l1 != null && l2 != null) {
			if (l1.val >= l2.val) {
				if (start == null) {
					start = l2;
					current = start;
				} else {
					current.next = l2;
					current = current.next;
				}
				l2 = l2.next;
			} else {
				if (start == null) {
					start = l1;
					current = start;
				} else {
					current.next = l1;
					current = current.next;
				}
				l1 = l1.next;
			}

		}
		if (l1 == null) {
			current.next = l2;
		} else {
			current.next = l1;
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