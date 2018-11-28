package LeetCode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * This is about top-bottom level traversal
 * @author huang
 *
 */
public class BTLevelOrderTraversal {
	//DFS solution
	public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
	        addLevel(wrapList, root, 0);
	        return wrapList;
	    }

	private void addLevel(List<List<Integer>> list, TreeNode node, int level) {
		if(node == null) return;
		if(list.size() <= level) list.add(new LinkedList<Integer>());
		addLevel(list, node.left, level+1);
		addLevel(list, node.right, level+1);
		list.get(level).add(node.val);
	}
}
