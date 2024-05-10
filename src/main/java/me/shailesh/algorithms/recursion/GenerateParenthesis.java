package me.shailesh.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        var result = new ArrayList<String>();
        gpRecursive("", n, 0, 0, result);
        return result;

    }

    private void gpRecursive(String str, int n, int open, int close, List<String> result) {
        if(open == n && close == n) {
            result.add(str);
            return;
        }
        if(open < n) {
            gpRecursive(str + "(", n, open + 1, close, result);
        }
        if(close >= open) {
            return;
        }
        if(close < n) {
            gpRecursive(str + ")", n, open, close + 1, result);
        }
    }

    public static void main(String[] args) {
        var gp = new GenerateParenthesis();
        var result = gp.generateParenthesis(4);
        for(var r : result) {
            System.out.println(r);
        }
    }
}
