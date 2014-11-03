package LinkedListCycleII;

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		// find the meeting point first;
		ListNode fast = head;
		ListNode slow = head;
		boolean cycle = false;
		do {
			if (fast.next == null || fast.next.next == null)
				break;
			if (slow.next == null)
				break;
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				cycle = true;
				break;
			}
		} while (true);
		if (!cycle)
			return null;
		// fast == slow
		ListNode fromHead = head;
		while (fromHead != slow) {
			fromHead = fromHead.next;
			slow = slow.next;
		}
		return slow;
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