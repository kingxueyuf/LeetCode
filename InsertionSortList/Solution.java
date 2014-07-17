package InsertionSortList;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return head;
		ListNode current = head.next;
		ListNode end = head;
		ListNode start = head;
		while (current != null) {
			if (end.val > current.val) {
				if (start.val >= current.val) {
					ListNode temp1 = current.next;
					current.next = start;
					start = current;
					current = temp1;
					end.next = null;
				} else {
					ListNode target = start;
					while (target.val < current.val) {
						if (target.next.val >= current.val)
							break;
						else
							target = target.next;
					}
					ListNode temp = target.next;
					target.next = current;
					ListNode temp2 = current.next;
					current.next = temp;
					current = temp2;
					end.next = null;
				}
			} else {
				// current.val <= next.val
				end.next = current;
				end = current;
				current = current.next;
			}
		}
		return start;
	}

	public void test() {
		ListNode a = new ListNode(4);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(1);
		ListNode d = new ListNode(3);
		a.next = b;
		b.next = c;
		c.next = d;
		ListNode t = insertionSortList(a);
		while (t != null) {
			System.out.println(t.val);
			t = t.next;
		}
	}
}

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
