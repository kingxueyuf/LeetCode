package SumRoottoLeafNumbers;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public int sumNumbers(TreeNode root) {

		if (root == null)
			return 0;
		preorder(root);
		return sum;
	}

	int sum = 0;
	int current = 0;

	public boolean preorder(TreeNode node) {
		if (node == null)
			return true;
		current = current * 10 + node.val;

		boolean left = preorder(node.left);

		boolean right = preorder(node.right);

		if (left && right) {
			sum += current;
		}
		current = current / 10;

		return false;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
