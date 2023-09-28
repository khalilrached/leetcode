package org.example;

// https://leetcode.com/problems/add-strings/description/
public class AddStrings {
    public static class Solution{
        public static String addStrings(String num1,String num2){
            StringBuffer buffer = new StringBuffer();
            int i = num1.length()-1;
            int j = num2.length()-1;
            int r = 0;
            while (i>=0 || j>=0 || r!=0){
                int sum = r ;
                sum += (i>=0)?Integer.parseInt(String.valueOf(num1.charAt(i))):0;
                sum += (j>=0)?Integer.parseInt(String.valueOf(num2.charAt(j))):0;
                r = (sum>=10)?1:0;
                buffer.append(sum%10);
                if(i>=0) i--;
                if(j>=0) j--;
            }
            return buffer.reverse().toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.addStrings("2345","3456"));
    }
}
