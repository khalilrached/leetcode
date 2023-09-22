package org.example;

public class SwapNodesInKGroup {
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
        public static ListNode reverseKGroup(ListNode head,int k) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode end = dummy;
            while (end.next!=null){
                for (int i = 0; i < k && end!=null; i++) {
                    end = end.next;
                }
                if(end==null) break;
                ListNode start = pre.next;
                ListNode next = end.next;
                end.next = null;
                pre.next = reverse(start);
                start.next = next;
                pre = start;
                end = pre;
            }
            return dummy.next;
        }

        private static ListNode reverse(ListNode start) {
            ListNode pre = null;
            ListNode current = start;
            while (current!=null){
                ListNode next = current.next;
                current.next = pre;
                pre = current;
                current = next;
            }
            return pre;
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
