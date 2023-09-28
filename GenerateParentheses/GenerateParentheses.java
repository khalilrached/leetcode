package org.example;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static class Solution {
        public static List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            generate(result, "", 0, 0, n);
            return result;
        }

        private static void generate(List<String> result, String s, int left, int right, int n) {
            if (left == n && right == n) {
                result.add(s);
                return;
            }
            if (left < n) {
                generate(result, s + "(", left + 1, right, n);
            }
            if (right < left) {
                generate(result, s + ")", left, right + 1, n);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.generateParenthesis(3));
    }
}
