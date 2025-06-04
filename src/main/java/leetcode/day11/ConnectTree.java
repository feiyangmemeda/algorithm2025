package leetcode.day11;

import leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author feiyang.duan
 * @date 2025/6/4
 * @description 填充每个节点的下一个右侧节点指针 II
 */
public class ConnectTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;

        treeNode2.right = treeNode5;

        TreeNode root = connect(treeNode);
        System.out.println(root);
    }

    public static TreeNode connect(TreeNode root) {
        // 广度优先遍历bfs
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        root.next = null;
        while (!queue.isEmpty()) {
            // 同一层,按顺序放入
            ArrayList<TreeNode> list = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                    list.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                    list.add(treeNode.right);
                }
            }
            if (list.isEmpty()) {
                continue;
            }
            // 按顺序设置next
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    list.get(i).next = null;
                } else {
                    list.get(i).next = list.get(i + 1);
                }
            }
        }
        return root;
    }
}
