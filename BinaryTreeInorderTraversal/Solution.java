package BinaryTreeInorderTraversal;

import java.util.ArrayList;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		
		if(root == null)
			return output;
		
		inorder(root);
		
		return this.output;
	}
	
	ArrayList<Integer> output = new ArrayList<Integer>();
	public void inorder(TreeNode node)
	{
		if(node == null)
			return;
		
		inorder(node.left);
		
		output.add(node.val);
		
		inorder(node.right);
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
