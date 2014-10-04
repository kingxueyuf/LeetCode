package BinaryTreeMaximumPathSum;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		cal(root);
		return max;
	}

	public int cal(TreeNode root) {
		if (root == null)
			return 0;
		int leftBranch = cal(root.left);
		if (leftBranch < 0)
			leftBranch = 0;
		int rightBranch = cal(root.right);
		if (rightBranch < 0)
			rightBranch = 0;
		int currentMax = getMax(leftBranch + root.val, rightBranch + root.val,
				leftBranch + root.val + rightBranch);
		if (currentMax > max) {
			max = currentMax;
		}
		return getMax(leftBranch + root.val, rightBranch + root.val, 0);

	}

	public int getMax(int a, int b, int c) {
		int abMax = Math.max(a, b);
		return Math.max(abMax, c);
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