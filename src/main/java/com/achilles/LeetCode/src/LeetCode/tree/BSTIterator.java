package LeetCode.tree;

import java.util.Stack;

/*	
 * 	Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
	Calling next() will return the next smallest number in the BST.
	Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree. 
*/
//the idea is same as using stack to do Binary Tree Inorder Traversal 
/**
 * solution:
 * 		once you get to a TreeNode, in order to get the smallest, you need to go all the way down its left branch. 
 * 		So our first step is to point to pointer to the left most TreeNode. The problem is how to do back trace.
 * 		for next(), I directly return where the pointer pointing at, which should be the left most TreeNode I previously found. 
 * 		What to do next? After returning the smallest TreeNode, I need to point the pointer to the next smallest TreeNode. 
 * 		When the current TreeNode has a right branch (It cannot have left branch, remember we traversal to the left most), 
 * 		we need to jump to its right child first and then traversal to its right child's left most TreeNode.
 * 		When the current TreeNode doesn't have a right branch, it means there cannot be a node with value smaller than itself father node, 
 * 		point the pointer at its father node.
 * @author huang
 *
 */
public class BSTIterator {
	//method one
	/*
	Stack<TreeNode> stack = null;
	TreeNode current = null;
	
	public BSTIterator(TreeNode root){
		current = root;
		stack = new Stack<>();
	}
	*//** @return whether we have a next smallest number *//*
    public boolean hasNext() {
    	return !stack.isEmpty() || current != null;
    }

    *//** @return the next smallest number *//*
    public int next() {
        while(current != null){
        	stack.push(current);
        	current = current.left;
        }
        TreeNode t = stack.pop();
        current = t.right;
        return t.val;
    }*/
	
	//method two
	/*private Stack<TreeNode> stack;
	public BSTIterator(TreeNode root){
		stack = new Stack<>();
		TreeNode cur = root;
		while(cur != null){
			stack.push(cur);
			if(cur.left != null){
				cur = cur.left;
			}
			else{
				break;
			}
		}
	}
	public boolean hasNext(){
		return !stack.isEmpty();
	}
	public int next(){
		TreeNode node = stack.pop();
		TreeNode cur = node;
		//traversal right branch
		if(cur.right != null){
			cur = cur.right;
			while(cur != null){
				stack.push(cur);
				if(cur.left != null){
					cur = cur.left;
				}
				else{
					break;
				}
			}
		}
		return node.val;
	}*/
	//method three
	//best one
	//just focus on stack,keep stack is not empty! or each node had been pop
	private Stack<TreeNode> stack = new Stack<TreeNode>();
	public BSTIterator(TreeNode root){
		pushAll(root);
	}
	public boolean hasNext(){
		return !stack.isEmpty();
	}
	public int next(){
		TreeNode tmpNode = stack.pop();
		pushAll(tmpNode.right);
		return tmpNode.val;
	}
	private void pushAll(TreeNode node) {
		for(; node != null; stack.push(node),node = node.left);
	}
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */