package dp;

import java.util.HashSet;
import java.util.List;

public class LC139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        //定义dp数组，dp[i]表示下标为[1,i]的字符串是否能由词典的单词构成
        boolean[] dp = new boolean[s.length() + 1];

        //初始化dp数组
        dp[0] = true;

        //确定遍历顺序
        //因为字符串的单词构成是有顺序，所以要先遍历背包，再遍历物品
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String s1 = s.substring(j, i);
                if (dict.contains(s1) && dp[j] == true) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];

    }
}
