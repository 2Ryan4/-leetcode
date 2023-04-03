package dp;

public class LC377 {
    public int combinationSum4(int[] nums, int target) {
        //定义dp数组，dp[i]表示和为i的元素排列组合的最大数量
        int[] dp = new int[target + 1];

        //初始化dp数组
        dp[0] = 1;

        //因为是排列组合，要注意两个for循环的位置
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }
}
