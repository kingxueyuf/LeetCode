package ValidateBinarySearchTree;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public boolean isValidBST(TreeNode root) {
		inorder(root);
		return isValid;
	}

	int last = Integer.MIN_VALUE;
	boolean isValid = true;

	public void inorder(TreeNode node) {
		if(node == null)
			return;
		inorder(node.left);
		if (!isValid)
			return;
		if (node.val <= last)
			isValid = false;
		else {
			last = node.val;
			inorder(node.right);
		}
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