package com.fanlu.leetcode.binarytree;
// Source : https://leetcode.com/problems/minimum-distance-between-bst-nodes/
// Id     : 783
// Author : Fanlu Hai
// Date   : 2018-04-26
// Other  :
// Tips   :

public class MinimumDistanceBetweenBSTNodes {
    int min = Integer.MAX_VALUE;

    //
    public int minDiffInBST(TreeNode root) {

        return min;
    }


    //! only considered connected nodes. but its any given nodes in the description
    // And I didn't even think about the bst thing,
    // I treated it as an ordaniry btree which is highly likely to be wrong, at least inefficient.
    public int minDiffInBSTWrongAnswer(TreeNode root) {
        dfsWrongAnswer(root);
        return min;
    }

    public void dfsWrongAnswer(TreeNode root) {
        if (root == null) {
            return;
        }

        //left null
        if (root.left == null) {
            // right null
            if (root.right == null) {
                return;
            }
            // right has
            if (min - Math.abs(root.val - root.right.val) > 0)
                min = Math.abs(root.val - root.right.val);
            dfsWrongAnswer(root.right);
        } else {
            //left has
            if (min - Math.abs(root.val - root.left.val) > 0) {
                min = Math.abs(root.val - root.left.val);
            }
            dfsWrongAnswer(root.left);
            // right null
            if (root.right == null) {
                return;
            }
            //right has
            if (min - Math.abs(root.val - root.right.val) > 0)
                min = Math.abs(root.val - root.right.val);
            dfsWrongAnswer(root.right);
        }
        dfsWrongAnswer(root.right);
    }
}
