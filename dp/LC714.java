package dp;

public class LC714 {
    public int maxProfit(int[] prices, int fee) {
        //定义dp数组
        int len = prices.length;
        int[][] dp = new int[len][2];

        //初始化
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        //递推公式
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }

        return dp[len - 1][1];
    }
}
