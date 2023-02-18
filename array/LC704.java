package array;

public class LC704 {
    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;//因为数组为有序，先和最小最大值相比
        }

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);//避免整型溢出
            if (nums[mid] > target) {
                r = mid - 1; //目标值在左区间
            } else if (nums[mid] < target) {
                l = mid + 1;//目标值在右区间
            } else {
                return mid;
            }
        }

        return -1;//目标值不存在
    }


}
