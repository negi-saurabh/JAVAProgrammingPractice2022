package leetcode.easy.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreOrderTraversal {

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> listPreOrder = new ArrayList<>();

		if(root == null)
			return listPreOrder;

		listPreOrder.add(root.val);
		List<Integer> subListLeft = preorderTraversal(root.left);
		List<Integer> subListRight = preorderTraversal(root.right);
		listPreOrder.addAll(subListLeft);
		listPreOrder.addAll(subListRight);
		
		return listPreOrder;
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(56, new TreeNode(6) , new TreeNode(8));
		List<Integer> orderedList = preorderTraversal(node);
		for (int i = 0; i < orderedList.size(); i++) {
			System.out.println(orderedList.get(i));
		}
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
