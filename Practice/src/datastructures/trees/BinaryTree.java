package datastructures.trees;

public class BinaryTree{
    Node root;
    public BinaryTree(int data){
        root = new Node(data);
    }

    BinaryTree(){
        root = null;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
    }

}

class Node{
    Node left, right;
    int data;
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}
