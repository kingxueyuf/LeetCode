package PopulatingNextRightPointersinEachNode;

/**
 * Definition for binary tree with next pointer. public class TreeLinkNode { int
 * val; TreeLinkNode left, right, next; TreeLinkNode(int x) { val = x; } }
 */
public class Solution {

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode node = root;
		if (node.left == null)
			return;
		node.left.next = node.right;
		node = node.left;
		while (node != null) {
			TreeLinkNode layerScanner = node;
			while (layerScanner != null) {
				if (layerScanner.left == null)
					return;
				layerScanner.left.next = layerScanner.right;
				if(layerScanner.next == null)
					break;
				layerScanner.right.next = layerScanner.next.left;
				layerScanner = layerScanner.next;
			}
			node = node.left;
		}
	}

	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
}
