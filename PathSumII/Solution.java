package PathSumII;

import java.util.ArrayList;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {

	int sum = 0;
	ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {

		if (root == null)
			return arr;
		
		this.sum = sum;
		preorder(root);
		return arr;
	}

	ArrayList<Integer> arrTemp = new ArrayList<Integer>();

	public boolean preorder(TreeNode node) {
		if (node == null) {
			return true;
		}
		arrTemp.add(node.val);

		boolean left = preorder(node.left);

		boolean right = preorder(node.right);

		if (left && right) {
			int tempSum = 0;
			for (int i = 0; i < arrTemp.size(); i++) {
				tempSum += arrTemp.get(i);
			}
			if (this.sum == tempSum) {
				ArrayList<Integer> copyArr = copyArrayList(arrTemp);
				arr.add(copyArr);
			}
		}
		arrTemp.remove(arrTemp.size() - 1);
		return false;
	}

	public ArrayList<Integer> copyArrayList(ArrayList<Integer> arr) {
		ArrayList<Integer> arrCopy = new ArrayList<Integer>();
		for (int i = 0; i < arr.size(); i++) {
			arrCopy.add(arr.get(i));
		}
		return arrCopy;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}