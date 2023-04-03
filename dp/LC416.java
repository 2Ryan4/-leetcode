package dp;

public class LC416 {
    public boolean canPartition(int[] nums) {
        //因为要分成两个和相等的子集，那么子集的和必然为数组和的一半
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //数组和不能整除2和数组长度为1都不满足条件
        if (sum % 2 != 0 || nums.length == 1) {
            return false;
        }

        //因为每个数有两种状态，取或不取，且每个数只能使用一次，那么可以按照01背包思路来解题
        //dp[i]表示背包容量为i的最大价值，即选取的数组元素相加和小于等于i的最大和
        //数组元素可以理解成物品，num[i]即是价值，也是重量
        //如果dp[sum/2]=sum/2，则符合条件

        //背包容量
        int target = sum / 2;
        int[] dp = new int[target + 1];

        //初始化dp数组，默认值为0已经完成了初始化

        //一定先遍历物品，再遍历背包，否则背包只会选取一个元素
        for (int i = 0; i < nums.length; i++) {
            //遍历背包一定为倒序，保证每个数组元素只被使用一次
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[target] == target;

    }
}
