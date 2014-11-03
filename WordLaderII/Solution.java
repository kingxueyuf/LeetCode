package WordLaderII;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
	boolean find = false;
	int minD = 0;

	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		List<List<String>> res = new ArrayList<List<String>>();
		Node node = new Node(start);
		node.list.add(start);
		node.depth = 1;
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(node);
		// bfs
		while (queue.size() > 0) {
			Node n = queue.remove();
			if (canTrans(n.word, end)) {
				if (find) {
					if (minD == n.depth)
						res.add(n.list);
					else
						break;
				} else {
					find = true;
					minD = n.depth;
				}
			} else {
				Iterator<String> iter= dict.iterator();
				while(iter.hasNext()){
					String s = iter.next();
					if (canTrans(n.word, s)) {
						Node newN = new Node(s);
						newN.depth = n.depth + 1;
						copyList(n.list, newN.list);
						newN.list.add(s);
						iter.remove();
						queue.add(newN);
					}
				}
			}
		}

		return res;
	}

	private void copyList(ArrayList<String> list, ArrayList<String> list2) {
		// TODO Auto-generated method stub
		for (String s : list) {
			list2.add(s);
		}
	}

	private boolean canTrans(String word, String s) {
		// TODO Auto-generated method stub
		int diff = 0;
		if (word.length() != s.length())
			return false;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) != s.charAt(i))
				diff++;
		}
		if (diff != 1)
			return false;
		return true;

	}
}

class Node {
	int depth;
	String word;
	ArrayList<String> list;

	Node(String word) {
		this.word = word;
		list = new ArrayList<String>();
	}
}
