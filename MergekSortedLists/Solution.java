package MergekSortedLists;

import java.util.ArrayList;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {

		if (lists == null)
			return null;
		if (lists.isEmpty())
			return null;
		if (lists.size() == 1)
			return lists.get(0);

		int count = 0;
		int listSize = lists.size();
		int minIndex;
		ListNode lastPoint = null;
		ListNode startPoint = null;
		do {
			count = 0;
			minIndex = -1;
			for (int i = 0; i < lists.size(); i++) {
				if (lists.get(i) == null) {
					count++;
					continue;
				} else if (minIndex == -1) {
					minIndex = i;
				}

				if (lists.get(minIndex).val >= lists.get(i).val) {
					minIndex = i;
				}
			}

			if (count == listSize)
				break;
			ListNode newNode = duplicate(minIndex, lists);
			if (startPoint == null) {
				startPoint = newNode;
			}
			if (lastPoint == null) {
				lastPoint = newNode;
			} else {
				lastPoint.next = newNode;
				lastPoint = newNode;
			}

			lists.set(minIndex, lists.get(minIndex).next);
		} while (true);

		return startPoint;
	}

	public ListNode duplicate(int i, ArrayList<ListNode> lists) {
		ListNode node = new ListNode(lists.get(i).val);
		return node;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// public static void main(String args[])
	// {
	// ArrayList<ListNode> list = new ArrayList<ListNode>();
	// Solution s = new Solution();
	// list.add(null);
	// list.add(null);
	// ListNode node = s.mergeKLists(list);
	// if(node == null)
	// System.out.println("null");
	// }
}