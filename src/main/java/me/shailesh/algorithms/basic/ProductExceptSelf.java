package me.shailesh.algorithms.basic;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        var n = nums.length;
        var before = new int[n];
        var after = new int[n];
        var result = new int[n];
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                before[i] = 1;
                after[n - 1] = 1;
                continue;
            }
            before[i] = nums[i - 1] * before[i - 1];
            after[n - 1 - i] = nums[n - i] * after[n - i];
        }

        for(int i = 0; i < n; i++) {
            result[i] = before[i] * after[i];
        }
        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
        var n = nums.length;
        var result = new int[n];

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                result[i] = 1;
                continue;
            }
            result[i] = result[i - 1] * nums[i - 1];
        }
        int postfix = 1;
        for(int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * postfix;
            postfix *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        var pes = new ProductExceptSelf();
        var result = pes.productExceptSelf(new int[]{1, 2, 3, 4});
        for(var r : result) {
            System.out.println(r);
        }
        result = pes.productExceptSelf(new int[]{1, 2, 3, 4});
        for(var r : result) {
            System.out.println(r);
        }
    }
}
