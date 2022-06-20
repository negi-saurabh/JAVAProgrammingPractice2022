package leetcode.easy.trees;

public class MaximumDepthofBinaryTree {

	public int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		
		return Math.max(left+1, right+1);
	}

	public static void main(String[] args) {
		TreeNode leftnode = new TreeNode(3, new TreeNode(45) , new TreeNode(62));
		TreeNode rightnode = new TreeNode(71, new TreeNode(89) , new TreeNode(22));
		TreeNode node = new TreeNode(56, leftnode , rightnode);
		System.out.println(new MaximumDepthofBinaryTree().maxDepth(node));
	}

}
