package me.shailesh.algorithms.binarysearch;

public class BinarySearch {
    public int searchIterative(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int t = 0;
        while(start < end) {
            t = (start + end) / 2;
            if(nums[t] == target) {
                return t;
            }
            if(nums[t] < target) {
                start = t + 1;
                continue;
            }
            end = t - 1;
        }
        return -1;
    }

    public int searchRecursive(int[] nums, int target, int start, int end) {
        int t = (start + end) / 2;
        if(nums[t] == target) {
            return t;
        }
        if(start >= end) {
            return -1;
        }
        if(nums[t] < target) {
            return searchRecursive(nums, target, t + 1, end);
        }
        return searchRecursive(nums, target, start, t - 1);
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(bs.searchIterative(nums, 5));
        System.out.println(bs.searchRecursive(nums, 5, 0, nums.length - 1));
    }
}
