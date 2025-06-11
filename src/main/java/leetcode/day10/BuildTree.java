package leetcode.day10;

import leetcode.base.TreeNode;

import java.util.Arrays;

/**
 * @author feiyang.duan
 * @date 2025/6/3
 * @description 从前序与中序遍历序列构造二叉树
 */
public class BuildTree {

    public static void main(String[] args) {
        int[] array1 = {1,2};
        int[] array2 = {2,1};
        TreeNode treeNode = buildTree(array1, array2);
        System.out.println(treeNode);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        // 前序遍历的第一个节点就是根
        int rootValue = preorder[0];
        // 找到中序遍历根的index下标
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (rootValue == inorder[i]) {
                rootIndex = i;
            }
        }
        // 把左子树和右子树拆开
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, 1 + rootIndex);
        int[] preorderRight = Arrays.copyOfRange(preorder, 1 + rootIndex, preorder.length);
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        return root;
    }



}
