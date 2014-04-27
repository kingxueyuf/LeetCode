package RemoveDuplicatesfromSortedList;
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */

public class Solution {

	public ListNode deleteDuplicates(ListNode head) {

		if (head == null)
			return head;
		ListNode current = head;

		while (current.next != null) {
			if (current.val == current.next.val) {
				ListNode duplicateStart = current;
				while (current.next !=null && current.val == current.next.val) {
					current = current.next;
				}
				current = current.next;
				duplicateStart.next = current;
				if(current == null)
					break;
			} else {
				current = current.next;
			}
		}
		return head;
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
