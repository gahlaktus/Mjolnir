package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * Recursive solution is trivial, could you do it iteratively?
 * @author huang
 *	
 * root --> left --> right
 */
public class BTPreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		//check cur
	        /*List<Integer> list = new ArrayList<Integer>();
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        TreeNode cur = root;
	        while(cur != null){
	        	list.add(cur.val);
	        	if(cur.right != null){
	        		stack.push(cur.right);
	        	}
	        	cur = cur.left;
	        	if(cur == null && !stack.isEmpty()){
	        		cur = stack.pop();
	        	}
	        }*/
		
		//check stack
		//ÿ�ζ�Ҫ�����������Ž�ջ���棬�ռ�ռ���ʴ󡣣�����Ҫ������null�Ž�ȥ�� �˷����Ƽ���
			/*List<Integer> list = new ArrayList<Integer>();
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(root);
			while(!stack.isEmpty()){
				TreeNode node = stack.pop();
				if(node != null){
					list.add(node.val);
					stack.push(node.right);
					stack.push(node.left);
				}
			}*/
		
			List<Integer> list = new ArrayList<Integer>();
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        TreeNode cur = root;
	        while(cur != null || !stack.isEmpty()){
	        	if(cur != null){
	        		list.add(cur.val);
	        		stack.push(cur.right);
	        		cur = cur.left;
	        	}
	        	else{
	        		cur = stack.pop();
	        	}
	        }
	        return list;
	    }
	
	
}
