package PartitionList;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	public ListNode partition(ListNode head, int x) {
		if (head == null)
			return null;
		ListNode iter = head;
		ListNode lastLess = null;
		boolean findGreater = false;
		ListNode last = head;
		while (iter != null) {
			if (iter.val < x) {
				if (!findGreater) {
					lastLess = iter;
					last = iter;
					iter = iter.next;
				} else {
					if (lastLess == null) {
						// head is greater;
						ListNode headT = head;
						last.next = iter.next;
						head = iter;
						iter.next = headT;
						lastLess = iter;
						iter = last.next;

					} else {
						// insert after lastLess
						ListNode tmpN = lastLess.next;
						lastLess.next = iter;
						ListNode iterN = iter.next;
						iter.next = tmpN;
						lastLess = iter;
						iter = iterN;
						last.next = iter;
					}
				}
			} else if (iter.val >= x) {
				findGreater = true;
				last = iter;
				iter = iter.next;
			} 
		}
		return head;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(3);
		ListNode three = new ListNode(2);
		one.next = two;
		two.next = three;
		three.next = null;
		ListNode head = s.partition(one, 2);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
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
