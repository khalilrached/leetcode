package org.example;

public class MergeKSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public static ListNode build(int[] nums) {
            ListNode head = new ListNode(0);
            ListNode current = head;
            for (int num : nums) {
                current.next = new ListNode(num);
                current = current.next;
            }
            return head.next;
        }

        public static void print(ListNode head) {
            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
        }
    }

    public static class Solution {
        public static ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) return null;
            return merge(lists, 0, lists.length - 1);
        }

        private static ListNode merge(ListNode[] lists, int left, int right) {
            if (left == right) return lists[left];
            int mid = (left + right) / 2;
            ListNode l1 = merge(lists, left, mid);
            ListNode l2 = merge(lists, mid + 1, right);
            return mergeTwoLists(l1, l2);
        }

        private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head = new ListNode(0);
            ListNode current = head;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    current.next = list1;
                    list1 = list1.next;
                } else {
                    current.next = list2;
                    list2 = list2.next;
                }
                current = current.next;
            }
            current.next = (list1 != null) ? list1 : list2;
            return head.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.build(new int[]{1, 4, 5});
        ListNode l2 = ListNode.build(new int[]{1, 3, 4});
        ListNode l3 = ListNode.build(new int[]{2, 6});
        ListNode result = Solution.mergeKLists(new ListNode[]{l1, l2, l3});
        ListNode.print(result);
    }
}
