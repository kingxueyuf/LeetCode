package ConvertSortedArraytoBinarySearchTree;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {

	int[] num;

	public TreeNode sortedArrayToBST(int[] num) {
		if(num == null) return null;
		if(num.length == 0)return null;
		this.num = num;
		TreeNode node = recursion(0, num.length - 1);
		return node;
	}

	public TreeNode recursion(int s, int e) {
		if (s > e)
			return null;
		if (s == e)
			return new TreeNode(num[e]);

		int mid = (s + e) / 2;
		int val = num[mid];
		TreeNode current = new TreeNode(val);

		TreeNode leftChild = recursion(s, mid - 1);
		current.left = leftChild;

		TreeNode rightChild = recursion(mid + 1, e);
		current.right = rightChild;

		return current;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}