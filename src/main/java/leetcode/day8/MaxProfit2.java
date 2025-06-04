package leetcode.day8;

/**
 * @author feiyang.duan
 * @date 2025/5/19
 * @description 买卖股票的最佳时机II
 */
public class MaxProfit2 {

    public static void main(String[] args) {
        int i = maxProfit(new int[]{7,6,4,3,1});
        System.out.println(i);
    }

    public static int maxProfit(int[] prices) {
        int totalProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                // 如果当日价格小于历史最低价格，更新历史最低价
                minPrice = prices[i];
            }
            // 如果当日不是最低价，那当日价格-之前的最低价
            else {
                int profile = prices[i] - minPrice;
                totalProfit = totalProfit + profile;
                // 重置minPrice
                minPrice = prices[i];
            }
        }
        return totalProfit;
    }
}
