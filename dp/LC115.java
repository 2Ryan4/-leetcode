package dp;

public class LC115 {
    public int numDistinct(String s, String t) {
        //定义dp数组，dp[i][j]表示以i-1为结尾的s出现以j-1为结尾的t的最大次数
        //本质上是求出s有多少种删除方式能够变成t
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 1];


        //确认递推公式
        //若s[i-1]=t[j-1]
        //1.使用s[i-1]匹配t[j-1]，那么dp[i][j]=dp[i-1][j-1]
        //2.不使用s[i-1]匹配t[j-1]，那么看s[i-2]能否匹配t[j-1]，相同于删除掉s[i-1]
        //综上所述：dp[i][j]=dp[i-1][j-1]+dp[i-1][j]
        //若s[i-1]!=t[j-1]
        //则是删除s[i-1]，看之前的是否能匹配，即dp[i][j]=dp[i-1][j]

        //初始化dp数组
        //由递归公式可以看出，dp[i][j]在二维数组能由上方，斜上方和左边推出
        //倘若s不为空，t为空，则变为t的方法数只有一种，即全删
        //倘若s为空，t不为空，则无法变成t
        //倘若都为空，则s不删就成为t，t出现次数也为一种
        for (int i = 0; i <= sLen; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= tLen; i++) {
            dp[0][i] = 0;
        }

        //确认遍历顺序
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[sLen][tLen];


    }
}
