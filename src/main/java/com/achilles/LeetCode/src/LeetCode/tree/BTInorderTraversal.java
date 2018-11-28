package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTInorderTraversal {
	 public List<Integer> inorderTraversal(TreeNode root) {
		 	
		 //my method
		/* List<Integer> list = new ArrayList<Integer>();
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        TreeNode cur = root;
	        if(cur == null) return list;
	        while(cur != null || !stack.isEmpty()){
	            if(cur != null){
	                stack.push(cur);
	                cur = cur.left;
	                continue;
	            }
	            if(!stack.isEmpty()){
	                cur = stack.pop();
	                list.add(cur.val);
	                cur = cur.right;
	            }
	        }*/
	        
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;

		while (cur != null || !stack.empty()) {
			while (cur != null) {
				stack.add(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			list.add(cur.val);
			cur = cur.right;
		}

		    return list;
	 }
}
