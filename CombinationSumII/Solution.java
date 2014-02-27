package CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Solution {

	int[] num;
	int target;
	HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {

		if (num == null)
			return null;
		if (num.length == 0)
			return null;

		Arrays.sort(num);
		this.num = num;
		this.target = target;

		ArrayList<Integer> listTemp = new ArrayList<Integer>();
		dfs(0, listTemp);

		Iterator<ArrayList<Integer>> iter = set.iterator();
		while (iter.hasNext()) {
			ArrayList<Integer> listP = iter.next();
			list.add(listP);
		}

		return this.list;
	}

	int sum = 0;

	public void dfs(int index, ArrayList<Integer> temp) {
		if (index == num.length)
			return;

		sum += num[index];
		if (sum > this.target) {
			sum = sum - num[index];
			return;
		} else {
			temp.add(num[index]);
			if (sum == this.target) {
				ArrayList<Integer> copyList = copyList(temp);
				set.add(copyList);
				temp.remove(temp.size() - 1);
				sum = sum - num[index];
				return;
			}
			dfs(index + 1, temp);
			temp.remove(temp.size() - 1);
			sum = sum - num[index];
			dfs(index + 1, temp);

		}
	}

	private ArrayList<Integer> copyList(ArrayList<Integer> temp) {
		// TODO Auto-generated method stub

		ArrayList<Integer> newList = new ArrayList<Integer>();
		for (int i = 0; i < temp.size(); i++) {
			newList.add(temp.get(i));
		}
		return newList;
	}

	public void test() {
		int[] numT = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		ArrayList<ArrayList<Integer>> list = combinationSum2(numT, target);
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j));
			}
			System.out.println();
		}
	}
}
