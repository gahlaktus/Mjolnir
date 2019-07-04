package com.stark.datastructure.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * @author huangzhibo
 */
@Getter
@Setter
public class TreeNode {

    private int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}