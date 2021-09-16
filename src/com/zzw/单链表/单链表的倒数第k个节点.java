package com.zzw.单链表;

import com.zzw.单链表.model.ListNode;

/**
 * @author Zhangzhiwei
 * @Description: 首先，我们先让一个指针 p1 指向链表的头节点 head，然后走 k 步：
 * 现在的 p1，只要再走 n - k 步，就能走到链表末尾的空指针了对吧？
 * <p>
 * 趁这个时候，再用一个指针 p2 指向链表头节点 head：
 * <p>
 * 接下来就很显然了，让 p1 和 p2 同时向前走，p1 走到链表末尾的空指针时走了 n - k 步，p2 也走了 n - k 步，也就是链表的倒数第 k 个节点：
 * @return
 * @date 2021/9/16 2:28 PM
 */
public class 单链表的倒数第k个节点 {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8};
        ListNode head = ListNode.createListNode(nums);
        ListNode result = findFromEnd(head, 5);
        System.out.println(result.val);
    }

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
