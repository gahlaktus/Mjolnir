package com.stark.datastructure.tree;

import java.util.LinkedList;

/**
 * @author huangzhibo
 * @date 2019/6/24
 */
public class TreeVisitDemo {

    /**
     * 递归实现
     * 前序遍历：root -> left -> right
     *
     * @param root 二叉树根节点
     */
    public static void preOrderTraverseRecursively(TreeNode root) {
        if (root != null) {
            // do something...
            System.out.println(root.getVal());
            preOrderTraverseRecursively(root.left);
            preOrderTraverseRecursively(root.right);
        }

    }

    /**
     * 非递归实现前序遍历
     * @param root 二叉树根节点
     */
    public static void preOrderTraverseNonRecursively(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            if (curNode != null) {
                // do something...
                System.out.println(curNode.getVal());
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                curNode = stack.pop().getRight();
            }
        }
    }

    /**
     * 递归实现
     * 中序遍历：left -> root -> right
     * @param root 二叉树根节点
     */
    public static void inOrderTraverseRecursively(TreeNode root){
        if (root != null){
            inOrderTraverseRecursively(root.left);
            // do something
            System.out.println(root.getVal());
            inOrderTraverseRecursively(root.right);
        }
    }

    public static void inOrderTraverseNonRecursively(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curNode = root;

        while (curNode != null || !stack.isEmpty()){
            if (curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                curNode = stack.pop();
                // do something...
                System.out.println(curNode.getVal());
                curNode = curNode.right;
            }
        }
    }
}
