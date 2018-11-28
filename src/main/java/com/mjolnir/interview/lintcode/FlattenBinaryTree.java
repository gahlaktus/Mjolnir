package com.mjolnir.interview.lintcode;

/**
 * @author huangzhibo
 * @date 01/03/2018
 */
public class FlattenBinaryTree {

    public void flatten(TreeNode root){
        if (root == null){
            return;
        }
        preOrderRecursionSolution(root);
    }
    private void preOrderRecursionSolution(TreeNode root){
        if (root == null){
            return;
        }
        TreeNode left = root.left;
        if (left != null){
            TreeNode tempRight = root.right;
            root.right = left;
            root.left = null;
            TreeNode tempLeft = left;
            while (tempLeft.right != null){
                tempLeft = tempLeft.right;
            }
            tempLeft.right = tempRight;
        }
        preOrderRecursionSolution(root.right);
    }

}
