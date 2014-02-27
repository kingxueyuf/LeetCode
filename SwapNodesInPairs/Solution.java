package SwapNodesInPairs;

import java.util.ArrayList;

public class Solution {
	public ListNode swapPairs(ListNode head) {

		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}

		ListNode start = null;
		ListNode last = null;

		while (head != null) {
			ListNode current = head;
			ListNode currentNext = head.next;
			if (currentNext == null) {
				last.next = current;
				break;
			}
			ListNode nextPair = currentNext.next;

			ListNode temp = currentNext;
			temp.next = current;
			temp.next.next = null;
			if (start == null) {
				start = temp;
				last = temp.next;
			} else {
				last.next = temp;
				last = temp.next;
			}
			head = nextPair;
		}

		return start;
	}

	public void test() {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		one.next = two;

		ListNode s = swapPairs(one);
		while (s != null) {
			System.out.println(s.val);
			s = s.next;
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

	public static void main(String args[]) {
		Solution s = new Solution();
		s.test();
	}

}
