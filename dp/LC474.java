package dp;

public class LC474 {
    public int findMaxForm(String[] strs, int m, int n) {
        //定义dp[i][j]，dp[i][j]表示在0容量为i，1容量为j的背包装入物品的最大数量
        //物品为字符串，重量为此字符串0的数量和1的数量
        int[][] dp = new int[m + 1][n + 1];

        //初始化dp数组，默认值为0已经完成初始化工作

        //先遍历物品
        for (String str : strs) {
            //先统计当前字符串的0和1数量
            int zeroNum = 0;
            int oneNum = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }

            //遍历背包
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
