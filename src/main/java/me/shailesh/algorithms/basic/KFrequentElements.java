package me.shailesh.algorithms.basic;

import java.util.HashMap;
import java.util.PriorityQueue;

public class KFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        var frequencies = new HashMap<Integer, Node>();
        for (int num : nums) {
            if (frequencies.containsKey(num)) {
                var node = frequencies.get(num);
                node.priority += 1;
            } else {
                var node = new Node(1, num);
                frequencies.put(num, node);
            }
        }
        System.out.println(frequencies);
        var pq = new PriorityQueue<Node>(frequencies.values());
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            if(!pq.isEmpty()) {
                result[i] = pq.poll().value;
            }
        }
        return result;
    }

    public static class Node implements Comparable<Node> {
        Integer priority;
        Integer value;

        public Node(int priority, int value) {
            this.priority = priority;
            this.value = value;
        }

        @Override
        public int compareTo(Node other) {
            return other.priority.compareTo(this.priority);
        }
    }
}
