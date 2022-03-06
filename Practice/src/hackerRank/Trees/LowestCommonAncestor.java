package hackerRank.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LowestCommonAncestor {
	
	
	public static Node lca(Node root, int v1, int v2) {
      	// Write your code here.
		
		if(root==null)
			return root;
		
		 if (root.data == v1 || root.data == v2)
	            return root;
		
		// check left
		Node valLeftNode = lca(root.left, v1, v2);
		// check right
		Node valRightNode = lca(root.right, v1, v2);
		
		if (valLeftNode!=null && valRightNode!=null)
            return root;
 
        // Otherwise check if left subtree or right subtree is LCA
        return (valLeftNode != null) ? valLeftNode : valRightNode;
		
    }
	
	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }	
}


