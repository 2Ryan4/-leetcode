package dp;

public class LC518 {
    public int change(int amount, int[] coins) {
        //定义dp数组，dp[i]表示总金额为i的硬币组合的最大方法数
        int[] dp = new int[amount + 1];

        //因为硬币的数量为无限个，为完全背包问题
        //初始化dp数组
        dp[0] = 1;

        //确定递推和遍历顺序
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        //两层for循环不能颠倒
        //先遍历硬币，再遍历背包，求的是组合数，即不在乎元素顺序
        //假设coin[i]和coin[i+1]都被装入背包，coin[i]一定是在coin[i+1]之前被装入背包，只有一种情况
        //先遍历背包，再遍历硬币，则会出现coin[i]在coin[i+1]之后再被装入背包，两种情况，即要注意元素顺序

        return dp[amount];
    }
}
