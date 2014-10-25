package BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		queue.add(root);
		while (queue.size() != 0) {
			LinkedList<TreeNode> tmp = new LinkedList<TreeNode>();
			ArrayList<Integer> list = new ArrayList<Integer>();
			while (queue.size() != 0) {
				TreeNode node = queue.remove();
				list.add(node.val);
				if (node.left != null)
					tmp.add(node.left);
				if (node.right != null)
					tmp.add(node.right);
			}
			queue = tmp;
			res.add(list);
		}
		return res;
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