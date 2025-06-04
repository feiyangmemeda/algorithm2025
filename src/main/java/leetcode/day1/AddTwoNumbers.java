package leetcode.day1;

/**
 * @author feiyang.duan
 * @date 2025/4/17
 * @description 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9)));
        //ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        //ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        //ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(9)));
        //ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))));
        ListNode node = addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head;
        ListNode next = new ListNode(0);
        head = next;

        int tenNum = 0;

        while (true) {
            int value = l1.val + l2.val + tenNum;
            if (value >= 10) {
                value = value % 10;
                tenNum = 1;
            } else {
                tenNum = 0;
            }
            ListNode node = new ListNode(value);
            next.next = node;
            next = node;
            if (l1.next == null && l2.next == null) {
                if (tenNum == 1) {
                    next.next = new ListNode(1);
                }
                return head.next;
            }
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null) {
                break;
            }
            if (l2 == null) {
                break;
            }
        }


        while (l1 != null) {
            int value = l1.val + tenNum;
            if (value >= 10) {
                value = value % 10;
                tenNum = 1;
            } else {
                tenNum = 0;
            }
            ListNode node = new ListNode(value);
            next.next = node;
            next = node;
            l1 = l1.next;
        }

        while (l2 != null) {
            int value = l2.val + tenNum;
            if (value >= 10) {
                value = value % 10;
                tenNum = 1;
            } else {
                tenNum = 0;
            }
            ListNode node = new ListNode(value);
            next.next = node;
            next = node;
            l2 = l2.next;
        }

        if (tenNum == 1) {
            next.next = new ListNode(1);
        }

        return head.next;

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
