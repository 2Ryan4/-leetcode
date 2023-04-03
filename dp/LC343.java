package dp;

public class LC343 {
    public int integerBreak(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        //dp[i+1]表示i的相加数的最大乘积
        int[] dp = new int[n + 1];

        //初始化dp数组
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        //递推
        for (int i = 3; i <= n; i++) {
            //要使乘积最大，那么i要拆分成m个相同的数
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(Math.max(j * (i - j), j * dp[i - j]), dp[i]);
            }
        }

        return dp[n];
    }
}
