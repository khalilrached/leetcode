package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfBinaryTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }
    public static class Solution{
        public static int maxDepth(TreeNode root){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            return 0;
        }
    }

    public static void main(String[] args) {

    }
}
