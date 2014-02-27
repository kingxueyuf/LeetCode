package BalancedBinaryTree;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	boolean balance = true;

	public boolean isBalanced(TreeNode root) {

		if (root == null)
			return true;

		int left = calculate(root.left);
		int right = 0;
		if (!balance) {
			return balance;
		} else {
			right = calculate(root.right);
		}

		if (Math.abs(left - right) > 1)
			balance = false;

		return balance;
	}

	public int calculate(TreeNode node) {
		if (!balance)
			return 0;
		if (node == null)
			return 0;
		int left = calculate(node.left);
		if (!balance) {
			return 0;
		}
		int right = calculate(node.right);

		if (Math.abs(left - right) > 1) {
			balance = false;
			return 0;
		} else {
			return Math.max(right, left) + 1;
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
}