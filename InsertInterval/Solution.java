package InsertInterval;

import java.util.List;

/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
public class Solution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals == null)
			return null;
		if (newInterval == null)
			return intervals;
		boolean sFind = false;
		boolean eFind = false;
		boolean sIn = false;
		boolean eIn = false;
		int sPosition = 0;
		int ePosition = 0;
		for (int i = 0; i < intervals.size(); i++) {
			Interval item = intervals.get(i);
			if (!sFind) {
				if (newInterval.start < item.start) {
					sIn = false;
					sPosition = i;
					sFind = true;
				} else if (newInterval.start <= item.end) {
					sIn = true;
					sPosition = i;
					sFind = true;
				}
			}
			if (!eFind) {
				if (newInterval.end < item.start) {
					eIn = false;
					ePosition = i;
					eFind = true;
				} else if (newInterval.end <= item.end) {
					eIn = true;
					ePosition = i;
					eFind = true;
				}
			}
			if (sFind && eFind) {
				break;
			}
		}

		if (!sFind && !eFind) {
			intervals.add(newInterval);
			return intervals;
		}
		if (sFind && !eFind) {
			if (sIn) {
				int deleteAmount = intervals.size() - 1 - sPosition;
				for (int i = 0; i < deleteAmount; i++) {
					intervals.remove(sPosition + 1);
				}
				intervals.get(sPosition).end = newInterval.end;
				return intervals;
			} else {
				int deleteAmount = intervals.size() - sPosition;
				for (int i = 0; i < deleteAmount; i++) {
					intervals.remove(sPosition);
				}
				intervals.add(newInterval);
				return intervals;
			}
		}
		if (sIn && eIn) {
			if (!(sPosition == ePosition)) {
				int newEnd = intervals.get(ePosition).end;
				for (int i = 0; i < ePosition - sPosition; i++) {
					intervals.remove(sPosition + 1);
				}
				intervals.get(sPosition).end = newEnd;
				return intervals;
			} else
				return intervals;
		}
		if (sIn && !eIn) {
			for (int i = 0; i < ePosition - sPosition - 1; i++) {
				intervals.remove(sPosition + 1);
			}
			intervals.get(sPosition).end = newInterval.end;
			return intervals;
		}
		if (!sIn && eIn) {
			for (int i = 0; i < ePosition - sPosition; i++) {
				intervals.remove(sPosition);
			}
			intervals.get(sPosition).start = newInterval.start;
			return intervals;
		}
		if (!sIn && !eIn) {
			for (int i = 0; i < ePosition - sPosition; i++) {
				intervals.remove(sPosition);
			}
			intervals.add(sPosition, newInterval);
			return intervals;
		}
		return null;
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