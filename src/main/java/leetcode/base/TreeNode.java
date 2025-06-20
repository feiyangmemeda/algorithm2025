package leetcode.base;

import leetcode.day10.BuildTree;

/**
 * @author feiyang.duan
 * @date 2025/6/4
 * @description 类的描述信息
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
