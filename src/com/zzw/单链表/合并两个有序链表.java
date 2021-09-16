package com.zzw.单链表;

import com.zzw.单链表.model.ListNode;

public class 合并两个有序链表 {
    public static void main(String[] args) {
        int[] num1 = {1, 3, 5};
        int[] num2 = {2, 4, 6};
        ListNode.display(mergeTwoLists(ListNode.createListNode(num1), ListNode.createListNode(num2)));
    }


    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟头结点
        // 一般思路就是虚拟头结点，然后定义一个指向头结点的指针p，然后n段链表有n个指针指向
        // 这样做好处是：可以避免处理空指针情况，降低代码复杂性
        ListNode dummy = new ListNode(-1);
        // p指向头结点
        ListNode p = dummy;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }

}
