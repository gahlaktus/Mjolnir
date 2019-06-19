package LeetCode.array;

/**
 * Created by bobo on 2015/9/13.
 */
public class BestTime2BuyAndSellStockII {
    public int maxProfit(int[] prices){
        //don't think too much!!!
        if (prices.length <= 2) return 0;
        int total = 0;
        for (int i = 1; i < prices.length; i++){
            int temp = prices[i] - prices[i-1];
            if (temp > 0){
                total += temp;
            }
        }
        return total;
    }
}
