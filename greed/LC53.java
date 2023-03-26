package greed;

public class LC53 {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            result = Math.max(result, count);//不断更新最大值
            //当连续子数组的和小于0，调整区间
            if (count < 0) {
                count = 0;
            }
        }
        return result;
    }
}
