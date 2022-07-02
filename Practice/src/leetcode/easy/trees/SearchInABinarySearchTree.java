package leetcode.easy.trees;

public class SearchInABinarySearchTree {

	public TreeNode searchBST(TreeNode root, int val) {
		
		while(root != null)
		{
			if(val == root.val) {
				return root;
			}
		}
		return root;
	}


	public static void main(String[] args) {
		TreeNode leftnode = new TreeNode(2, new TreeNode(1) , new TreeNode(3));
		TreeNode rightnode = new TreeNode(7, null, null);
		TreeNode node = new TreeNode(4, leftnode , rightnode);
		System.out.println(new SearchInABinarySearchTree().searchBST(node, 2));
	}

}
