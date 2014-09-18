package RotateList;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	public ListNode rotateRight(ListNode head, int n) {
		if(head == null || n ==0)
			return head;
		ListNode iter = head;
		int length = 0;
		ListNode last = null;
		while (iter != null) {
			length++;
			last = iter;
			iter = iter.next;
		}
		last.next = head;
		n = n % length;
		iter = head;
		int num = 0;
		
		while (true) {
			num++;
			if (num == length - n) {
				ListNode res = iter.next;
				iter.next = null;
				return res;
			}
			iter = iter.next;
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
}