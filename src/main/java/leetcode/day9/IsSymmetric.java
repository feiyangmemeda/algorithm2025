package leetcode.day9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author feiyang.duan
 * @date 2025/5/30
 * @description 对称二叉树
 */
public class IsSymmetric {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode left = new TreeNode();
        left.val = 2;
        root.left = left;
        TreeNode right = new TreeNode();
        right.val = 2;
        root.right = right;
        TreeNode left2 = new TreeNode();
        left2.val = 3;
        left.left = left2;
        TreeNode right2 = new TreeNode();
        right2.val = 4;
        left.right = right2;
        TreeNode left3 = new TreeNode();
        left3.val = 4;
        right.left = left3;
        TreeNode right3 = new TreeNode();
        right3.val = 3;
        right.right = right3;

        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> judgeList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    judgeList.add(node.left.val);
                } else {
                    judgeList.add(null);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    judgeList.add(node.right.val);
                } else {
                    judgeList.add(null);
                }
            }
            // 判断judgeList是否对称
            for (int i = 0; i < judgeList.size(); i++) {
                if (!Objects.equals(judgeList.get(i), judgeList.get(judgeList.size() - i - 1))) {
                    return false;
                }
            }
        }
        return true;
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
