package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class SwapNodesInPairs {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class Solution {
        public static ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode current = dummy;
            while (current.next != null && current.next.next != null) {
                ListNode first = current.next;
                ListNode second = current.next.next;
                first.next = second.next;
                current.next = second;
                current.next.next = first;
                current = current.next.next;
            }
            return dummy.next;
        }
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(4);
        ListNode e = new ListNode(3, l);
        ListNode r = new ListNode(2, e);
        ListNode h = new ListNode(1, r);

        print(h);
        System.out.println("\n");
        print(Solution.swapPairs(h));
    }
}
