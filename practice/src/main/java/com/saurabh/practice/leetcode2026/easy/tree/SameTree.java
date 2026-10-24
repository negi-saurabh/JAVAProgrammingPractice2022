package com.saurabh.practice.leetcode2026.easy.tree;

public class SameTree {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;

        if(p == null || q == null)
            return false;

        if(p.val != q.val)
            return false;


        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return left == false || right == false  ? false : true;
    }

    public static void main(String[] args) {
        TreeNode parent1 = new TreeNode(1);
        parent1.left = new TreeNode(2);

        TreeNode parent2 = new TreeNode(1);
        parent2.left = null;
        parent1.right = new TreeNode(2);

        new SameTree().isSameTree(parent1, parent2);
    }
}
