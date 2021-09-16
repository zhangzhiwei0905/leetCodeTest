package com.zzw.单链表;

import com.zzw.单链表.model.ListNode;

import java.util.PriorityQueue;

/**
 * @author Zhangzhiwei
 * @Description: 合并 k 个有序链表的逻辑类似合并两个有序链表，难点在于，如何快速得到 k 个节点中的最小节点，接到结果链表上？
 * <p>
 * 这里我们就要用到 优先级队列（二叉堆） 这种数据结构，把链表节点放入一个最小堆，就可以每次获得 k 个节点中的最小节点：
 * <p>
 * <p>
 * <p>
 * 优先队列 pq 中的元素个数最多是 k，所以一次 poll 或者 add 方法的时间复杂度是 O(logk)；所有的链表节点都会被加入和弹出 pq，
 * 所以算法整体的时间复杂度是 O(Nlogk)，其中 k 是链表的条数，N 是这些链表的节点总数。
 * @return
 * @date 2021/9/16 10:06 AM
 */
public class 合并k个有序链表 {
    public static void main(String[] args) {
        int[] num1 = {1, 3, 5};
        int[] num2 = {2, 6, 8};
        int[] num3 = {2, 6, 9};
        ListNode[] lists = {ListNode.createListNode(num1), ListNode.createListNode(num2), ListNode.createListNode(num3)};
        ListNode.display(mergeKLists(lists));
    }


    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b) -> (a.val - b.val)
        );
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            // 将node的下一个添加到优先队列中
            if (node.next != null) {
                pq.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
