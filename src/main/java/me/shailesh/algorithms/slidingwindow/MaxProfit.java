package me.shailesh.algorithms.slidingwindow;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j]-prices[i]);
            }
        }
        return maxProfit;
    }

    public int maxProfitOptimized(int[] prices) {
        int maxProfit = 0;
        int left = 0;
        int right = left + 1;

        while(right < prices.length) {
            maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            if(prices[right] <= prices[left]) {
                left = right;
            }
            right += 1;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        var mp = new MaxProfit();
        System.out.println(mp.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(mp.maxProfitOptimized(new int[]{7,1,5,3,6,4}));
    }
}
