package LeetCode.array;

/**
 * 找出数组prices中最大的差值（最大值，最小值）
 * remember that: buy 的的下标一定小于或者等于 sell的下标
 * Created by bobo on 2015/9/13.
 */
public class BestTime2BuyAndSellStock {
    public static int maxProfit(int[] prices){
        // TLE  expected!
       /* int maxPro = 0;
        for (int i = 0; i < prices.length; i++){
            for (int j = i+1; j <prices.length; j++){
                int temp = prices[j] - prices[i];
                if(temp > maxPro) maxPro = temp;
            }
        }
        return maxPro;*/
        /**
         * Kadane's Algorithm
         * maxCur = current maximum value
         * maxSoFar = maximum value found so far
         *
         */
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            //这里其实也确定当前最低买价！！！
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;

        //记录当前最低价，计算今日收益。记录收益最高值。
        //动态规划
        /*if (prices.length == 0 ) return 0;
        int minPri = prices[0], maxPro = 0;
        for (int i = 1; i < prices.length; i++){
            minPri = Math.min(prices[i-1], minPri);
            maxPro = Math.max(maxPro, prices[i]-minPri);
        }
        return maxPro;*/
    }

    public static void main(String[] args) {
        int[] prices = {2,1,6,7};
        System.out.println(maxProfit(prices));
    }
}
