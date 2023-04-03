package dp;

public class LC188 {
    public int maxProfit(int k, int[] prices) {
        //定义dp数组
        int len = prices.length;
        int status = k * 2 + 1;
        int[][] dp = new int[len][status];

        //初始化dp数组
        for (int i = 0; i < status; i++) {
            if (i % 2 == 0) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = -prices[0];
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < status; j++) {
                if (j % 2 == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }

        return dp[len - 1][status - 1];

    }
}
