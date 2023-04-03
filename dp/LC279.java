package dp;

import java.util.Arrays;

public class LC279 {
    public int numSquares(int n) {
        //定义dp数组，dp[i]表示凑成i的最小数量
        int[] dp = new int[n + 1];

        //确定递推公式

        //初始化dp数组
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        //确定遍历顺序
        //背包一定要正序
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (j - i * i >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }

        return dp[n];


    }
}
