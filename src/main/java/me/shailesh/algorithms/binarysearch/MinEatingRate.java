package me.shailesh.algorithms.binarysearch;

public class MinEatingRate {
    public int minEatingSpeedBF(int[] piles, int h) {
        int n = piles.length;
        int maxRate = 0;
        for(int num : piles) {
            maxRate = Math.max(maxRate, num);
        }
        for(int i = 1; i <= maxRate; i++) {
            int time = 0;
            for(int num : piles) {
                time += ((num + i - 1) / i);
                if(time > h) {
                    break;
                }
            }
            if(time <= h) {
                return i;
            }
        }
        return maxRate;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxRate = 0;
        for(int num : piles) {
            maxRate = Math.max(maxRate, num);
        }

        int left = 1;
        int right = maxRate;
        int minRate = maxRate;

        while(left <= right) {
            int rate = (left + right) / 2;
            int time = 0;
            for(int num : piles) {
                time += (num + rate - 1) / rate;
            }

            if(time <= h) {
                minRate = Math.min(minRate, rate);
                right = rate - 1;
                continue;
            }
            left = rate + 1;
        }
        return minRate;
    }

    public static void main(String[] args) {
        var mer = new MinEatingRate();
        System.out.println(mer.minEatingSpeedBF(new int[]{3,6,7,11}, 8));
        System.out.println(mer.minEatingSpeed(new int[]{3,6,7,11}, 8));
    }
}
