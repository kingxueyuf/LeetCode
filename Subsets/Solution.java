package Subsets;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	int[] arr;
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		if (S == null)
			return res;
		if (S.length == 0)
			return res;
		arr = S;
		Arrays.sort(arr);
		preorder(0);
		return res;
	}

	ArrayList<Integer> arrT = new ArrayList<Integer>();

	public void preorder(int index) {
		if (index == arr.length) {
			ArrayList<Integer> arrCopy = duplicate(arrT);
			res.add(arrCopy);
			return;
		}
		// add it
		arrT.add(arr[index]);

		preorder(index + 1);

		arrT.remove(arrT.size() - 1);

		preorder(index + 1);
		
	}

	private ArrayList<Integer> duplicate(ArrayList<Integer> arrT2) {
		// TODO Auto-generated method stub
		ArrayList<Integer> copyArr = new ArrayList<Integer>();
		for (int i = 0; i < arrT2.size(); i++) {
			copyArr.add(arrT2.get(i));
		}
		return copyArr;
	}
}
