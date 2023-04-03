package dp;

public class LC516 {
    public int longestPalindromeSubseq(String s) {
        //定义dp数组，dp[i][j]表示[i,j]的s的回文子序列的最大长度
        int[][] dp = new int[s.length()][s.length()];

        //确定递推公式

        //初始化dp数组
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        //确定遍历顺序
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
