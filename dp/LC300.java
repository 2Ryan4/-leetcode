package dp;

import java.util.Arrays;
import java.util.List;

public class LC300 {
    public int lengthOfLIS(int[] nums) {
        //定义dp数组，dp[i]表示到nums[i]的最大递增子序列
        int len = nums.length;
        int[] dp = new int[len];
        int result = 1;

        //初始化dp数组
        //无论从哪开始，最小长度都是1，即自身构成一个序列
        Arrays.fill(dp, 1);

        //确认递推公式和遍历顺序
        //找到前一个比自身小的数，取它的长度加一和自身序列长度的最大值，所以是从前往后遍历
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
