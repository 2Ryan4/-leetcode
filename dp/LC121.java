package dp;

public class LC121 {
    public int maxProfit(int[] prices) {
        //定义dp数组，dp[i][0]第i+1天持有股票的最大现金，dp[i][1]第i+1天不持有股票的最大现金
        int[][] dp = new int[prices.length][2];

        //初始化dp数组
        //因为一开始收头现金为0，持有股票，手头现金为负数
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        //确定遍历顺序
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        //因为股票只能买卖一次，最后一天肯定是不持有股票的手头现金最多
        return dp[prices.length - 1][1];
    }
}
