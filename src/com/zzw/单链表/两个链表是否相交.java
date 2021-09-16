package com.zzw.单链表;

import com.zzw.单链表.model.ListNode;


/**
 * @author Zhangzhiwei
 * @Description: 解决这个问题的关键是，通过某些方式，让 p1 和 p2 能够同时到达相交节点 c1。
 * <p>
 * 所以，我们可以让 p1 遍历完链表 A 之后开始遍历链表 B，让 p2 遍历完链表 B 之后开始遍历链表 A，这样相当于「逻辑上」两条链表接在了一起。
 * <p>
 * 如果这样进行拼接，就可以让 p1 和 p2 同时进入公共部分，也就是同时到达相交节点 c1：
 * @return
 * @date 2021/9/16 3:23 PM
 */
public class 两个链表是否相交 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);


        ListNode c1 = new ListNode(5);
        ListNode c2 = new ListNode(6);

        a1.next = a2;
        a2.next = c1;
        c1.next = c2;

        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);

        b1.next = b2;
        b2.next = b3;
        b3.next = c1;

        ListNode node = getIntersectionNode(a1, b1);
        System.out.println(node.val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

}
