package dp;

public class LC509 {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        //dp表示斐波那契数列
        int[] dp = new int[n + 1];

        //初始化dp数组
        dp[0] = 0;
        dp[1] = 1;

        //确定递推公式
        //优化：不需要记录整个队列，只需要记录最后结果
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
