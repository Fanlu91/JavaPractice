package com.fanlu.leetcode.binarytree;
// Source : https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
// Id     : 671
// Author : Fanlu Hai
// Date   : 2018-04-23
// Other  :
// Tips   :

import java.util.PriorityQueue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

// to do
public class SecondMinimumNodeInABinaryTree {

    public int findSecondMinimumValue(TreeNode root) {
        if (null==root || null==root.left)
            return -1;
        if (root.left.val==root.right.val){
            findSecondMinimumValue(root.left);
            findSecondMinimumValue(root.right);
        }
        return  root.left.val>root.right.val ? root.left.val: root.right.val;
    }

    PriorityQueue<Integer> queue = new PriorityQueue<>();

    public int findSecondMinimumValueThinkTooLess(TreeNode root) {
        preorderTraverse(root);

        if (queue.isEmpty() || queue.size() == 1)
            return -1;
        int min = queue.poll();
        System.out.println(min);
        while (!queue.isEmpty()) {
            int second = queue.poll();
            System.out.println(second);
            if (second == min) {
                continue;
            }
            return second;
        }
        return -1;
    }

    public void preorderTraverse(TreeNode node) {
        if (null == node)
            return;
        queue.add(node.val);
        preorderTraverse(node.left);
        preorderTraverse(node.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(5);
        TreeNode treeNode7 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(4);
        TreeNode treeNode9 = new TreeNode(4);
        TreeNode treeNode10 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;
        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;
        treeNode5.left = treeNode9;
        treeNode6.left = treeNode10;

        SecondMinimumNodeInABinaryTree secondMinimumNodeInABinaryTree = new SecondMinimumNodeInABinaryTree();
        secondMinimumNodeInABinaryTree.findSecondMinimumValue(treeNode1);
    }
}
