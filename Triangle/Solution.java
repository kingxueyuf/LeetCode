package Triangle;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		LinkedList<Node> queue = new LinkedList<Node>();
		int min = Integer.MIN_VALUE;
		// bfs
		Node root = new Node();
		root.rowNum = 0;
		root.index = 0;
		root.total = triangle.get(0).get(0);
		queue.add(root);
		while (queue.size() > 0) {
			Node c = queue.remove();
			if (c.rowNum == triangle.size() - 1) {
				if (c.total < min)
					min = c.total;
				continue;
			}
			// add left
			Node left = new Node();
			left.rowNum = c.rowNum + 1;
			left.index = c.index;
			left.total = c.total + triangle.get(left.rowNum).get(left.index);
			queue.add(left);
			// add right
			Node right = new Node();
			right.rowNum = c.rowNum + 1;
			right.index = c.index + 1;
			right.total = c.total + triangle.get(right.rowNum).get(right.index);
			queue.add(right);
		}
		return min;
	}
}

class Node {
	int rowNum;
	int index;
	int total;
}