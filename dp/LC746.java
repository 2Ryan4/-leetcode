package dp;

public class LC746 {
    public int minCostClimbingStairs(int[] cost) {
        //dp[i]表示爬到第i阶楼梯的最低费用，dp[n]表示爬到楼顶的最低费用
        int n = cost.length;
        int[] dp = new int[n + 1];

        //初始化dp数组
        //因为可以选择从下标为0或1的楼梯可以爬起，故费用为0
        dp[0] = 0;
        dp[1] = 0;

        //确定递推公式
        for (int i = 2; i <= n; i++) {
            //有两种爬法，一种为在第i-1阶楼梯爬一步，另一种为在第i-2阶楼梯爬两步
            //取花费最少的爬法
            dp[i] = Math.min(dp[i - 1] + cost[i -1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }
}
