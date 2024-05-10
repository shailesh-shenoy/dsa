package me.shailesh.algorithms.stack;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperaturesBF(int[] temperatures) {
        int n = temperatures.length;
        var result = new int[n];
        for(int i = 0; i < n; i++) {
            int j = i + 1;
            while(j < n) {
                if(temperatures[j] > temperatures[i]) {
                    break;
                }
                j += 1;
            }
            if(j == n) {
                continue;
            }
            result[i] = j - i;
        }
        return result;
    }

    public record Temp(int temperature, int index) {}

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        var st = new Stack<Temp>();
        var result = new int[n];

        for(int i = 0; i < n; i++) {
            int current = temperatures[i];
            if(st.isEmpty() || current <= st.peek().temperature()) {
                st.push(new Temp(current, i));
                continue;
            }

            while(!st.isEmpty() && st.peek().temperature() < current) {
                var t = st.pop();
                result[t.index()] = i - t.index();
            }
            st.push(new Temp(current, i));
        }

        return result;
    }

    public static void main(String[] args) {
        var dt = new DailyTemperatures();
        var result = dt.dailyTemperaturesBF(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for(var r : result) {
            System.out.print(r + " ");
        }
        System.out.println();
        result = dt.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for(var r : result) {
            System.out.print(r + " ");
        }
    }
}
