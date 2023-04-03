package dp;

public class LC647 {
    public int countSubstrings(String s) {
        //定义dp数组
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int result = 0;
        //确认递推公式

        //初始化dp数组

        //确定遍历顺序
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j <= i + 1) {
                        dp[i][j] = true;
                        result++;
                    } else if (dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                        result++;
                    }
                }
            }
        }

        return result;
    }
}
