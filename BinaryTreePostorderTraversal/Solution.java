package BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> visitChild = new Stack<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		stack.push(root);
		while (stack.size() > 0) {
			TreeNode n = stack.peek();
			if (visitChild.contains(n)) {
				// right node need to push again;
				res.add(n.val);
//				System.out.println(n.val);
				stack.pop();
			} else {
				visitChild.add(n);
				if (n.right != null) {
					stack.push(n.right);
				}
				if (n.left != null) {
					stack.push(n.left);
				}
				if (n.left == null && n.right == null) {
					// leaf node
					res.add(n.val);
//					System.out.println(n.val);
					stack.pop();
				}
			}
		}
		return res;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		TreeNode root = new TreeNode(3);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		root.left = left;
		root.right = right;
		s.postorderTraversal(root);
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
