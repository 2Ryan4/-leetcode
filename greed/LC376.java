package greed;

public class LC376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int curDiff = 0;//记录当前数和下一个差值
        int preDiff = 0;//记录前一对差值
        int result = 1;//默认序列最右边有一个峰值

        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            if ((preDiff >= 0 && curDiff < 0) || (preDiff <= 0 && curDiff > 0)) {
                result++;
                preDiff = curDiff;
            }
        }

        return result;
    }
}
