package TextJustification;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<String>();
		int width = 0;
		int start = 0;
		int i = 0;
		while (i < words.length) {
			if (i != start)
				width++;
			width += words[i].length();
			if (width >= maxWidth) {
				if (width == maxWidth) {
					justify(res, start, i, words, maxWidth);
					i++;
				} else {
					justify(res, start, i - 1, words, maxWidth);
				}
				start = i;
				width = 0;
			} else {
				i++;
			}
		}
		// last line
		if (start == i)
			return res;
		StringBuilder sb = new StringBuilder();
		sb.append(words[start]);
		start++;
		for (; start < i; start++) {
			sb.append(" ");
			sb.append(words[start]);
		}
		res.add(sb.append(generateSpace(maxWidth - width)).toString());
		return res;
	}

	private void justify(List<String> res, int start, int end, String[] words, int maxWidth) {
		int len = 0;
		for (int i = start; i <= end; i++) {
			len += words[i].length();
		}
		int slot = end - start;
		if (slot == 0) {
			// single word case
			res.add(words[start] + generateSpace(maxWidth - words[start].length()));
			return;
		}
		int slotSpace = maxWidth - len;
		if (slotSpace % slot == 0) {
			// evenly
			String space = generateSpace(slotSpace / slot);
			String row = generateOneRow(words, start, end, space);
			res.add(row);
		} else {
			// at least 2 slots
			// the space between 1st and 2nd is 1 more than others
			String space = generateSpace(slotSpace / slot);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < slotSpace % slot; i++) {
				sb.append(words[start]);
				sb.append(space + " ");
				start++;
			}
			String row = generateOneRow(words, start, end, space);
			res.add(sb.append(row).toString());
		}
	}

	private String generateOneRow(String[] words, int start, int end, String space) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(words[start]);
		for (int i = start + 1; i <= end; i++) {
			sb.append(space);
			sb.append(words[i]);
		}
		return sb.toString();
	}

	private String generateSpace(int i) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < i; j++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		String[] sArr = new String[] { "This", "is", "an", "example", "of", "text", "justification." };
		String[] sArr1 = new String[] { "a", "b", "c", "d", "e" };
		String[] sArr2 = new String[] { "Listen", "to", "many,", "speak", "to", "a", "few." };
		String[] sArr3 = new String[] { "" };
		String[] sArr4 = new String[] { "a" };
		String[] sArr5 = new String[] { "What", "must", "be", "shall", "be." };
		String[] sArr6 = new String[] { "Here", "is", "an", "example", "of", "text", "justification." };
		String[] sArr7 = new String[] { "Don't", "go", "around", "saying", "the", "world", "owes", "you", "a",
				"living;", "the", "world", "owes", "you", "nothing;", "it", "was", "here", "first." };
		List<String> list = s.fullJustify(sArr7, 30);
		for (String str : list) {
			System.out.println("/" + str + "/");
		}
	}
}
