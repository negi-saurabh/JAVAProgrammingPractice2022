package leetcode.easy.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

	List<Integer> inorderList = new ArrayList<Integer>();
	public List<Integer> inorderTraversal(TreeNode root) {
		
		if(root == null)
			return inorderList;
		
		inorderTraversal(root.left);
		inorderList.add(root.val);
		inorderTraversal(root.right);
		
		return inorderList;
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(56, new TreeNode(6) , new TreeNode(8));
		List<Integer> orderedList = new BinaryTreeInorderTraversal().inorderTraversal(node);
		for (int i = 0; i < orderedList.size(); i++) {
			System.out.println(orderedList.get(i));
		}
	}
}
