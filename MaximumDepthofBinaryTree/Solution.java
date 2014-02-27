package MaximumDepthofBinaryTree;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public int maxDepth(TreeNode root) {

		if (root == null)
			return 0;
		preorder(root);
		return this.max;
	}

	int max = 0;
	int currentLength = 0;

	public void preorder(TreeNode node) {

		if (node == null)
			return;

		currentLength++;

		if (node.left == null && node.right == null) {
			if (currentLength > max) {
				max = currentLength;
			}
		}

		preorder(node.left);

		preorder(node.right);

		currentLength--;

	}

	public void test() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);

		node1.left = node2;
		node1.right = node3;
//		node2.left = node4;
		
		int res = maxDepth(node1);
		System.out.println(res);

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