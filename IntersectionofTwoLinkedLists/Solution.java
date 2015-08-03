package IntersectionofTwoLinkedLists;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lengthA = 0;
		int lengthB = 0;

		ListNode headAcopy = headA;
		ListNode headBcopy = headB;
		while (headAcopy != null) {
			headAcopy = headAcopy.next;
			lengthA++;
		}
		while (headBcopy != null) {
			headBcopy = headBcopy.next;
			lengthB++;
		}

		int diff = lengthA - lengthB;
		if (diff > 0) {
			// lengthA > lengthB
			for (int i = 0; i < diff; i++) {
				headA = headA.next;
			}
		} else {
			// lengthB>lengthA
			diff = diff * -1;
			for (int i = 0; i < diff; i++) {
				headB = headB.next;
			}
		}
		while (headA != headB && headA != null && headB != null) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
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