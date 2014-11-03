package CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Definition for undirected graph. class UndirectedGraphNode { int label;
 * List<UndirectedGraphNode> neighbors; UndirectedGraphNode(int x) { label = x;
 * neighbors = new ArrayList<UndirectedGraphNode>(); } };
 */
public class Solution {
	HashMap<UndirectedGraphNode, UndirectedGraphNode> oldToNew = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		ArrayList<UndirectedGraphNode> queue = new ArrayList<UndirectedGraphNode>();
		UndirectedGraphNode rootN = new UndirectedGraphNode(node.label);
		queue.add(node);
		oldToNew.put(node, rootN);
		int i = 0;
		while (i < queue.size()) {
			UndirectedGraphNode cR = queue.get(i);
			for (UndirectedGraphNode n : cR.neighbors) {
				if (!queue.contains(n)) {
					queue.add(n);
					UndirectedGraphNode newN = new UndirectedGraphNode(n.label);
					oldToNew.get(cR).neighbors.add(newN);
					oldToNew.put(n, newN);
					// newN.neighbors.add(oldToNew.get(cR));
				} else {
					// contain n;
					// if
					// (!oldToNew.get(cR).neighbors.contains(oldToNew.get(n))) {
					// has been created but no relation between cR' and n'
					oldToNew.get(cR).neighbors.add(oldToNew.get(n));
					// oldToNew.get(n).neighbors.add(oldToNew.get(cR));
					// }
				}
			}
			i++;
		}
		return oldToNew.get(node);
	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};
