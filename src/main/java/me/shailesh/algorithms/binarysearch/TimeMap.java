package me.shailesh.algorithms.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {
    private Map<String, List<Value>> map;
    public record Value(int timestamp, String value) {};
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<Value>());
        }
        map.get(key).add(new Value(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        String result = "";
        int min = Integer.MAX_VALUE;
        var values = map.get(key);
        int left = 0;
        int right = values.size() - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            var current = values.get(mid);
            if(current.timestamp() == timestamp) {
                return current.value;
            }
            if(current.timestamp() > timestamp) {
                right = mid - 1;
                continue;
            }
            left = mid + 1;
            result = current.value();
        }
        return result;
    }

    public static void main(String[] args) {
        var tm = new TimeMap();
        tm.set("foo", "bar", 1);
        System.out.println(tm.get("foo", 1));
        System.out.println(tm.get("foo", 3));
        tm.set("foo", "bar2", 4);
        System.out.println(tm.get("foo", 4));
        System.out.println(tm.get("foo", 5));
    }
}


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */