package leetcode.day8;

/**
 * @author feiyang.duan
 * @date 2025/5/19
 * @description 买卖股票的最佳时机
 */
public class MaxProfit {

    public static void main(String[] args) {
        int i = maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(i);
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                // 如果当日价格小于历史最低价格，更新历史最低价
                minPrice = prices[i];
            }
            // 如果当日不是最低价，那就试着当日价格-之前的最低价，看看是否大于历史价差
            else if ((prices[i] - minPrice) > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
