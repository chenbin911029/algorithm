package main.com.java.dynamic;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * 斐波那契数列
 */
public class Fibonacci {
    /**
     * 1.递归解法
     */
    int fibonacciRecursion(int n) {
        if (n == 1 || n == 2) return 1;
        return fibonacciRecursion(n-1) + fibonacciRecursion(n-2);
    }

    /**
     * 2.带备忘录的递归解法
     * 既然存在大量重复计算，那可以造一个备忘录，每次遇到相同子问题，直接取结果，不用再耗费时间
     * 自顶向下
     */
    int fibWithMap(int n) {
        if (n < 1) return 0;
        Map<Integer, Integer> memo = new HashMap<>(n);
        return helper(memo, n);
    }

    int helper(Map<Integer, Integer> memo, int n) {
        //base case
        if (n == 1 || n == 2) return 1;
        //map存取已经计算过的
        if (memo.get(n) != null) return memo.get(n);
        memo.put(n, helper(memo, n-1) + helper(memo, n-2));
        return memo.get(n);
    }
    /**
     * 3.dp数组的迭代解法
     * 自底向上
     */
    int fibDP(int n) {
        int[] dp = new int[n+1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 递归算法的时间复杂度计算
     * 子问题个数 * 解决一个子问题需要的时间
     * 二叉树节点总数为指数级别
     * 子问题 f(n-1) + f(n-2)为常数
     * O(2^n) * O(1)
     * 递归解法存在大量的重复计算
     * f(20) = f(19) + f(18)
     * =f(18)+f(17)+(17)+f(16)
     * =f(16)+(f17)+f(16)+(15)+f(16)+(15)+f(15)+f(14)
     * =.......
     * 显然f(18)开始，往下存在大量的重复计算，重叠子问题
     */

    @Test
    public void test() {
        System.out.println(System.currentTimeMillis());
        System.out.println(fibonacciRecursion(40));
        System.out.println(System.currentTimeMillis());
        System.out.println(fibWithMap(40));
        System.out.println(System.currentTimeMillis());
        System.out.println(fibDP(40));
        System.out.println(System.currentTimeMillis());
    }
}
