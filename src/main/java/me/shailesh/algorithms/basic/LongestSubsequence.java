package me.shailesh.algorithms.basic;

import java.util.Arrays;
import java.util.HashSet;

public class LongestSubsequence {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int len = 1;
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                continue;
            }
            if(nums[i - 1] == nums[i] - 1) {
                len += 1;
            } else {
                len = 1;
            }
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }

    public int longestConsecutiveSet(int[] nums) {
        var numSet = new HashSet<Integer>();
        for( int n : nums) {
            numSet.add(n);
        }
        int len = 0;
        int maxLen = 0;
        for(int n : numSet) {
            if(numSet.contains(n-1)) {
               len = 0;
               continue;
            }
            while(numSet.contains(n + len)) {
                len += 1;
            }
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubsequence ls = new LongestSubsequence();
        int[] nums = {100, 4, 200, 1, 3, 2, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15};
        System.out.println(ls.longestConsecutive(nums));
        System.out.println("Set based solution: " + ls.longestConsecutiveSet(nums));
    }
}
