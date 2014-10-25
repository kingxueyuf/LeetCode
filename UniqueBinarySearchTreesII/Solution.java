package UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; left = null; right = null; } }
 */
public class Solution {

	public List<TreeNode> generateTrees(int n) {
		if (n <= 0) {
			List<TreeNode> one = new ArrayList<TreeNode>();
			one.add(null);
			return one;
		}
		return recursion(1, n);
	}

	public List<TreeNode> recursion(int s, int e) {
		if (s > e) {
			List<TreeNode> one = new ArrayList<TreeNode>();
			one.add(null);
			return one;
		}
		if (s == e) {
			List<TreeNode> one = new ArrayList<TreeNode>();
			one.add(new TreeNode(s));
			return one;
		}
		List<TreeNode> list = new ArrayList<TreeNode>();
		for (int i = s; i <= e; i++) {
			TreeNode root = new TreeNode(i);
			List<TreeNode> left = recursion(s, i - 1);
			List<TreeNode> right = recursion(i + 1, e);
			for (TreeNode leftItem : left) {
				root.left = leftItem;
				for (TreeNode rightItem : right) {
					root.right = rightItem;
					TreeNode copy = deepCopy(root);
					list.add(copy);
				}
			}
		}
		return list;
	}

	private TreeNode deepCopy(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return null;
		TreeNode copy = new TreeNode(root.val);
		copy.left = deepCopy(root.left);
		copy.right = deepCopy(root.right);
		return copy;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}
