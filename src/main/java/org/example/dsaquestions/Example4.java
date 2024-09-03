package org.example.dsaquestions;

import java.util.Arrays;

/*
    Best Time to Buy and Sell Stock
    Example: Input: prices = [7,1,5,3,6,4] = min, maxDiff
             Output: 5
             Input: prices = [7,6,4,3,1]
             Output: 0
 */
public class Example4 {

    /*public int getMaxProfit(int [] tBookDay) { //7,1,5,3,6,4
        int min = Integer.MAX_VALUE;
        System.out.println(min);
        int maxDiff = 0; //0

        for (int i = 0; i < tBookDay.length; i++) {
            min = Math.min(min,tBookDay[i]); // 7,1,1,1,1,1
            maxDiff = Math.max(maxDiff,tBookDay[i] - min); // 0,0,4,4,5,5
        }

        return maxDiff;
    }*/

    //same as above get max profit - Leetcode Problem: 121
    public int getMaxProfit(int [] prices) {
        int profit = 0, min = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            else
                profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }

    //get all max profit - [7,1,5,3,6,4] - Leetcode Problem: 122
    public int getAllMaxProfit(int [] prices){
        int profit = 0;

        for(int i=1;i < prices.length;i++){ //1,2,3,4,5
            if(prices[i] > prices[i-1]){ //1 > 7,5>1,3>5,6>3,4>3
                profit += prices[i] - prices[i-1]; // 0,4,4,7,7
            }
        }

        return profit; //7
    }

    //Get atmost 2 profit - Leetcode Problem: 123
    public int getAtMost2MaxProfit(int [] prices) {
        int n = prices.length;
        int[] profit = new int[n];
        Arrays.fill(profit, 0);
        int max_price=prices[n-1];
        for(int i=n-2;i>=0;i--) {
            if(prices[i]>max_price)
                max_price=prices[i];
            profit[i] = Math.max(profit[i + 1], max_price - prices[i]);
        }
        int min_price=prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] < min_price)
                min_price = prices[i];
            profit[i] = Math.max(profit[i - 1], profit[i] + (prices[i] - min_price));
        }
        int res=profit[n-1];
        return res;
    }
    //Leetcode Problem: 188
    public int maxKTransactionProfit(int k, int [] prices) {
        int n = prices.length;
        int[] profit_after_buying = new int[k + 1];
        Arrays.fill(profit_after_buying, Integer.MIN_VALUE);

        int[] profit_after_selling = new int[k + 1];
        Arrays.fill(profit_after_selling, 0);

        for (int i = 0; i < n; ++i) {
            int cur_price = prices[i];
            for (int j = k; j >= 1; --j) {
                profit_after_buying[j] = Math.max(profit_after_buying[j], profit_after_selling[j-1] - cur_price);
                profit_after_selling[j] = Math.max(profit_after_selling[j], profit_after_buying[j] + cur_price);
            }
        }
        return profit_after_selling[k];
}
    public static void main(String[] args) {
        Example4 ex = new Example4();
        int [] t =  {7, 1, 5, 3, 6, 4, 9, 8};
        System.out.println("Max profit in a week=> "+ex.getAtMost2MaxProfit(t));
    }
}
