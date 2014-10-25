package BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		queue.add(root);
		boolean left = true;
		while (queue.size() != 0) {
			LinkedList<TreeNode> tmp = new LinkedList<TreeNode>();
			ArrayList<Integer> list = new ArrayList<Integer>();
			while (queue.size() != 0) {
				TreeNode node = queue.remove();
				list.add(node.val);
				if (left) {
					if (node.left != null)
						tmp.push(node.left);
					if (node.right != null)
						tmp.push(node.right);
				} else {
					if (node.right != null)
						tmp.push(node.right);
					if (node.left != null)
						tmp.push(node.left);
				}
			}
			left = !left;
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