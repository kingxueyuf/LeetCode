package BinaryTreePreorderTraversal;

import java.util.ArrayList;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {

	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		preorder(root);
		return output;
	}

	ArrayList<Integer> output = new ArrayList<Integer>();

	public void preorder(TreeNode root) {
		if (root == null)
			return;
		
		output.add(root.val);

		preorder(root.left);

		preorder(root.right);
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
