package MergekSortedLists;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// heap -> priority queue
public class Solution2 {
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(),
				new Comparator<ListNode>() {
					@Override
					public int compare(ListNode o1, ListNode o2) {
						// TODO Auto-generated method stub
						if (o1.val < o2.val)
							return -1;
						else if (o1.val > o2.val)
							return 1;
						else
							return 0;
					}
				});
		for (ListNode node : lists) {
			if (node != null)
				pq.add(node);
		}
		ListNode head = pq.poll();
		ListNode iter = head;
		while (pq.size() != 0) {
			if (iter.next != null)
				pq.add(iter.next);
			ListNode cM = pq.poll();
			iter.next = cM;
			iter = cM;
		}
		return head;
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