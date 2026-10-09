package com.saurabh.practice.leetcode2026.easy.tree;

public class BinaryTreeMaxDepth {
    int maxDepth = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right ==null)
            return 1;

        int leftDepth = maxDepth(root.left)+1;
        int rightDepth = maxDepth(root.right)+1;
        return Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        new BinaryTreeMaxDepth().maxDepth(root);
    }

    private static class TreeNode {
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

