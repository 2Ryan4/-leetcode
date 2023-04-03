package dp;

public class LC72 {
    public int minDistance(String word1, String word2) {
        //定义
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        //确认递推公式

        //初始dp数组
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
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i - 1][j - 1] + 1, dp[i][j - 1] + 1));
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
