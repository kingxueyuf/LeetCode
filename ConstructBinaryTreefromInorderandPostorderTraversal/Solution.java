package ConstructBinaryTreefromInorderandPostorderTraversal;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return construct(inorder, 0, inorder.length - 1, postorder, 0,
				postorder.length - 1);
	}

	private TreeNode construct(int[] inorder, int i, int j, int[] postorder,
			int k, int l) {
		// TODO Auto-generated method stub
		if (i > j)
			return null;
		if (k > l)
			return null;
		TreeNode node = new TreeNode(postorder[l]);
		int index = 0;
		for (int a = i; a <= j; a++) {
			if (inorder[a] == node.val) {
				index = a;
				break;
			}
		}
		node.left = construct(inorder, i, index - 1, postorder, k, k + index
				- i - 1);
		node.right = construct(inorder, index + 1, j, postorder, k + index - i,
				l - 1);
		return node;
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