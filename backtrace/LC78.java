package backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC78 {
    private LinkedList<Integer> path = new LinkedList<>();
    private ArrayList<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
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
            path.add(nums[i]);
            backtrack(nums, i + 1);
            //回溯
            path.removeLast();
        }
    }
}
