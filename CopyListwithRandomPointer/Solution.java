package CopyListwithRandomPointer;

import java.util.ArrayList;

/**
 * Definition for singly-linked list with a random pointer. class RandomListNode
 * { int label; RandomListNode next, random; RandomListNode(int x) { this.label
 * = x; } };
 */
public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {

		if (head == null)
			return null;

		RandomListNode start = head;
		RandomListNode oldNow = head;

		RandomListNode last = null;
		while (oldNow != null) {
			RandomListNode copy = new RandomListNode(oldNow.label);
			copy.random = oldNow.next;
			oldNow.next = copy;
			if (last == null)
				last = copy;
			else {
				last.next = copy;
				last = copy;
			}
			oldNow = copy.random;
		}

		RandomListNode newHead = head.next;
		RandomListNode oldHead = head;
		ArrayList<RandomListNode> list = new ArrayList<RandomListNode>();

		while (head != null) {

			RandomListNode next = head.next.random;
			list.add(next);
			if (head.random != null)
				head.next.random = head.random.next;
			else
				head.next.random = null;
			head = next;
		}
		while (oldHead != null) {
			oldHead.next = list.get(0);
			list.remove(0);
			oldHead = oldHead.next;
		}
		return newHead;
	}

	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};
}