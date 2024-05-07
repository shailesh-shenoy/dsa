package me.shailesh.algorithms.basic;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        var complement = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {

            if(nums[i] > target) {
                continue;
            }

            if(complement.containsKey(nums[i])) {
                result[0] = i;
                result[1] = complement.get(nums[i]);
                return result;
            }

            int c = target - nums[i];

            complement.put(c, i);
        }
        return result;
    }
}
