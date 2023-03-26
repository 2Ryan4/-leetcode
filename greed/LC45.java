package greed;

public class LC45 {
    public int jump(int[] nums) {
        if (nums .length ==1) {
            return 0;
        }
        int step = 0;
        int curCover = 0;//当前覆盖范围
        int nextCover = 0;//下一步的覆盖范围

        for (int i = 0; i < nums.length; i++) {
            //更新下一步的最大覆盖范围
            nextCover = Math.max(nums[i] + i, nextCover);
            //当前覆盖范围内存在一个元素可以跳到数组末尾，下一步就到末尾
            if (nextCover >= nums.length - 1) {
                step++;
                break;
            }
            if (i == curCover) {
                curCover = nextCover;
                step++;
            }
        }

        return step;
    }
}
