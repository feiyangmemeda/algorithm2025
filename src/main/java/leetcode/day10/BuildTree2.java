package leetcode.day10;

import leetcode.base.TreeNode;

import java.util.Arrays;

/**
 * @author feiyang.duan
 * @date 2025/6/4
 * @description 从中序与后序遍历序列构造二叉树
 */
public class BuildTree2 {

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode treeNode = buildTree(inorder, postorder);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        if (postorder.length == 1) {
            return new TreeNode(postorder[0]);
        }
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        // 找到根
        int rootValue = postorder[postorder.length - 1];
        // 找到中序遍历根的位置
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
            }
        }
        // 拆分左树和右树
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        int[] postorderLeft = Arrays.copyOfRange(postorder, 0, rootIndex);
        int[] postorderRight = Arrays.copyOfRange(postorder, rootIndex, postorder.length - 1);
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(inorderLeft, postorderLeft);
        root.right = buildTree(inorderRight, postorderRight);
        return root;
    }


}
