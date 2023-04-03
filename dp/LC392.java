package dp;

public class LC392 {
    public boolean isSubsequence(String s, String t) {
        //定义dp数组，dp[i][j]表示已i-1为结尾的s和j-1为结尾的t的公共子序列的最大长度
        //当dp[s.length()][t.length()]=s.length()，说明s为t的子字符串
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        //初始化dp数组,dp[0][j],dp[i][0]都默认为0

        //确定递推公式和遍历顺序
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[s.length()][t.length()] == s.length();

    }
}
