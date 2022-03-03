package hackerRank.Trees;

import java.util.Scanner;

public class HeightOfBinaryTree {

	public static int height(Node root) {

		// Write your code here.
		int height = 0;
		if(root == null || root.left == null || root.right ==  null)
			return 0;
		while(root.left!=null || root.right != null) {
			height++;
			if(root.left!=null)
				root.left = root.left.left;
			else
				root.right = root.right.right;
		}

		return height;
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
		scan.close();
		int height = height(root);
		System.out.println(height);
	}	
}

class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

