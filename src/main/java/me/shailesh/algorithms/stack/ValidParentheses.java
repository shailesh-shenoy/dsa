package me.shailesh.algorithms.stack;

import java.util.Set;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> op = Set.of('(', '[', '{');
        Set<Character> cp = Set.of(')', ']', '}');
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(op.contains(c)) {
                stack.push(c);
                continue;
            }
            if(!cp.contains(c)) {
                continue;
            }
            if(stack.isEmpty()) {
                return false;
            }
            char other = stack.pop();
            if(!isMatchingPair(c, other)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char c, char other) {
        return switch (other) {
            case '(' -> c == ')';
            case '[' -> c == ']';
            case '{' -> c == '}';
            default -> false;
        };
    }
}
