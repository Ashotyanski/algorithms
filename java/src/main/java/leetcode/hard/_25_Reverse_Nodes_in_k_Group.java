package leetcode.hard;

import java.util.*;
import java.lang.*;
import leetcode.utils.*;

public class _25_Reverse_Nodes_in_k_Group {
	public static void main(String[] args) {
		ListNode node = createList(new int[]{1, 2, 3, 4, 5});
		printList(node);

		printList(new _25_Reverse_Nodes_in_k_Group().reverseKGroup(node, 3));
		// printList(reverse(node));
	}

	/**
	Back from two weeks of doing unimportant shit (thanks shia)
	Extremely lucky this time, only one minor mistake (especially when code turned out to be quite complex)
	Regarding complexity, oj says this solution is not even nearly as fast as the median,
	so some cool optimization trick must be hidden here
	*/
    public ListNode reverseKGroup(ListNode head, int k) {
    	if (head == null || head.next == null || k == 1) {
    		return head;
    	}
    	ListNode prev = head, cur = head.next, next = head.next.next;
    	ListNode groupStart = head, groupEnd = null;
    	ListNode resHead = null, resTail = null;
        while (true) {
        	// 1. find group end
    		ListNode groupNode = groupStart;
    		int i = 1;
    		while (true) {
    			// System.out.println("i: " + i + ", groupNode.val:" + groupNode.val);
    			if (groupNode == null) {
    				if (resHead == null) {
    					return head;
    				} else {
    					resTail.next = groupStart;
    					return resHead;
    				}
    			} else if (i == k) {
    				groupEnd = groupNode;
    				break;
    			}
    			groupNode = groupNode.next;
    			i++;
    		}

        	// 2. reverse until cur == groupEnd
        	prev = groupStart; cur = groupStart.next; next = groupStart.next.next;
        	prev.next = null;
        	while (true) {
        		cur.next = prev;
        		if (cur == groupEnd) {
        			break;
        		}
        		prev = cur;
        		cur = next;
        		next = next.next;
        	}

        	// 3. group start = next
        	if (resHead == null) {
        		resHead = groupEnd;
        		resTail = groupStart;
        	} else {
        		resTail.next = groupEnd;
        		resTail = groupStart;
        	}
        	groupStart = next;
        	if (groupStart == null) {
        		break;
        	}
        }

        return resHead;
    }

	static ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = head, cur = head.next, next = head.next.next;
		head.next = null;
		while (true) {
			cur.next = prev;
			if (next == null) {
				break;
			}
			prev = cur;
			cur = next;
			next = next.next;
		}
		return cur;
	}

	static void printList(ListNode head) {
		ListNode node = head;
		while (node != null) {
			System.out.print(node.val);
			if (node.next != null) {
				System.out.print("->");
			}
			node = node.next;
		}
		System.out.println();
	}

	static ListNode createList(int[] array) {
		ListNode head = new ListNode(0);
		ListNode tail = head;

		for (int i : array) {
			tail.next = new ListNode(i);
			tail = tail.next;
		}
		return head.next;
	}
}