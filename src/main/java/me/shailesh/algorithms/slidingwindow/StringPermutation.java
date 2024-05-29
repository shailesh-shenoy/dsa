package me.shailesh.algorithms.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {
    public boolean checkInclusion(String s1, String s2) {
        var s1Counts = new HashMap<Character, Integer>();
        var windowCounts = new HashMap<Character, Integer>();
        int m = s1.length();
        int n = s2.length();
        int l = 0;
        int r = m - 1;

        for(int i = 0; i < m; i++) {
            char c = s1.charAt(i);
            if(!s1Counts.containsKey(c)) {
                s1Counts.put(c, 0);
            }
            s1Counts.put(c, s1Counts.get(c) + 1);

            c = s2.charAt(i);
            if(!windowCounts.containsKey(c)) {
                windowCounts.put(c, 0);
            }
            windowCounts.put(c, windowCounts.get(c) + 1);
        }


        if(s1Counts.equals(windowCounts)) {
            return true;
        }

        while(r < n - 1) {
            char c = s2.charAt(l);
            windowCounts.put(c, windowCounts.get(c) - 1);
            l += 1;
            r += 1;
            c = s2.charAt(r);
            if(!windowCounts.containsKey(c)) {
                windowCounts.put(c, 0);
            }
            windowCounts.put(c, windowCounts.get(c) + 1);
            if(checkMapEquality(s1Counts, windowCounts)) {
                return true;
            }
            System.out.println(windowCounts);
        }

        return false;
    }

    public boolean checkInclusionOptimized(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        var s1Counts = new int[26];
        var windowCounts = new int[26];

        for(int i = 0; i < m; i++) {
            char c = s1.charAt(i);
            int index = c - 'a';
            s1Counts[index] += 1;

            c = s2.charAt(i);
            index = c - 'a';
            windowCounts[index] += 1;
        }
        int matches = 0;
        for(int i = 0; i < 26; i++) {
            if(s1Counts[i] == windowCounts[i]) {
                matches += 1;
            }
        }

        if(matches == 26) {
            return true;
        }

        int l = 0;

        for(int r = m; r < n - 1; r++) {
            int c = s2.charAt(l);
            int index = c - 'a';
            windowCounts[index] -= 1;
            if(windowCounts[index] == s1Counts[index]) {
                matches += 1;
            }
            if(windowCounts[index] == s1Counts[index] - 1) {
                matches -= 1;
            }

            l += 1;
            c = s2.charAt(r);
            index = c - 'a';
            windowCounts[index] += 1;

            if(windowCounts[index] == s1Counts[index]) {
                matches += 1;
            }
            if(windowCounts[index] == s1Counts[index] + 1) {
                matches -= 1;
            }

            if(matches == 26) {
                return true;
            }
        }

        return false;
    }

    private boolean checkMapEquality(Map<Character, Integer> s1Counts, Map<Character, Integer> windowCounts) {
        for(var entry : s1Counts.entrySet()) {
            var k = entry.getKey();
            var v = entry.getValue();
            if(!windowCounts.containsKey(k)) {
                return false;
            }
            if(!windowCounts.get(k).equals(v)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var sp = new StringPermutation();
        System.out.println(sp.checkInclusion("ab", "eidbaooo"));
        System.out.println(sp.checkInclusionOptimized("ab", "eidbaoo"));
    }
}
