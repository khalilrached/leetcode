package org.example;
import java.util.*;

// https://leetcode.com/problems/add-to-array-form-of-integer/
public class AddToArrayFromInt {
    public static class Solution{
        public static List<Integer> addToArrayForm(int[] num, int k) {
            // transform k to array of int
            List<Integer> list = new ArrayList<>();
            int i = num.length-1;
            int r = 0;
            while(k!=0 || i >= 0 || r != 0){
                int sum = r + num[i] + k%10;
                r = (sum>=10)?1:0;
                list.add(sum%10);
                if(k!=0) k = k/10;
                if(i >= 0) i--;
            }
            Collections.reverse(list);
            return list;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.addToArrayForm(new int[]{1,2,0,0},34));;
    }
}
