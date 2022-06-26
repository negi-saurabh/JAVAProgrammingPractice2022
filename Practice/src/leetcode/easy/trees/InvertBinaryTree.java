package leetcode.easy.trees;

public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if(root == null)
			return root;
		
		invertTree(root.left);
		invertTree(root.right);
		
		if(root.left != null && root.right != null)
		{
			int temp = root.left.val;
			root.left.val = root.right.val;
			root.right.val = temp;
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode leftnode = new TreeNode(71, new TreeNode(89) , new TreeNode(22));
		TreeNode rightnode = new TreeNode(71, new TreeNode(89) , new TreeNode(22));
		TreeNode node = new TreeNode(56, leftnode , rightnode);
		System.out.println(new InvertBinaryTree().invertTree(node));
	}

}
