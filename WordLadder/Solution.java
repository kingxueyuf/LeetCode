package WordLadder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class Solution {

	public int ladderLength(String start, String end, HashSet<String> dict) {
		if (start == null || end == null || dict == null) {
			return 0;
		}

		String[] dictArr = new String[dict.size()];
		int i = 0;
		for (String str : dict) {
			dictArr[i] = str;
			// System.out.print(str + " ");
			i++;
		}

		ArrayDeque<Node> queue = new ArrayDeque<Node>();
		Node node = new Node(start, 1);
		queue.push(node);
		int steps = BFS(queue, dictArr, end, dict);
		return steps;
	}

	private int BFS(ArrayDeque<Node> queue, String[] arr, String end,
			HashSet<String> dict) {
		while (!queue.isEmpty()) {
			Node current = queue.pop();
			char[] cChArr = current.word.toCharArray();

			for (int i = 0; i < end.length(); i++) {
				char saved = cChArr[i];
				for (char c = 'a'; c < 'z'; c++) {
					cChArr[i] = c;
					String tmp = new String(cChArr);
					if (tmp.equals(current.word))
						continue;
					if (tmp.equals(end))
						return current.steps + 1;
					if (dict.contains(tmp)) {
						if (current.useTable.get(tmp) == null) {
							// haven't visited yet
							Node node = new Node(tmp, current.steps + 1);
							for (Map.Entry entry : current.useTable.entrySet()) {
								node.useTable.put((String) entry.getKey(), true);
							}
							node.useTable.put(tmp, true);
							queue.push(node);
						}
					}
				}
				cChArr[i] = saved;
			}
		}
		return 0;
	}

	public void test() {
		String start = "hot";
		String end = "dog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("cog");
		dict.add("dog");
		dict.add("tot");
		dict.add("hog");
		dict.add("hop");
		dict.add("pot");
		dict.add("dot");

		int res = this.ladderLength(start, end, dict);
		System.out.println(res);
	}

	class Node {
		String word;
		HashMap<String, Boolean> useTable;
		int steps;

		Node(String word, int steps) {
			this.word = word;
			this.useTable = new HashMap<String, Boolean>();
			this.steps = steps;
		}
	}

}