package com.stark.datastructure.tree;

/**
 * @author huangzhibo
 * @date 2019/6/19
 */
public class TreeOptions {

    public int findDepth(TreeNode root) {
        int depth = 0;
        if(root != null)
        {
            int lDepth = findDepth(root.left);
            int rDepth = findDepth(root.right);
            depth = lDepth > rDepth ? lDepth + 1 : rDepth + 1;
        }
        return depth;
    }

}
