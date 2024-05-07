package me.shailesh.algorithms.basic;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        var sortedMap = new HashMap<String, List<String>>();
        for(String s : strs) {
            String sortedS = sortString(s);
            if(sortedMap.containsKey(sortedS)) {
                sortedMap.get(sortedS).add(s);
            } else {
                var temp = new ArrayList<String>();
                temp.add(s);
                sortedMap.put(sortedS, temp);
            }
        }
        return new ArrayList<List<String>>(sortedMap.values());
    }

    private String sortString(String s) {
        char[] charsInS = s.toCharArray();
        Arrays.sort(charsInS);
        return new String(charsInS);
    }

    public List<List<String>> groupAnagramsWithMaps(String[] strs) {
        var groups = new HashMap<Map<Character, Integer>, List<String>>();
        for(String s : strs) {
            var charCounts = new HashMap<Character, Integer>();
            var charsInS = s.toCharArray();
            for(char c : charsInS) {
                if(charCounts.containsKey(c)) {
                    charCounts.put(c, charCounts.get(c) + 1);
                } else {
                    charCounts.put(c, 1);
                }
            }
            if(groups.containsKey(charCounts)) {
                groups.get(charCounts).add(s);
            } else {
                var temp = new ArrayList<String>();
                temp.add(s);
                groups.put(charCounts, temp);
            }
        }
        return new ArrayList<List<String>>(groups.values());
    }
}
