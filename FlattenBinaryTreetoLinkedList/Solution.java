package FlattenBinaryTreetoLinkedList;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
       	recursion(root);
    }

    private TreeNode recursion(TreeNode node){
    	if(node == null)
    		return null;
    	TreeNode tmpRight = node.right;
    	tmpRight = recursion(tmpRight);
    	node.right = recursion(node.left);
    	TreeNode pointer = node;
    	while(pointer.right != null)
    	{
    		pointer = pointer.right;
    	}
    	pointer.right = tmpRight;
   		return node;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}