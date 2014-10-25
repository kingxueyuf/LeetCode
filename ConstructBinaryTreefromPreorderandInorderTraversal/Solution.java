package ConstructBinaryTreefromPreorderandInorderTraversal;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return construct(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1);
	}

	private TreeNode construct(int[] preorder, int i, int j, int[] inorder,
			int k, int l) {
		if (i > j)
			return null;
		if(i == j)
			return 
		if (k > l)
			return null;
		TreeNode root = new TreeNode(preorder[i]);
		int in = 0;
		for (int index = k; index <= l; index++) {
			if (inorder[index] == root.val)
				in = index;
		}
		root.left = construct(preorder, i + 1, i + in - k, inorder, k, in - 1);
		root.right = construct(preorder, i + in - k + 1, j, inorder, in + 1, l);

		return root;
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