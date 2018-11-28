package LeetCode.tree;
/**
 * 	Given a binary tree, determine if it is height-balanced.
	For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
 */
public class BalanceBinaryTree {
	//method one
	/*private static final int UNBALANCED = -99;
	public boolean isBalanced(TreeNode root){
		if(root == null){
			System.err.println("This Tree is null!");
			return true;
		}
		return getHeight(root) != UNBALANCED;
	}
	private int getHeight(TreeNode root) {
		if(root == null){
			return -1;
		}
		int l = getHeight(root.left);
		int r = getHeight(root.right);
		if(l == UNBALANCED || r == UNBALANCED || Math.abs(l-r) > 1)
			return UNBALANCED;
		return 1 + Math.max(l, r);
	}*/
	
	//method 2
	public boolean isBalanced(TreeNode root){
		if(root == null){
			return true;
		}
		return height(root) != -1;
	}

	private int height(TreeNode root) {
		if(root == null){
			return 0;
		}
		int l = height(root.left);
		if(l == -1){
			return -1;
		}
		int r = height(root.right);
		if(r == -1){
			return -1;
		}
		if(l-r < -1 || l-r > 1){
			return -1;
		}
		return Math.max(l, r)+1;
	}
}
