package main.com.java.dynamic;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你 k 种⾯值的硬币，⾯值分别为 c1, c2 ... ck ，每种硬 币的数量⽆限，再给⼀个总⾦额 amount ，问你最少需要⼏枚硬币凑出这个 ⾦额，如果不可能凑出，算法返回 -1 。
 */
public class CoinChangeSolution {
    /**
     * 1.递归解法
     */
    int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }

    int dp(int[] coins, int n) {
        //base case
        if (n == 0) return 0;
        if (n < 0) return -1;
        //取最小值，则初始化max_value
        Integer res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, n - coin);
            //子问题无解，跳过
            if (subProblem == -1) continue;
            res = Math.min(res, 1 + subProblem);
        }
        return res != Integer.MAX_VALUE ? res : -1;
    }
    /**
     * 递归解法时间复杂度：子问题总数 * 每个子问题的时间
     * O(n^k) * O(k) = O(k * n^k)
     */

    /**
     * 2.带备忘录的递归
     */
    int coinChangeWithMap(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>(amount);
        return dpWithMap(coins, amount, memo);
    }

    /**
     * 完全消除了子问题的冗余，所以子问题不会超过金额数 n，即子问题数目为O(n)
     * 处理一个子问题的时间不变，仍然是O(k)，所以总时间复杂度是O(nk);
     */
    int dpWithMap(int[] coins, int n, Map<Integer, Integer> memo) {
        //使用备忘录，避免重复计算
        if (memo.get(n) != null) return memo.get(n);
        //base case
        if (n == 0) return 0;
        if (n < 0) return -1;
        //取最小值，则初始化max_value
        Integer res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dpWithMap(coins, n - coin, memo);
            //子问题无解，跳过
            if (subProblem == -1) continue;
            res = Math.min(res, 1 + subProblem);
        }
        memo.put(n, res != Integer.MAX_VALUE ? res : -1);
        return memo.get(n);
    }

    /**
     * 3.dp数组的迭代解法
     * 我们也可以自底向上使用dp table来消除重叠子问题
     */
    int coinChangeDP(int[] coins, int amount) {
        //声明dp数组，赋初值
        int dp[] = new int[amount + 1];
        int initValue = amount +1;
        for (int i = 0; i < dp.length; i++) dp[i] = initValue;
        dp[0] = 0;
        for (int i = 0;i < dp.length; i++) {
            //内循环for，求所有子问题 + 1的最小值
            for (int coin : coins) {
                //子问题无解跳过
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == initValue ? -1 : dp[amount];
    }


    /**
     * 测试类
     */
    @Test
    public void testCoinChange() {
        int[] coins = {1,2,5};
        int amount = 36;
        System.out.println(System.currentTimeMillis());
        System.out.println(coinChange(coins, amount));
        System.out.println(System.currentTimeMillis());
        System.out.println(coinChangeWithMap(coins, amount));
        System.out.println(System.currentTimeMillis());
        System.out.println(coinChangeDP(coins, amount));
        System.out.println(System.currentTimeMillis());
    }
}
