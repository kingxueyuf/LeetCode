package WordLadder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

public class Solution_Better {
	public int ladderLength(String start, String end, Set<String> dict) {
		if (dict.size() == 0)
			return 0;

		Deque<String> queue_word = new LinkedList<String>();
		Deque<Integer> queue_counter = new LinkedList<Integer>();

		queue_word.addFirst(start);
		queue_counter.addFirst(1);
		dict.add(end);

		while (!queue_word.isEmpty()) {
			String trial_word = queue_word.pollFirst();
			int count = queue_counter.pollFirst();
			if (trial_word.equals(end))
				return count;
			for (int i = 0; i < trial_word.length(); i++) {
				char array[] = trial_word.toCharArray();
				for (array[i] = 'a'; array[i] <= 'z'; array[i]++) {
					String test = new String(array);
					if (dict.contains(test)) {
						queue_word.addLast(test);
						queue_counter.addLast(count + 1);
						dict.remove(test);
					}
				}
			}
		}
		return 0;
	}

}
