package dp;

public class LC70 {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        //dp数组表示爬楼梯的方法数，下标表示楼梯数
        int[] dp = new int[n + 1];

        //初始化dp数组，楼梯数为1只能爬一步，2有两种方法，一步一步爬和一次性爬两步
        dp[1] = 1;
        dp[2] = 2;

        //确定递推公式
        for (int i = 3; i <= n; i++) {
            //爬楼梯只能爬一步或两步，当楼梯数为n-1时，爬一步就到了；当楼梯数为n-2时，一次性爬2步就到了
            //所以爬到n阶楼梯时，方法数就是爬到n-1阶楼梯的方法数加上爬到n-2阶楼梯的方法数
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
