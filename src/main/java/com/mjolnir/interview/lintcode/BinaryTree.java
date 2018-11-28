package com.mjolnir.interview.lintcode;

import java.util.Stack;

/**
 * 前序遍历：根节点->左子树->右子树
 * 中序遍历：左子树->根节点->右子树
 * 后序遍历：左子树->右子树->根节点
 * @author huangzhibo
 * @date 01/03/2018
 */
public class BinaryTree {

    private TreeNode max = null;

    public TreeNode maxNode(TreeNode root) {
        if (root == null){
            return max;
        }
        preOrderRecursionSolution(root);
        return max;
    }

    private void preOrderRecursionSolution(TreeNode root){
        if (root == null){
            return;
        }
        if (max == null || root.val > max.val){
            max = root;
        }
        preOrderRecursionSolution(root.left);
        preOrderRecursionSolution(root.right);
    }

    private void preOrderTraversalSolution(TreeNode root){

        if (root == null){
            return;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()){
            TreeNode cur = nodeStack.pop();
            if (cur != null){
                if (max == null || cur.val > max.val){
                    max = cur;
                }
                nodeStack.push(cur.right);
                nodeStack.push(cur.left);
            }
        }
    }

    private void visit(TreeNode node){
        System.out.print(node.val+" ");
    }

    /**
     * 递归实现前序遍历
     * @param root
     */
    private void preOrderRecursion(TreeNode root){
        if (root == null){
            return;
        }
        visit(root);
        preOrderRecursion(root.left);
        preOrderRecursion(root.right);
    }

    /**
     * 非递归实现前序遍历
     * @param root
     */
    private void preOrderTraversal(TreeNode root){

        //List<TreeNode> nodeList = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();

        if (root == null){
            return;
        }
        nodeStack.push(root);
        while (!nodeStack.isEmpty()){
            TreeNode cur = nodeStack.pop();
            if (cur != null){
                //nodeList.add(cur);
                visit(cur);
                nodeStack.push(cur.right);
                nodeStack.push(cur.left);
            }
        }
    }



}
