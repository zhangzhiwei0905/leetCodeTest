package com.zzw.单链表;

import com.zzw.单链表.model.ListNode;

public class 删除单链表倒数第k个节点 {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8};
        ListNode head = ListNode.createListNode(nums);
        ListNode listNode = removeNthFromEnd(head, 3);
        ListNode.display(listNode);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = findFromEnd(head, n + 1);
        node.next = node.next.next;
        return dummy.next;
    }

    // 找到倒数第K个
    public static ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head, p2 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

}
