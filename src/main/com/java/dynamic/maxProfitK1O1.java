package main.com.java.dynamic;

/**
 * leetCode 121. 买卖股票的最佳时机，时间复杂度O(1)
 */
public class maxProfitK1O1 {
    public int maxProfit(int[] prices) {
        /**
         * 二维数组 dp[i][2]表示第i天的两种状态
         * dp[i][0] 表示 第i天手中不持有股票
         * dp[i][1] 表示 第i天手中持有股票
         */
        int n = prices.length;
//        int[][] dp = new int[n][2];
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0;i < n;i++) {
//            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
//            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        //最后一天不持有股票
        return dp_i_0;
    }
}
/**
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
