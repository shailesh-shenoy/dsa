package me.shailesh.algorithms.twopointers;

import java.util.Stack;

public class ValidPalindrome {
    public boolean isPalindromeStack(String s) {
       var stack = new Stack<Character>();
        s = s.toLowerCase();
        var sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c >= 'a' && c <= 'z') {
                stack.push(c);
                sb.append(c);
            }
        }
        s = sb.toString();
        sb.setLength(0);
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return s.contentEquals(sb);
    }

    public boolean isPalindromeTP(String s) {
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;

        while(start < end) {
            char c1 = s.charAt(start);
            char c2 = s.charAt(end);
            if(c1 < 'a' || c1 > 'z') {
                start += 1;
                continue;
            }
            if(c2 < 'a' || c2 > 'z') {
                end -= 1;
                continue;
            }
            if(c1 != c2) {
                return false;
            }
            start += 1;
            end -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindromeStack("A man, a plan, a canal: Panama"));
        System.out.println(vp.isPalindromeTP("A man, a plan, a canal: Panama"));
    }
}
