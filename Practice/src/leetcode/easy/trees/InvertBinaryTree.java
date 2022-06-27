package leetcode.easy.trees;

public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if(root == null)
			return root;

		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);

		root.left = right;
		root.right = left;
		return root;
	}

	public static void main(String[] args) {
		TreeNode leftnode = new TreeNode(71, new TreeNode(89) , new TreeNode(22));
		TreeNode rightnode = new TreeNode(71, new TreeNode(89) , new TreeNode(22));
		TreeNode node = new TreeNode(56, leftnode , rightnode);
		System.out.println(new InvertBinaryTree().invertTree(node));
	}

}
