package org.example;

import java.util.Stack;

public class RemoveNthFromEndOfList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }

        public static ListNode build(int[] nums){
            ListNode head = new ListNode(0);
            ListNode current = head;
            for (int num : nums) {
                current.next = new ListNode(num);
                current = current.next;
            }
            return head.next;
        }

        public static void print(ListNode head){
            while (head!=null){
                System.out.print(head.val+" ");
                head = head.next;
            }
        }
    }

    public static class Solution {
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode fast = dummy;
            ListNode slow = dummy;
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }
            while (fast.next!=null){
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.build(new int[]{1,2,3,4,5});
        ListNode.print(Solution.removeNthFromEnd(head,2));
    }
}
