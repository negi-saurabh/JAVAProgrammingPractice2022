package leetcode.easy.trees;

import java.util.List;

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		if(root.left.val != root.right.val)
			return false;
		else {
			isSymmetric(root.left);
			isSymmetric(root.right);
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode leftnode = new TreeNode(3, new TreeNode(45) , new TreeNode(62));
		TreeNode rightnode = new TreeNode(71, new TreeNode(89) , new TreeNode(22));
		TreeNode node = new TreeNode(56, leftnode , rightnode);
		System.out.println(new SymmetricTree().isSymmetric(node));
	}

}
