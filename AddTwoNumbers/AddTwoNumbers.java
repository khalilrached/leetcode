package org.example;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            List<Integer> list = new ArrayList<>();
            int r = 0;
            while(l1 != null || l2 != null || r!=0 ){
                int sum = r;
                if(l1!=null) sum += l1.val;
                if(l2!=null) sum += l2.val;
                if(sum<10) r=0;
                if(sum>=10) { r = 1; sum %= 10; }
                list.add(sum);
                if(l1!=null) l1 = l1.next;
                if(l2!=null) l2 = l2.next;
            }
            if(r!=0) list.add(r);
            ListNode head = null;
            for(int i = list.size()-1;i>=0;i--){
                head = new ListNode(list.get(i),head);
            }
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9,l1);
        ListNode l3 = new ListNode(9,l2);
        ListNode l4 = new ListNode(9,l3);
        ListNode l = new ListNode(1);

        ListNode head = Solution.addTwoNumbers(l4,l);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
