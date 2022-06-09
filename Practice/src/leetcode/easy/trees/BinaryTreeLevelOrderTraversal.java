package leetcode.easy.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

	List<List<Integer>> levelOrderlist = new ArrayList<>();
	public List<List<Integer>> levelOrder(TreeNode root) {

		for (int i = 1; i <= height(root); i++) {
			List<Integer> eachlevel = getLevelList(root, i);
			levelOrderlist.add(eachlevel);
		}
		return levelOrderlist;
	}

	List<Integer> getLevelList(TreeNode node, int level){
		List<Integer> eachlevel = new ArrayList<Integer>();
		if(node == null)
			return eachlevel;
		
		if( level == 1) {
			eachlevel.add(node.val);
			return eachlevel;
		}
		if( level > 1) {
			List<Integer> eachLeftlevel = getLevelList(node.left, level - 1);
			List<Integer> eachRightlevel= getLevelList(node.right, level - 1);
			eachlevel.addAll(eachLeftlevel);
			eachlevel.addAll(eachRightlevel);
		}
		return eachlevel;
	}

	int height(TreeNode root) {
		if(root == null)
			return 0;
		else {
			int subLeftHeight = height(root.left);
			int subRightHeight = height(root.right);
			return Math.max(subLeftHeight+1, subRightHeight+1);
		}
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
