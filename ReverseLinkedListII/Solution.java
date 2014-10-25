package ReverseLinkedListII;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;
		ListNode last = null;
		int count = 1;
		ListNode iter = head;
		while (count != m) {
			last = iter;
			iter = iter.next;
			count++;
		}
		ListNode reverseTail = iter;
		ListNode mergeTail = last;
		last = iter;
		iter = iter.next;
		count++;
		// start reverse from iter
		while (count <= n) {
			ListNode tmp = iter.next;
			iter.next = last;
			last = iter;
			iter = tmp;
			count++;
		}
		ListNode reverseHead = last;
		ListNode mergeHead = iter;
		reverseTail.next = mergeHead;
		if (mergeTail != null) {
			mergeTail.next = reverseHead;
			return head;
		} else {
			return reverseHead;
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
