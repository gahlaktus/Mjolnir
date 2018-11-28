package LeetCode.array;

/**
 * �ҳ�����prices�����Ĳ�ֵ�����ֵ����Сֵ��
 * remember that: buy �ĵ��±�һ��С�ڻ��ߵ��� sell���±�
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
            //������ʵҲȷ����ǰ�����ۣ�����
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;

        //��¼��ǰ��ͼۣ�����������档��¼�������ֵ��
        //��̬�滮
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
