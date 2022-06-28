package leetcode.easy.trees;

public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
 
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> values = new LinkedList<Integer>();
 
        nodes.add(root);
        values.add(root.val);
 
        while(!nodes.isEmpty()){
            TreeNode curr = nodes.poll();
            int sumValue = values.poll();
 
            if(curr.left == null && curr.right == null && sumValue==sum){
                return true;
            }
 
            if(curr.left != null){
                nodes.add(curr.left);
                values.add(sumValue+curr.left.val);
            }
 
            if(curr.right != null){
                nodes.add(curr.right);
                values.add(sumValue+curr.right.val);
            }
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
