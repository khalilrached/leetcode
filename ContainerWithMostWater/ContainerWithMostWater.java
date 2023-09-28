package org.example;

// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    public static class Solution{
        public static int maxArea(int[] height){
            int max_area = Math.min(height[0],height[1]);
            for(int i = 0;i<height.length-1;i++){
                for(int j = i+1;j< height.length;j++){
                    int area = Math.min(height[i],height[j])*(j-i);
                    if(area>max_area) max_area = area;
                }
            }
            return max_area;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
