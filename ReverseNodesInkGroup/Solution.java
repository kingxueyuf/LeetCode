package ReverseNodesInkGroup;

import java.util.ArrayList;

public class Solution {

	public ListNode reverseKGroup(ListNode head, int k) {

		if (head == null)
			return head;
		if (head.next == null)
			return head;
		if (k == 1)
			return head;

		ListNode start = null;
		ListNode last = null;

		boolean findOne = false;
		boolean jump = false;

		ListNode temp = head;

		ArrayList<ListNode> pointList = new ArrayList<ListNode>(k);

		while (true) {
			for (int i = 0; i < k; i++) {
				if (temp == null) {
					jump = true;
					break;
				}
				pointList.add(temp);
				temp = temp.next;
			}
			if (jump)
				break;
			findOne = true;
			for (int i = k - 1; i >= 1; i--) {
				if (i == k - 1 && start == null) {
					start = pointList.get(i);
				}
				pointList.get(i).next = pointList.get(i - 1);
			}
			pointList.get(0).next = null;
			if (last != null) {
				last.next = pointList.get(k - 1);
				last = pointList.get(0);
			} else {
				last = pointList.get(0);
			}
			pointList.clear();
		}

		if (findOne) {
			if (!pointList.isEmpty())
				last.next = pointList.get(0);
			return start;
		} else {
			return head;
		}

	}

	public void test() {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		one.next = two;

		ListNode s = reverseKGroup(one, 2);
		while (s != null) {
			System.out.println(s.val);
			s = s.next;
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
