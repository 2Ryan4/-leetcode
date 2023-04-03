package dp;

public class LC53 {
    public int maxSubArray(int[] nums) {
        //定义dp数组，dp[i]表示末尾下标为i的最大子数组和
        int length = nums.length;
        int[] dp = new int[length];

        //初始化dp数组
        dp[0] = nums[0];
        int result = dp[0];

        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
