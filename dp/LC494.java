package dp;

public class LC494 {
    public int findTargetSumWays(int[] nums, int target) {
        //每个元素可以加或减，就将要加的元素分成一个集合，要减的元素分成一个集合
        //数组和为sum，目标值为target，加元素的总和和left，减元素的总和为right
        //left+right=sum,left-right=target
        //等式变化，left=(sum+target)/2

        //定义dp[i]，装满容量为i的背包有dp[i]的方法
        //将背包问题和不同路径问题联系在一起
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum + target) % 2 == 1 || Math.abs(target) > sum) {
            return 0;
        }
        int left = (sum + target) / 2;
        int[] dp = new int[left + 1];

        //确定递推公式
        //因为求的是组合数量，可以类比成路径问题
        //dp[i] += dp[i - num[i]];

        //初始化dp数组
        //如果dp[0]=0，往后所有dp[i]全部为0
        //例子：nums=[0]，target为0，那么dp[0]=1，就一种方法，装0种物品
        dp[0] = 1;

        //确定遍历顺序
        for (int i = 0; i < nums.length; i++) {
            for (int j = left; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[left];


    }
}
