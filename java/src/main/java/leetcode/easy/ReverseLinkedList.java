package leetcode.easy;

import leetcode.utils.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode current = head;
        while (current != null) {
            ListNode newNode = new ListNode(current.val);
            newNode.next = newHead;
            newHead = newNode;
            current = current.next;
        }
        return newHead;
    }

    public ListNode reverseListRecursive(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode newNode = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return newNode;
    }
}
