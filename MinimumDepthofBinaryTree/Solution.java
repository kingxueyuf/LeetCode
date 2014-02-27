package MinimumDepthofBinaryTree;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {

	public int minDepth(TreeNode root) {
		if(root == null) return 0;
		
		preorder(root);
		return min;
	}

	int min = Integer.MAX_VALUE;
	int current = 0;

	public boolean preorder(TreeNode node) {
		if (node == null)
			return false;
		current++;
		boolean left = preorder(node.left);

		boolean right = preorder(node.right);

		if (!left && !right) {
			if (current < min)
				min = current;
		}
		current--;
		return true;
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
