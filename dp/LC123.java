package dp;

public class LC123 {
    public int maxProfit(int[] prices) {
        //定义dp数组
        //dp[i][0]表示不操作
        //dp[i][1]表示第一次持有股票的状态
        //dp[i][2]表示第一次不持有股票的状态
        //dp[i][3]表示第二次持有股票的状态
        //dp[i][4]表示第二次不持有股票的状态
        int[][] dp = new int[prices.length][5];

        //初始化dp数组
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;

        //确定递推公式和遍历顺序
        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        //也可以是max(dp[len-1][2], dp[len-1][4])，但dp[len-1][4]是大于等于dp[len-1][2]，dp[len-1][4]是dp[len-1][2]的状态间接转移
        return dp[prices.length - 1][4];
    }
}
