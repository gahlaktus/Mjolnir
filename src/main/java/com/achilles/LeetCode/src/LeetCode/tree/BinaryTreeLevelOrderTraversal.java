package LeetCode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * this is bottom-up level traversal
 * @author huang
 *
 */
public class BinaryTreeLevelOrderTraversal {
	//DFS solution
	/*public List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
		putList(wrapList, root, 0);
		return wrapList;
	}

	private void putList(List<List<Integer>> list,
			TreeNode root, int level) {
		if(root == null){
			return;
		}
		if(level >= list.size()){
			list.add(0, new LinkedList<Integer>());
		}
		putList(list, root.left, level+1);
		putList(list, root.right, level+1);
		list.get(list.size()-level-1).add(root.val);
	}*/
	
	//BFS solution
	public List<List<Integer>> levelOrderBottom(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
		
		if(root == null){
			return wrapList;
		}
		//== add(e)
		queue.offer(root);
		while(!queue.isEmpty()){
			int levelNum = queue.size();
			List<Integer> subList = new LinkedList<Integer>();
			for (int i = 0; i < levelNum; i++) {
				if(queue.peek().left != null) queue.offer(queue.peek().left);		//peek() 获取但不移除此队列的头；如果此队列为空，则返回 null。
				if(queue.peek().right != null) queue.offer(queue.peek().right);
				subList.add(queue.poll().val);		//poll() 获取并移除此队列的头，如果此队列为空，则返回 null。
			}
			wrapList.add(0,subList);
		}
		return wrapList;
	}
}
