package org.example;

public class ValidParentheses {
    public static class Solution {
        public static boolean isValid(String s) {
            if (s.length() % 2 != 0) return false;
            char[] stack = new char[s.length()];
            int top = -1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (top == -1) {
                    stack[++top] = c;
                } else {
                    if (c == ')' && stack[top] == '(') {
                        top--;
                    } else if (c == ']' && stack[top] == '[') {
                        top--;
                    } else if (c == '}' && stack[top] == '{') {
                        top--;
                    } else {
                        stack[++top] = c;
                    }
                }
            }
            return top == -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.isValid("()"));
        System.out.println(Solution.isValid("()[]{}"));
        System.out.println(Solution.isValid("(]"));
        System.out.println(Solution.isValid("([)]"));
        System.out.println(Solution.isValid("{[]}"));
    }
}
