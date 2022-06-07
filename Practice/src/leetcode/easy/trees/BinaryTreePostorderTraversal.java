package leetcode.easy.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
	
	List<Integer> postOrderList = new ArrayList<Integer>();
	public List<Integer> postOrderTraversal(TreeNode root) {
		
		if(root == null)
			return postOrderList;
		
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		postOrderList.add(root.val);
		
		return postOrderList;
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(56, new TreeNode(6) , new TreeNode(8));
		List<Integer> orderedList = new BinaryTreePostorderTraversal().postOrderTraversal(node);
		for (int i = 0; i < orderedList.size(); i++) {
			System.out.println(orderedList.get(i));
		}
	}

}
