package me.shailesh.algorithms.stack;

import java.util.Set;
import java.util.Stack;

public class EvaluateRPN {
    public int evalRPN(String[] tokens) {
        var st = new Stack<Integer>();
        int result = 0;
        boolean firstOp = true;
        Set<String> operators = Set.of("+", "-", "*", "/");
        for(String t : tokens) {
            if(!operators.contains(t)) {
                st.push(Integer.parseInt(t));
                continue;
            }
            if(firstOp) {
                result = st.pop();
                firstOp = false;
            }
            int current = st.pop();

            result = switch (t) {
                case "+" -> current + result;
                case "-" -> current - result;
                case "*" -> current * result;
                case "/" -> current / result;
                default -> result;
            };
        }
        return result;
    }

    public static void main(String[] args) {
        var erpn = new EvaluateRPN();
        System.out.println(erpn.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(erpn.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(erpn.evalRPN(new String[]{"10", "6", "9", "3", "/", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
