package com.zzw.单链表;

import com.zzw.单链表.model.ListNode;

/**
 * @author Zhangzhiwei
 * @Description: 主要用到快慢指针
 * 需要注意的是，如果链表长度为偶数，也就是说中点有两个的时候，我们这个解法返回的节点是靠后的那个节点。
 * @return
 * @date 2021/9/16 2:59 PM
 */
public class 单链表的中点 {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 5, 6};
        ListNode head = ListNode.createListNode(nums);
        ListNode listNode = middleNode(head);
        System.out.println(listNode.val);
    }


    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 若为偶数，返回的是中间两个节点的后一个
        return slow;
    }
}
