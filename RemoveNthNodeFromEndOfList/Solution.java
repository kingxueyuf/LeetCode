package RemoveNthNodeFromEndOfList;

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ListNode index = head;
		int total = 1;
		while (index.next != null) {
			index = index.next;
			total++;
		}
		total = total - n;
		if (total == 0) {
			return head.next;
		} else {
			ListNode pointer = head;
			for (int i = 0; i < total - 1; i++) {
				pointer = pointer.next;
			}
			pointer.next = pointer.next.next;

			return head;
		}
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
