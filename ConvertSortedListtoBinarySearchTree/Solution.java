package ConvertSortedListtoBinarySearchTree;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null)
			return null;
		ListNode end = head;
		while (end.next != null) {
			end = end.next;
		}
		return binarySearch(head, end);
	}

	private TreeNode binarySearch(ListNode head, ListNode end) {
		// TODO Auto-generated method stub
		if (head == end)
			return new TreeNode(head.val);
		if(head == null || end == null)
			return null;
		ListNode iter = head;
		int count = 0;
		while (iter != end) {
			iter = iter.next;
			count++;
		}
		int mid = count / 2;
		count = 0;
		ListNode midNode = head;
		ListNode last = null;
		while (count != mid) {
			last = midNode;
			midNode = midNode.next;
			count++;
		}
		TreeNode root = new TreeNode(midNode.val);
		root.left = binarySearch(head, last);
		root.right = binarySearch(midNode.next, end);
		return root;
	}
	public static void main(String args[])
	{
		Solution s = new Solution();
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(3);
		one.next = two;
		two.next = null;
		s.sortedListToBST(one);
	}
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
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