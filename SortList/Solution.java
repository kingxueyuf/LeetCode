package SortList;


/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	public ListNode sortList(ListNode head) {
		// merge sort
		int amount = 0;
		ListNode tmpHead = head;
		while (tmpHead != null) {
			amount++;
			tmpHead = tmpHead.next;
		}
		if (amount == 0)
			return null;
		if (amount == 1)
			return head;
		if (amount == 2) {
			if (head.val > head.next.val) {
				ListNode tmp = head;
				head = head.next;
				head.next = tmp;
			}
			head.next.next = null;
			return head;
		}
		ListNode tmpHead2 = head;
		ListNode secondHalfHead = null;
		ListNode last = null;
		for (int i = 0; i < amount / 2; i++) {
			last = tmpHead2;
			tmpHead2 = tmpHead2.next;
		}
		secondHalfHead = tmpHead2;
		last.next = null;

		ListNode one = sortList(head);
		ListNode two = sortList(secondHalfHead);

		return mergeTwoLists(one, two);
	}

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