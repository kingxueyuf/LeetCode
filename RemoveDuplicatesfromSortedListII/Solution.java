package RemoveDuplicatesfromSortedListII;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode start = null;
		ListNode last = null;
		ListNode current = head;

		while (current != null) {
			if (current.next == null) {
				if (last == null) {
					last = current;
					start = current;
				} else {
					last.next = current;
				}
				return start;
			}
			if (current.val != current.next.val) {
				if (last == null) {
					start = current;
					last = current;
				} else {
					last.next = current;
					last = current;
				}
			}
			
			while (current.val == current.next.val) {
				current = current.next;
				if(current.next == null)
				{	
					if(start == null)
						return start;
					else
					{
						last.next = null;
						return start;
					}
				}
			}
			current = current.next;
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