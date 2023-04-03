package dp;

public class LC122 {
    public int maxProfit(int[] prices) {
        //定义dp数组，dp[i][0/1]表示第i+1天手头持有或不持有该支股票的手头最大现金
        int[][] dp = new int[prices.length][2];

        //初始化dp数组
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        //确定递推公式和遍历顺序
        for (int i = 1; i < prices.length; i++) {
            //第i+1天持有股票的手头最大现金由前一天的状态推导出来，即之前就持有了和之前不持有但这天买入股票后再持有
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            //第i+1天不持有股票的手头最大现金由前一天的状态推导出来，即之前就不持有了和之前持有但这天卖出股票后不再持有
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        //最后一天肯定是不持有股票的利润最大
        return dp[prices.length - 1][1];
    }
}
