package PopulatingNextRightPointersinEachNodeII;

public class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode node = root;
		if (node.left != null) {
			node.left.next = node.right;
			node = node.left;
		} else {
			if (node.right != null)
				node = node.right;
			else
				return;
		}
		while (node != null) {
			TreeLinkNode layerScanner = node;
			TreeLinkNode current = null;
			while (current == null && layerScanner != null) {
				if (layerScanner.left != null)
					current = layerScanner.left;
				else if (layerScanner.right != null)
					current = layerScanner.right;
				else
					layerScanner = layerScanner.next;
			}
			if (layerScanner == null)
				return;
			node = current;

			if (current == layerScanner.right)
				layerScanner = layerScanner.next; 

			while (current != null && layerScanner != null) {
				if (layerScanner.left != null && layerScanner.left != current) {
					current.next = layerScanner.left;
					current = current.next;
				} else if (layerScanner.right != null
						&& layerScanner.right != current) {
					current.next = layerScanner.right;
					current = current.next;
					layerScanner = layerScanner.next;
				} else {
					layerScanner = layerScanner.next;
				}
			}
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
