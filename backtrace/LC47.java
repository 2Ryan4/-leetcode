package backtrace;

import java.util.*;

public class LC47 {
    private LinkedList<Integer> path = new LinkedList<>();
    private ArrayList<List<Integer>> result = new ArrayList<>();
    private boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums);
        return result;
    }

    public void backtrack(int[] nums) {
        //因为为全排列，递归结束的时候同时收集结果
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //第一个判断条件是树层去重，去重的条件是元素数值相同，第二判断条件是树枝去重，去重的是是否为同一个元素
            if ((i > 0 && nums[i] == nums[i -1] && used[i - 1] == false) || used[i] == true) {
                continue;
            } else {
                used[i] = true;
                path.add(nums[i]);
                backtrack(nums);
                path.removeLast();
                used[i] = false;
            }
        }

    }
}
