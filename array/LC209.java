package array;

public class LC209 {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;//最终结果
        int sum = 0;//子数组的元素和
        int subLength = 0;//子数组长度
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    subLength = j - i + 1;
                    result = Math.min(result, subLength);
                    break;//跳出循环
                }
            }
        }
        return result == java.lang.Integer.MAX_VALUE ? 0 : result;
        //如果结果不变，则没有满足条件的子数组
    }

    public int minSubArrayLen1(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int i = 0;//窗口的起始位置
        int sum = 0;
        int subLength = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {//确保窗口滑动后，子数组元素和仍满足条件
                subLength = j - i + 1;
                result = Math.min(result, subLength);//不断更新
                sum -= nums[i++];//滑动窗口的精髓，不断调整起始位置
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}













