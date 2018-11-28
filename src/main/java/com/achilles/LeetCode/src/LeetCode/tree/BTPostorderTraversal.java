package LeetCode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * Recursive solution is trivial, could you do it iteratively?
 * @author huang
 *	left --> right --> root
 */
public class BTPostorderTraversal {
	// reverse   root --> right --> left    just like preorder(but right -->left) brilliant
	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while(cur != null){
			list.addFirst(cur.val);
			if(cur.left != null){
				stack.push(cur.left);
			}
			cur = cur.right;
			if(cur == null && !stack.isEmpty()){
				cur = stack.pop();
			}
		}
		return list;
	    }
}
