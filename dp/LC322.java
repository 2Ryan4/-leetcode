package dp;

import java.util.Arrays;

public class LC322 {
    public int coinChange(int[] coins, int amount) {
        //定义dp数组，dp[i]表示凑成总金额为i的最小硬币数
        int[] dp = new int[amount + 1];

        //初始化dp数组
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        //确定遍历顺序
        //因为求的是物品数量，所以两层for的位置不重要
        //物品的遍历顺序正序倒序都可以
        for (int i = coins.length - 1; i >= 0; i--) {
            for (int j = coins[i]; j <= amount; j++) {
                //要判断前一个金额是否能凑成
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[amount];
        }


    }
}
