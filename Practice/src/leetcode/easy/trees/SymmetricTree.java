package leetcode.easy.trees;

import java.util.List;

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		return check(root,root);
	}
	private boolean check(TreeNode root1,TreeNode root2){
		if(root1==null || root2==null){
			return root1==root2;
		}
		return root1.val==root2.val && check(root1.left,root2.right) && check(root1.right,root2.left);
	}

	public static void main(String[] args) {
		TreeNode leftnode = new TreeNode(71, new TreeNode(89) , new TreeNode(22));
		TreeNode rightnode = new TreeNode(71, new TreeNode(89) , new TreeNode(22));
		TreeNode node = new TreeNode(56, leftnode , rightnode);
		System.out.println(new SymmetricTree().isSymmetric(node));
	}

}
