package dp;

public class LC62 {
    public int uniquePaths(int m, int n) {
        //dp[i][j]表示走到map[i][j]的位置的路径数量
        int[][] dp = new int[m][n];

        //因为起始位置为map的左上角，只能向下或向右走
        //初始化第一列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //初始化第一行
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        //递推公式
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //到达map[i][j]有两种方式
                //在map[i-1][j]向下走，在map[i][j-1]向右走
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m-1][n-1];
    }
}
