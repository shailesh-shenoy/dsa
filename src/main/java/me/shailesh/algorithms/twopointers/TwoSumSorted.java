package me.shailesh.algorithms.twopointers;

public class TwoSumSorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int sum = 0;
        int[] result = new int[2];
        while(left < right) {
            sum = numbers[left] + numbers[right];
            if(sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }
            if(sum > target) {
                right -= 1;
                continue;
            }
            left += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSumSorted ts = new TwoSumSorted();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = ts.twoSum(numbers, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
