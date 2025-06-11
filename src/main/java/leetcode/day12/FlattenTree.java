package leetcode.day12;

import leetcode.base.TreeNode;

import java.util.Stack;

/**
 * @author feiyang.duan
 * @date 2025/6/6
 * @description 二叉树展开为链表
 */
public class FlattenTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        treeNode.left = treeNode1;
        treeNode.right = treeNode4;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode4.right = treeNode5;
        flatten(treeNode);
        while (treeNode != null) {
            System.out.println(treeNode.val);
            treeNode = treeNode.right;
        }
    }


    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 关键点就是创建一个栈，先进后出，这样可以保证左节点先跳出，绑定成右节点
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            // 相当于pre每次会往下传递，每次都在pre的右节点续接
            if (pre != null) {
                pre.right = temp;
                pre.left = null;
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
            pre = temp;
        }
    }


}
