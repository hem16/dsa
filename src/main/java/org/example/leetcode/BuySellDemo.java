package org.example.leetcode;

public class BuySellDemo {

    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        int maxPrice = getMaxProfit(prices);
        System.out.println("maxPrice = " + maxPrice);
    }

    private static int getMaxProfit(int [] prices) {
        int min = Integer.MAX_VALUE;
        int maxPrice = 0;
        for (int i = 0; i < prices.length-1; i++) {
            min = Integer.min(prices[i],min);//7,
            maxPrice = Integer.max(maxPrice,prices[i+1] - min);//0,
        }

        return maxPrice;
    }

}
