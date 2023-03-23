package backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC90 {
    private LinkedList<Integer> path = new LinkedList<>();
    private ArrayList<List<Integer>> result = new ArrayList<>();
    private boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums, 0);
        return result;
    }

    public void backtrack(int[] nums, int startIndex) {
        //收集结果
        result.add(new ArrayList<>(path));
        //结束条件：遍历完数组末尾之后
        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums [i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, i + 1);
            //回溯
            used[i] = false;
            path.removeLast();
        }
    }
}
