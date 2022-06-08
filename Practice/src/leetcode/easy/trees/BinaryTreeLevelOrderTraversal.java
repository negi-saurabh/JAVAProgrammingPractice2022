package leetcode.easy.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

	List<List<Integer>> levelOrderlist = new ArrayList<>();
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<Integer> listPerLevel = new ArrayList<Integer>();
		
		if( root == null)
			return levelOrderlist;
		
		listPerLevel.add(root.val);
		
		System.out.println("Test");
		
		return null;
	}

	public static void main(String[] args) {
		TreeNode leftnode = new TreeNode(3, new TreeNode(45) , new TreeNode(62));
		TreeNode rightnode = new TreeNode(71, new TreeNode(89) , new TreeNode(22));
		TreeNode node = new TreeNode(56, leftnode , rightnode);
		List<List<Integer>>  orderedList = new BinaryTreeLevelOrderTraversal().levelOrder(node);
		for (int i = 0; i < orderedList.size(); i++) {
			System.out.println(orderedList.get(i));
		}
	}

}
