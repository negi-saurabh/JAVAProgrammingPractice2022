package com.saurabh.practice.leetcode2026.easy.tree;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        swapNode(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swapNode(TreeNode root){
        int temp;
        TreeNode tempNode;
        tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
