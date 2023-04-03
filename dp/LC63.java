package dp;

public class LC63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //dp[i][j]表示能到达obstacleGrid[i][j]的路径数量
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        //初始化dp数组
        //若obstacleGrid[i][j]=1，则表示有障碍物，能到达该位置的路径数量为0
        //初始化第一行
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        //初始化第一列
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        //递推公式
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
