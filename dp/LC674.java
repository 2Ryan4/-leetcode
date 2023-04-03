package dp;

import java.util.Arrays;

public class LC674 {
    public int findLengthOfLCIS(int[] nums) {
        //定义dp数组，dp[i]表示到nums[i]的最大连续递增子序列的长度
        int length = nums.length;
        int[] dp = new int[length];

        //初始化dp数组，无论从哪开始，自身都可以成为一个长度为1的序列
        Arrays.fill(dp, 1);
        int result = 1;

        //确认递推公式和遍历顺序
        //题目要求是连续子序列，所以dp[i]的状态只和dp[i-1]有关，若nums[i]>num[i-1]，则dp[i]=dp[i-1]+1，否则不变
        for (int i = 1; i < length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
