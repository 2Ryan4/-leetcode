package greed;

public class LC55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int maxCover = 0;//最大覆盖范围(下标)
        for (int i = 0; i <= maxCover; i++) {
            maxCover = Math.max(nums[i] + i, maxCover);
            if (maxCover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
