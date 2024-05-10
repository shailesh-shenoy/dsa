package me.shailesh.algorithms.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int start = 0;
        int end = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if((i > 0) && (nums[i] == nums[i - 1])) {
                continue;
            }
            start = i + 1;
            end = n - 1;
            while(start < end) {

                int sum = nums[start] + nums[end] + nums[i];
                if(sum == 0) {
                    List<Integer> threeSum = List.of(nums[start], nums[end], nums[i]);
                    result.add(threeSum);
                    start += 1;
                    while(nums[start] == nums[i] && start < end) {
                        start += 1;
                    }
                    continue;
                }
                if(sum < 0) {
                    start += 1;
                    continue;
                }
                end -= 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var ts = new ThreeSum();
        var result = ts.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for(var r : result) {
            System.out.println(r);
        }
    }
}
