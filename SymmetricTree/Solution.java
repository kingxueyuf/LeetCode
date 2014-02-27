package SymmetricTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;

		queue.add(root);
		int num = 1;
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		while (queue.size() != 0) {
			for (int i = 0; i < num; i++) {
				list.add(queue.poll());
			}
			num = 0;
			for (int i = 0; i < list.size() / 2; i++) {
				TreeNode front = list.get(i);
				TreeNode end = list.get(list.size() - 1 - i);
				if (front == null && end == null)
					continue;
				if (front == null || end == null)
					return false;
				if (front.val != end.val)
					return false;
			}

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) == null)
					continue;
				queue.add(list.get(i).left);
				queue.add(list.get(i).right);
				num = num + 2;
			}

			list.clear();
		}
		return true;
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