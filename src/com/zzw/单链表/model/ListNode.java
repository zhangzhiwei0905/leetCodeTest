package com.zzw.单链表.model;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void display(ListNode head) {
        if (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        while (head != null) {
            System.out.print("->" + head.val);
            head = head.next;
        }
    }

    public static ListNode createListNode(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for (int i = 0; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return dummy.next;
    }
}
