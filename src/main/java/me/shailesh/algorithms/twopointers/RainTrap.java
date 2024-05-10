package me.shailesh.algorithms.twopointers;

public class RainTrap {
    public int trap(int[] height) {
        int n = height.length;
        int totalArea = 0;
        var leftHeights = new int[n];
        var rightHeights = new int[n];
        int maxL = 0;
        int maxR = 0;

        for(int i = 0; i < n; i++) {
            leftHeights[i] = maxL;
            maxL = Math.max(height[i], maxL);
            rightHeights[n - 1 - i] = maxR;
            maxR = Math.max(height[n - 1 - i], maxR);
        }
        for(int i = 0; i < n; i++) {
            int minH = Math.min(leftHeights[i], rightHeights[i]);
            int area = Math.max(minH - height[i], 0);
            totalArea += area;
        }
        return totalArea;
    }

    public int trapTP(int[] height) {
        int totalArea = 0;
        int l = 0;
        int r = height.length - 1;
        int maxL = height[l];
        int maxR = height[r];

        while(l < r) {
            int area = 0;
            if(maxL < maxR) {
                l += 1;
                maxL = Math.max(maxL, height[l]);
                area = maxL - height[l];
            } else {
                r -= 1;
                maxR = Math.max(maxR, height[r]);
                area = maxR - height[r];
            }
            area = Math.max(area, 0);
            totalArea += area;
        }
        return totalArea;
    }

    public static void main(String[] args) {
        var rt = new RainTrap();
        System.out.println(rt.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(rt.trapTP(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
