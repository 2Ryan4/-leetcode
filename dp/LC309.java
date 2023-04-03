package dp;

public class LC309 {
    public int maxProfit(int[] prices) {
        //定义dp数组
        //dp[i][0]：表示持有股票的状态，三种情况：今天买入股票，前一天是冷冻期；今天买入股票，前一天不是冷冻期；之前就买入股票了，维持持有股票的状态
        //dp[i][1]：表示维持不持有股票的状态，但股票不是这天卖出，之前就卖出了，说明前一天有可能是冷冻期，也可能不是冷冻期
        //dp[i][2]：表示这天卖出股票，为不持有股票的状态，前一天一定是持有股票
        //dp[i][3]：表示冷冻期，说明前一天一定是卖出股票了
        int len = prices.length;
        int[][] dp = new int[len][4];

        //初始化dp数组
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;

        //确定递推公式和遍历顺序
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3] - prices[i], dp[i - 1][1] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }

        return Math.max(dp[len - 1][1], Math.max(dp[len - 1][2], dp[len - 1][3]));
    }
}
