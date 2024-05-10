package me.shailesh.algorithms.twopointers;

public class WaterContainer {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right) {
            int min;
            int w = right - left;
            if(height[left] < height[right]) {
                min = left;
                left += 1;
            } else {
                min = right;
                right -= 1;
            }
            int area = height[min] * w;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        var wc = new WaterContainer();
        System.out.println(wc.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
