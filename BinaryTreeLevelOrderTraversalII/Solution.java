package BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {

	Stack<ArrayList<TreeNode>> stack = new Stack<ArrayList<TreeNode>>();

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		if (root == null)
			return res;

		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		list.add(root);

		stack.push(list);

		while (true) {
			ArrayList<TreeNode> rootList = stack.peek();
			ArrayList<TreeNode> childList = new ArrayList<TreeNode>();
			for (int i = 0; i < rootList.size(); i++) {
				TreeNode currentRoot = rootList.get(i);
				if (currentRoot.left != null) {
					childList.add(currentRoot.left);
				}
				if (currentRoot.right != null) {
					childList.add(currentRoot.right);
				}
			}
			if (childList.size() == 0)
				break;
			stack.push(childList);
		}

		while (stack.size() > 0) {
			ArrayList<Integer> listInt= new ArrayList<Integer>();
			ArrayList<TreeNode> listNode= stack.pop();
			for(int i = 0 ; i <listNode.size() ; i++)
			{
				listInt.add(listNode.get(i).val);
			}
			res.add(listInt);
		}

		return res;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}