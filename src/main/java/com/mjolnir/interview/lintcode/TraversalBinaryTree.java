package com.mjolnir.interview.lintcode;
import java.util.*;

/**
 * @author huangzhibo
 * @date 06/03/2018
 */
public class TraversalBinaryTree {

    /**
     * 前序遍历：根节点->左子树->右子树
     *
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preOrderTraversal(TreeNode root) {

        if (root == null) {
            return null;
        }
        List<Integer> nodeList = new ArrayList<>();
        Stack<TreeNode> tempStack = new Stack<>();
        tempStack.push(root);
        while (!tempStack.isEmpty()) {
            TreeNode cur = tempStack.pop();
            if (cur != null) {
                nodeList.add(cur.val);
                tempStack.push(cur.right);
                tempStack.push(cur.left);
            }
        }
        return nodeList;
    }

    List<Integer> nodeList = new ArrayList<>();

    /**
     * 递归前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderRecursive(TreeNode root) {

        if (root == null) {
            return nodeList;
        }
        nodeList.add(root.val);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
        return nodeList;
    }

    public List<Integer> inOrderRecursive(TreeNode root) {

        if (root == null) {
            return nodeList;
        }

        inOrderRecursive(root.left);
        nodeList.add(root.val);
        inOrderRecursive(root.right);

        return nodeList;
    }

    /**
     * 中序遍历：左子树->根节点->右子树
     *
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inOrderTraversal(TreeNode root) {

        List<Integer> visitedList = new ArrayList<>();
        // 保存已访问的节点
        Map<TreeNode, Integer> visitedNodeMap = new HashMap<>();
        Stack<TreeNode> tempStack = new Stack<>();
        if (root == null) {
            return visitedList;
        }
        tempStack.push(root);
        while (!tempStack.isEmpty()) {
            TreeNode cur = tempStack.peek();
            while (cur.left != null) {
                if (visitedNodeMap.get(cur.left) != null) {
                    break;
                }
                tempStack.push(cur.left);
                cur = cur.left;
            }
            cur = tempStack.pop();
            visitedList.add(cur.val);
            visitedNodeMap.put(cur, 1);
            if (cur.right != null) {
                tempStack.push(cur.right);
            }
        }
        return visitedList;
    }

    public List<Integer> inOrderTraversal1(TreeNode root) {

        List<Integer> visitedList = new ArrayList<>();
        if (root != null) {

            Stack<TreeNode> tempStack = new Stack<>();

            while (!tempStack.isEmpty() || root != null) {
                if (root != null) {
                    tempStack.add(root);
                    root = root.left;
                } else {
                    root = tempStack.pop();
                    visitedList.add(root.val);
                    root = root.right;
                }
            }

        }
        return visitedList;
    }

    /**
     * 非递归实现中序遍历
     */
    public void inOrderUnRecur(TreeNode root) {


        if (root != null) {
            Stack<TreeNode> tempStack = new Stack<>();
            while (!tempStack.isEmpty() || root != null) {

                if (root != null) {
                    tempStack.push(root);
                    root = root.left;
                } else {
                    root = tempStack.pop();
                    System.out.println(root.val);
                    root = root.right;
                }

            }
        }

        System.out.println("over");

    }

    /**
     * 后序遍历：左子树->右子树->根节点
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> visitedList = new ArrayList<>();

        if (root != null) {

            Stack<TreeNode> tempStack = new Stack<>();
            Stack<TreeNode> postStack = new Stack<>();
            tempStack.push(root);
            while (!tempStack.isEmpty()) {
                root = tempStack.pop();
                postStack.add(root);
                if (root.left != null) {
                    tempStack.push(root.left);
                }
                if (root.right != null) {
                    tempStack.push(root.right);
                }
            }

            while (!postStack.isEmpty()){
                visitedList.add(postStack.pop().val);
            }
        }

        return visitedList;
    }

    public void postOrderUnRecur(TreeNode head) {


        if (head != null) {

            Stack<TreeNode> tempStack = new Stack<>();
            Stack<TreeNode> postStack = new Stack<>();

            tempStack.push(head);

            while (!tempStack.isEmpty()) {

                head = tempStack.pop();
                postStack.push(head);

                if (head.left != null) {
                    tempStack.push(head.left);
                }
                if (head.right != null) {
                    tempStack.push(head.right);
                }

            }

            while (!postStack.isEmpty()) {
                System.out.println(postStack.pop() + "-");
            }

        }

    }

    public void postOrderUnRecur1(TreeNode head) {


       if (head != null){

           Stack<TreeNode> tempStack = new Stack<>();
           tempStack.push(head);
           TreeNode cur;
           while (!tempStack.isEmpty()){
               cur = tempStack.peek();
               if (cur.left != null && head != cur.left && head != cur.right){
                   tempStack.push(cur.left);
               }
               else if (cur.right != null && head != cur.right){
                   tempStack.push(cur.right);
               }
               else {
                   System.out.println(tempStack.pop()+"-");
                   head = cur;
               }
           }
       }

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here

        List<List<Integer>> valNode = new ArrayList<>();

        Stack<TreeNode> pre = new Stack<>();
        Stack<TreeNode> next = new Stack<>();

        pre.push(root);
        if (root != null){

            List<Integer> curList = new ArrayList<>();

            while (!pre.isEmpty()){

                TreeNode cur = pre.pop();

                if (cur != null){
                    curList.add(cur.val);
                    if (cur.right != null){
                        next.push(cur.right);
                    }
                    if (cur.left != null){
                        next.push(cur.left);
                    }
                }

                if (pre.isEmpty()){
                    pre = next;
                    next = new Stack<>();
                    valNode.add(curList);
                    curList = new ArrayList<>();
                }
            }

        }
        else {
            return valNode;
        }

        valNode.remove(valNode.size()-1);
        return valNode;

    }


    public List<List<Integer>> levelOrder1(TreeNode root) {
        // write your code here

        TreeNode last = root;
        TreeNode nLast = null;

        List<List<Integer>> valNode = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> curList = new ArrayList<>();

        if (root == null){
            return valNode;
        }

        while (!queue.isEmpty()){
            root = queue.poll();
            curList.add(root.val);
            if (root.left != null){
                queue.offer(root.left);
                nLast = root.left;
            }
            if (root.right != null){
                queue.offer(root.right);
                nLast = root.right;
            }
            if (root == last){
                if (!curList.isEmpty()){
                    valNode.add(curList);
                    curList = new ArrayList<>();
                }
                last = nLast;
            }
        }
        return valNode;

    }


    public int maxDepth(TreeNode root){

        int depth = 0;
        if (root == null){
            return depth;
        }

        TreeNode last = root;
        TreeNode nLast = null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        depth++;
        while (!queue.isEmpty()){
            root = queue.poll();
            if (root.left != null){
                queue.offer(root.left);
                nLast = root.left;
            }
            if (root.right != null){
                queue.offer(root.right);
                nLast = root.right;
            }
            if (root == last){
                depth++;
                last = nLast;
            }
        }
        return depth;
    }

}
