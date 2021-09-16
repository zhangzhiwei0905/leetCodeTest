package com.zzw.单链表;

import com.zzw.单链表.model.ListNode;

public class 单链表反转 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 6, 3, 4, 5, 6};
        ListNode head = ListNode.createListNode(nums);
        ListNode result = reverseList(head);
        ListNode.display(result);
    }

    // 头插法
    public static ListNode reverseList(ListNode head) {
        // dummy当做头结点，这样可以不用判断空指针
        ListNode dummy = new ListNode(-1);
        // 这个用来遍历我的链表
        ListNode cur = head;
        // 这个就是每次断连接后的node
        ListNode node;
        // 如果只有一个节点，那么就输出本身
        if (head.next == null) {
            return head;
        }
        // 遍历链表
        while (cur != null) {
            // 先用node指向当前的一个节点
            node = cur;
            // 注意，这里一定要先移动cur到下一个位置
            cur = cur.next;
            // 头插法
            node.next = dummy.next;
            dummy.next = node;

        }
        return dummy.next;

    }
}
