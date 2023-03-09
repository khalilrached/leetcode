package org.example;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/zigzag-conversion/
public class ZigzagConversion {
    public static class Solution{
        public static String convert(String s,int rowLength){
            if(s.length()<rowLength || rowLength == 1) return s;
            List<StringBuffer> list = new ArrayList<>();
            int row = 0;
            int increment = 0;
            for(int i = 0;i<rowLength;i++){
                list.add(new StringBuffer());
            }
            for (int i = 0;i<s.length();i++){
                list.get(row).append(s.charAt(i));
                if(row == rowLength-1) increment = -1;
                else if(row == 0) increment = 1 ;
                row += increment;
            }
            return list.stream().map((buffer) -> (String) buffer.toString()).reduce("",(acc,elm)->acc + elm);
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.convert("AB",1));
    }
}
