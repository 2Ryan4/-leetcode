package dp;

public class LC583 {
    public int minDistance(String word1, String word2) {
        //定义dp数组，dp[i][j]表示以i-1为结尾的word1变成以j-1为结尾的word2的最小删除次数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        //确认递推公式

        //初始化dp数组
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        dp[0][0] = 0;

        //确认遍历顺序
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 2));
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
