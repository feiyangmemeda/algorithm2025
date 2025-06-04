package leetcode.day9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author feiyang.duan
 * @date 2025/5/29
 * @description 是否相同的树
 */
public class IsSameTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode left = new TreeNode();
        left.val = 2;
        root.left = left;
        TreeNode right = new TreeNode();
        right.val = 3;
        root.right = right;
        root.left = null;
        List<Integer> treeNodes = treeToList(root);
        System.out.println(treeNodes);
    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pList = treeToList(p);
        List<Integer> qList = treeToList(q);
        if (pList.size() != qList.size()) {
            return false;
        }
        for (int i = 0; i < pList.size(); i++) {
            if (!Objects.equals(pList.get(i), qList.get(i))) {
                return false;
            }
        }
        return true;
    }


    public static List<Integer> treeToList(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.pop();
                if (treeNode.left == null && treeNode.right == null) {
                    continue;
                }
                if (treeNode.left != null) {
                    result.add(treeNode.left.val);
                    queue.offer(treeNode.left);
                } else {
                    result.add(null);
                }
                if (treeNode.right != null) {
                    result.add(treeNode.right.val);
                    queue.offer(treeNode.right);
                } else {
                    result.add(null);
                }
            }
        }
        return result;

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
