package main.com.java.dynamic.maxprofit;
/**
 * leetCode 309. 最佳买卖股票时机含冷冻期,k为任意正整数
 */
public class maxProfitKMaxCooldown {
    public int maxProfit(int[] prices) {
        /**
         * k 为任意整数
         * dp[i][0] 表示第i天不持有股票
         * dp[i][1] 表式第i天持有股票
         * 冷冻期一天
         */
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0;i < n;i++) {
            //i = 0时，i-1=-1
            if (i - 1 == -1) {
                //base case
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            if (i - 2 == -1) {
                //base case
                dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[i]);
                dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}
/**
 * leetCode 309. 最佳买卖股票时机含冷冻期,k为任意正整数
 * 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
