package leetcode.easy.trees;

public class PathSum {

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root == null && targetSum == 0)
			return true;
		return branchSum(root, root.val, targetSum);
	}
	private boolean branchSum(TreeNode node, int sum , int targetSum ) {
		if(sum == targetSum)
			return true;
		int LeftSum =0 , RightSum =0;

		if(node.left != null) {
			LeftSum = sum + node.left.val;
			if(branchSum(node.left, LeftSum, targetSum))
				return true;
		}
		if(node.right != null) {
			RightSum = sum + node.right.val;
			if(branchSum(node.right, RightSum, targetSum))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode leftnode = new TreeNode(1, new TreeNode(9) , new TreeNode(2));
		TreeNode rightnode = new TreeNode(4, new TreeNode(8) , new TreeNode(5));
		TreeNode node = new TreeNode(10, leftnode , rightnode);
		System.out.println(new PathSum().hasPathSum(node, 13));
	}

}
