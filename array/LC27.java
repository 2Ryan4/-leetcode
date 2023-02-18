package array;

public class LC27 {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                for (int j = i; j < length - 1; j++) {
                    nums[j] = nums[j + 1];//后面的元素往前移动
                }
                i--;//后面元素往前移动后，下标减1
                length--;
            }
        }
        return length;
    }//暴力解法

    int removeElement1(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }//双指针解法

    int removeElement2(int[] nums, int val) {
        //因为题目说明可以改变元素顺序，如果val值出现在数组开头，可以用数据末尾的不为val的值覆盖掉
        int l = 0;//指向数组开头的指针
        int r = nums.length-1;//指向数组末尾的指针

        while (l <= r) {
            if (nums[l] == val) {
                nums[l] = nums[r];
                r--;
            } else {
                l++;
            }
        }

        return l;
        //避免了需要保留的元素的重复赋值操作
    }


}
