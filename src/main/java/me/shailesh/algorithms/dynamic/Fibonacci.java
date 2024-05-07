package me.shailesh.algorithms.dynamic;

//TODO: Finish this

public class Fibonacci {
    public static int fibRecursive(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static int fibRecursiveMemo(int n, int[] memo) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(memo[n - 1] != 0) {
            return memo[n - 1];
        }
        memo[n - 1] = fibRecursiveMemo(n - 1, memo) + fibRecursiveMemo(n - 2, memo);
        return memo[n - 1];
    }

    public static int fibRecursiveMemo2(int n, int n1, int n2) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return fibRecursiveMemo2(n - 1, n1, n1 + n2);
    }

    public static int fibIterative(int n) {
        int a = 0;
        int b = 1;
        for(int i = 2; i <= n; i++) {
            a = b;
            b = a + b;
            int result = 1;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println("Fib Recursive: " + fibRecursive(11));
        System.out.println("Fib Recursive Memo: " + fibRecursiveMemo(11, new int[11]));
    }
}
