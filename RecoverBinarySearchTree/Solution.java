package RecoverBinarySearchTree;

import java.util.ArrayList;

/**
 * @author yufanxue
 * @date Sep 13, 2014
 * @TODO TODO
 * @analysis
 */

// Definition for binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	ArrayList<Integer> list = new ArrayList<Integer>();

	public void recoverTree(TreeNode root) {
		// left -> root -> right
		inorder(root);
		int tmp = bigger.val;
		bigger.val = smaller.val;
		smaller.val = tmp;
	}

	TreeNode bigger;
	TreeNode smaller;
	TreeNode last;

	private void inorder(TreeNode node) {
		if (node == null)
			return;
		inorder(node.left);
		if (node.val < list.get(list.size() - 1) && bigger == null) {
			bigger = last;
		} else if (node.val < list.get(list.size() - 1) && smaller == null) {
			smaller = node;
		}
		this.list.add(node.val);
		last = node;
		inorder(node.right);
	}
}