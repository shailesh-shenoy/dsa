package me.shailesh.algorithms.binarysearch;

import java.sql.SQLOutput;

public class RotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(left == right) {
                return nums[mid];
            }
            if(nums[mid] > nums[right]) {
                left = mid + 1;
                continue;
            }
            right = mid;
        }
        return left;
    }

    public int searchRotatedArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            int current = nums[mid];
            int l = nums[left];
            int r = nums[right];
            if(current == target) {
                return mid;
            }

            if(target == l) {
                return left;
            }
            if(target == r) {
                return right;
            }
            if(target < current) {
                if(target > l) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                continue;
            }
            if(target < r) {
                left = mid + 1;
            }
            right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        var rsa = new RotatedSortedArray();
        System.out.println(rsa.findMin(new int[]{3,4,5,1,2}));
        System.out.println(rsa.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(rsa.findMin(new int[]{11,13,15,17}));
        System.out.println("Search rotated array");
        System.out.println(rsa.searchRotatedArray(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(rsa.searchRotatedArray(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(rsa.searchRotatedArray(new int[]{4,5,6,7,0,1,2}, 5));
        System.out.println(rsa.searchRotatedArray(new int[]{4,5,6,7,0,1,2}, 2));
        System.out.println(rsa.searchRotatedArray(new int[]{4,5,6,7,0,1,2}, 4));
        System.out.println(rsa.searchRotatedArray(new int[]{4,5,6,7,0,1,2}, 7));
        System.out.println(rsa.searchRotatedArray(new int[]{4,5,6,7,0,1,2}, 1));
    }
}
