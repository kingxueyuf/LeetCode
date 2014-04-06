package MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
public class Solution {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

		if (intervals == null) {
			return null;
		}
		if (intervals.size() == 0) {
			return new ArrayList<Interval>();
		}

		// bubble sort *** two slow
		// sortIntervalsByBubble(intervals);
		sortIntervalsByCollection(intervals);
		int start = 0;
		int i = 1;

		Interval current = intervals.get(start);
		int cRight = current.end;
		while (i < intervals.size()) {
			Interval next = intervals.get(i);
			if (cRight < next.start) {
				for (int a = 0; a < i - start - 1; a++) {
					intervals.remove(start + 1);
				}
				intervals.get(start).end = cRight;
				start = start + 1;
				i = start + 1;
				cRight = intervals.get(start).end;
			} else if (cRight >= next.start && cRight <= next.end) {
				int tmpEnd = next.end;
				for (int a = 0; a < i - start; a++) {
					intervals.remove(start + 1);
				}
				intervals.get(start).end = tmpEnd;
				i = start + 1;
				cRight = tmpEnd;
			} else if (cRight > next.end) {
				i++;
			}
		}
		if (start < intervals.size() - 1) {
			for (int a = 1; a < i - start; a++) {
				intervals.remove(start + 1);
			}
		}

		return intervals;
	}

	public void sortIntervalsByBubble(ArrayList<Interval> intervals) {
		for (int i = 0; i < intervals.size() - 1; i++) {
			if (intervals.get(i).start > intervals.get(i + 1).start) {
				swap(intervals, i, i + 1);
				for (int j = i; j > 0; j--) {
					if (intervals.get(j - 1).start > intervals.get(j).start)
						swap(intervals, j, j - 1);
					else
						break;
				}
			}
		}
	}

	public void swap(ArrayList<Interval> intervals, int i, int j) {
		Interval temp = intervals.get(i);
		intervals.set(i, intervals.get(j));
		intervals.set(j, temp);
	}

	public void sortIntervalsByCollection(ArrayList<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval int1, Interval int2) {
				return int1.start - int2.start;
			}
		});
	}

	public void test() {
		ArrayList<Interval> list = new ArrayList<Interval>();
		Interval three = new Interval(8, 14);
		Interval two = new Interval(2, 26);
		Interval one = new Interval(2, 5);
		Interval four = new Interval(15, 18);
		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);

		this.merge(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).start + "," + list.get(i).end + " ");
		}
	}

	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}