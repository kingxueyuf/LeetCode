package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Solution {

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {

		if(candidates == null) return null;
		if(candidates.length == 0)return null;
		
		
		HashMap<Integer, HashSet<ArrayList<Integer>>> map = new HashMap<Integer, HashSet<ArrayList<Integer>>>();
		int c = 0;

		for (int i = 1; i <= target; i++) {
			HashSet<ArrayList<Integer>> newSet = new HashSet<ArrayList<Integer>>();
			for (int j = candidates.length - 1; j > -1; j--) {
				if (i - candidates[j] < 0)
					continue;
				else if (i - candidates[j] == 0) {
					ArrayList<Integer> list2 = new ArrayList<Integer>();
					list2.add(candidates[j]);
					newSet.add(list2);
				} else {
					HashSet<ArrayList<Integer>> set = map
							.get(i - candidates[j]);
					if (set == null)
						continue;
					else {

						Iterator<ArrayList<Integer>> iter = set.iterator();
						while (iter.hasNext()) {
							ArrayList<Integer> list = iter.next();
							ArrayList<Integer> newList = copyList(list);
							newList.add(candidates[j]);
							Collections.sort(newList);
							newSet.add(newList);
						}
					}
				}
			}
			map.put(i, newSet);
		}

		HashSet<ArrayList<Integer>> set = map.get(target);
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		Iterator<ArrayList<Integer>> iter = set.iterator();
		while (iter.hasNext()) {
			list.add(iter.next());
		}
		return list;
	}

	public ArrayList<Integer> copyList(ArrayList<Integer> list) {
		ArrayList<Integer> newList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			newList.add(list.get(i));
		}
		return newList;
	}

	public void test() {
		//{ 2, 3, 6, 7 }
		//{ 1 }
		int[] candidates = { 1};
		int target = 7;
		ArrayList<ArrayList<Integer>> list = combinationSum(candidates, target);
		for (int i = 0; i < list.size(); i++) {
			ArrayList<Integer> listN = list.get(i);
			for (int j = 0; j < listN.size(); j++) {
				System.out.print(listN.get(j));
			}
			System.out.println();
		}
		// System.out.println("here");
	}
}
