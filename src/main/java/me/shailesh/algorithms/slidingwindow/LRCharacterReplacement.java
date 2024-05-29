package me.shailesh.algorithms.slidingwindow;

import java.util.HashMap;

public class LRCharacterReplacement {
    public int characterReplacement(String s, int k) {
        var charCount = new HashMap<Character, Integer>();

        int l = 0;
        int maxCount = 0;

        for(int r = 0; r < s.length(); r++) {
            var c = s.charAt(r);
            if(!charCount.containsKey(c)) {
                charCount.put(c, 0);
            }
            charCount.put(c, charCount.get(c) + 1);
            int maxF = 0;
            for(int count : charCount.values()) {
                maxF = Math.max(maxF, count);
            }

            int windowLength = r - l + 1;
            if(windowLength - maxF <= k) {
                maxCount = Math.max(maxCount, windowLength);
                continue;
            }

            // Invalid Window
            var temp = s.charAt(l);
            charCount.put(temp, charCount.get(temp) - 1);
            l += 1;
        }
        return maxCount;
    }
}
