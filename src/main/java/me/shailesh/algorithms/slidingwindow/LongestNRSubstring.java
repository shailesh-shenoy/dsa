package me.shailesh.algorithms.slidingwindow;

import java.util.HashSet;

public class LongestNRSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        int i = 0;
        int j = 1;
        int l = 1;
        int maxL = 1;
        var subSet = new HashSet<Character>();
        subSet.add(s.charAt(0));

        while(j < s.length()) {
            var c = s.charAt(j);
            if(!subSet.contains(c)) {
                j += 1;
                l = j - i;
                maxL = Math.max(l, maxL);
                subSet.add(c);
                continue;
            }
            while(i != j) {
                var temp = s.charAt(i);
                i += 1;
                subSet.remove(temp);
                if(temp == c) {
                    break;
                }
            }
            j += 1;
            subSet.add(c);
        }
        return maxL;
    }

    public int lengthOfLongestSubstringCleaner(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        int l = 0;
        int maxL = 1;
        var subSet = new HashSet<Character>();
        for(int r = 0; r < s.length(); r++) {
            var c = s.charAt(r);
            while(subSet.contains(c)) {
                subSet.remove(s.charAt(l));
                l += 1;
            }
            subSet.add(c);
            maxL = Math.max(maxL, r - l + 1);
        }
        return maxL;
    }

    public static void main(String[] args) {
        var lnr = new LongestNRSubstring();
        System.out.println(lnr.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lnr.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lnr.lengthOfLongestSubstring("pwwkew"));
        System.out.println(lnr.lengthOfLongestSubstring(" "));
        System.out.println(lnr.lengthOfLongestSubstring("au"));
        System.out.println(lnr.lengthOfLongestSubstring("aab"));
        System.out.println(lnr.lengthOfLongestSubstring("dvdf"));
        System.out.println(lnr.lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(lnr.lengthOfLongestSubstring("abcdefg"));
        System.out.println(lnr.lengthOfLongestSubstringCleaner("abcabcbb"));
        System.out.println(lnr.lengthOfLongestSubstringCleaner("bbbbb"));
        System.out.println(lnr.lengthOfLongestSubstringCleaner("pwwkew"));
        System.out.println(lnr.lengthOfLongestSubstringCleaner(" "));
        System.out.println(lnr.lengthOfLongestSubstringCleaner("au"));
        System.out.println(lnr.lengthOfLongestSubstringCleaner("aab"));
        System.out.println(lnr.lengthOfLongestSubstringCleaner("dvdf"));
        System.out.println(lnr.lengthOfLongestSubstringCleaner("tmmzuxt"));
        System.out.println(lnr.lengthOfLongestSubstringCleaner("abcdefg"));
    }
}
