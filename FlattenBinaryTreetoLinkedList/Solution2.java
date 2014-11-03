package FlattenBinaryTreetoLinkedList;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution2 {
	public void flatten(TreeNode root) {
		TreeNode node = recursion(root);
	}

	public TreeNode recursion(TreeNode root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null)
			return root;
		TreeNode left = recursion(root.left);
		TreeNode right = recursion(root.right);
		TreeNode iter = left;
		while (iter != null && iter.right != null) {
			iter = iter.right;
		}
		if (iter != null) {
			iter.right = right;
			root.right = left;
		} else {
			root.right = right;
		}
		return root;
	}
}
