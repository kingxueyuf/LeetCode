package PathSum;

public class Solution {

	int sum = 0;
	TreeNode root;

	public boolean hasPathSum(TreeNode root, int sum) {

		if (root == null)
			return false;
		if (root.left == null && root.right == null && root.val == sum)
			return true;
		this.sum = sum;
		this.root = root;
		preorder(root);

		return this.found;
	}

	int currentSum = 0;
	boolean found = false;
	TreeNode currentPointer;

	public void preorder(TreeNode node) {
		if (node != null)
			currentPointer = node;
		if (node == null) {
			if (currentPointer.left != null || currentPointer.right != null)
				return;
			if (currentSum == this.sum) {
				if (currentPointer != root)
					found = true;
			}
			return;
		}

		currentSum += node.val;
		// left
		preorder(node.left);

		currentPointer = node;

		// right
		preorder(node.right);

		currentSum -= node.val;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void test() {
		TreeNode root = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		root.left = right;

		boolean find = hasPathSum(root, 1);
		System.out.println(find);
	}

}
